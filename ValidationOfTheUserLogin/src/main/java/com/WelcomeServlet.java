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


@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public WelcomeServlet() {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		
		// If user enters a correct username and password, the Welcome page appears.
		if (session != null) {
			String username=(String)session.getAttribute("Username");
			out.println("Welcome " + username + "!");
			out.println("<br><a href='logout'>Log out</a>"); // User option to log out of account.
	}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("index.html"); // Directs to login/index page.

			rd.include(request, response);
		}
		out.close();
	}
}
