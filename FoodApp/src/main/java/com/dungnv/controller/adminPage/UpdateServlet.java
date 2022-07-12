//package com.dungnv.controller.adminPage;
//
//import java.io.IOException;
//import java.net.URL;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.dungnv.dao.ProductDAO;
//import com.dungnv.model.Product;
//
//@WebServlet(urlPatterns = {"/update"})
//public class UpdateServlet extends HttpServlet {
//	private ProductDAO productDAO;
//	
//	@Override
//	public void init() throws ServletException {
//		productDAO = new ProductDAO();
//	} 
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doGet(req, resp);
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("id");
//		String name = req.getParameter("nameEdit");
//		Integer price = Integer.valueOf(req.getParameter("priceEdit"));
//		String shortDescription = req.getParameter("shortDescriptionEdit");
//		String imageLink = req.getParameter("imageLinkEdit");
//		Product newProduct = new Product(id,name,price,imageLink,shortDescription);
//		int result = productDAO.updateProduct(newProduct);
//		if (result != 0) {
//			try {
//				resp.sendRedirect("admin-page");
//				return;
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		try {
//			resp.sendRedirect("edit");
//			return;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//}
