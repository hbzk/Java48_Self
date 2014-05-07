package sems.controls.ajax;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sems.dao.SubjectDao;
import sems.vo.AjaxResult;
import sems.vo.SubjectVo;

@Controller
@RequestMapping("/subject")
public class SubjectControl {
	static Logger log = Logger.getLogger(SubjectControl.class);
	
	@Autowired
	SubjectDao subjectDao;
	
	@RequestMapping("/list")
  public AjaxResult list( 
		@RequestParam(value="pageNo", defaultValue="1") int pageNo,
		@RequestParam(value="pageSize", defaultValue="10") int pageSize,
		HttpSession session,
		HttpServletResponse response,
		Model model) {
		
		try {
			HashMap<String, Integer> params = new HashMap<String, Integer>();
			params.put("startIndex", (pageNo - 1) * pageSize);
			params.put("pageSize", pageSize);
			
	    List<SubjectVo> list = subjectDao.list(params);
	    int listSize = list.size();
	    session.setAttribute("list", list);
	    
	    
	    AjaxResult result = new AjaxResult().setStatus("ok").setData(list).setPageSize(listSize);
	    
	    response.setContentType("text/html;charset=UTF-8");
	    return result;
	    
    } catch (Throwable ex) {
			return new AjaxResult()
					.setStatus("error").setData(ex.getMessage());
    }
  }
	
	@RequestMapping("/detail")
  public String detail(int no, Model model) {
    try {
    	SubjectVo subject = subjectDao.detail(no);
	    model.addAttribute("subject", subject);
	    return "subject/detail";
	    
    } catch (Throwable ex) {
	    throw new Error(ex);
    }
  }
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String form() {
		return "subject/form";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(SubjectVo vo) {
		try {
			subjectDao.insert(vo);
			return "subject/insert";
			
		}	catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateForm(int no, Model model) {
		try {
			SubjectVo subject = subjectDao.detail(no);
			model.addAttribute("subject", subject);
			return "subject/updateform";

		}	catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(SubjectVo vo, Model model) {
		try {
				subjectDao.update(vo);
				return "redirect:detail.bit?no=" + vo.getNo();
				
		}	catch (Throwable ex) {
			throw new Error(ex);
		}
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
  public String delete(int no) {
		try {
			subjectDao.delete(no);
			return "redirect:list.bit?pageNo=1&pageSize=10";
			
		}	catch (Throwable ex) {
			throw new Error(ex);
		}
  }
	
}
