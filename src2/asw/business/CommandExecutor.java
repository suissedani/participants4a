package asw.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import asw.business.exception.BusinessException;
import asw.persistance.util.Jpa;

public class CommandExecutor {
	/**
	 * Prepara la interacción con el EntityManager para cualquier petición sobre
	 * la base de datos
	 * 
	 * @param cmd
	 *            El comando a realizar
	 * @return El objeto requerido
	 * @throws BusinessException
	 *             Se produce una excepción si hay algún tipo de error producido
	 *             por el ususario
	 */
	public Object execute(Command cmd) throws BusinessException {
		EntityManager mapper = Jpa.createEntityManager();
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
