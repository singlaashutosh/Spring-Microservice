package com.questionService.app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    String question;
    String optOne;
    String optTwo;
    String optThree;
    String optFour;
    String catagory;
    String difficultyLevel;
    String rightAnswer;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQuestion() {
        return this.question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOptOne() {
        return this.optOne;
    }
    public void setOptOne(String optOne) {
        this.optOne = optOne;
    }
    public String getOptTwo() {
        return this.optTwo;
    }
    public void setOptTwo(String optTwo) {
        this.optTwo = optTwo;
    }
    public String getOptThree() {
        return this.optThree;
    }
    public void setOptThree(String optThree) {
        this.optThree = optThree;
    }
    public String getOptFour() {
        return this.optFour;
    }
    public void setOptFour(String optFour) {
        this.optFour = optFour;
    }
    public String getCatagory() {
        return this.catagory;
    }
    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
    public String getDifficultyLevel() {
        return this.difficultyLevel;
    }
    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public String getRightAnswer() {
        return this.rightAnswer;
    }
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

}
