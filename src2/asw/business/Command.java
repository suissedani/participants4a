package asw.business;

import asw.business.exception.BusinessException;

public interface Command {
	public Object execute() throws BusinessException;
}
