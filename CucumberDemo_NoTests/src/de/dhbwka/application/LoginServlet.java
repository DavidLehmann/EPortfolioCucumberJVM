package de.dhbwka.application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    
    protected void doGetOrPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	UserBean loginUser = new UserBean();
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	loginUser.setUsername(username);
		loginUser.setPassword(password);
		boolean loginSuccessful = false;
    	
    	if(loginUser.getUsername().equals("User") && loginUser.getPassword().equals("1234")){
    		loginUser.setAdmin(false);
    		loginSuccessful = true;
    	}else if(loginUser.getUsername().equals("Admin") && loginUser.getPassword().equals("admin")){
    		loginUser.setAdmin(true);
    		loginSuccessful = true;
    	}
    	
    	request.getSession().setAttribute("loginUser", loginUser);
    	if(loginSuccessful){
    		loginUser.setLoginFailed(false);
    		response.sendRedirect("TempCalculator.jsp");
    	}else{
    		loginUser.setLoginFailed(true);
    		request.getRequestDispatcher("Login.jsp").forward(request, response);
    	}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetOrPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGetOrPost(request, response);
	}

}
