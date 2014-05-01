package sems.controls.auth;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sems.dao.DaoException;
import sems.dao.UserDao;
import sems.vo.UserVo;

@Controller
@RequestMapping("/auth/login")
public class LoginControl {
	static Logger log = Logger.getLogger(LoginControl.class);
	@Autowired
	UserDao userDao;
	
	public LoginControl() {
	  log.debug("LoginControl 생성됨");
  }
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "/auth/login.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String execute(
			String email,
			String password,
			@RequestParam(required=false) String saveEmail,
			HttpSession session,
			HttpServletResponse response) {
		try {
				UserVo userVo = null;
				
				try {
					HashMap<String,String> params = new HashMap<String,String>();
					params.put("email", email);
					params.put("password", password);
					
					userVo = userDao.getUser(params);
				} catch (DaoException e) { // 로그인 실패!
					return "redirect:login.bit";
				}
				
				session.setAttribute("loginUser", userVo);
				
				if (saveEmail != null) {
					Cookie cookie = new Cookie("loginEmail", email);
					cookie.setDomain("s09.java48.com"); // 서버 범위
					cookie.setPath("/web02");					// 하위 폴더 범위
					
					response.addCookie(cookie);
				}
				
				return "redirect:../subject/list.bit?pageNo=1&pageSize=10";
		} catch (Throwable ex) {
			throw new Error(ex);
		}
	}

}
