package com.dal.view;

import java.util.Scanner;
import java.io.*;

import com.dal.controller.EmployeeController;
import com.dal.controller.EmployeeInterface;
//import com.dal.model.Employee;
import com.dal.exception.*;

public class MainClass {

	public static void addViewEmp() throws IOException {
		EmployeeInterface ec = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		String choice = null;
		do {

			System.out.println("Enter your choice");
			System.out.println("1. Add Employee");
			System.out.println("2. View Employee");
			System.out.println("3. Serialize Employee");
			System.out.println("4. DeSerialize Employee");
			System.out.println("5. Sort By Employee ID");
			System.out.println("6. Sort By Employee Name");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				ec.addEmployee();
				break;
			}
			case 2: {
				ec.viewEmployee();
				break;
			}
			case 3: {
				ec.SerialEmp();
				break;
			}
			case 4: {
				ec.DeSerialEmp();
				break;
			}
			case 5: {
				ec.sortByEid();
				break;
			}
			case 6: {
				ec.sortByEname();
				break;
			}
			default: {
				System.out.println("Enter right choice");
				break;
			}
			}
			System.out.println("Do u want to continue Y or y");
			choice = sc.next();
		} while (choice.equals("Y") || choice.equals("y"));
		System.out.println("Exited");
		System.exit(0);

	}
	public static void main(String[] args) throws IOException {

		System.out.println("Welcome");
		String uname = null;
		String pwd = null;
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter user name:");
			uname = br.readLine();
			System.out.println("Enter Password:");
			pwd = br.readLine();
			if (uname.equals("test") && pwd.equals("pass")) {
				System.out.println("Welcome" + uname);
				addViewEmp();
			} else {
				throw new UserNotFoundException("User "+uname+" not found");
			}
		} catch (Exception ex) {
			System.out.println("except"+ex);
			ex.printStackTrace();
			//System.exit(0);
		}

		
	}

}
