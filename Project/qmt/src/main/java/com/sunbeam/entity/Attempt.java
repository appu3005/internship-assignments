package com.sunbeam.entity;

public class Attempt {
	
	private int quize_id;
	private int student_id;
	
	public Attempt(int quize_id, int student_id) {
		super();
		this.quize_id = quize_id;
		this.student_id = student_id;
	}

	public int getQuize_id() {
		return quize_id;
	}

	public void setQuize_id(int quize_id) {
		this.quize_id = quize_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	@Override
	public String toString() {
		return "Attempt [quize_id=" + quize_id + ", student_id=" + student_id + "]";
	}

}
