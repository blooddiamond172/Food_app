package com.dungnv.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.IDebugRequestor;

import com.dungnv.dao.CommentDAO;
import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Comment;
import com.dungnv.model.Product;
import com.dungnv.model.User;

@WebServlet(urlPatterns = {"/post-comment"})
public class PostCommentsServlet extends HttpServlet {
	private ProductDAO productDAO;
	private CommentDAO commentDAO;

	
	@Override
	public void init() throws ServletException {
		productDAO = new ProductDAO();
		commentDAO = new CommentDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		
		boolean result1 = checkSession(user);
		
		int userID;
		
		String productID;
		
		String commentOfUser;
		
		Comment comment;
		
		if (result1) {
			resp.sendRedirect("login.jsp");
			return;
		}
		
		userID = user.getUserID();
		
		productID = req.getParameter("id");
		
		commentOfUser = req.getParameter("comment");
		
		comment = new Comment(userID, productID, commentOfUser);
		commentDAO.insertComment(comment);
		
		resp.setHeader("Refresh", "0; URL=" + req.getContextPath() + "/product?id=" + productID);
		return;
	}

	private boolean checkSession(User user) {
		return ((user == null));
	}
	
}
