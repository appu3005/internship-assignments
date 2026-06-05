package com.sunbeam;

import java.util.Scanner;
public class Q2 {

	public static void main(String[] args) {
		int qty;
		int bill;
		double totalbill=0;
		
		Scanner sc= new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("generate bill");
			System.out.println("1.Dosa Price =30");
			System.out.println("2.Samosa Price = 20");
			System.out.println("3.Idli Price= 25");
			System.out.println("4.Generate bill..");
			System.out.println("5.Enter choice:");
choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Dosa price 30 rupees enter quantity: ");
				qty = sc.nextInt();
				bill=qty*30;
				totalbill+=bill;
				break;
				
			case 2:
				System.out.println("Samosa price 20 rupees enter quantity: ");
				qty = sc.nextInt();
				bill=qty*20;
				totalbill+=bill;

				break;
				
			case 3:
				System.out.println("Idli price 30 rupess enter quantity: ");
				qty = sc.nextInt();
				bill=qty*30;
				totalbill+=bill;

				break;
				
				
			case 4: 
				System.out.println("Generated Bill: " +totalbill);
				break;
			}	
		}while(choice != 3);
		
		sc.close();
		
		}

}