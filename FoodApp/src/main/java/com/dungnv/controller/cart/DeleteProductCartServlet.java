package com.dungnv.controller.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.CartDAO;


@WebServlet(urlPatterns = {"/delete-product-in-cart"})
public class DeleteProductCartServlet extends HttpServlet {
	private CartDAO cartDAO;
	
	@Override
	public void init() throws ServletException {
		cartDAO = new CartDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productID = req.getParameter("productID");
		
		Integer cartID = (Integer) req.getServletContext().getAttribute("cartID");
				
		cartDAO.deleteProductInCart(cartID,productID);
		req.getRequestDispatcher("your-cart").forward(req, resp);
		return;
	}
	
}

