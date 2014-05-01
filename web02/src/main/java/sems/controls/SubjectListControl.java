package sems.controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sems.dao.SubjectDao;
import sems.vo.SubjectVo;

// @RequestParam를 사용
//@Component("/subject/list.bit")
@Controller
public class SubjectListControl {
	@Autowired
	SubjectDao subjectDao;
	
	/*  RequestParam("요청 파라미터명)
	 * - 메서드의 파라미터와 요청 파라미터 이름이 같다면 생략 가능
	 */
	@RequestMapping("/subject/list")
  public String execute( 
		@RequestParam(value="pageNo", defaultValue="1") int pageNo,
		@RequestParam(value="pageSize", defaultValue="10") int pageSize,
		Model model) {
		
		try {
	    List<SubjectVo> list = subjectDao.list(pageNo, pageSize);
	    model.addAttribute("list", list);
	    return "/subject/list.jsp";
	    
    } catch (Throwable ex) {
	    throw new Error(ex);
    }
  }
	
}
