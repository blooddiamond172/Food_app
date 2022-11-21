package com.dungnv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dungnv.model.Comment;

public class CommentDAO {
	private static String URL = "jdbc:mysql://localhost:3306/food_app";
	private static String username = "root";
	private static String password = "nguyenvandung";
	Connection con = getConnection();
	
	private String SELECT_ALL_COMMENT = 
			"SELECT * FROM food_app.comment WHERE product_id=?"
			+ " LIMIT 4;";
	private String SELECT_USERNAME = 
			"SELECT username"
			+ " FROM user as u join comment as cmt on u.user_id = cmt.user_id"
			+ " WHERE product_id like ?;";
	
	private String INSERT_COMMENT = 
			"INSERT INTO food_app.comment(user_id, product_id, short_comment) VALUES(?,?,?);";
	
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insertComment(Comment comment) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_COMMENT);
			preparedStatement.setInt(1, comment.getUserID());
			preparedStatement.setString(2, comment.getProductID());
			preparedStatement.setString(3, comment.getComment());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<Comment> getComments(String id) {
		ArrayList<Comment> comments = new ArrayList<>();
		
		try {
			ResultSet resultSet1;
			ResultSet resultSet2;
			PreparedStatement preparedStatement1 = con.prepareStatement(SELECT_ALL_COMMENT);
			PreparedStatement preparedStatement2 = con.prepareStatement(SELECT_USERNAME);
			preparedStatement1.setString(1, id);
			resultSet1 = preparedStatement1.executeQuery();
			preparedStatement2.setString(1, id);
			resultSet2 = preparedStatement2.executeQuery();
			while (resultSet1.next() && resultSet2.next()) {
				Integer userID = resultSet1.getInt("user_id");
				String username = resultSet2.getString("username");
				String productID = resultSet1.getString("product_id");
				String comment = resultSet1.getString("short_comment");
				Comment cmt = new Comment(userID,username,productID,comment);
				comments.add(cmt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return comments;
	}
	
}
