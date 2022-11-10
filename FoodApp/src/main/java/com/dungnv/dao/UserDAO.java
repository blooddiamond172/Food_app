package com.dungnv.dao;

import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dungnv.model.User;
import com.oracle.wls.shaded.org.apache.regexp.recompile;

public class UserDAO {
	private static String URL = "jdbc:mysql://localhost:3306/food_app";
	private static String username = "root";
	private static String password = "nguyenvandung";
	
	private static String SELECT_USER = 
			"SELECT * FROM food_app.user WHERE phone_number = ? and password = ?;";
	private static String SELECT_USERS = 
			"SELECT * FROM food_app.user;";
	private static String INSERT_USER = 
			"INSERT INTO food_app.user(username,password,phone_number,address)"
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

	public User getUser(String phone, String pass) {		
		Connection con = getConnection();
		
		PreparedStatement preparedStatement; 
		
		ResultSet resultSet;
				
		try {
			preparedStatement = con.prepareStatement(SELECT_USER);
			preparedStatement.setString(1, phone);
			preparedStatement.setString(2, pass);
			
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Integer userID = resultSet.getInt("user_id");
				
				String phoneNumber = resultSet.getString("phone_number");
					
				String password = resultSet.getString("password");
					
				String username = resultSet.getString("username");
					
				String address = resultSet.getString("address");
					
				return (new User(userID,username, password, phoneNumber, address));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int addUser(User user) {
		Connection con = getConnection();
		
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = con.prepareStatement(INSERT_USER);
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

	public static List<User> getUsers() {
		Connection con = getConnection();
		List<User> users = new ArrayList<>();
		PreparedStatement pre;
		try {
			pre = con.prepareStatement(SELECT_USERS);
			System.out.println(pre);
			ResultSet resultSet = pre.executeQuery();
			while (resultSet.next()) {
				Integer userID = resultSet.getInt("user_id");
				String userName = resultSet.getString("username");
				String password = resultSet.getString("password");
				String phoneNumber = resultSet.getString("phone_number");
				String address = resultSet.getString("address");
				User user = new User(userID, userName, password, phoneNumber, address);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
