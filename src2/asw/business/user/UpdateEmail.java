package asw.business.user;

import asw.business.Command;
import asw.business.exception.BusinessException;
import asw.model.Usuario;

public class UpdateEmail implements Command {

	private String emailAntiguo;
	private String emailNuevo;
	private Usuario user;

	public UpdateEmail(Usuario user, String emailAntiguo, String emailNuevo) {
		this.user = user;
		this.emailAntiguo = emailAntiguo;
		this.emailNuevo = emailNuevo;
	}

	@Override
	public Usuario execute() throws BusinessException {
		assertNotNull(emailAntiguo, emailNuevo);
		assertDistinctEmail(emailAntiguo, emailNuevo);
		assertEmailAntiguo(user, emailAntiguo);
		user.setEmail(emailNuevo);
		return user;

	}

	/**
	 * Comprueba que el email introducido sea el antiguo
	 * 
	 * @param user2
	 *            usuario logueado
	 * @param emailAntiguo2
	 *            email antiguo introducido por el ususario
	 * @throws BusinessException
	 *             Si el email introducido es distinto del del usuario
	 */
	private void assertEmailAntiguo(Usuario user2, String emailAntiguo2) throws BusinessException {
		if (!user2.getEmail().equals(emailAntiguo2))
			throw new BusinessException("El email antiguo no es correcto");
	}

	/**
	 * Comprueba que el email nuevo y el antiguo introducidos por el usuario no
	 * sea el mismo
	 * 
	 * @param emailAntiguo2
	 *            el email antiguo introducido por el usuario
	 * @param emailNuevo2
	 *            el email nuevo introducido por el usuario
	 * @throws BusinessException
	 *             Si el email antiguo introducido y el nuevo son iguales
	 */
	private void assertDistinctEmail(String emailAntiguo2, String emailNuevo2) throws BusinessException {
		if (emailAntiguo == emailNuevo)
			throw new BusinessException("EL e-mail antiguo y el nuevo son iguales");

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
	private void assertNotNull(String emailAntiguo2, String emailNuevo2) throws BusinessException {
		if (emailAntiguo == null && emailNuevo == null)
			throw new BusinessException("Alguno de los campos están vacíos");
	}

}
