package sems.controls.auth;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutControl {
	
	@RequestMapping("/auth/logout.bit")
	public String execute(HttpSession session) {
		session.invalidate();
		return "redirect:login.bit";
	}

}

