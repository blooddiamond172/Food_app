package com.dungnv.controller;

import java.awt.PageAttributes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import org.eclipse.jdt.internal.compiler.env.IGenericField;

import com.dungnv.dao.UserDAO;
import com.dungnv.model.User;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private UserDAO userDAO;

	@Override
	public void init() throws ServletException {
		userDAO = new UserDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String phoneNumber = req.getParameter("phoneNumber");
		
		String password = req.getParameter("password");
		
		String conditionOfPhoneNumber = "[0-9]{8,15}";
		
		String conditionOfPassword = "[A-Z][a-z0-9]{6,9}";
		
		boolean result1 = checkCondition(phoneNumber, conditionOfPhoneNumber);
		
		boolean result2 = checkCondition(password, conditionOfPassword);
		
		ArrayList<User> users = new ArrayList<>();
		
		User user = null; 
		
		if (!result1 ||	!result2 ) {
			resp.sendRedirect("login.jsp");
			return;
		}
		
		users = userDAO.getUserList(phoneNumber);
		if (users.isEmpty()) {
			resp.sendRedirect("login.jsp");
			return;
		}
		
		user = validateUser(users, phoneNumber, password);
		if (user == null) {
			resp.sendRedirect("login.jsp");
			return;
		}
		
		req.getSession().setAttribute("user", user);
		resp.sendRedirect("index.jsp");
		return;
	}

	private User validateUser(ArrayList<User> users, 
							  String phoneNumber, 
							  String password) {
		for (User user : users) {
			if (user.getPhoneNumber().compareTo(phoneNumber) == 0 && 
				user.getPassword().compareTo(password) == 0) {
				return user;
			}
		}
		return null;
	}

	private boolean checkCondition(String attribute, String condition) {
		return Pattern.compile(condition).matcher(attribute).matches();
	}
	
}

