package com.sunbeam.DAO;

import java.util.HashSet;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.sunbeam.entity.Quizze;
import com.sunbeam.entity.Student;

public interface StudentDao extends AutoCloseable {
	
	void register(Student s) throws Exception;
	
	int addStudent(Student student);  //used for register
	
	Student loginStudent(String email, String password)throws Exception; //login student
	
	boolean login(String email, String password) throws Exception;
	
	HashSet<Quizze> viewQuizzes() throws Exception;
	
	List<com.sunbeam.entity.Result> viewScores(int studentId) throws Exception;
	
	@Override
	default void close() throws Exception {
		
	}
	
}



