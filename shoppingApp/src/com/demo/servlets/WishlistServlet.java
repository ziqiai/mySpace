package com.demo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.CartService;
import com.demo.service.WishlistService;

/**
 * Servlet implementation class WishListServlet
 */
@WebServlet("/WishListServlet")
public class WishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = String.valueOf(request.getSession().getAttribute("userID"));
		String pid = request.getParameter("product_id");
		String pimage = request.getParameter("product_image");
		if(!uid.equals("null")) {
			add_to_wishlist(uid, pid, pimage);
		}
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = String.valueOf(request.getSession().getAttribute("userID"));
		String pid = request.getParameter("product_id");
		String action = request.getParameter("action");
		if (action.equals("delete")) {
			delete_item(uid, pid);
		}
		if(action.equals("move")) {
			String pimage = request.getParameter("product_image");
			move_item_to_cart(uid, pid, pimage);
		}
		response.sendRedirect("wishlist.jsp");
	}

	private void add_to_wishlist(String uid, String pid, String pimage) {
		WishlistService wishlistService = new WishlistService();
		wishlistService.insert(uid, pid, pimage);
	}

	private void delete_item(String uid, String pid) {
		WishlistService wishlistService = new WishlistService();
		wishlistService.delete(uid, pid);
	}

	private void move_item_to_cart(String uid, String pid, String pimage) {
		CartService cartService = new CartService();
		cartService.insert_from_wishlist_to_cart(uid, pid, pimage);
	}

}
