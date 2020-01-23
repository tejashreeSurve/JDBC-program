package com.bridgelabz.jdbccallablestatement.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnection {

	static String url = "jdbc:mysql://localhost:3306/Data?useSSL=false";
	static String username = "root";
	static String password = "root";

	// select query
	public static void executSql() throws ClassNotFoundException, SQLException {
		String query = "{call getEmployee()}";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		CallableStatement callStatement = connection.prepareCall(query);
		System.out.println("Employee id\tEmployee name\t\tEmployee Dep\tPhone Number\t\tEmail");
		ResultSet resultSet = callStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t\t" + resultSet.getString(3)
					+ "\t\t" + resultSet.getString(4) + "\t\t" + resultSet.getString(5));
		}
		System.out.println();
		callStatement.close();
		connection.close();
	}

	// insert query
	public static void insertData(int id, String name, String Dep, String phoneNO, String email)
			throws ClassNotFoundException, SQLException {
		String query = "{call insertValues(?,?,?,?,?)}";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		CallableStatement callStatement = connection.prepareCall(query);
		callStatement.setInt(1, id);
		callStatement.setString(2, name);
		callStatement.setString(3, Dep);
		callStatement.setString(4, phoneNO);
		callStatement.setString(5, email);
		callStatement.execute();
		System.out.println(" record is added successfully");
		callStatement.close();
		connection.close();
	}

	// update query
	public static void UpdateData(int id, String name, String Dep, String phoneNO, String email)
			throws ClassNotFoundException, SQLException {
		String query = "{call UpdateEmployee(?,?,?,?,?)}";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		CallableStatement callStatement = connection.prepareCall(query);
		callStatement.setString(1, name);
		callStatement.setString(2, Dep);
		callStatement.setString(3, phoneNO);
		callStatement.setString(4, email);
		callStatement.setInt(5, id);
		callStatement.executeUpdate();
		System.out.println(" record is updated successfully");
		callStatement.close();
		connection.close();
	}

	// delete query
	public static void deletData(int id) throws ClassNotFoundException, SQLException {
		String query = "{call deleteEmployee(?)}";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		CallableStatement callStatement = connection.prepareCall(query);
		callStatement.setInt(1, id);
		callStatement.executeUpdate();
		System.out.println(" record is deleted successfully");
		callStatement.close();
		connection.close();
	}

	// delete all rows
	public static void deleteAllRows() throws ClassNotFoundException, SQLException {
		String query = "{call deleteAllRows()}";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		CallableStatement callStatement = connection.prepareCall(query);
		callStatement.executeUpdate();
		System.out.println("all records is deleted successfully");
		callStatement.close();
		connection.close();
	}
}
