package com.dungnv.controller.category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Product;

@WebServlet(urlPatterns = { "/category-pizza" })
public class PizzaServlet extends HttpServlet {
	private ProductDAO productDAO;

	@Override
	public void init() throws ServletException {
		productDAO = new ProductDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Product> pizzas = new ArrayList<>();
		pizzas = productDAO.getPizzas();
		req.setAttribute("products", pizzas);
		try {
			req.getRequestDispatcher("order.jsp").forward(req, resp);
			return;
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
