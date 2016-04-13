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

/**
 * Servlet implementation class CrudUser
 */
@WebServlet("/CrudUser")
public class CrudUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
			
		try {
			HttpSession session = request.getSession();
			
		if("edit".equals(session.getAttribute("Operation"))){
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String errorMsg = null;
			if(email == null || email.equals("")){
				errorMsg = "Email ID can't be null or empty.";
			}
			if(password == null || password.equals("")){
				errorMsg = "Password can't be null or empty.";
			}
			if(fname == null || fname.equals("")){
				errorMsg = "Name can't be null or empty.";
			}
			
			if(errorMsg != null){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/editUser.jsp");
				PrintWriter out= response.getWriter();
				out.println("<font color=red>"+errorMsg+"</font>");
				rd.include(request, response);
			}
			User user = new User(fname, lname, email, phone,password);
			
			if(UtliStroage.userList.contains(user)){
				int  index = UtliStroage.userList.indexOf(user);
				user = UtliStroage.userList.get(index);
				user.setFname(fname);
				user.setLname(lname);
				user.setEmail(email);
				user.setTelephone(phone);
				user.setPassword(password);
					
			//forward to dashboard page
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard.jsp");
			PrintWriter out= response.getWriter();
					
			session.setAttribute("loginUser", user);
			out.println("<font color=green>Successfully updated</font>");
			rd.include(request, response);
		}
		}else
		if("delete".equals(session.getAttribute("Operation"))){
			String email = (String) session.getAttribute("email");
			User user = new User(null, null, email, null,null);
			
			if(UtliStroage.userList.contains(user)){
				UtliStroage.userList.remove(user);
				
			
			//forward to dashboard page
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Successfully deleted</font>");
			rd.include(request, response);
		 }
		}
		
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Failed to perform Opertion on user.");
		}
		
	}
	
}
