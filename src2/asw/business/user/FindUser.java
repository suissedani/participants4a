package asw.business.user;

import java.util.List;

import asw.business.Command;
import asw.business.exception.BusinessException;
import asw.model.Usuario;
import asw.persistance.UsuarioFinder;

public class FindUser implements Command {

	private String email;
	private String contraseña;

	public FindUser(String email, String contraseña) {
		this.email = email;
		this.contraseña = contraseña;
	}

	@Override
	public Usuario execute() throws BusinessException {
		List<Usuario> usuarios = UsuarioFinder.findUserByEmailPass(email, contraseña);
		assertNotNull(usuarios);
		assertOnlyOne(usuarios);
		return usuarios.get(0);
	}

	/**
	 * Comprueba que en la lista solamente haya un usuario con esas credenciales
	 * 
	 * @param usuarios
	 *            La lista de usuarios
	 * @throws BusinessException
	 */
	private void assertOnlyOne(List<Usuario> usuarios) throws BusinessException {
		if (usuarios.size() > 1)
			throw new BusinessException("Hay más de un usuario con estas credenciales");
	}

	/**
	 * Comprueba que la lista de usuarios no esté vacía
	 * 
	 * @param usuarios
	 *            La lista de usuarios
	 * @throws BusinessException
	 */
	private void assertNotNull(List<Usuario> usuarios) throws BusinessException {
		if (usuarios.isEmpty())
			throw new BusinessException("El e-mail o la contraseña son incorrectos");
	}

}
