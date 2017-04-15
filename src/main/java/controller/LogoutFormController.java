package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import utils.WebConstants;

@Controller
public class LogoutFormController {

	@RequestMapping(method = RequestMethod.GET, value = "/logoutform/logout")
	public String toLoginView(HttpSession session) {
		session.setAttribute(WebConstants.USER_KEY, null);
		return "logoutform/logoutSuccess";
	}
}
