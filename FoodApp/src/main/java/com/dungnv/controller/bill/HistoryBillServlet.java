package com.dungnv.controller.bill;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungnv.dao.BillDAO;
import com.dungnv.dao.CartDAO;
import com.dungnv.model.Bill;
import com.dungnv.model.User;
import com.dungnv.model.UserCart;

@WebServlet(urlPatterns = { "/history-bill" })
public class HistoryBillServlet extends HttpServlet {
	private BillDAO billDAO;
	private CartDAO cartDAO;
	
	@Override
	public void init() throws ServletException {
		billDAO = new BillDAO();
		cartDAO = new CartDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer cartID = (Integer) req.getServletContext().getAttribute("cartID");
		
		Integer billID = (Integer) req.getServletContext().getAttribute("billID");

		ArrayList<Bill> bills = new ArrayList<>();
		
		Integer total;
		
		if (cartID == null || billID == null) {
			req.getRequestDispatcher("history-bill.jsp").forward(req, resp);
			return;
		}
		
		bills = billDAO.getProductInBill(billID,cartID);
		
		total = (Integer) req.getServletContext().getAttribute("total");

		req.setAttribute("total", total);
		req.setAttribute("bills", bills);
		req.getRequestDispatcher("history-bill.jsp").forward(req, resp);
		return;
	}
	
}
