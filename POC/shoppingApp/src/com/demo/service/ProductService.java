package com.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Product;

public class ProductService {

	private Connection connection;

	public ProductService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart?serverTimezone=UTC",
					"root", "aiziqi");
			if (connection != null) {
				System.out.println("Connected to Database!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Product> viewAll() {
		List<Product> list = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from products");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setImage(rs.getString(4));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
