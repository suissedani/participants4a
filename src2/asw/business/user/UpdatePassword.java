package asw.business.user;

import asw.business.Command;
import asw.business.exception.BusinessException;

public class UpdatePassword implements Command {

	private String contraseñaAntigua;
	private String contraseñaNueva;

	public UpdatePassword(String contraseñaAntigua, String contraseñaNueva) {
		super();
		this.contraseñaAntigua = contraseñaAntigua;
		this.contraseñaNueva = contraseñaNueva;
	}

	@Override
	public Object execute() throws BusinessException {
		
		return null;
	}

}
