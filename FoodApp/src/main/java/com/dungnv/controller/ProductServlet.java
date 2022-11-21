package com.dungnv.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.CommentDAO;
import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Comment;
import com.dungnv.model.Product;

@WebServlet(urlPatterns = {"/product"})
public class ProductServlet extends HttpServlet {
	private CommentDAO commentDAO;
	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
		productDAO = new ProductDAO();
		commentDAO = new CommentDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		Product product = productDAO.getProduct(id);
		
		ArrayList<Comment> comments = commentDAO.getComments(id);
		
		req.setAttribute("product", product);
		req.setAttribute("comments", comments);
		req.getRequestDispatcher("product.jsp").forward(req, resp);
		return;
	}
	
}
