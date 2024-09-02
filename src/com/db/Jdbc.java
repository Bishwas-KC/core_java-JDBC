package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {

	public static Connection connection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaintern", "root",
					"admin");
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}