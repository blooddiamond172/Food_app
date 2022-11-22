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
				
		User user = null; 
		
		boolean result3 = checkAccoutAD(phoneNumber,password);
		
		if (!result1 ||	!result2 ) {
			resp.sendRedirect("login.jsp");
			return;
		}
		
		if (result3) {
			resp.sendRedirect("admin-page");
			return;
		}
		
		user = userDAO.getUser(phoneNumber, password);
		if (user == null) {
			resp.sendRedirect("login.jsp");
			return;
		}
		
		req.getSession().setAttribute("user", user);
		req.getServletContext().setAttribute("userID", user.getUserID());
		resp.sendRedirect("index.jsp");
		return;
	}

	private boolean checkAccoutAD(String phoneNumber, String password) {
		return ((phoneNumber.compareTo("0973171717") == 0) && 
				(password.compareTo("Admin12345") == 0));
	}

	private boolean checkCondition(String attribute, String condition) {
		return Pattern.compile(condition).matcher(attribute).matches();
	}
	
}

