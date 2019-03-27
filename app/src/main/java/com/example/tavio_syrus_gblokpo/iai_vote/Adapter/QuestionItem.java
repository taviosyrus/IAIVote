package com.example.tavio_syrus_gblokpo.iai_vote.Adapter;

public class QuestionItem {
    private String question_id;
    private String question_name;
    private int answer = -1; //-1 means not yet answer

    public String getQuestionId() {
        return question_id;
    }

    public void setQuestionId(String question_id) {
        this.question_id = question_id;
    }

    public String getQuestionName() {
        return question_name;
    }

    public void setQuestionName(String question_name) {
        this.question_name = question_name;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}