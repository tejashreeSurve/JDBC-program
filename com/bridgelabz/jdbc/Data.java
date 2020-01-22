package com.bridgelabz.jdbc;

import java.sql.*;


public class Data {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Employee emp=new Employee();
	String url="jdbc:mysql://localhost:3306/Data?useSSL=false";
	String username="root";
	String password="root";
	String query="select * from student";
	Class.forName("com.mysql.jdbc.Driver");
	Connection connection= DriverManager.getConnection(url, username, password);
	Statement statement=connection.createStatement();
	ResultSet resultStatement=statement.executeQuery(query);
	while(resultStatement.next()) {
		String name=resultStatement.getString("name");
		int rollno=resultStatement.getInt("rollno");
		System.out.println("rollno :"+ rollno + " "+ "name:"+name);
	}
	statement.close();
	connection.close();
	
}
}
