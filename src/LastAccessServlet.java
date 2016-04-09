

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.util.Date;
/**
 * Servlet implementation class LastAccessServlet
 */
@WebServlet("/LastAccessServlet")
public class LastAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=utf-8");
		String lastAccessTime=null;
		Cookie[] cookies= request.getCookies();
		for(int i=0; cookies!=null && i<cookies.length; i++){
			if("lastAccess".equals(cookies[i].getName())){
				lastAccessTime=cookies[i].getValue();
				break;
			}
		}
		if(lastAccessTime==null){
			response.getWriter().println("你是第一次访问本站");
		}else{
			response.getWriter().println("上次访问时间为："+lastAccessTime);
		}
		String currenttime= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		Cookie cookie = new Cookie("lastAccess",currenttime);
		//cookie.setMaxAge(0);
		response.addCookie(cookie);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
