package com.sunbeam;

import java.util.ArrayList;
import java.util.Scanner;

public class empmain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        empDao employeDao = new EmployeDaoImpl();

        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

            case 1:
            	System.out.println("Enter Employe Id ");
            	int empId=sc.nextInt();
            	try(empDao employeDao1 = new EmployeDaoImpl()){
					employe e = employeDao.findByID(empId);
					if(e != null)
					System.out.println(e);
					else
						System.out.println("element not found");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		
				
				break;
			
			case 2:
				List<employe> list = new ArrayList<>();
				try(empDao employeDao2 = new EmployeDaoimpl()){
					list = employeDao.findAll();
					for(employe e : list) {
						System.out.println(e.toString());
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 3:
				sc.nextLine();
				  System.out.print("Enter id");
				    empId = sc.nextInt();
				   sc.nextLine();
				   System.out.print("Enter name");
				   String empname = sc.nextLine();
				   
				   
				   System.out.print("Enter department");
				   String department = sc.nextLine();
				   System.out.print("Enter salary");
				   Double salary = sc.nextDouble();
				   
				   
				   
				   try(empDao employeDao3 = new EmployeDaoImpl()){
					   employe e = new employe(empId,empname,department,salary);
					   int cnt = employeDao1.save(e);
					   System.out.println("Rows Affected : " + cnt);
				   }
				   catch(Exception e) {
					   e.printStackTrace();
				   }
				break;
				
			case 4:
				   
			       System.out.print("Enter Employee ID to Delete : ");
			       int id = sc.nextInt();

			      try(employeDao empDao = new EmployeeDaoimpl()){
			    	  empDao.delete(id);
			    	  System.out.println("Deleted successfully");
			      }
			      catch(Exception e) {
			    	  e.printStackTrace();
			      }
	       
	            break;
	
			case 5:
				System.out.println("Exitted successfully!");
				break;
				
				
				default:
					System.out.println("invalid choice!");
					
		}
	}
	while(choice != 0);
	
	}
}
            	
    ;
            	