package com.dungnv.controller.adminPage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Product;

@WebServlet(urlPatterns = {"/admin-page"})
public class AdminPageServlet extends HttpServlet {
	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
		productDAO = new ProductDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Product> listOfProduct = new ArrayList<>();
		listOfProduct = productDAO.getProducts();
		req.setAttribute("listOfProduct", listOfProduct);
		req.getRequestDispatcher("adminPage.jsp").forward(req, resp);
		return;
	}
}
