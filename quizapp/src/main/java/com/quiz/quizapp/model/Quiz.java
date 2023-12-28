package com.quiz.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    String title;
    @ElementCollection
    List<Integer> questionIds;
    public List<Integer> getQuestionId() {
        return this.questionIds;
    }
    public void setQuestionId(List<Integer> questionId) {
        this.questionIds = questionId;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
   
    
}
