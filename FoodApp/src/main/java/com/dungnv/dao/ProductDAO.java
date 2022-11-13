package com.dungnv.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dungnv.model.Product;

public class ProductDAO {
	private static String URL = "jdbc:mysql://localhost:3306/food_app";
	private static String username = "root";
	private static String password = "nguyenvandung";
	Connection con = getConnection();

	private String SELECT_PRODUCTS = 
			"SELECT * FROM food_app.product\r\n"
			+ "WHERE product_id NOT IN \r\n"
			+ "(SELECT product_id FROM food_app.product\r\n"
			+ "WHERE product_id like 'D%');";
	private String SELECT_PRODUCT_BY_ID = 
			"SELECT * FROM food_app.product WHERE product_id = ?;";
	private String SELECT_PRODUCT_BY_NAME = 
			"SELECT * FROM food_app.product WHERE name like ?;";
	private String SELECT_ALL_BURGER = 
			"SELECT * FROM food_app.product WHERE name like 'BURGER%';";
	private String SELECT_ALL_BAKERY = 
			"SELECT * FROM food_app.product "
			+ "WHERE name like 'BÁNH MỲ%' or name like 'SANDWICH %';";
	private String SELECT_ALL_DRINK = 
			"SELECT * FROM food_app.product WHERE product_id like 'D%';";
	private String SELECT_ALL_PIZZA = 
			"SELECT * FROM food_app.product WHERE name like 'PIZZA%';";
	private String SELECT_ALL_KFC = 
			"SELECT * FROM food_app.product WHERE name like 'GÀ%';";
	private String SELECT_PRODUCTS_LOWER = 
			"SELECT * FROM food_app.product WHERE product_id not in "
			+ "(SELECT product_id FROM food_app.product WHERE product_id like 'D%') "
			+ "ORDER BY price DESC;";
	private String SELECT_ALL_PRODUCTS_HIGHER = 
			"SELECT * FROM food_app.product WHERE product_id not in "
			+ "(SELECT product_id FROM food_app.product WHERE product_id like 'D%') "
			+ "ORDER BY price;";
	
