package com.dungnv.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.UserDAO;
import com.dungnv.model.User;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
	private UserDAO userDAO;
	
	@Override
	public void init() throws ServletException {
		userDAO = new UserDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phoneNumber = req.getParameter("phoneNumber");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String repassword = req.getParameter("password2");
		String address = req.getParameter("address");
		if (password.compareTo(repassword) == 0) {
			String regex = "[0-9]{8,15}";
			String reg = "[A-Z][[a-z0-9]+]{8,15}";
			Pattern pattern = Pattern.compile(regex);
			Pattern pattern1 = Pattern.compile(reg);
			Matcher matcher = pattern.matcher(phoneNumber);
			Matcher matcher1 = pattern1.matcher(password);
			if (matcher.matches()) {
				if (matcher1.matches()) {
					User user = new User(phoneNumber,username,password,address);
					int result = userDAO.addUser(user);
					if (result != 0) {
						req.getRequestDispatcher("index.jsp").forward(req, resp);
						return;
					}
				}
			}
		}
		req.getRequestDispatcher("register.jsp").forward(req, resp);
		return;
	}
}
