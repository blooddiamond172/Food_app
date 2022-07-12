package com.dungnv.controller.adminPage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/new"})
public class NewFormServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.getRequestDispatcher("adminPage-add.jsp").forward(req, resp);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
