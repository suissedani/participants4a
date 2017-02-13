package asw.ui.action.user;

import org.json.JSONObject;

import asw.business.user.FindUser;
import asw.model.Usuario;
import asw.ui.action.Action;

public class FindUserAction implements Action {

	private String email;
	private String password;
	private JSONObject json;
	
	public FindUserAction(JSONObject json, String email, String password) {
		this.email=email;
		this.password = password;
		this.json = json;
	}

	@Override
	public void execute() throws Exception {
		String email = json.getString("email");
		String password = json.getString("password");
		Usuario user = new FindUser(email, password).execute();
	}

}
