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
	Connection con = getConnection();
	
	private String SELECT_USER_CART = 
			"SELECT cart_id FROM user_cart \r\n"
			+ "WHERE user_id = ? \r\n"
			+ "order by cart_id DESC "
			+ "LIMIT 1;";
	private String SELECT_CART = 
			"SELECT p.product_id, p.name, p.price, p.image_link, p.short_description, c.quantity, c.new_price\r\n"
			+ "FROM product as p join cart as c USING (product_id)\r\n"
			+ "WHERE cart_id = ?;";
	private String SELECT_PRODUCT_ID =
			"SELECT * FROM food_app.cart\r\n"
			+ "WHERE cart_id = ? and product_id = ?;";
	private String SELECT_TOTAL = 
			"SELECT sum(new_price) as \"total\" FROM food_app.cart\r\n"
			+ "WHERE cart_id = ?;";
	
	private String SELECT_QUANTITY_OF_PRODUCT = 
			"SELECT quantity FROM food_app.cart "
			+ "WHERE cart_id = ? and product_id = ?";
	private String INSERT_CART = 
			"INSERT INTO food_app.user_cart(user_id) VALUE(?);";
	private String INSERT_PRODUCT_TO_CART =
			"INSERT INTO food_app.cart VALUES(?,?,?,?);";
	private String DELETE_PRODUCT_IN_CART =
			"DELETE FROM food_app.cart "
			+ "WHERE cart_id=? and product_id=? ;";
	private String UPDATE_CART =
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

	public int createCartID(Integer id) {
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement = con.prepareStatement(INSERT_CART);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Integer getCartID(Integer id) {
		try {
			ResultSet resultSet;
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER_CART);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getInt("cart_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int addProductToCart(Integer cartID, Product product) {
		try {
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_PRODUCT_TO_CART);
			preparedStatement.setInt(1, cartID);
			preparedStatement.setString(2, product.getProductID());
			preparedStatement.setInt(3, 1);
			preparedStatement.setInt(4, product.getPrice());
			System.out.println(preparedStatement);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<Cart> getCart(Integer cartID) {
		ArrayList<Cart> carts = new ArrayList<>();
						
		try {
			ResultSet resultSet;
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_CART);
			preparedStatement.setInt(1, cartID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String productID = resultSet.getString("product_id");
				String name = resultSet.getString("name");
				String imageLink = resultSet.getString("image_link");
				Integer price = resultSet.getInt("price");
				String shortDescription = resultSet.getString("short_description");
				Product product = new Product(productID, name, price, imageLink, shortDescription); 
				Integer quantity = resultSet.getInt("quantity");
				Integer new_price = resultSet.getInt("new_price");				
				carts.add(new Cart(cartID, product, quantity, new_price));
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

//	public Cart getProductsInCart(Integer cartID) {
//		try {
//			PreparedStatement preparedStatement = con.prepareStatement(SELECT_PRODUCT_ID);
//			preparedStatement.setInt(1, cartID);
//			preparedStatement.setString(2, productID);
//			System.out.println(preparedStatement);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				String idOfProduct = resultSet.getString("product_id");
//				Integer quantity = resultSet.getInt("quantity");
//				Integer price = resultSet.getInt("new_price");
//				Cart cart = new Cart(cartID,idOfProduct,quantity,price);
//				return cart;
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//		
//	}

	public int updateCart(Integer cartID, Product product) {
		try {
			ResultSet resultSet;
			Integer quantity = null;
			PreparedStatement preparedStatement1 = con.prepareStatement(SELECT_QUANTITY_OF_PRODUCT);
			PreparedStatement preparedStatement2 = con.prepareStatement(UPDATE_CART);
			preparedStatement1.setInt(1, cartID);
			preparedStatement1.setString(2, product.getProductID());
			resultSet = preparedStatement1.executeQuery();
			while (resultSet.next()) {
				quantity = resultSet.getInt("quantity");
			}
			preparedStatement2.setInt(1, (quantity + 1));
			preparedStatement2.setInt(2, ((quantity + 1) * product.getPrice()));
			preparedStatement2.setInt(3, cartID);
			preparedStatement2.setString(4, product.getProductID());
			return preparedStatement2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public Integer getToTal(Integer cartID) {
		try {
			ResultSet resultSet;
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_TOTAL);
			preparedStatement.setInt(1, cartID);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return (resultSet.getInt("total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int isExist(Integer cartID, String productID) {
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_PRODUCT_ID);
			
			ResultSet resultSet;
			
			preparedStatement.setInt(1, cartID);
			preparedStatement.setString(2, productID);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				return 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
