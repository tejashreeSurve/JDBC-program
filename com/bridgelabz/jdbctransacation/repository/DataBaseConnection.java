package com.bridgelabz.jdbctransacation.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DataBaseConnection {

	static String url = "jdbc:mysql://localhost:3306/Data?useSSL=false";
	static String username = "root";
	static String password = "root";
	static Scanner scanner = new Scanner(System.in);

	// select query
	public static void executSql() throws ClassNotFoundException, SQLException {
		String query = "select * from employees";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		System.out.println("Employee id\t\tEmployee name\t\tEmployee Dep\t\tPhone Number\t\tEmail");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(
					resultSet.getInt(1) + "\t" + "\t" + resultSet.getString(2) + "\t" + "\t" + resultSet.getString(3)
							+ "\t" + "\t" + resultSet.getString(4) + "\t" + "\t" + resultSet.getString(5));
		}
		preparedStatement.close();
		connection.close();
	}

	// insert query
	public static void insertData(int id, String name, String Dep, String phoneNO, String email)
			throws ClassNotFoundException, SQLException {
		String query = "insert into employees values(?,?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		connection.setAutoCommit(false);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setString(3, Dep);
		preparedStatement.setString(4, phoneNO);
		preparedStatement.setString(5, email);
		preparedStatement.executeUpdate();
		System.out.println("commit/rollback");
		String answer = scanner.next();
		if (answer.equals("commit")) {
			connection.commit();
			System.out.println("record successfully saved");
		}
		if (answer.equals("rollback")) {
			connection.rollback();
			System.out.println("transcation is canclled ");
		}
		connection.commit();
		connection.close();
	}

	// update query
	public static void UpdateData(int id, String name, String Dep, String phoneNO, String email)
			throws ClassNotFoundException, SQLException {
		String query = "update employees set ename=?,department=?,phoneNumber=?,email=? where eid=?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, Dep);
		preparedStatement.setString(3, phoneNO);
		preparedStatement.setString(4, email);
		preparedStatement.setInt(5, id);
		preparedStatement.executeUpdate();
		System.out.println("commit/rollback");
		String answer = scanner.next();
		if (answer.equals("commit")) {
			connection.commit();
			System.out.println("record successfully saved");
		}
		if (answer.equals("rollback")) {
			connection.rollback();
			System.out.println("transcation is canclled ");
		}
		connection.commit();
		connection.close();
	}

	// delete query
	public static void deletData(int id) throws ClassNotFoundException, SQLException {
		String query = "delete from employees where eid=?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		System.out.println("commit/rollback");
		String answer = scanner.next();
		if (answer.equals("commit")) {
			connection.commit();
			System.out.println("record successfully saved");
		}
		if (answer.equals("rollback")) {
			connection.rollback();
			System.out.println("transcation is canclled ");
		}
		connection.commit();
		connection.close();
	}

	// delete all rows
	public static void deleteAllRows() throws ClassNotFoundException, SQLException {
		String query = "{call deleteAllRows()}";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		CallableStatement callStatement = connection.prepareCall(query);
		callStatement.executeUpdate();
		System.out.println("commit/rollback");
		String answer = scanner.next();
		if (answer.equals("commit")) {
			connection.commit();
			System.out.println("record successfully saved");
		}
		if (answer.equals("rollback")) {
			connection.rollback();
			System.out.println("transcation is canclled ");
		}
		connection.commit();
		connection.close();
	}
}
