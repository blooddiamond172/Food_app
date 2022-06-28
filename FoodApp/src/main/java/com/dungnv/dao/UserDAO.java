package com.dungnv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dungnv.model.User;
import com.oracle.wls.shaded.org.apache.regexp.recompile;

public class UserDAO {
	private static String URL = "jdbc:mysql://localhost:3306/food_app";
	private static String username = "root";
	private static String password = "nguyenvandung";
	
	private String SELECT_USER = "SELECT * FROM food_app.user WHERE phone_number = ?;";
	private String INSERT_USER = "INSERT INTO food_app.user(username,password,phone_number,address)"
			+ " VALUE(?,?,?,?);"; 
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkAccount(User user) {
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER);
			preparedStatement.setString(1, user.getPhoneNumber());
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String phone = resultSet.getString("phone_number");
				String password = resultSet.getString("password");
				User user1 = new User(phone, password);
				if (user.getPhoneNumber().equals(user1.getPhoneNumber())
						&& user.getPassword().equals(user1.getPassword())){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int addUser(User user) {
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USER);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getPhoneNumber());
			preparedStatement.setString(4, user.getAddress());
			System.out.println(preparedStatement);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
}
}
