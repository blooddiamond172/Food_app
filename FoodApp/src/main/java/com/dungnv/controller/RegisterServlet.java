package com.dungnv.controller;

import java.io.IOException;
import java.nio.channels.NonReadableChannelException;
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String phoneNumber = req.getParameter("phoneNumber");
		
		String username = req.getParameter("username");
		
		String password = req.getParameter("password");
		
		String repassword = req.getParameter("password2");
		
		String address = req.getParameter("address");
		
		String conditionOfPhoneNumber = "[0-9]{8,15}";
		
		String conditionOfPassword = "[A-Z][a-z0-9]{6,9}";

		boolean result1 = checkCondition(phoneNumber, conditionOfPhoneNumber);
		
		boolean result2 = checkCondition(password, conditionOfPassword);
		
		boolean result3 = comparePassword(password, repassword);
		
		int result4;
		
		User user = null;
		
		int resultOfRegister;
		
		if (!result1 ||	!result2 || !result3) {
			resp.sendRedirect("register.jsp");
			return;
		}
		
		result4 = checkExist(phoneNumber);
		if (result4 == 1) {
			resp.sendRedirect("register.jsp");
			return;
		}
		
		user = new User(phoneNumber, username, password, address);
		
		resultOfRegister = userDAO.addUser(user);
		if (resultOfRegister == 0) {
			resp.sendRedirect("register.jsp");
			return;
		}
		
		resp.sendRedirect("login.jsp");
	}
	
	private int checkExist(String phoneNumber) {
		return (userDAO.existOfPhoneNumber(phoneNumber));
	}

	private boolean comparePassword(String password, String repassword) {
		return (password.compareTo(repassword) == 0);
	}

	private boolean checkCondition(String attribute, String condition) {
		return Pattern.compile(condition).matcher(attribute).matches();
	}
	
}
