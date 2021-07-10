package org.renu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Site")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		page=page.toLowerCase();
		switch(page)
		{
		case "home":
			home(request,response);
			break;
		
	default:
		

		errorPage(request,response);

}
}
	public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title","Home");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
		public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setAttribute("title","Error");
			request.getRequestDispatcher("error.jsp").forward(request, response);

}
}
