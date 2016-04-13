package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
@WebServlet("/login")
public class LoginController extends HttpServlet  
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String errorMsg = null;
		if(email == null || email.equals("")){
			errorMsg ="User Email can't be null or empty";
		}
		if(password == null || password.equals("")){
			errorMsg = "Password can't be null or empty";
		}
		
		if(errorMsg != null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			rd.include(request, response);
			out.close();
		}else{
			response.setContentType("text/html");
			
			String user=request.getParameter("email");
			String pass=request.getParameter("password");
			User loginUser = new User(null, null, user, null, pass);
			UtliStroage.addAdmintoList();
			if(UtliStroage.userList.contains(loginUser)){
				int  index = UtliStroage.userList.indexOf(loginUser);
				loginUser = UtliStroage.userList.get(index);
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard.jsp");
				rd.include(request, response);
				
			}
			else{
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
				PrintWriter out= response.getWriter();
				out.println("<font color=red>"+"Login Failed...!"+"</font>");
				rd.include(request, response);
				out.close();
			}		
			}
		
	
	}

}
