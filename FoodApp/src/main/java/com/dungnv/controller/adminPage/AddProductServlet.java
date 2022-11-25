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
public class AddProductServlet extends HttpServlet {
	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
		productDAO = new ProductDAO();
	} 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productID = req.getParameter("productID");
		
		String name = req.getParameter("name");
		
		Integer price = Integer.valueOf(req.getParameter("price"));
		
		String imageLink = req.getParameter("imageLink");
		
		String shortDescription = req.getParameter("shortDescription");
		
		int result1;
		
		Product newProduct = null;
		
		int result2;
		
		if (productID == null || name == null || price == null ||
			imageLink == null || shortDescription == null) {
			resp.sendRedirect("adminPage-add.jsp");
			return;
		}
		
		result1 = productDAO.checkProductID(productID);
		if (result1 == 1) {
			resp.sendRedirect("adminPage-add.jsp");
			return;
		}
		
		newProduct = new Product(productID, name, price, imageLink, shortDescription);
		
		result2 = productDAO.addProduct(newProduct);
		if(result2 == 0) {
			resp.sendRedirect("adminPage-add.jsp");
			return;
		}
		
		resp.sendRedirect("admin-page");
		return;
	}
	
}
