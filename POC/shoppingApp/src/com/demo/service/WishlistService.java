package com.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Item;

public class WishlistService {

	private Connection connection;

	public WishlistService() {
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

	public List<Item> viewAll(String uid) {
		List<Item> list = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from wishlist where uid = ?");
			ps.setInt(1, Integer.parseInt(uid));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setProduct_id(rs.getInt("product_id"));
				item.setImage(rs.getString("image"));
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insert(String uid, String pid, String pimage) {
		try {
			PreparedStatement statement = connection
					.prepareStatement("select count(*) from wishlist where uid = ? and pid = ?");
			statement.setInt(1, Integer.parseInt(uid));
			statement.setInt(2, Integer.parseInt(pid));
			ResultSet rs = statement.executeQuery();
			int count = -1;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count == 0) {
				PreparedStatement ps = connection
						.prepareStatement("insert into wishlist (uid, pid, image) values (?,?,?)");
				ps.setInt(1, Integer.parseInt(uid));
				ps.setInt(2, Integer.parseInt(pid));
				ps.setString(3, pimage);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String uid, String pid) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from wishlist where uid = ? and pid = ?");
			ps.setInt(1, Integer.parseInt(uid));
			ps.setInt(2, Integer.parseInt(pid));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert_from_cart_to_wishlist(String uid, String pid, String pimage) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("select count(*) from wishlist where uid = ? and pid = ?");
			ps.setInt(1, Integer.parseInt(uid));
			ps.setInt(2, Integer.parseInt(pid));
			ResultSet rs = ps.executeQuery();
			int count = -1;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count == 0) {
				PreparedStatement statement = connection
						.prepareStatement("insert into wishlist (uid, pid, image) values (?,?,?)");
				statement.setInt(1, Integer.parseInt(uid));
				statement.setInt(2, Integer.parseInt(pid));
				statement.setString(3, pimage);
				statement.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
