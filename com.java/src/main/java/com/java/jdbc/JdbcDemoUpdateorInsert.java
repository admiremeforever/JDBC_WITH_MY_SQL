package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemoUpdateorInsert {
	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "admin";

		Integer id = 347;
		String city = "Telangana";
		String name = "Virat tendulkar";
		String status = "Aab to jeet ley";
		// String query = "select name from user where id = 352";

		// String query = "insert into user value(99,\"punjab\",\"Hulk\",\"amazed\")";
		// we can work with prepared stmt when we need to map variables to db columns
		// (to avoid double quotes and all)
		String querry = "insert into user value(?,?,?,?)";

		// step 2 -> load and register the driver with the help of forName method

		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 3 -> create connection
		Connection con = DriverManager.getConnection(url, userName, password);
		// step 4 -> create statement
		PreparedStatement stmt = con.prepareStatement(querry);
		stmt.setInt(1, id);
		stmt.setString(2, city);
		stmt.setString(3, name);
		stmt.setString(4, status);
		// step 5 ->execute statement( note here we are calling executeUpdate method)
		int count = stmt.executeUpdate();
		// step 6 -> process the result

		System.out.println(count + " row/s affected");

		// step 7-> closing connection
		stmt.close();
		con.close();

	}

}
