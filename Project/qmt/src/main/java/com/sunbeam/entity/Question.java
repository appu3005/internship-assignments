package com.sunbeam.entity;

public class Question {

    private int que_id;
    private int quizze_id;
    private String question;
    private String option_A;
    private String option_B;
    private String option_C;
    private String option_D;
    private String correct_ans;

    public Question(int que_id, int quizze_id, String question,
                    String option_A, String option_B,
                    String option_C, String option_D,
                    String correct_ans) {

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

    public int getQuizze_id() {
        return quizze_id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption_A() {
        return option_A;
    }

    public String getOption_B() {
        return option_B;
    }

    public String getOption_C() {
        return option_C;
    }

    public String getOption_D() {
        return option_D;
    }

    public String getCorrect_ans() {
        return correct_ans;
    }
}