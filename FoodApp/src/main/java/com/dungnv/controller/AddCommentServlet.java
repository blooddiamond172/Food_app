package com.dungnv.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dungnv.dao.CommentDAO;
import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Comment;
import com.dungnv.model.Product;
import com.dungnv.model.User;

@WebServlet(urlPatterns = {"/add-comment"})
public class AddCommentServlet extends HttpServlet {
	private ProductDAO productDAO;
	private CommentDAO commentDAO;

	
	@Override
	public void init() throws ServletException {
		productDAO = new ProductDAO();
		commentDAO = new CommentDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String comment = req.getParameter("comment");
		HttpSession httpSession = req.getSession();
		User user = (User) httpSession.getAttribute("user");
		Integer userID = user.getUserID();
		String productID = req.getParameter("id");
		Comment cmt = new Comment(userID,productID,comment);
		commentDAO.insertComment(cmt);
		resp.sendRedirect("products");
		return;
	}
}
