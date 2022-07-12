package com.dungnv.controller;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<User> users = new ArrayList<>();
		String phoneNumber = req.getParameter("phoneNumber");
		String password = req.getParameter("password");
		String regex1 = "[0-9]{8,15}";
		String regex2 = "[A-Z][[a-z0-9]+]{8,15}";
		Pattern pattern1 = Pattern.compile(regex1);
		Pattern pattern2 = Pattern.compile(regex2);
		Matcher matcher1 = pattern1.matcher(phoneNumber);
		Matcher matcher2 = pattern2.matcher(password);
		if (matcher1.matches() && matcher2.matches()) {
			if (phoneNumber.equals("1900171717") && password.equals("Admin123")) {
				resp.sendRedirect("admin-page");
			} else {
			for (User user : users) {
				if (phoneNumber.equals(user.getPhoneNumber()) && 
						password.equals(user.getPassword())) {
					HttpSession httpSession = req.getSession();
					httpSession.setAttribute("user", user);
					resp.sendRedirect("index.jsp");
					return;
				}
			}
			resp.sendRedirect("login.jsp");
			}
		} else {
			resp.sendRedirect("login.jsp");
		}
	}
}
