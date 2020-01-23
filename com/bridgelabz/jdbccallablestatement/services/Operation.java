package com.bridgelabz.jdbccallablestatement.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.jdbccallablestatement.repository.DataBaseConnection;

public class Operation {
	static Scanner scanner = new Scanner(System.in);

	// value of employee to add
	public static void insert() throws ClassNotFoundException, SQLException {
		System.out.println("enter data");
		System.out.println("Enter eid");
		int id = scanner.nextInt();
		System.out.println("Enter ename");
		String name = scanner.next();
		System.out.println("Enter department");
		String dep = scanner.next();
		System.out.println("Enter phone number ");
		String phoneNumber = scanner.next();
		System.out.println("Enter email");
		String email = scanner.next();
		DataBaseConnection.insertData(id, name, dep, phoneNumber, email);
		print();
	}

	// value of employee to update
	public static void update() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Employee id to update");
		int id = scanner.nextInt();
		System.out.println("Enter ename");
		String name = scanner.next();
		System.out.println("Enter department");
		String dep = scanner.next();
		System.out.println("Enter phone number ");
		String phoneNumber = scanner.next();
		System.out.println("Enter email");
		String email = scanner.next();
		DataBaseConnection.UpdateData(id, name, dep, phoneNumber, email);
		print();
	}

	// id of employee to delete
	public static void delet() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Employee id to delete");
		int id = scanner.nextInt();
		DataBaseConnection.deletData(id);
		print();
	}

	// print data
	public static void print() throws ClassNotFoundException, SQLException {
		DataBaseConnection.executSql();
	}

	// delete entire data of employee
	public static void deletAllrows() throws ClassNotFoundException, SQLException {
		DataBaseConnection.deleteAllRows();
		print();
	}
}
