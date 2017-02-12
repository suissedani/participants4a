package asw.persistance;

import java.util.List;

import asw.model.Usuario;
import asw.persistance.util.Hibernate;

public class UsuarioFinder {

	public static List<Usuario> findUserByEmailPass(String email, String contraseña) {
		return Hibernate.getManager().createNamedQuery("Usuario.findByEmailPass", Usuario.class).setParameter(1, email)
				.setParameter(2, contraseña).getResultList();
	}

}
