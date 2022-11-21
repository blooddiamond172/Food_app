package com.dungnv.controller.cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.CartDAO;
import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Cart;
import com.dungnv.model.Product;
import com.dungnv.model.User;
import com.dungnv.model.UserCart;

@WebServlet(urlPatterns = {"/your-cart"})
public class ShowCartServlet extends HttpServlet {
	private CartDAO cartDAO;
	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
		cartDAO = new CartDAO();
		productDAO = new ProductDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		
		Integer userID;
		
		Integer cartID = (Integer) req.getServletContext().getAttribute("cartID");
				
		ArrayList<Cart> carts = new ArrayList<>();
		
		ArrayList<Product> products = new ArrayList<>();
		
		Integer total;
	
		if (user == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		} 
		
		userID = user.getUserID();
		
		if (cartID == null) {
			req.getRequestDispatcher("cart.jsp").forward(req, resp);
			return;
		}
		
		cartID = cartDAO.getCartID(userID);
				
		carts = cartDAO.getCart(cartID);
			
		total = cartDAO.getToTal(cartID);
		
		req.setAttribute("carts", carts);
		req.setAttribute("total", total);
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
		return;
	}
	
}