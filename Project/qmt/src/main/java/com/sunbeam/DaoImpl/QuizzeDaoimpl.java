package com.sunbeam.DaoImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.DAO.QuizzeDao;
import com.sunbeam.DBUtil.DButil;
import com.sunbeam.entity.Question;
import com.sunbeam.entity.Quizze;
import com.sunbeam.entity.Result;
import com.sunbeam.exceptions.NoQuestionFoundException;

public class QuizzeDaoimpl implements QuizzeDao {
	
	public Connection con;
	private int student_id;
		
		public QuizzeDaoimpl() throws Exception{
			con=DButil.getConnection();
		}

	
	@Override
	public void CreateQuizze(String title, String path) throws Exception {
		String sql = "insert into quizzes (title) values(?)";
		
		PreparedStatement stmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
		
		stmt.setString(1, title);
		stmt.executeUpdate();
		ResultSet rs = stmt.getGeneratedKeys();                  //id  --generate 
		
		int que_id=0;
		if(rs.next()) {
			que_id=rs.getInt(1);
		}
		System.out.println("generate key"+que_id);           //title id generated
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		
		String Question;
		boolean Qfound=false;

		while((Question=br.readLine())!=null) {
			
			if(Question.trim().isEmpty())
			continue;
		
		Qfound=true;
		String option_A=br.readLine();
		String option_B=br.readLine();
		String option_C=br.readLine();
		String option_D=br.readLine();
		String correct_ans=br.readLine();
		
		String sql1= "insert into questions (quizze_id,question, option_A,option_B,option_C,option_D, correct_ans) values(?,?,?,?,?,?,?)";
		
		PreparedStatement stmt1=con.prepareStatement(sql1);
		stmt1.setInt(1, que_id);
		stmt1.setString(2, Question);
		stmt1.setString(3, option_A);
		stmt1.setString(4, option_B);
		stmt1.setString(5, option_C);
		stmt1.setString(6, option_D);
		stmt1.setString(7, correct_ans);
		
		stmt1.executeUpdate();
		}
		if(!Qfound) {
			throw new NoQuestionFoundException("NO Question found"+path);
		}
		
		System.out.println("Quize i created");
		}


	@Override
	public List<Result> viewResults() throws Exception {

	    List<Result> list = new ArrayList<>();

	    String sql = "select * from result";

	    PreparedStatement stmt = con.prepareStatement(sql);

	    ResultSet rs = stmt.executeQuery();

	    while(rs.next()) {

	        int resultId = rs.getInt("result_id");
	        int studentId = rs.getInt("student_id");
	        int quizzeId = rs.getInt("quize_id");
	        int score = rs.getInt("score");

	        Result r = new Result(resultId, studentId, quizzeId, score);

	        list.add(r);
	    }

	    return list;
	}
	
	@Override
	public List<Question> getQuestions(int quizzeId) throws Exception {

	    List<Question> list = new ArrayList<>();

	    System.out.println("Quiz ID Received = " + quizzeId);

	    String sql = "select * from questions where quizze_id=?";

	    PreparedStatement stmt = con.prepareStatement(sql);

	    stmt.setInt(1, quizzeId);

	    ResultSet rs = stmt.executeQuery();

	    while(rs.next()) {

	        System.out.println("Question Found : "
	                + rs.getString("question"));

	        Question q = new Question(

	                rs.getInt("que_id"),
	                rs.getInt("quizze_id"),
	                rs.getString("question"),
	                rs.getString("option_A"),
	                rs.getString("option_B"),
	                rs.getString("option_C"),
	                rs.getString("option_D"),
	                rs.getString("correct_ans")

	        );

	        list.add(q);
	    }

	    System.out.println("Total Questions = " + list.size());

	    return list;
	}

	@Override
	public int deleteQuizze(int quize_id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from questions where quizze_id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, quize_id);
		stmt.executeUpdate();
		
			String sql1 = "delete from quizzes where quize_id = ?";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setInt(1, quize_id);
			return stmt1.executeUpdate();
	}


	@Override
	public void close() throws Exception {
	}

	@Override
	public void attemptQuiz(int studentId, int quizzeId) throws Exception {

	    Scanner sc = new Scanner(System.in);

	    String sql = "SELECT * FROM questions WHERE quizze_id = ?";

	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setInt(1, quizzeId);

	    ResultSet rs = stmt.executeQuery();

	    int score = 0;
	    boolean found = false;

	    while (rs.next()) {

	        found = true;

	        System.out.println("\nQuestion : " + rs.getString("question"));

	        System.out.println("A. " + rs.getString("option_A"));
	        System.out.println("B. " + rs.getString("option_B"));
	        System.out.println("C. " + rs.getString("option_C"));
	        System.out.println("D. " + rs.getString("option_D"));

	        System.out.print("Enter Answer (A/B/C/D): ");
	        String answer = sc.next();

	        String correctAnswer = rs.getString("correct_ans");

	        if (answer.equalsIgnoreCase(correctAnswer)) {
	            score++;
	        }
	    }

	    if (!found) {
	        System.out.println("No questions found for this Quiz ID.");
	        return;
	    }

	  
	    String sql2 = "INSERT INTO result(student_id, quize_id, score) VALUES(?,?,?)";

	    PreparedStatement stmt2 = con.prepareStatement(sql2);

	    stmt2.setInt(1, studentId);
	    stmt2.setInt(2, quizzeId);
	    stmt2.setInt(3, score);

	    stmt2.executeUpdate();

	    System.out.println("\nQuiz Completed Successfully!");
	    System.out.println("Your Score = " + score);
	}
	
	@Override
	public HashSet<Quizze> viewQuizzes1() throws Exception {
		// TODO Auto-generated method stub
		HashSet<Quizze> quizzes = new HashSet<>();

	    String sql = "select * from quizzes";

	    PreparedStatement stmt = con.prepareStatement(sql);

	    ResultSet rs = stmt.executeQuery();

	    while(rs.next()) {

	       // int quizzeId = rs.getInt("quizze_id");
	    	int quizeid = rs.getInt("quize_id");
	        String title = rs.getString("title");

	        quizzes.add(new Quizze(quizeid, title));
	    }

	    return quizzes;
	}

	@Override
	public HashSet<Quizze> viewQuizzes() throws Exception {

	    HashSet<Quizze> quizzes = new HashSet<>();

	    String sql = "select * from quizzes";

	    PreparedStatement stmt = con.prepareStatement(sql);

	    ResultSet rs = stmt.executeQuery();

	    while(rs.next()) {

	        System.out.println(
	                rs.getInt("quize_id") + " "
	                + rs.getString("title"));

	        Quizze q = new Quizze(
	                rs.getInt("quize_id"),
	                rs.getString("title")
	        );

	        quizzes.add(q);
	    }
	    System.out.println("Total Quiz = " + quizzes.size());
	    
	    return quizzes;
	}
	
	@Override
	public void saveResult(int studentId, int quizzeId, int score) throws Exception {

	    String sql =
	            "insert into result(student_id, quize_id, score) values(?,?,?)";

	    PreparedStatement stmt =
	            con.prepareStatement(sql);

	    stmt.setInt(1, studentId);
	    stmt.setInt(2, quizzeId);
	    stmt.setInt(3, score);

	    stmt.executeUpdate();
	}
}


