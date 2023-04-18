package com.dal.controller;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import com.dal.model.Employee;
import java.io.*;
import com.dal.dao.EmployeeDao;
import com.dal.dao.EmployeeDaoImpl;

import java.io.*;
public class EmployeeController implements EmployeeInterface {
	Employee emp;
	List<Employee> emplist = new ArrayList<Employee>();
	EmployeeDao dao = new EmployeeDaoImpl();
	public void addEmployee()
	{		
		emp = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Eid");
		int eid= sc.nextInt();
		emp.setEid(eid);
		
		System.out.println("Enter Ename");
		String ename= sc.next();
		emp.setEname(ename);
		emplist.add(emp);
		dao.insertEmployee(emp);
		System.out.println("Employee Added Succesfully");
	}
	
	public void viewEmployee() {
		//System.out.println(emp);
//		Iterator i = emplist.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}
		
		//emplist.forEach(lis->System.out.println(lis));
		dao.showEmployee();
		
	}
	public void SerialEmp() throws IOException {
		try{
			Iterator i = emplist.iterator();
			
			//Employee emp = new Employee();
		
			FileOutputStream fos = new FileOutputStream("dedalus.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(emp);
//			while(i.hasNext()) {
//				oos.writeObject(i.next());
//			}
			System.out.println("Serilized to file dedalus.txt");
			oos.close();
			fos.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
		
	}
	public void DeSerialEmp() throws IOException {
		try{
			FileInputStream fis = new FileInputStream("dedalus.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			//System.out.println("inside1 "+(Employee)ois.readObject());
			Employee emp = (Employee)ois.readObject();
			System.out.println(emp);
			System.out.println("DeSerilized from file dedalus.txt");
			System.out.println(emp.getEid());
			System.out.println(emp.getEname());
			ois.close();
			fis.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
			catch(ClassNotFoundException cnf)
			{
				System.out.println("No Emp class");
			}
		catch(IOException IO) {
			System.out.println("IO Exception");
		}
	}
	@Override
	public void sortByEid() {
		Collections.sort(emplist);
		System.out.println("After sorting by EID");
		System.out.println(emplist);
	}

	@Override
	public void sortByEname() {
		Collections.sort(emplist, Employee.NameComparator);
		System.out.println(emplist);
		
	}
	
	public void deleteEmployee()
	{		
		emp = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Eid");
		int eid= sc.nextInt();
		emp.setEid(eid);
		dao.deleteEmployee(eid);
	}
	public void updateEmployee() throws IOException {
		
		emp = new Employee();
		try{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Enter Eid");
		String eid = br.readLine();
		emp.setEid(Integer.parseInt(eid));
		System.out.println("Enter Emp Name:");
		String ename = br.readLine();
		emp.setEname(ename);
		} catch(IOException IO) {
			System.out.println("IO Exception");
		}

		
		//System.out.println("Employee deleted Succesfully");
	}
	
}
