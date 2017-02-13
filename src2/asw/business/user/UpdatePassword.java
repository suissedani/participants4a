package asw.business.user;

import asw.business.Command;
import asw.business.exception.BusinessException;
import asw.model.Usuario;

public class UpdatePassword implements Command {

	private String passAntigua;
	private String passNueva;
	private Usuario user;

	public UpdatePassword(Usuario u, String passAntigua, String passNueva) {
		super();
		this.passAntigua = passAntigua;
		this.passNueva = passNueva;
		this.user = u;
	}

	@Override
	public Usuario execute() throws BusinessException {
		assertNotNull(passNueva, passAntigua);
		assertPassDistinct(passNueva, passAntigua);
		user.updateContraseña(passAntigua, passNueva);
		return user;

	}

	/**
	 * Comprueba que las contraseñas introducidas por es usuario son distintas
	 * 
	 * @param passNueva
	 *            La contraseña nueva introducida por el usuario
	 * @param passVieja
	 *            La contraseña antigua introducida por el usuario
	 * @throws BusinessException
	 *             Si las contraseñas son iguales
	 */
	private void assertPassDistinct(String passNueva, String passVieja) throws BusinessException {
		if (passNueva == passVieja)
			throw new BusinessException("La contraseña vieja y la antigua son iguales");
	}

	/**
	 * Comprueba que el campo no son nulos
	 * 
	 * @param emailAntiguo2
	 *            el email antiguo introducido por el usuario
	 * @param emailNuevo2
	 *            el email nuevo introducido por el usuario
	 * @throws BusinessException
	 *             Si alguno de los campos es nulo
	 */

	/**
	 * Comprueba que el campo no son nulos
	 * 
	 * @param passNueva
	 *            la contraseña nueva introducida por el usuario
	 * @param passVieja
	 *            la contraseña vieja introducida por el usuario
	 * @throws BusinessException
	 *             Si alguna de las contraseñas está vacía
	 */
	private void assertNotNull(String passNueva, String passVieja) throws BusinessException {
		if (passNueva == null && passVieja == null)
			throw new BusinessException("Alguno de los campos está vacío");

	}
}
