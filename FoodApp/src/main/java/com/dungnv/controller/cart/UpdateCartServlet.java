//package com.dungnv.controller.cart;
//
//import java.io.IOException;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.dungnv.dao.CartDAO;
//
//
//@WebServlet(urlPatterns = {"/update-cart"})
//public class UpdateCartServlet extends HttpServlet {
//	private CartDAO cartDAO;
//	
//	@Override
//	public void init() throws ServletException {
//		cartDAO = new CartDAO();
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer number = Integer.valueOf(req.getParameter("numberOfProduct"));
//		String regex = "[0-9]+";
//		Matcher matcher = Pattern.compile(regex).matcher(String.valueOf(number));
//		if (matcher.matches()) {
//			cartDAO.updateCart(number);
//		}
//	}
//}
//
