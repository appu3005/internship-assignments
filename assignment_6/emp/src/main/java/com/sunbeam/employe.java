package com.sunbeam;

public class employe {
	private int empId;
	private String empname;
	private String department;
	private int salary;
	public employe() {
	}
	public employe(int empId, String empname, String department, Double salary) {
		this.empId=empId;
		this.department=department;
		this.salary=salary;
		this.empname=empname;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "employe [empId=" + empId + ", empname=" + empname + ", department=" + department + ", salary=" + salary
				+ "]";
	}
	

}
