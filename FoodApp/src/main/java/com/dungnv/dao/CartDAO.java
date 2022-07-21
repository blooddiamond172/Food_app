package com.dungnv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dungnv.model.Cart;
import com.dungnv.model.Product;
import com.dungnv.model.UserCart;

public class CartDAO {
	private static String URL = "jdbc:mysql://localhost:3306/food_app";
	private static String username = "root";
	private static String password = "nguyenvandung";
	
	private String SELECT_USER_CART = 
			"SELECT * FROM user_cart \r\n"
			+ "WHERE user_id = ? \r\n"
			+ "order by cart_id DESC "
			+ "LIMIT 1;";
	private String SELECT_PRODUCT_IN_CART = 
			"SELECT p.product_id, p.name, p.price, p.image_link, p.short_description, c.quantity, c.new_price\r\n"
			+ "FROM product as p join cart as c USING (product_id)\r\n"
			+ "WHERE cart_id = ?;";
	private String SELECT_PRODUCT_ID = 
			"SELECT * FROM food_app.cart "
			+ "WHERE cart_id = ? and product_id = ?;";
	private String SELECT_TOTAL = 
			"SELECT sum(new_price) as \"total\" FROM food_app.cart\r\n"
			+ "WHERE cart_id = ?;";
	
	private String INSERT_CART = 
			"INSERT INTO food_app.user_cart(user_id) VALUE(?);";
	private String INSERT_PRODUCT_TO_CART =
			"INSERT INTO food_app.cart VALUES(?,?,?,?);";
	private String DELETE_PRODUCT_IN_CART =
			"DELETE FROM food_app.cart "
			+ "WHERE cart_id=? and product_id=? ;";
	private String UPDATE_PRODUCT_IN_CART =
			"UPDATE cart SET quantity=?, new_price=? "
			+ "WHERE cart_id = ? and product_id = ?;";
	
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int createCart(Integer id) {
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_CART);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public UserCart getUserCart(Integer id) {
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER_CART);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer cartID = resultSet.getInt("cart_id");
				Integer userID = resultSet.getInt("user_id");
				UserCart uc = new UserCart(cartID,userID);
				return uc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insertProductToCart(Integer cartID, String productID,
			Integer price) {
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_PRODUCT_TO_CART);
			preparedStatement.setInt(1, cartID);
			preparedStatement.setString(2, productID);
			preparedStatement.setInt(3, 1);
			preparedStatement.setInt(4, price);
			System.out.println(preparedStatement);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Cart> getCart(Integer cartID) {
		Connection con = getConnection();
		ArrayList<Cart> carts = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_PRODUCT_IN_CART);
			preparedStatement.setInt(1, cartID);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String productID = resultSet.getString("product_id");
				String name = resultSet.getString("name");
				Integer price = resultSet.getInt("price");
				String imageLink = resultSet.getString("image_link");
				String shortDescription = resultSet.getString("short_description");
				Product product = new Product(productID,name,price,imageLink,shortDescription);
				Integer quantity = resultSet.getInt("quantity");
				Integer new_price = resultSet.getInt("new_price");
				Cart cart = new Cart(cartID,product,quantity,new_price);
				carts.add(cart);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carts;
		
	}

	public int deleteProductInCart(Integer cartID, String productID) {
		Connection con = getConnection();
		ArrayList<Cart> carts = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(DELETE_PRODUCT_IN_CART);
			preparedStatement.setInt(1, cartID);
			preparedStatement.setString(2, productID);
			System.out.println(preparedStatement);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Cart getProductInCart(Product product, Integer cartID) {
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_PRODUCT_ID);
			preparedStatement.setInt(1, cartID);
			preparedStatement.setString(2, product.getProductID());
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String productID = resultSet.getString("product_id");
				Integer quantity = resultSet.getInt("quantity");
				Integer price = resultSet.getInt("new_price");
				Cart cart = new Cart(cartID,product,quantity,price);
				return cart;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public int updateProductToCart(Cart cart) {
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(UPDATE_PRODUCT_IN_CART);
			preparedStatement.setInt(1, cart.getQuantity()+1);
			preparedStatement.setInt(2, (cart.getQuantity()+1)*(cart.getProduct().getPrice()));
			preparedStatement.setInt(3, cart.getCartID());
			preparedStatement.setString(4, cart.getProduct().getProductID());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Integer getToTal(Integer cartID) {
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_TOTAL);
			preparedStatement.setInt(1, cartID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer total = resultSet.getInt("total");
				return total;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
