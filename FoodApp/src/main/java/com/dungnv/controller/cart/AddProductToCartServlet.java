package com.dungnv.controller.cart;

import java.io.IOException;

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

@WebServlet(urlPatterns = {"/create-cart"})
public class AddProductToCartServlet extends HttpServlet {
	private CartDAO cartDAO;
	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
		cartDAO = new CartDAO();
		productDAO = new ProductDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		Integer userID = (Integer) req.getServletContext().getAttribute("userID");
		
		Integer cartID = (Integer) req.getServletContext().getAttribute("cartID");
						
		String productID; 
				
		int result;
				
		if(userID == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
				
		if (cartID == null) {
			cartDAO.createCartID(userID);
			cartID = cartDAO.getCartID(userID);
			req.getServletContext().setAttribute("cartID", cartID);
		}
				
		productID = req.getParameter("idP");
		
		Product product = productDAO.getProduct(productID);
				
		result = checkExist(cartID, productID);
		if (result == 1) {
			cartDAO.updateCart(cartID, product);
		} else {
			cartDAO.addProductToCart(cartID, product);
		}
		
		req.getRequestDispatcher("products").forward(req, resp);
		return;
	}

	private int checkExist(Integer cartID, String productID) {
		return (cartDAO.isExist(cartID, productID));
	}
	
}
