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
	public Object execute() throws BusinessException {
		
		return null;
	}

}
