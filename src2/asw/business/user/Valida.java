package asw.business.user;

import java.util.List;

import asw.business.Command;
import asw.business.exception.BusinessException;
import asw.model.Usuario;
import asw.persistance.UsuarioFinder;

public class Valida implements Command {

	private String email;
	private String contraseña;

	public Valida(String email, String contraseña) {
		this.email = email;
		this.contraseña = contraseña;
	}

	@Override
	public Object execute() throws BusinessException {
		List<Usuario> repuestos = UsuarioFinder.findUserByEmailPass(email,contraseña);

		return ;
	}

}
