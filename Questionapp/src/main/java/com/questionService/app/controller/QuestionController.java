package com.questionService.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionService.app.model.Question;
import com.questionService.app.model.QuestionWrapper;
import com.questionService.app.model.Response;
import com.questionService.app.service.QuestionService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/")
public class QuestionController {
   
    @Autowired
    public QuestionService questionService;

    @GetMapping("question/{id}")
    public Optional<Question> getQuestion(@PathVariable int id){
    
        return this.questionService.getQuestionById(id);
        
    }

    @PostMapping("question")
    public Question createQuestion(@RequestBody Question entity) {
        //TODO: process POST request

        
        return this.questionService.addQuestion(entity)  ;
    }
    @GetMapping("questions")
    public List<Question> getAllQuestion(){
    
        return this.questionService.getAllQuestions();
        
    }

    @PostMapping("/question/quiz")
    public ResponseEntity<List<Integer>> fetchQuestionListForQuiz(@RequestParam int num, @RequestParam String category) {
        //TODO: process POST request
         return new ResponseEntity<>(this.questionService.createQuestionListForQuiz(num, category), HttpStatus.OK);
    }

    @PostMapping("/questions")
    public ResponseEntity<List<QuestionWrapper>> fetchQuestions(@RequestBody List<Integer> ids)  {
        //TODO: process POST request
         return new ResponseEntity<>(this.questionService.getQuestions(ids), HttpStatus.OK);
    }
    
    @PostMapping("/questions/score")
    public ResponseEntity<Integer> fetchScore(@RequestBody List<Response> responses)  {
        //TODO: process POST request
         return new ResponseEntity<>(this.questionService.getscore(responses), HttpStatus.OK);
    }
    
}
