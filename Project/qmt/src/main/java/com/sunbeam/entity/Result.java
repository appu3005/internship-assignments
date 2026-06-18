package com.sunbeam.entity;

public class Result {
	
	private int result_id;
	private int student_id;
	private int score;
	private int quize_id;
	
	public Result(int result_id, int student_id, int score, int quize_id) {
		super();
		this.result_id = result_id;
		this.student_id = student_id;
		this.score = score;
		this.quize_id = quize_id;
	}

	public int getResult_id() {
		return result_id;
	}

	public void setResult_id(int result_id) {
		this.result_id = result_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getQuize_id() {
		return quize_id;
	}

	public void setQuize_id(int quize_id) {
		this.quize_id = quize_id;
	}

	@Override
	public String toString() {
		return "Result [result_id=" + result_id + ", student_id=" + student_id + ", score=" + score + ", quize_id="
				+ quize_id + "]";
	}
	
	
	

}
