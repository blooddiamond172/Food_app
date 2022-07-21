package com.dungnv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dungnv.model.Bill;
import com.dungnv.model.Cart;
import com.dungnv.model.Product;
import com.dungnv.model.User;
import com.dungnv.model.UserBill;

public class BillDAO {
	private static String URL = "jdbc:mysql://localhost:3306/food_app";
	private static String username = "root";
	private static String password = "nguyenvandung";
	
	private String SELECT_BILL_ID = 
			"SELECT * FROM user_bill\r\n"
			+ "WHERE user_id = ?\r\n"
			+ "ORDER BY bill_id DESC\r\n"
			+ "LIMIT 1;";
	private String SELECT_PRODUCT_INFORMATION = 
			"SELECT * FROM\r\n"
			+ "(SELECT p.product_id, p.name, p.image_link, c.quantity, c.new_price\r\n"
			+ "FROM product as p JOIN cart as c USING (product_id)\r\n"
			+ "WHERE cart_id=?) as a JOIN bill USING (product_id)\r\n"
			+ "WHERE bill_id = ?;";
	
	private String CREATE_BILL_ID = 
			"INSERT INTO user_bill(user_id) "
			+ "VALUES (?);";
	private String INSERT_BILL = 
			"INSERT INTO bill VALUES (?,?,?);";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int createBillID(Integer userID) {
		Connection con = getConnection();
		try {
			PreparedStatement pre = con.prepareStatement(CREATE_BILL_ID);
			pre.setInt(1, userID);
			return pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int getBillID(Integer userID) {
		Connection con = getConnection();
		try {
			PreparedStatement pre = con.prepareStatement(SELECT_BILL_ID);
			pre.setInt(1, userID);
			ResultSet resultSet = pre.executeQuery();
			while (resultSet.next()) {
				Integer billID = resultSet.getInt("bill_id");
				return billID;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int insertBill(Integer billID, ArrayList<Cart> carts,
			Integer userID) {
		Connection con = getConnection();
		int result = 0;
		for (Cart cart : carts) {
			try {
				PreparedStatement pre = con.prepareStatement(INSERT_BILL);
				pre.setInt(1, billID);
				pre.setString(2, cart.getProduct().getProductID());
				pre.setInt(3, userID);
				System.out.println(pre);
				result = pre.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;	
	}

	public ArrayList<Bill> getProductInBill(Integer billID, Integer cartID) {
		Connection con = getConnection();
		ArrayList<Bill> bills = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_PRODUCT_INFORMATION);
			preparedStatement.setInt(1, cartID);
			preparedStatement.setInt(2, billID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("product_id");
				String name = resultSet.getString("name");
				String imageLink = resultSet.getString("image_link");
				Integer quantity = resultSet.getInt("quantity");
				Integer newPrice = resultSet.getInt("new_price");
				Product product = new Product(id,name,imageLink);
				Cart cart = new Cart(cartID,product,quantity,newPrice);
				Bill bill = new Bill(billID,cart);
				bills.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bills;
	}
}
