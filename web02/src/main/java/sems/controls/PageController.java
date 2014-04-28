package sems.controls;

import java.util.Map;

// 인터페이스 => 규칙 -> 호출자/피호출자
// 호출자 : FrontController(DisPatcherServlet)
// 피호출자 : PageController(예: SubjectListControl, ...)
public interface PageController {
	String execute(Map<String, Object> model);
}
