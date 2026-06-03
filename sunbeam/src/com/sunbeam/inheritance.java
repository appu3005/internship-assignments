package com.sunbeam;

class Employee{
	String name = "apurva";
	void displayEmployee() {
		System.out.println("Name:"+name);
		
	}
}

class Manager extends Employee{
	String department = "computer";
	void displayManager() {
		System.out.println("Department:"+department);
	}
	
	
}
public class inheritance {

	public static void main(String[] args) {
		Manager m = new Manager();
		m.displayEmployee();
		m.displayManager();
	}

}
