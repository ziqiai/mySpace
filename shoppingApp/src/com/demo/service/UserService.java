package com.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.demo.model.User;

public class UserService {

	private Connection connection;

	public UserService() {
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

	public int insert(User user) {
		int key = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(
					"insert into users (username, password) values (?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
				key = Integer.parseInt(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	public boolean checkUsername(User user) {
		boolean checked = false;
		try {
			if (user.getUsername() == null) {
				checked = false;
			} else {
				PreparedStatement statement = connection.prepareStatement("select username from users");
				ResultSet res = statement.executeQuery();
				while (res.next()) {
					if (res.getString("username").equals(user.getUsername())) {
						checked = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checked;
	}

	public boolean checkPassword(User user) {
		boolean checked = false;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from users where username = ?");
			statement.setString(1, user.getUsername());
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				if (res.getString("password").equals(user.getPassword())) {
					checked = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return checked;
	}

	public int getUserId(User user) {
		int userId = 0;
		@SuppressWarnings("unused")
		String password = "";
		try {
			PreparedStatement statement = connection.prepareStatement("select * from users where username = ?");
			statement.setString(1, user.getUsername());
			ResultSet res = statement.executeQuery();
			while (res.next()) {
				userId = res.getInt("id");
				password = res.getString("password");
			}
			System.out.println("authorize user_id: " + userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

}
