package com.sunbeam;

import java.util.Scanner;

class Student {
    private int rollNo;
    private String name;
    private double marks;

    public void accept_data() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values for roll, name, and marks:");
        this.rollNo = sc.nextInt();
        this.name = sc.next();
        this.marks = sc.nextDouble();
    }

    public void Display() {
        System.out.println("roll=" + rollNo + " name=" + name + " marks=" + marks);
    }

    public void cal_grade() {
        
        String grade; 
        
        if (marks >= 75) {
            grade = "A";
        } else if (marks > 60) {
            grade = "B";
        } else if (marks > 50) {
            grade = "C";
        } else {
            grade = "Fail";
        }
        System.out.println("Grade = " + grade);
    }
}

public class Q1 {
    public static void main(String[] args) {
        Student s = new Student();
        s.accept_data();
        s.Display();
        s.cal_grade(); 
    }
}