package controls;

import java.util.Map;

import annotations.Component;
import vo.SubjectVo;
import dao.SubjectDao;

@Component("/subject/insert.bit")
public class SubjectInsertControl implements PageController {
	SubjectDao subjectDao;
	
	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	@Override
	public String execute(Map<String, Object> model) {
		if (model.get("title") == null) { 	// > get/post 체크 대용
			return "/subject/form.jsp";
			
		} else {
			try {
				SubjectVo vo = new SubjectVo();
				vo.setTitle((String)model.get("title")); 	// > (String)
				vo.setDescription((String)model.get("description"));
				subjectDao.insert(vo);
				return "/subject/insert.jsp";
				
			}	catch (Throwable ex) {
				throw new Error(ex);
			}
		}
	}

}
