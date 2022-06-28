package com.dungnv.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		String phoneNumber = req.getParameter("phoneNumber");
		String password = req.getParameter("password");
		String regex = "[A-Z][[a-z0-9]+]{8,15}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			User user = new User(phoneNumber, password);
			boolean result = userDAO.checkAccount(user);
			if (result) {
				req.getSession().setAttribute("password", password);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				return;
			}
		}
		req.getRequestDispatcher("login.jsp").forward(req, resp);
		return;
	}
}
