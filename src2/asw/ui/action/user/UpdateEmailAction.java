package asw.ui.action.user;

import asw.business.user.UpdateEmail;
import asw.business.user.UpdatePassword;
import asw.model.Usuario;
import asw.ui.action.Action;

public class UpdateEmailAction implements Action {
	private String emailAntiguo;
	private String emailNuevo;

	@Override
	public void execute() throws Exception {
		Usuario u;
		Usuario user = new UpdateEmail(u, emailAntiguo, emailNuevo).execute();
	}

}
