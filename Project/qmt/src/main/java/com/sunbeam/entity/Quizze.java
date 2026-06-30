package com.sunbeam.entity;

public class Quizze {
	private int quizze_id;
	private String title;
	
	public Quizze(int quizze_id, String title) {
		super();
		this.quizze_id = quizze_id;
		this.title = title;
	}

	public int getQuizze_id() {
		return quizze_id;
	}

	public void setQuizze_id(int quizze_id) {
		this.quizze_id = quizze_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Quizze [quizze_id=" + quizze_id + ", title=" + title + "]";
	}
	
}
