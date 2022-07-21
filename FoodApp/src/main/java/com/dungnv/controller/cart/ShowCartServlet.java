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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		Integer userID = user.getUserID();
		UserCart uc = cartDAO.getUserCart(userID);
		Integer cartID = uc.getCartID();
		req.setAttribute("cartID", cartID);
		ArrayList<Cart> cart = cartDAO.getCart(cartID);
		req.setAttribute("cart", cart);
		Integer total = cartDAO.getToTal(cartID);
		req.setAttribute("total", total);
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
		return;
	}
}