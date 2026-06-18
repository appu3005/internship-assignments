package com.sunbeam.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import com.sunbeam.DAO.StudentDao;
import com.sunbeam.DBUtil.DButil;
import com.sunbeam.entity.Quizze;
import com.sunbeam.entity.Result;
import com.sunbeam.entity.Student;

public class StudentDaoImple implements StudentDao {
	
	public Connection con; 
	public StudentDaoImple() throws Exception {
	    con = DButil.getConnection();
	}
	
	@Override
	public void close() throws Exception {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public int addStudent(Student student) {
		
		int count=0;
		String sql = "insert into Student (std_name,email_id,password) values(?,?,?)";
		
		try(PreparedStatement stmt = con.prepareStatement(sql);
				){
			
			stmt.setString(1, student.getStd_name());
			stmt.setString(2, student.getEmail_id());
			stmt.setNString(3,student.getPassward());
			
			count=stmt.executeUpdate();
			
		}catch( Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Student loginStudent(String email, String passward) {
		
		Student student= null;
		String sql ="select * from student where email_id= ? and passward=?";
		
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, email);
			stmt.setString(2, passward);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {

	            student = new Student();

	            student.setStudent_id(rs.getInt("student_id"));
	            student.setStd_name(rs.getString("std_name"));
	            student.setEmail_id(rs.getString("email_id"));
	            student.setPassword(rs.getString("passward"));
	        }

			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return student;
	}

	@Override
	public void register(Student s) throws Exception {

	    Scanner sc = new Scanner(System.in);

	    System.out.print("Enter Name: ");
	    s.setStd_name(sc.nextLine());

	    System.out.print("Enter Email: ");
	    s.setEmail_id(sc.next());

	    System.out.print("Enter Password: ");
	    s.setPassword(sc.next());

	    String sql =
	            "insert into student(std_name,email_id,passward) values(?,?,?)";

	    PreparedStatement stmt = con.prepareStatement(sql);

	    stmt.setString(1, s.getStd_name());
	    stmt.setString(2, s.getEmail_id());
	    stmt.setString(3, s.getPassward());

	    int count = stmt.executeUpdate();

	    if(count > 0) {
	        System.out.println("Student Registered Successfully.");
	    }
	}
	
	@Override
	public boolean login(String email, String passward) throws Exception {

	    String sql = "select * from student where email_id=? and passward=?";

	    PreparedStatement stmt = con.prepareStatement(sql);

	    stmt.setString(1, email);
	    stmt.setString(2, passward);

	    ResultSet rs = stmt.executeQuery();

	    return rs.next();
	}

	@Override
	public List<Result> viewScores(int studentId) throws Exception {

	    List<Result> scores = new ArrayList<>();

	    String sql = "select * from result where student_id = ?";

	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setInt(1, studentId);

	    ResultSet rs = stmt.executeQuery();

	    while(rs.next()) {

	        int resultId = rs.getInt("result_id");
	        int quizId = rs.getInt("quize_id");
	        int score = rs.getInt("score");

	        Result r = new Result(resultId, studentId, quizId, score);

	        scores.add(r);
	    }

	    return scores;
	}

	@Override
	public HashSet<Quizze> viewQuizzes() throws Exception {
		return null;
	}

}


