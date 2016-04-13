package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		ArrayList<String> al = new ArrayList<>();
			
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		
		
		if(al.contains(email)){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red> Enter a different email ID </font>");
			rd.include(request, response);
		}
		
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
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			rd.include(request, response);
		}else{
		
			
		try {
								
				User newUser = new User(fname, lname, email, phone,password);
				UtliStroage.userList.add(newUser);
				al.add(email);
						
				//forward to login page to login
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
				PrintWriter out= response.getWriter();
				out.println("<font color=green>Registration successful, please login below.</font>");
				rd.include(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Failed to register the user.");
		}
		}
	}

}
