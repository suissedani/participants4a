package asw.ui.action.user;

import org.json.JSONObject;

import asw.business.user.UpdatePassword;
import asw.model.Usuario;
import asw.ui.action.Action;

public class UpdatePasswordAction implements Action {

	private String passAntigua;
	private String passNueva;
	private JSONObject json;
	
	public UpdatePasswordAction(JSONObject json, String passAntigua, String passNueva) {
		this.passAntigua = passAntigua;
		this.passNueva = passNueva;
		this.json = json;
	}

	@Override
	public void execute() throws Exception {
		String passAntigua= json.getString("passAntigua");
		String passNueva = json.getString("passNueva");
		Usuario user = new UpdatePassword(u, passAntigua, passNueva).execute();
	}

}