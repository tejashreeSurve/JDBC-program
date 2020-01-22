package com.bridgelabz.jdbcstatement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	static String url = "jdbc:mysql://localhost:3306/Data?useSSL=false";
	static String username = "root";
	static String password = "root";

	// select query
	public static void executSql() throws ClassNotFoundException, SQLException {
		String query = "select * from employees";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		ResultSet resultStatement = statement.executeQuery(query);
		while (resultStatement.next()) {
			int eid = resultStatement.getInt("eid");
			String ename = resultStatement.getString("ename");
			String dep = resultStatement.getString("department");
			String number = resultStatement.getString("phoneNumber");
			String email = resultStatement.getString("email");
			System.out.println("Employee id\tEmployee name\tEmployee Dep\tPhone Number\tEmail");
			System.out.println(eid + "\t" + ename + "\t" + dep + "\t" + number + "\t" + email);
		}
		statement.close();
		connection.close();
	}
	
	// insert query
	public static void insertData(int id, String name, String Dep, String phoneNO, String email)
			throws ClassNotFoundException, SQLException {
		String query = "insert into employees values("+id+",'"+name+"','"+Dep+"','"+phoneNO+"','"+email+"')";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(query);
		System.out.println(count + " record is added successfully");
		statement.close();
		connection.close();
	}
	
	// update query
	public static void UpdateData(int id, String name, String Dep, String phoneNO, String email)
			throws ClassNotFoundException, SQLException {
		String query = "update employees set ename='"+name+"',department='"+Dep+"',phoneNumber='"+phoneNO+"',email='"+email+"' where eid="+id;
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(query);
		System.out.println(count+1 + " record is added successfully");
		statement.close();
		connection.close();
	}

	// delete query
	public static void deletData(int id) throws ClassNotFoundException, SQLException {
		String query = "delete from employees where eid="+id;
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(query);
		System.out.println(count + " record is added successfully");
		statement.close();
		connection.close();
	}
}
