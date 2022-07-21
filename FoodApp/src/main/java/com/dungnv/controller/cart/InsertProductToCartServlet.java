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
public class InsertProductToCartServlet extends HttpServlet {
	private CartDAO cartDAO;
	private ProductDAO productDAO;
	Integer cartID;
	
	@Override
	public void init() throws ServletException {
		cartDAO = new CartDAO();
		productDAO = new ProductDAO();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		if(user == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		Integer id = user.getUserID();
		if (cartID == null) {
			cartDAO.createCart(id);
		}
		UserCart uc = cartDAO.getUserCart(id);
		cartID = uc.getCartID();
		String productID = req.getParameter("idP");
		Product product = productDAO.getProduct(productID);
		Cart cart = cartDAO.getProductInCart(product,cartID);
		if (cart != null) {
			cartDAO.updateProductToCart(cart);
		} else {
			cartDAO.insertProductToCart(cartID,productID,product.getPrice());
		}
		req.getRequestDispatcher("products").forward(req, resp);
		return;
	}
}
