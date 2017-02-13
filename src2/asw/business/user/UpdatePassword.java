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
		user.updateContraseña(passAntigua, passNueva);
		return user;

	}

}
