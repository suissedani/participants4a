package asw.business;

import asw.business.exception.BusinessException;

public interface Command {
	/**
	 * Ejecuta una acción que requiere el usuario
	 * 
	 * @return El objeto requerido
	 * @throws BusinessException
	 *             si se produce un error en la ejecución del programa
	 */
	public Object execute() throws BusinessException;
}
