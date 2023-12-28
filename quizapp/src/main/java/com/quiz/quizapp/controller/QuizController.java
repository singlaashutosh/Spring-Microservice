package com.quiz.quizapp.controller;

import java.util.List;

import org.hibernate.type.descriptor.java.IntegerJavaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quizapp.model.QuestionWrapper;
import com.quiz.quizapp.model.Quiz;
import com.quiz.quizapp.model.Response;
import com.quiz.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

   
       @Autowired
       QuizService quizService; 
    
       @PostMapping("/")
       ResponseEntity createQuiz(@RequestParam int num, @RequestParam String catagory ){
         Quiz quiz = this.quizService.createQuiz(num, catagory);
        ;
        return new ResponseEntity("success:"+quiz.getId(), HttpStatus.OK);
       }
       
       @GetMapping("/{id}")
       ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id ){
        
        return  new ResponseEntity<>(this.quizService.getQuiz(id),HttpStatus.OK);
       }
       @PostMapping("/submit")
       int submitQuiz(@RequestBody List<Response> responses ){

        return this.quizService.submitQuiz(responses);
       }


}
