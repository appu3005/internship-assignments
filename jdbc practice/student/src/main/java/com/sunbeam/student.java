package com.sunbeam;

public class student {
	private int roll;
	private String name;
	private double marks;
	public student() {
	}
	public student(int roll, String name, double marks){
		this.roll=roll;
		this.name=name;
		this.marks=marks;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "student [roll=" + roll + ", name=" + name + ", marks=" + marks + "]";
	}
	
	}


