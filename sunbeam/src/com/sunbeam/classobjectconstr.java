package com.sunbeam;

class Employee1{
	int id;
	String name;
	int salary;
	
	public Employee1(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	void display() {
		System.out.println("id:"+id);
		System.out.println("name:"+name);
		System.out.println("salary:"+salary);
	}
}

public class classobjectconstr {
	
	public static void main(String[] args) {
		
		Employee1 e = new Employee1(101, "apurva", 200);
		e.display();


	}

}
