package com.quiz.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.quizapp.dao.IQuizDao;

import com.quiz.quizapp.model.QuestionWrapper;
import com.quiz.quizapp.model.Quiz;
import com.quiz.quizapp.model.Response;

@Service
public class QuizService {
   
    @Autowired
    IQuizDao quizdao;

    @Autowired
    IQuizService iQuizService;


   public Quiz createQuiz(int num,String category){
      List<Integer> questions = this.iQuizService.fetchQuestionListForQuiz(num, category).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(category);
        quiz.setQuestionId(questions);
        ;
        return this.quizdao.save(quiz) ;
    }
    public List<QuestionWrapper> getQuiz(int id){

 
        List<QuestionWrapper> listQuestionWrapper = this.iQuizService.fetchQuestions(  this.quizdao.findById(id).get().getQuestionId()).getBody();
        return listQuestionWrapper;
}
  public  int  submitQuiz(List<Response> responses){

    //call question service and retun score
int score = this.iQuizService.fetchScore(responses).getBody();
       
        return  score;
    }



   
    
}
