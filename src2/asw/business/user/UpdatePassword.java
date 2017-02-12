package asw.business.user;

import asw.business.Command;
import asw.business.exception.BusinessException;
import asw.model.Usuario;

public class UpdatePassword implements Command {

	private String contraseñaAntigua;
	private String contraseñaNueva;
	private Usuario user;

	public UpdatePassword(Usuario u, String contraseñaAntigua, String contraseñaNueva) {
		super();
		this.contraseñaAntigua = contraseñaAntigua;
		this.contraseñaNueva = contraseñaNueva;
		this.user = u;
	}

	@Override
	public Usuario execute() throws BusinessException {
		user.updateContraseña(contraseñaAntigua, contraseñaNueva);
		return user;

	}

}
