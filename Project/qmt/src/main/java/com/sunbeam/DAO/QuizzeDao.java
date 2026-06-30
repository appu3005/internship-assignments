package com.sunbeam.DAO;

import java.util.HashSet;
import java.util.List;

import com.sunbeam.entity.Question;
import com.sunbeam.entity.Quizze;
import com.sunbeam.entity.Result;

public interface QuizzeDao extends AutoCloseable {
	
	void CreateQuizze(String title, String path) throws Exception; 
	
	public  HashSet<Quizze> viewQuizzes() throws Exception;
	
	public int deleteQuizze(int quize_id) throws Exception;
	
	List<Result> viewResults() throws Exception;
	
	void attemptQuiz(int student_id, int quizze_id) throws Exception;
	
	HashSet<Quizze> viewQuizzes1() throws Exception;
	
	List<Question> getQuestions(int quizzeId) throws Exception;

	void saveResult(int studentId,int quizzeId,int score) throws Exception;
	

}
