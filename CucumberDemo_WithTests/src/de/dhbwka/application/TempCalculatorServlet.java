package de.dhbwka.application;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TempCalculatorServlet")
public class TempCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	  protected void doGetOrPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	UserBean loginUser = (UserBean) request.getSession().getAttribute("loginUser");
	    	CalculationBean calc = new CalculationBean();
	    	
	    	try{
	    		double celcius = Double.valueOf(request.getParameter("celcius"));
	    		calc.setCelcius(celcius);
	    		calc.setFarenheit((celcius * 1.8) + 32);
	    		request.setAttribute("calc", calc);
	    		request.getRequestDispatcher("TempCalculator.jsp").forward(request, response);
	    	}catch(NumberFormatException e){
	    		calc.setCalcError(true);
	    		request.getSession().setAttribute("calc", calc);
	    		request.getRequestDispatcher("TempCalculator.jsp").forward(request, response);
	    	}	
	    	
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGetOrPost(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGetOrPost(request, response);
		}

}
