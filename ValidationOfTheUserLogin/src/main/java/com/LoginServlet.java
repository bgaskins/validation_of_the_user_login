package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		// Gets username and password from login page.
		String username=request.getParameter("UName");
		String password=request.getParameter("Pass");
			
			// Hard coded username (case insensitive) and password (case sensitive). Correct user input brings user to Welcome page.
			if (username.equalsIgnoreCase("Student2022") && password.equals("Java123!")) {
				HttpSession session = request.getSession(true);
				session.setAttribute("Username", username);
				RequestDispatcher rd = request.getRequestDispatcher("welcome");
				rd.forward(request, response);
			}
			else
			{	// Invalid input brings user to the login/index page. Prompts user to try their login again.
				PrintWriter out=response.getWriter(); // Out object prints output on web browser.
				out.println("Sorry, your username or password is invalid. Try again.");
				RequestDispatcher rd=request.getRequestDispatcher("index.html"); // Directs to login/index page.
				rd.include(request, response);
		}
	}
	

}
