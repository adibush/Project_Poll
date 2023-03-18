package com.example.Project_Poll.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Poll {

    private int question_id;
    @JsonProperty(value = "question_title")
    private String title;
    @JsonProperty(value = "question_first_answer")
    private String firstAnswer;
    @JsonProperty(value = "question_second_answer")
    private String secondAnswer;
    @JsonProperty(value = "question_third_answer")
    private String thirdAnswer;
    @JsonProperty(value = "question_fourth_answer")
    private String fourthAnswer;
    @JsonProperty(value = "user_id")
    private int userId;

    private String answer;

    public Poll(int question_id, String title, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer, int userId, String answer) {
        this.question_id = question_id;
        this.title = title;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
        this.userId = userId;
        setAnswer(switchAnswer(answer));

    }


    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public String getFourthAnswer() {
        return fourthAnswer;
    }

    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String switchAnswer(String result) {
        switch (result) {
            case "A":
                this.answer = "A";
                break;
            case "B":
                this.answer = "B";
                break;
            case "C":
                this.answer = "C";
                break;
            case "D":
                this.answer = "D";
                break;
            default:
                answer = "";
        }

        return answer;
    }


}
