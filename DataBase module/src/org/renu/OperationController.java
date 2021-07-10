package org.renu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.renu.entity.User;
import org.renu.model.UsersModel;



@WebServlet("/Operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Resource(name="jdbc/project")
    private DataSource dataSource;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		page=page.toLowerCase();
		switch(page)
		{
		
			
		case "listuser":
	
		listUser(request,response);
		
		case "adduser":
	
		addUserFormLoader(request,response);
			
	    break;
		case "updateuser":
			
	UpdateUserFormLoader(request,response);
				
		    break;
		    
		 case "deleteuser":
			 System.out.println("from delete case");
		    	deleteUser(Integer.parseInt(request.getParameter("userId")));
		    	listUser(request,response);
		    	
		    	break;
		    	
			default:
				

				errorPage(request,response);
				
		}
		
		
		
	}
	
	private void UpdateUserFormLoader(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "List of User");
		
		try {
			request.getRequestDispatcher("updateUser.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String operation=request.getParameter("form");
	operation=operation.toLowerCase();
	
    switch(operation)
    {
    
    case "adduseroperation":
    	User newUser=new User(request.getParameter("username"),request.getParameter("email"));
    	addUserOperation(newUser);
    	listUser(request,response);
    	break;
    	
    case "updateuseroperation":
    	User updatedUser=new User(Integer.parseInt(request.getParameter("userId")),request.getParameter("username"),request.getParameter("email"));
    	updateUserOperartion(dataSource,updatedUser);
    	listUser(request,response);
    	break;
   
    	default:
    		errorPage(request,response);
    		break;
    		
    		
    }
    
	}
	
	
	
	private void deleteUser(int userId) {
		System.out.println("Delete user from operation");
		new UsersModel().deleteUser(dataSource,userId);
		return;
	}

	private void updateUserOperartion(DataSource dataSource2, User updatedUser) {
		new UsersModel().updateUser(dataSource,updatedUser);
		
	}

	private void addUserOperation(User newUser) {
		// TODO Auto-generated method stub
		new UsersModel().addUser(dataSource, newUser);
		return;
		
	}

	public void addUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Add User");
		request.getRequestDispatcher("addUser.jsp").forward(request, response);
		
}
	public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUser=new ArrayList<>();
		listUser=new UsersModel().listUser(dataSource);
		request.setAttribute("listUser", listUser);
	
		
				request.getRequestDispatcher("listuser.jsp").forward(request, response);

	}
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("title","Error");
		request.getRequestDispatcher("error.jsp").forward(request, response);

}
	
}