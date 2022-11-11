package com.dungnv.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.model.Product;

@WebServlet(urlPatterns = { "/get-result" })
public class GetSearchingServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Product> products = new ArrayList<>();
		
		products = (ArrayList<Product>) getServletContext()
											.getAttribute("products-of-searching");	
		req.setAttribute("products", products);
		req.getRequestDispatcher("order.jsp").forward(req, resp);
		return;
	}

}
