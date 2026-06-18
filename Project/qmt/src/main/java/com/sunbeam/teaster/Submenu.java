package com.sunbeam.teaster;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import com.sunbeam.DAO.StudentDao;
import com.sunbeam.DAO.QuizzeDao;
import com.sunbeam.DaoImpl.QuizzeDaoimpl;
import com.sunbeam.DaoImpl.StudentDaoImple;
import com.sunbeam.entity.Quizze;
import com.sunbeam.entity.Result;

public class Submenu {
	int choice;
	Scanner sc = new Scanner(System.in);

	public void AdminMenu() throws Exception {
do {
		System.out.println("/n=============admin menu==============");
		System.out.println("1. Create Quiz");
		System.out.println("2. View Quizzes");
		System.out.println("3. View Results");
		System.out.println("4. Delete Quiz");
		System.out.println("5. Logout");
		System.out.print("Enter choice: ");
		choice = sc.nextInt();

		switch (choice) {

		case 1:
		{
			try {
				System.out.print("Enter Quiz Title: ");
				String title = sc.next();
				sc.nextLine();

				System.out.print("Enter Quiz File Path: ");
				String path = sc.nextLine();
				QuizzeDaoimpl qdao = new QuizzeDaoimpl();

				qdao.CreateQuizze(title, path);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
			break;
		case 2:
		{
			System.out.println("View Quizzes..");
			QuizzeDao qdao = new QuizzeDaoimpl();
			HashSet<Quizze> que= qdao.viewQuizzes();
			for (Quizze q : que) {
				System.out.println(q);
			}
		}
			break;

		case 3:
		{
		    System.out.println("View Results...");

		    QuizzeDao qdao = new QuizzeDaoimpl();

		    List<Result> result = qdao.viewResults();

		    if(result.isEmpty()) {
		        System.out.println("No results found.");
		    }
		    else {
		        for(Result r : result) {
		            System.out.println(r);
		        }
		    }
		}
		break;

		case 4:
		{
			System.out.println("Delete Quiz...");
			QuizzeDao qdaDao = new QuizzeDaoimpl();
			System.out.println("enter the quizze_id to delete");
			int quizze_id=sc.nextInt();
			int count = qdaDao.deleteQuizze(quizze_id);
			if(count > 0)
			{
				System.out.println("Quizze delete Successfully");
				
			}
		}
			
			//qdaDao.deleteQuizze(quizze_id);
			break;

		case 5:
		{
			System.out.println("Admin logged out successfully.");
		break;
		}

		default:
			System.out.println(" Invalid choice!");
		}
		}while(choice != 5);
}
	
public void StudentMenu(int i) throws Exception {

    do {
        System.out.println("\n============= STUDENT MENU =============");
        System.out.println("1. View Quizzes");
        System.out.println("2. Take Quiz");
        System.out.println("3. View Scores");
        System.out.println("4. Logout");
        System.out.print("Enter choice: ");

        choice = sc.nextInt();

        switch (choice) {

        case 1:
        {
            QuizzeDao qdao = new QuizzeDaoimpl();

            HashSet<Quizze> quizzes = qdao.viewQuizzes();

            for(Quizze q : quizzes) {
                System.out.println(q);
            }
        }
        break;

        case 2:
        {
            System.out.print("Enter Quiz ID to attempt: ");
            int quizze_Id = sc
            		.nextInt();

            QuizzeDao qdao = new QuizzeDaoimpl();

            qdao.attemptQuiz(i, quizze_Id);

            break;
        }

        case 3:
        {
            StudentDao sdao = new StudentDaoImple();

            List<Result> scores = sdao.viewScores(i);

            if(scores.isEmpty()) {
                System.out.println("No Scores Available.");
            }
            else {
                for(Result r : scores) {
                    System.out.println(r);
                }
            }
        }
        break;
      
        case 4:
        {
            System.out.println("Student logged out successfully.");
            break;
        }

        default:
            System.out.println("Invalid choice! Please try again.");
        }

    } while (choice != 4);
}

	
}
