package com.bridgelabz.jdbccallablestatement.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.jdbccallablestatement.services.Operation;

public class Controller {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Perfom Operation");
		int option = 0;
		Scanner scanner = new Scanner(System.in);

		// Provide Operations
		while (option != 6) {
			System.out.println("1.Insert new Employee Data");
			System.out.println("2.Update Employees Data");
			System.out.println("3.Read All Employees Data");
			System.out.println("4.Delet Employee Records");
			System.out.println("5.Delete All Employees Data");
			System.out.println("6.Exit");
			System.out.println("Enter option");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				// add new employee in DataBase
				System.out.println("Insert new record of Employee into DataBase");
				Operation.insert();
				break;
			case 2:
				// update record of employee in DataBase
				System.out.println("Update the records of Employee into DataBase");
				Operation.update();
				break;
			case 3:
				// print record of DataBase
				System.out.println("Print the records of Employee from DataBase");
				Operation.print();
				break;
			case 4:
				// delete record from DataBase
				System.out.println("Delete the records of Employee from DataBase");
				Operation.delet();
				break;
			case 5:
				System.out.println("Delete All Employees Data");
				Operation.deletAllrows();
				break;
			case 6:
				System.out.println("--Thank you--");
			default:
				System.out.println("please enter valid option");
				break;
			}
		}
		scanner.close();
	}
}