	private String UPDATE_PRODUCT = 
			"UPDATE food_app.product"
			+ " SET name= N?, price= ?, image_link= ?, short_description= N? \r\n"
			+ "WHERE product_id=?;";
	private String INSERT_PRODUCT = 
			"INSERT INTO food_app.product VALUES(?,?,?,?,?);";
	private String DELETE_PRODUCT = 
			"DELETE FROM food_app.product WHERE product_id=?;";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Product> getProductsOfAdminPage() {
		ArrayList<Product> products = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement1 = con.prepareStatement(SELECT_PRODUCTS);
			PreparedStatement preparedStatement2 = con.prepareStatement(SELECT_ALL_DRINK);
			System.out.println(preparedStatement1);
			System.out.println(preparedStatement2);
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			ResultSet resultSet2 = preparedStatement2.executeQuery();
			while (resultSet1.next()) {
				String id = resultSet1.getString("product_id");
				String name = resultSet1.getString("name");
				Integer price = resultSet1.getInt("price");
				String imageLink = resultSet1.getString("image_link");
				String shortDescription = resultSet1.getString("short_description");
				Product product1 = new Product(id,name,price,imageLink,shortDescription);
				products.add(product1);
			}
			while (resultSet2.next()) {
				String id = resultSet2.getString("product_id");
				String name = resultSet2.getString("name");
				Integer price = resultSet2.getInt("price");
				String imageLink = resultSet2.getString("image_link");
				String shortDescription = resultSet2.getString("short_description");
				Product product2 = new Product(id,name,price,imageLink,shortDescription);
				products.add(product2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public ArrayList<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<>();
		
		PreparedStatement preparedStatement;
		
		ResultSet resultSet;
		
		try {
			preparedStatement = con.prepareStatement(SELECT_PRODUCTS);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("product_id");
				String name = resultSet.getString("name");
				Integer price = resultSet.getInt("price");
				String imageLink = resultSet.getString("image_link");
				String shortDescription = resultSet.getString("short_description");
				Product product = new Product(id,name,price,imageLink,shortDescription);
				products.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	public ArrayList<Product> SearchProduct(String nameProduct) {
		ArrayList<Product> products = new ArrayList<>();
				
		PreparedStatement preparedStatement;
		
		ResultSet resultSet;
		
		try {
			preparedStatement = con.prepareStatement(SELECT_PRODUCT_BY_NAME);
			preparedStatement.setString(1, nameProduct);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("product_id");
				
				String name = resultSet.getString("name");
				
				Integer price = resultSet.getInt("price");
				
				String imageLink = resultSet.getString("image_link");
				
				String shortDescription = resultSet.getString("short_description");
				
				Product product = new Product(id,name,price,imageLink,shortDescription);
				
				products.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public ArrayList<Product> getCategoriedProducts(String query){
		ArrayList<Product> categoriedProducts = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement preparedStatement;
		
		ResultSet resultSet;
		
		try {
			preparedStatement = con.prepareStatement(query);
			
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				return categoriedProducts;
			} 
			
			while (resultSet.next()) {
				String id = resultSet.getString("product_id");
				
				String name = resultSet.getString("name");
				
				Integer price = resultSet.getInt("price");
				
				String imageLink = resultSet.getString("image_link");
				
				String shortDescription = resultSet.getString("short_description");
				
				Product product = new Product(id,name,price,imageLink,shortDescription);
				
				categoriedProducts.add(product);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categoriedProducts;
	}
	
	public ArrayList<Product> getBurgers() {
		return getCategoriedProducts(SELECT_ALL_BURGER);
	}

	public ArrayList<Product> getBakerys() {
		return getCategoriedProducts(SELECT_ALL_BAKERY);
	}

	public ArrayList<Product> getDrinks() {
		return getCategoriedProducts(SELECT_ALL_DRINK);
	}

	public ArrayList<Product> getPizzas() {
		return getCategoriedProducts(SELECT_ALL_PIZZA);
	}

	public ArrayList<Product> getKfcs() {
		return getCategoriedProducts(SELECT_ALL_KFC);
	}

	public ArrayList<Product> getListOfProductLower() {
		return getCategoriedProducts(SELECT_PRODUCTS_LOWER);
	}

	public ArrayList<Product> getListOfProductHigher() {
		return getCategoriedProducts(SELECT_ALL_PRODUCTS_HIGHER);
	}

	public Product getProduct(String id) {		
		PreparedStatement preparedStatement;
		
		ResultSet resultSet;
		
		try {
			preparedStatement = con.prepareStatement(SELECT_PRODUCT_BY_ID);
			preparedStatement.setString(1, id);
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String idP = resultSet.getString("product_id");
				String name = resultSet.getString("name");
				Integer price = resultSet.getInt("price");
				String imageLink = resultSet.getString("image_link");
				String shortDescription = resultSet.getString("short_description");
				Product product = new Product(idP,name,price,imageLink,shortDescription);
				return product;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int updateProduct(Product newProduct) {
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(UPDATE_PRODUCT);
			preparedStatement.setString(1, newProduct.getName());
			preparedStatement.setInt(2, newProduct.getPrice());
			preparedStatement.setString(3, newProduct.getImageLink());
			preparedStatement.setString(4, newProduct.getShortDescription());
			preparedStatement.setString(5, newProduct.getProductID());
			System.out.println(preparedStatement);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean checkIDProduct(String productID) {
		Connection con = getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(SELECT_PRODUCT_BY_ID);
			preparedStatement.setString(1, productID);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String productId = resultSet.getString("product_id");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
		
	}
	public int addProduct(Product product) {
		Connection con = getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(INSERT_PRODUCT);
			preparedStatement.setString(1, product.getProductID());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getPrice());
			preparedStatement.setString(4, product.getImageLink());
			preparedStatement.setString(5, product.getShortDescription());
			System.out.println(preparedStatement);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void deleteProduct(String id) {
		Connection con = getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(DELETE_PRODUCT);
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
