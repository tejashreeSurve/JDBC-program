package com.bridgelabz.jdbcpreparedstatement.controller;

import java.sql.SQLException;
import java.util.Scanner;
import com.bridgelabz.jdbcstatement.services.Operation;

public class Controller {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Perfom Operation");
		int option = 0;
		Scanner scanner = new Scanner(System.in);

		// Provide Operations
		while (option != 5) {
			System.out.println("1.Create DataBase");
			System.out.println("2.Update DataBase");
			System.out.println("3.Read DataBase");
			System.out.println("4.Delet DataBase");
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
				System.out.println("Delet the records of Employee from DataBase");
				Operation.delet();
				break;
			case 5:
				System.out.println("--Thank you--");
			default:
				System.out.println("please enter valid option");
				break;
			}
		}
		scanner.close();
	}
}
