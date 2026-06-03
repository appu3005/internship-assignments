package com.sunbeam;

class animal{
	void sound() {
		System.out.println("animal makes sound");
	}
}
class dog extends animal{
	@Override
	void sound() {
		System.out.println("dog barks");
		
	}
	
}
public class override {

	public static void main(String[] args) {
		
		dog d = new dog();
		d.sound();
				
	}

}
