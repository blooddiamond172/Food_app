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
import com.dungnv.model.User;
import com.dungnv.model.UserBill;

@WebServlet(urlPatterns = {"/create-bill"})
public class CreateBillServlet extends HttpServlet {
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
		Integer userID = (Integer) req.getServletContext().getAttribute("userID");

		billDAO.createBillID(userID);
		req.getRequestDispatcher("insert-product-to-bill").forward(req, resp);
		return;
	}
}
