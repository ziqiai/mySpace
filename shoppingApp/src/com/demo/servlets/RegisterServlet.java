package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.User;
import com.demo.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		PrintWriter out = response.getWriter();

		boolean existUser = uService.checkUsername(user);
		if (existUser) {
			out.println("<body text='red'>");
			out.println("<h3>User Already Existed!</h3>");
			out.println("</body>");
		}
		else {
			int key = uService.insert(user);
			System.out.println("key is: " + key);
			response.sendRedirect("loginform.jsp");
		}
	}

}
