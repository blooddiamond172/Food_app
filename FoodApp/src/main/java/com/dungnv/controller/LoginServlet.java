package com.dungnv.controller;

import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<User> users = new ArrayList<>();
		String phoneNumber = req.getParameter("phoneNumber");
		String password = req.getParameter("password");
		users = userDAO.checkAccount(phoneNumber);
		for (User user : users) {
			if (phoneNumber.equals(user.getPhoneNumber()) && 
					password.equals(user.getPassword())) {
				req.getSession().setAttribute("password", password);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
				return;
			}
		}
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
