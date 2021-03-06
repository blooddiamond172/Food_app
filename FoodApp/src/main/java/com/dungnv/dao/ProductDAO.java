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
	
	private String SELECT_ALL_PRODUCT = 
			"SELECT * FROM food_app.product;";
	private String SELECT_PRODUCTS = 
			"SELECT * FROM food_app.product\r\n"
			+ "WHERE product_id NOT IN \r\n"
			+ "(SELECT product_id FROM food_app.product\r\n"
			+ "WHERE product_id like 'D%');";
	private String SELECT_PRODUCT_BY_ID = 
			"SELECT * FROM food_app.product WHERE product_id = ?;";
	private String SELECT_PRODUCT_BY_NAME = 
			"SELECT * FROM food_app.product WHERE name like N?;";
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
			+ " SET name= ?, price= ?, image_link= ?, short_description= ? \r\n"
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
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_PRODUCT);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
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
	
	public ArrayList<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_PRODUCTS);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
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
	
	public ArrayList<Product> SearchProduct(String name) {
		ArrayList<Product> products = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_PRODUCT_BY_NAME);
			preparedStatement.setString(1, name);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("product_id");
				String nameP = resultSet.getString("name");
				Integer price = resultSet.getInt("price");
				String imageLink = resultSet.getString("image_link");
				String shortDescription = resultSet.getString("short_description");
				Product product = new Product(id,nameP,price,imageLink,shortDescription);
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public ArrayList<Product> getBurgers() {
		ArrayList<Product> burgers = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_BURGER);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("product_id");
				String name = resultSet.getString("name");
				Integer price = resultSet.getInt("price");
				String imageLink = resultSet.getString("image_link");
				String shortDescription = resultSet.getString("short_description");
				Product burger = new Product(id,name,price,imageLink,shortDescription);
				burgers.add(burger);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return burgers;
	}

	public ArrayList<Product> getBakerys() {
		ArrayList<Product> bakerys = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_BAKERY);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("product_id");
				String name = resultSet.getString("name");
				Integer price = resultSet.getInt("price");
				String imageLink = resultSet.getString("image_link");
				String shortDescription = resultSet.getString("short_description");
				Product bakery = new Product(id,name,price,imageLink,shortDescription);
				bakerys.add(bakery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bakerys;
	}

	public ArrayList<Product> getDrinks() {
		ArrayList<Product> drinks = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_DRINK);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("product_id");
				String name = resultSet.getString("name");
				Integer price = resultSet.getInt("price");
				String imageLink = resultSet.getString("image_link");
				String shortDescription = resultSet.getString("short_description");
				Product drink = new Product(id,name,price,imageLink,shortDescription);
				drinks.add(drink);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return drinks;
	}

	public ArrayList<Product> getPizzas() {
		ArrayList<Product> pizzas = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_PIZZA);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("product_id");
				String name = resultSet.getString("name");
				Integer price = resultSet.getInt("price");
				String imageLink = resultSet.getString("image_link");
				String shortDescription = resultSet.getString("short_description");
				Product pizza = new Product(id,name,price,imageLink,shortDescription);
				pizzas.add(pizza);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pizzas;
	}

	public ArrayList<Product> getKfcs() {
		ArrayList<Product> kfcs = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_KFC);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String id = resultSet.getString("product_id");
				String name = resultSet.getString("name");
				Integer price = resultSet.getInt("price");
				String imageLink = resultSet.getString("image_link");
				String shortDescription = resultSet.getString("short_description");
				Product kfc = new Product(id,name,price,imageLink,shortDescription);
				kfcs.add(kfc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kfcs;
	}

	public ArrayList<Product> getListOfProductLower() {
		ArrayList<Product> products = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_PRODUCTS_LOWER);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
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

	public ArrayList<Product> getListOfProductHigher() {
		ArrayList<Product> products = new ArrayList<>();
		Connection con = getConnection();
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_PRODUCTS_HIGHER);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
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

	public Product getProduct(String id) {
		Connection con = getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(SELECT_PRODUCT_BY_ID);
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
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
