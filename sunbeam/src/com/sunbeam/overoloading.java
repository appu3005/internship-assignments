package com.sunbeam;

class calculater{
	void multiply(int a, int b) {
	System.out.println("Multiply of 2 integers:"+(a*b));
	}
	void multiply(int a, int b, int c) {
	System.out.println("Multiply of 3 integers:"+(a*b*c));
	
	}
	void multipy(double a, double b) {
		System.out.println("Multiply of double 2 integers:"+(a*b));
	}
	
}

public class overoloading {

	public static void main(String[] args) {
		calculater c = new calculater();
		c.multiply(10,20);
		c.multiply(10,20,30);
		c.multipy(12,23);
	}

}
