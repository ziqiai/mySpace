package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.Item;
import com.demo.service.CartService;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")

public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShopServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = String.valueOf(request.getSession().getAttribute("userID"));
		String pid = request.getParameter("product_id");
		String quantity = request.getParameter("quantity");
		String pimage = request.getParameter("product_image");
		System.out.println("Product_id: " + pid + ", quantity: " + quantity + ", user_id: " + uid
				+ ", product_image:" + pimage);
		add_to_cart(uid, pid, quantity, pimage);
		response.sendRedirect("dashboard.jsp");
	}

	private void add_to_cart(String uid, String pid, String quantity, String pimage) {
		CartService cartService = new CartService();
		cartService.update_cart(uid, pid, quantity, pimage);
	}

}
