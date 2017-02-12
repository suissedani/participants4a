package asw.ui.action.user;

import asw.business.user.FindUser;
import asw.model.Usuario;
import asw.ui.action.Action;

public class FindUserAction implements Action {

	private String email;
	private String contraseña;

	@Override
	public void execute() throws Exception {
		Usuario user = new FindUser(email, contraseña).execute();
	}

}
