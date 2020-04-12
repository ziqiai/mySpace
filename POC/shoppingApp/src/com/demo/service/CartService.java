package com.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Item;

public class CartService {

	private Connection connection;

	public CartService() {
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

	public List<Item> view(String uid) {
		List<Item> list = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from cart where uid = ?");
			ps.setInt(1, Integer.parseInt(uid));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Item item = new Item();
				item.setProduct_id(rs.getInt("product_id"));
				item.setQuantity(rs.getInt("quantity"));
				item.setImage(rs.getString("image"));
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insert(String uid, String pid, String quantity, String pimage) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into cart (uid, pid, quantity, image) values (?,?,?,?)");
			ps.setInt(1, Integer.parseInt(uid));
			ps.setInt(2, Integer.parseInt(pid));
			ps.setInt(3, Integer.parseInt(quantity));
			ps.setString(4, pimage);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update_cart(String uid, String pid, String quantity, String pimage) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("select count(*) from cart where uid = ? and pid = ?");
			ps.setInt(1, Integer.parseInt(uid));
			ps.setInt(2, Integer.parseInt(pid));
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				if (res.getInt(1) == 1) {
					update(uid, pid, quantity, pimage);
				} else {
					insert(uid, pid, quantity, pimage);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(String uid, String pid, String quantity, String pimage) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("update cart set quantity = quantity + ? where uid = ? and pid = ?");
			ps.setInt(1, Integer.parseInt(quantity));
			ps.setInt(2, Integer.parseInt(uid));
			ps.setInt(3, Integer.parseInt(pid));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update_item(String uid, String pid, String quantity) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("update cart set quantity = ? where uid = ? and pid = ?");
			ps.setInt(1, Integer.parseInt(quantity));
			ps.setInt(2, Integer.parseInt(uid));
			ps.setInt(3, Integer.parseInt(pid));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete_item(String uid, String pid) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from cart where uid = ? and pid = ?");
			ps.setInt(1, Integer.parseInt(uid));
			ps.setInt(2, Integer.parseInt(pid));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert_from_wishlist_to_cart(String uid, String pid, String pimage) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("select count(*) from cart where uid = ? and pid = ?");
			ps.setInt(1, Integer.parseInt(uid));
			ps.setInt(2, Integer.parseInt(pid));
			ResultSet rs = ps.executeQuery();
			int count = -1;
			while (rs.next()) {
				count = rs.getInt(1);
			}
			if (count == 0) {
				PreparedStatement statement = connection
						.prepareStatement("insert into cart (uid, pid, image, quantity) values (?,?,?,1)");
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
