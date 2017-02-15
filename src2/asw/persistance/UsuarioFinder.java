package asw.persistance;

import java.util.List;

import asw.model.Usuario;
import asw.persistance.util.Jpa;

public class UsuarioFinder {

	/**
	 * Busca el usuario con las credenciales dadas
	 * 
	 * @param email
	 *            el correo electrónico del usuario
	 * @param contraseña
	 *            la contraseña del usuario
	 * @return el usuario
	 */
	public static List<Usuario> findUserByEmailPass(String email, String contraseña) {
		return Jpa.getManager().createNamedQuery("Usuario.findByEmailPass", Usuario.class).setParameter(1, email)
				.setParameter(2, contraseña).getResultList();
	}

}
