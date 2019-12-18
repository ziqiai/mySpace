package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.Item;
import com.demo.model.User;
import com.demo.service.CartService;
import com.demo.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		UserService uService = new UserService();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if (session.getAttribute("userID") != null) {
			out.println("<body text='red'>");
			out.println("<h3>Already logged in!</h3>");
			out.println("</body>");
		} else {
			int uid = uService.getUserId(user);
			if (uid != 0 && uService.checkPassword(user)) {
				session.setAttribute("userID", uid);
				response.sendRedirect("dashboard.jsp");
			} else {
				response.sendRedirect("error.html");
			}
		}
	}

}
