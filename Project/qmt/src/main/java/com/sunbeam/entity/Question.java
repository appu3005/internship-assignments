package com.sunbeam.entity;

import org.w3c.dom.Text;

public class Question {
	private int que_id;
	private int quizze_id;
	private Text question;
	private String option_A;
	private String option_B;
	private String option_C;
	private String option_D;
	private String correct_ans;
	
	
	public Question(int que_id, int quizze_id, Text question, String option_A, String option_B, String option_C,
			String option_D, String correct_ans) {
		super();
		this.que_id = que_id;
		this.quizze_id = quizze_id;
		this.question = question;
		this.option_A = option_A;
		this.option_B = option_B;
		this.option_C = option_C;
		this.option_D = option_D;
		this.correct_ans = correct_ans;
	}


	public int getQue_id() {
		return que_id;
	}


	public void setQue_id(int que_id) {
		this.que_id = que_id;
	}


	public int getQuizze_id() {
		return quizze_id;
	}


	public void setQuizze_id(int quizze_id) {
		this.quizze_id = quizze_id;
	}


	public Text getQuestion() {
		return question;
	}


	public void setQuestion(Text question) {
		this.question = question;
	}


	public String getOption_A() {
		return option_A;
	}


	public void setOption_A(String option_A) {
		this.option_A = option_A;
	}


	public String getOption_B() {
		return option_B;
	}


	public void setOption_B(String option_B) {
		this.option_B = option_B;
	}


	public String getOption_C() {
		return option_C;
	}


	public void setOption_C(String option_C) {
		this.option_C = option_C;
	}


	public String getOption_D() {
		return option_D;
	}


	public void setOption_D(String option_D) {
		this.option_D = option_D;
	}


	public String getCorrect_ans() {
		return correct_ans;
	}


	public void setCorrect_ans(String correct_ans) {
		this.correct_ans = correct_ans;
	}


	@Override
	public String toString() {
		return "Question [que_id=" + que_id + ", quizze_id=" + quizze_id + ", question=" + question + ", option_A="
				+ option_A + ", option_B=" + option_B + ", option_C=" + option_C + ", option_D=" + option_D
				+ ", correct_ans=" + correct_ans + "]";
	}

}
