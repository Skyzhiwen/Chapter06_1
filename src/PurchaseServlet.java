import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.Cookie;
import javax.servlet.http.*;
/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("id");
		if(id==null){
			String url = "/Chapter06/ListBookServlet";
		     response.sendRedirect(url);
		     return;
		}
		Book book = BookDB.getBook(id);
		HttpSession session = request.getSession();
		List<Book>cart = (List)session.getAttribute("cart");
		if(cart==null){
			cart=new ArrayList<Book>();
			session.setAttribute("cart",cart);
		} 
		cart.add(book);
		Cookie cookie=new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*30);
		cookie.setPath("/Chapter06");
		//response.addCookie(arg0);
		response.addCookie(cookie);
		String url ="/Chapter06/CartServlet";
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
