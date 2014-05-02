package sems.controls;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sems.vo.StudentVo;

//@Controller
@RequestMapping("/student")
public class StudentControl01 {
	static long fileCount;
	
	@Autowired
	ServletContext servletContext;
	
	// 기본 정보 입력 폼 출력
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String intsert() {
		return "/student/insert.jsp";
	}
	
	// 기본 정보 입력 값 받고 -> 추가 정보 입력 폼 출력
	@RequestMapping(value="/insert2", method=RequestMethod.POST)
	public String intsert2(StudentVo student, HttpSession session) {
		
		session.setAttribute("student", student);
		return "/student/insert2.jsp";
	}
	
	// 추가 정보 입력 값 받고 -> 전체 입력 값 출력
	@RequestMapping(value="/insert3", method=RequestMethod.POST)
	public String intsert3(StudentVo student, HttpSession session) {
		StudentVo basicInfo = (StudentVo) session.getAttribute("student");
		
		basicInfo.setCompany(student.getCompany());
		basicInfo.setPosition(student.getPosition());
		basicInfo.setWorkingState(student.getWorkingState());
		basicInfo.setLastSchool(student.getLastSchool());
		basicInfo.setBankingAccount(student.getBankingAccount());
		
		//session.setAttribute("student", basicInfo);	 // 이미 주소가 저장되어 있어서 다시 저장할 필요가 없다!
		return "/student/insert3.jsp";
	}
	
	// 전체 입력 값 DB 저장
	@RequestMapping(value="/insert4", method=RequestMethod.POST)
	public String intsert4() {
		
		return "/student/insert4.jsp";
	}
	
}
