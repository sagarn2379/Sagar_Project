package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Application;
import model.User;

/**
 * Servlet implementation class ApplicationController
 */
@WebServlet("/ApplicationController")
public class ApplicationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationController() {
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
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String appname = request.getParameter("appname");
		String appdesc = request.getParameter("appdesc");
		String errorMsg = null;
		if(email == null || email.equals("")){
			errorMsg ="User Email can't be null or empty";
		}
		if(appname == null || appname.equals("")){
			errorMsg = "Application Name can't be null or empty";
		}
		
		if(errorMsg != null){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>"+errorMsg+"</font>");
			rd.include(request, response);
			out.close();
		}else{
			response.setContentType("text/html");
			try{
			User loginUser = new User(null, null, email, null, null);
			Application app= new Application();
			app.setAppName(appname);
			app.setAppDesc(appdesc);
			Random rad = new Random();
			int id = rad.nextInt(100)+1;
			app.setAppId(id);
			app.setAppKey(appname+"_"+id);
			if(UtliStroage.userList.contains(loginUser)){
				int  index = UtliStroage.userList.indexOf(loginUser);
				loginUser = UtliStroage.userList.get(index);
				loginUser.getApplist().add(app);
				if(session.getAttribute("loginUser") == null){
					session.setAttribute("loginUser", loginUser);
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard.jsp");
				rd.forward(request, response);
				
			}
	
		}catch(Exception ex){
			ex.printStackTrace();
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard.jsp");
			rd.forward(request, response);
		}
		}
	}
}
