package com.dal.controller;

import java.io.IOException;

public interface EmployeeInterface {
	public void addEmployee();
	public void viewEmployee() ;
	public void SerialEmp() throws IOException;
	public void DeSerialEmp() throws IOException;
	public void sortByEid();
	public void sortByEname();
	
}
