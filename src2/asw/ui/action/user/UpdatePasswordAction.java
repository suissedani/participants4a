package asw.ui.action.user;

import asw.business.user.UpdatePassword;
import asw.model.Usuario;
import asw.ui.action.Action;

public class UpdatePasswordAction implements Action {

	private String contraseñaAntigua;
	private String contraseñaNueva;

	@Override
	public void execute() throws Exception {
		Usuario user = new UpdatePassword(u, contraseñaAntigua, contraseñaNueva).execute();
	}

}
