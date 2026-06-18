package com.sunbeam.teaster;

import java.util.Scanner;

import com.sunbeam.DaoImpl.AdminDaoImpl;
import com.sunbeam.DaoImpl.StudentDaoImple;
import com.sunbeam.entity.Admin;
import com.sunbeam.entity.Student;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        AdminDaoImpl adao=new AdminDaoImpl();
        StudentDaoImple sdao=new StudentDaoImple();
        Admin a=new Admin();
        Student s=new Student();
        Submenu smenu=new Submenu();
        
        int choice;

        do {
            System.out.println("\n========== QUIZ MANAGEMENT SYSTEM ==========");
            System.out.println("1. Admin Login");
            System.out.println("2. Student Registration");
            System.out.println("3. Student Login");
            System.out.println("0. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.println("\n----- Admin Login -----");

                System.out.print("Enter Email: ");
                String adminEmail = sc.next();

                System.out.print("Enter Password: ");
                String adminPassword = sc.next();

                
              a=  adao.logAdmin(adminEmail, adminPassword);
              smenu.AdminMenu();
                
                break;

            case 2:

                sdao.register(s);

                break;
                
            case 3:
                System.out.println("\n----- Student Login -----");

                System.out.print("Enter Email: ");
                String studentEmail = sc.next();

                System.out.print("Enter Password: ");
                String studentPassward = sc.next();
                s=sdao.loginStudent(studentEmail, studentPassward);
                smenu.StudentMenu(s.getStudent_id());
               
                break;

            case 0:
                System.out.println("Thank You for Using Quiz Management System.");
                break;

            default:
                System.out.println("Invalid Choice!");
            }

        } while (choice != 0);

        sc.close();
        
    }
    

          
    }