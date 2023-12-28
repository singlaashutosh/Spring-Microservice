package com.quiz.quizapp.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.quizapp.model.QuestionWrapper;
import com.quiz.quizapp.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface IQuizService {

    @PostMapping("/question/quiz")
    public ResponseEntity<List<Integer>> fetchQuestionListForQuiz(@RequestParam int num, @RequestParam String category); 

    @PostMapping("/questions")
    public ResponseEntity<List<QuestionWrapper>> fetchQuestions(@RequestBody List<Integer> ids) ;
    
    @PostMapping("/questions/score")
    public ResponseEntity<Integer> fetchScore(@RequestBody List<Response> responses);

}
