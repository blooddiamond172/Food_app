package com.dungnv.controller.adminPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Product;

@WebServlet(urlPatterns = {"/insert"})
public class AddServlet extends HttpServlet {
	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
		productDAO = new ProductDAO();
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productID = req.getParameter("productID");
		String name = req.getParameter("name");
		Integer price = Integer.valueOf(req.getParameter("price"));
		String imageLink = req.getParameter("imageLink");
		String shortDescription = req.getParameter("shortDescription");
		boolean result = productDAO.checkIDProduct(productID);
		if (result) {
			Product product = new Product(productID, name, price, imageLink, shortDescription);
			int res = productDAO.addProduct(product);
			if (res != 0) {
				try {
					resp.sendRedirect("admin-page");
					return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			resp.sendRedirect("adminPage-add.jsp");
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
