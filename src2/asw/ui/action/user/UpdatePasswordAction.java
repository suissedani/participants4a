package asw.ui.action.user;

import asw.business.user.UpdatePassword;
import asw.model.Usuario;
import asw.ui.action.Action;

public class UpdatePasswordAction implements Action {

	private String passAntigua;
	private String passNueva;

	@Override
	public void execute() throws Exception {
		Usuario user = new UpdatePassword(u, passAntigua, passNueva).execute();
	}

}
