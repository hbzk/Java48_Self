package sems.controls;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sems.dao.StudentDao;
import sems.dao.UserDao;
import sems.vo.StudentVo;

@Controller
@RequestMapping("/student")
@SessionAttributes("student") 	// 세션에 보관될 객체의 이름을 선언
public class StudentControl {
	static long fileCount;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	StudentDao studentDao;
	
	// 기본 정보 입력 폼 출력
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String intsert() {
		return "/student/insert.jsp";
	}
	
	// 기본 정보 입력 값 받고 -> 추가 정보 입력 폼 출력
	@RequestMapping(value="/insert2", method=RequestMethod.POST)
	public String intsert2(StudentVo student, Model model) {
		// 모델에 저장하는 객체의 이름이 "student" 이기 때문에
		// 이 객체는 세션에 보관될 것이다.
		
		// 모델에 저장하는 객체는 기본적으로 ServletRequest에 보관된다.
		// 만약 객체의 이름이 @SessionAttributes에 선언되어 있다면
		// HttpSession에 보관된다.
		model.addAttribute("student", student);
		return "/student/insert2.jsp";
	}
	
	// 추가 정보 입력 값 받고 -> 전체 입력 값 출력
	// @ModelAttribute("student")
	// - 파라미터 값을 세션으로부터 가져와라.
	// - 그리고 클라이언트가 보낸 데이터를 이 객체에 넣어라.
	@RequestMapping(value="/insert3", method=RequestMethod.POST)
	public String intsert3(@ModelAttribute("student") StudentVo student) {
		return "/student/insert3.jsp";
	}
	
	// 전체 입력 값 DB 저장
	@RequestMapping(value="/insert4", method=RequestMethod.POST)
	public String intsert4(@ModelAttribute("student") StudentVo student) {
		userDao.insert(student);
		studentDao.insert(student);
		return "/student/insert4.jsp";
	}
}



