package com.dungnv.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.ProductDAO;
import com.dungnv.model.Product;

@WebServlet(urlPatterns = {"/"})
public class CategoryServlet extends HttpServlet {
	private ProductDAO productDAO;
	
	@Override
	public void init() throws ServletException {
		productDAO = new ProductDAO();
	} 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case "/burger":
			getBurgerList(req,resp);
			break;
		case "/bakery":
			getBakeryList(req,resp);
			break;
		case "/drink":
			getDrinkList(req,resp);
			break;
		case "/pizza":
			getPizzaList(req,resp);
			break;
		case "/kfc":
			getKfcList(req,resp);
			break;
		case "/lower50":
			getProductsLower50(req,resp);
			break;
		case "/between50and100":
			getProductsBetween50and100(req,resp);
			break;		
		case "/higher100":
			getProductsHigher100(req,resp);
			break;
		default:
			req.getRequestDispatcher("order.jsp").forward(req, resp);
			break;
		}
	}

	private void getProductsHigher100(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Product> products = new ArrayList<>();
		products = productDAO.getListOfProductHigher();
		req.setAttribute("products", products);
		try {
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;
	}

	private void getProductsBetween50and100(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Product> products = new ArrayList<>();
		products = productDAO.getListOfProductBetween50and100();
		req.setAttribute("products", products);
		try {
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;
	}

	private void getProductsLower50(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Product> products = new ArrayList<>();
		products = productDAO.getListOfProductLower50();
		req.setAttribute("products", products);
		try {
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;
	}

	private void getKfcList(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Product> kfcs = new ArrayList<>();
		kfcs = productDAO.getKfcs();
		req.setAttribute("products", kfcs);
		try {
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;
	}

	private void getPizzaList(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Product> pizzas = new ArrayList<>();
		pizzas = productDAO.getPizzas();
		req.setAttribute("products", pizzas);
		try {
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;
	}

	private void getDrinkList(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Product> drinks = new ArrayList<>();
		drinks = productDAO.getDrinks();
		req.setAttribute("products", drinks);
		try {
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;
	}

	private void getBakeryList(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Product> bakerys = new ArrayList<>();
		bakerys = productDAO.getBakerys();
		req.setAttribute("products", bakerys);
		try {
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;
	}

	private void getBurgerList(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Product> burgers = new ArrayList<>();
		burgers = productDAO.getBurgers();
		req.setAttribute("products", burgers);
		try {
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return;

	}
}
