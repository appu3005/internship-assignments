package com.sunbeam.entity;

public class Result {

    private int result_id;
    private int student_id;
    private int quize_id;
    private int score;

    public Result(int result_id, int student_id,
                  int quize_id, int score) {

        this.result_id = result_id;
        this.student_id = student_id;
        this.quize_id = quize_id;
        this.score = score;
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

    public int getQuize_id() {
        return quize_id;
    }

    public void setQuize_id(int quize_id) {
        this.quize_id = quize_id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Result [result_id=" + result_id
                + ", student_id=" + student_id
                + ", quize_id=" + quize_id
                + ", score=" + score + "]";
    }
}