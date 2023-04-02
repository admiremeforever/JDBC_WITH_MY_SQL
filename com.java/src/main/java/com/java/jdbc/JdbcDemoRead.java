package com.java.jdbc;

//step 1 -> import the driver classes and interface 
import java.sql.*;

public class JdbcDemoRead {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String password = "admin";
		// String querry = "select name from user where id = 352";
		String querry = "DELETE FROM user WHERE id = 302";

		// step 2 -> load and register the driver with the help of forName method

		Class.forName("com.mysql.cj.jdbc.Driver");

		// step 3 -> create connection
		Connection con = DriverManager.getConnection(url, userName, password);
		// step 4 -> create statement
		Statement stmt = con.createStatement();
		// step 5 -> execute querry (ResultSet can store data
		//ResultSet rs = stmt.executeQuery(querry);
		boolean execute = stmt.execute(querry);
		// step 6 -> process the result

//		while (rs.next()) {
//			String userData = rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4);
//			System.out.println(userData);
//		}

		// step 7-> closing connection
		stmt.close();
		con.close();

	}

}
