package asw.ui.action.user;

import org.apache.catalina.User;
import org.json.JSONObject;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import asw.business.user.FindUser;
import asw.model.Usuario;
import asw.ui.action.Action;
import ch.qos.logback.core.net.LoginAuthenticator;

public class FindUserAction implements Action {

	private String email;
	private String password;
	
	public FindUserAction(String email, String password) {
		this.email=email;
		this.password = password;
	}

	@Override
	@RequestMapping(value="/validarse", method= RequestMethod.POST)
	public void execute() throws Exception {
		String email = email;
		String password = password;
		Usuario user = new FindUser(email, password).execute();
		println(email + " " + password);
	}

}
