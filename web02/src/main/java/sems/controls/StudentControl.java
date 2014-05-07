package sems.controls;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sems.services.StudentService;
import sems.vo.StudentVo;

@Controller
@RequestMapping("/student")
@SessionAttributes("student") 	// 세션에 보관될 객체의 이름을 선언
public class StudentControl {
	static long fileCount;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String intsert() {
		return "student/insert";
	}
	
	@RequestMapping(value="/insert2", method=RequestMethod.POST)
	public String intsert2(StudentVo student, Model model) {
		model.addAttribute("student", student);
		return "student/insert2";
	}
	
	@RequestMapping(value="/insert3", method=RequestMethod.POST)
	public String intsert3(@ModelAttribute("student") StudentVo student) {
		return "student/nsert3";
	}
	
	@RequestMapping(value="/insert4", method=RequestMethod.POST)
	public String intsert4(@ModelAttribute("student") StudentVo student) {
		studentService.add(student);
		return "student/nsert4";
	}
}



