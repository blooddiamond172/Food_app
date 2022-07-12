package com.dungnv.controller.adminPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Product;

@WebServlet(urlPatterns = {"/edit"})
public class EditFormServlet extends HttpServlet {
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
		String id = req.getParameter("id");
		Product productEdit = productDAO.getProduct(id);
		req.setAttribute("productEdit", productEdit);
		try {
			req.getRequestDispatcher("adminPage-edit.jsp").forward(req, resp);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
