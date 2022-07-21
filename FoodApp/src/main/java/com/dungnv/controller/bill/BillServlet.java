package com.dungnv.controller.bill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.BillDAO;
import com.dungnv.dao.CartDAO;
import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Bill;
import com.dungnv.model.Cart;
import com.dungnv.model.Product;
import com.dungnv.model.User;
import com.dungnv.model.UserBill;
import com.dungnv.model.UserCart;

@WebServlet(urlPatterns = {"/show-bill"})
public class BillServlet extends HttpServlet {
	private BillDAO billDAO;
	private CartDAO cartDAO;
	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
		billDAO = new BillDAO();
		cartDAO = new CartDAO();
		productDAO = new ProductDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		Integer userID = user.getUserID();
		Integer billID = billDAO.getBillID(userID);
		UserCart userCart = cartDAO.getUserCart(userID);
		Integer cartID = userCart.getCartID();
		ArrayList<Bill> bills = billDAO.getProductInBill(billID,cartID);
		Integer total = cartDAO.getToTal(cartID);
		req.setAttribute("total", total);
		req.setAttribute("bills", bills);
		req.getRequestDispatcher("bill.jsp").forward(req, resp);
		return;
	}
}
