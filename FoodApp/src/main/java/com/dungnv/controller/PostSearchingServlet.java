package com.dungnv.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Product;

@WebServlet(urlPatterns = {"/post-name-of-product"})
public class PostSearchingServlet extends HttpServlet {
	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
		productDAO = new ProductDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
							throws ServletException, IOException {
		String name = req.getParameter("name-product");
		
		ArrayList<Product> products = new ArrayList<>();
		
		products = productDAO.searchProduct(name);
		getServletContext().setAttribute("products-of-searching", products);
		resp.sendRedirect("get-result");
		return;
	}
	
}
