package asw.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import asw.business.exception.BusinessException;
import asw.persistance.util.Hibernate;

public class CommandExecutor {
	public Object execute(Command cmd) throws BusinessException {
		EntityManager mapper = Hibernate.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		try {
			Object res = cmd.execute();
			trx.commit();
			return res;

		} catch (BusinessException be) {
			trx.rollback();
			throw be;
		} finally {
			if (mapper.isOpen())
				mapper.close();
		}
	}
}
