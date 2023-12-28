package com.quiz.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quizapp.model.Quiz;

public interface IQuizDao extends JpaRepository<Quiz,Integer>{
    
}
