import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		HttpSession session=request.getSession();
//		String name = (String)session.getAttribute("name");
//		String password = (String)session.getAttribute("password");
//		
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html;charset=utf-8");
//		if(name.equals("itcast")&&password.equals("123")){
////			out.println("»¶Ó­µÇÂ½");
//			response.sendRedirect("/Chapter06/LoginServlet");
//		}else{
//			if(name==""&&password==""){
//				String url="/Chapter06/Login.html";
//				out.println("Äã»¹Ã»ÓÐµÇÂ½£¬Çëµã»÷µÇÂ½");
//				out.write("<a href='"+url+"'>µÇÂ½</a><br>");
//			}
//			else{
//				out.println("ÓÃ»§Ãû»òÕßÃÜÂë´íÎó");
//			}
//		}
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			response.getWriter().println("Äú»¹Ã»ÓÐµÇÂ¼£¬Çë<a href='/Chapter06/Login.html'>µÇÂ¼</a>");
		}else{
			response.getWriter().println("ÄúÒÑ¾­µÇÂ¼£¬"+user.getUsername()+"!");
			response.getWriter().println("<a href='/Chapter06/LogoutServlet'>ÍË³ö</a>");
			
			Cookie cookie = new Cookie("JSESSIONID",session.getId());
			cookie.setMaxAge(60*30);
			cookie.setPath("/Chapter06");
			response.addCookie(cookie);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
