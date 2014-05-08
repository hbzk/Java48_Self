package sems.controls.ajax;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sems.services.AuthService;
import sems.services.UserGroup;
import sems.vo.AjaxResult;
import sems.vo.UserVo;

@Controller
@RequestMapping("/auth")
@SessionAttributes("loginUser")
public class AuthControl {
	static Logger log = Logger.getLogger(AuthControl.class);
	
	@Autowired
	AuthService authService;

	/* return 타입은 JSON으로 출력할 객체이다.
	 * - 자동으로 JSON 문자열로 변환하려면, 빈 설정 파일에
	 * 		JSON 변환 Resolver를 등록해야한다.
	 */
	@RequestMapping(value="/login") //, method=RequestMethod.POST
	public AjaxResult login ( 
			String email, 
			String password, 
			@RequestParam(required=false) String saveEmail,
			HttpSession session,
			HttpServletResponse response,
			Model model) {
		try {
			
			UserVo userVo = authService.getLoginUser(
						email, password, UserGroup.STUDENT);
			AjaxResult result = null;
			
			if (userVo == null) {
				result = new AjaxResult().setStatus("ok").setData("failure");
				
			}	else {
				result = new AjaxResult().setStatus("ok").setData("success");
				
				model.addAttribute("loginUser", userVo);
				
				if (saveEmail.equals("true")) {
					Cookie cookie = new Cookie("loginEmail", email);
					cookie.setDomain("s09.java48.com"); // 서버 범위
					cookie.setPath("/web02");					// 하위 폴더 범위
					
					response.addCookie(cookie);
				}
			}
			
			response.setContentType("text/html;charset=UTF-8");
			return result;
			
		} catch (Throwable ex) {
			return new AjaxResult()
							.setStatus("error").setData(ex.getMessage());
			//throw new Error(ex);
		}
	}
	
	@RequestMapping("/logout")
  public AjaxResult logout(HttpSession session) {
	  session.invalidate();
	  return new AjaxResult().setData("ok");
	}
	
	@RequestMapping("/getLoginUser")
	public AjaxResult getLoginUser(HttpSession session) {
		UserVo loginUser = (UserVo) session.getAttribute("loginUser");
		if (loginUser == null) {
			return new AjaxResult().setStatus("failure").setData("로그인 하지 않았습니다.");
		} else {
			return new AjaxResult().setStatus("ok").setData(loginUser);
		}
	}
}


