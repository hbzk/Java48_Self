package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;
import dao.UserDao;

/* 사용자명에 상세보기 링크 추가
 * 
 */
@WebServlet("/user/list.bit")
@SuppressWarnings("serial")
public class UserListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>사용자목록</title></head><body>");
		
		try {
			out.println("<h1>사용자목록</h1>");
			
			// > 현재 객체의 getServletContext() 하고 그 중에 .getAttribute("userDao") 를 한다.
			UserDao dao = (UserDao) this.getServletContext().getAttribute("userDao");
			
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			
			List<UserVo> list = dao.list(pageNo, pageSize);
			out.println("<a href='form.html'>새사용자</a><br>");			
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>번호</th>");
			out.println("<th>사용자 이름</th>");
			out.println("</tr>");
			
			for (UserVo user : list) {
				out.println("<tr>");
				out.println("<td>" + user.getNo() + "</td>");
				out.println("<td><a href='detail.bit?no="
						+ user.getNo()
						+ "'>" + user.getName() + "</a></td>");
				out.println("</tr>");
			}

			out.println("</table>");
		}	catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
		
	}
}
