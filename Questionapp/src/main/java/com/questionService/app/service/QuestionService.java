package com.questionService.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.questionService.app.dao.IQuestionDao;
import com.questionService.app.model.Question;
import com.questionService.app.model.QuestionWrapper;
import com.questionService.app.model.Response;



@Service
public class QuestionService {
   
@Autowired
    IQuestionDao questionDao;

    public Question addQuestion(Question question){

       return this.questionDao.save(question);
    }

public Optional<Question> getQuestionById(int id){
    return this.questionDao.findById(id);
}

public List<Question> getQuestionByCatagory(String catagory){

    return this.questionDao.findByCatagory(catagory);
    
}
public List<Question> getAllQuestions(){

    return this.questionDao.findAll();
    
}
   public List<Integer> createQuestionListForQuiz(int num,String catagory){
      
    return this.questionDao.findByRandomCategory(num, catagory);

   /*  List<QuestionWrapper> listQuestionWrapper = new ArrayList<>();


      for (Question question : this.questionDao.findByRandomCategory(num, catagory)) {

        QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getQuestion(), question.getOptOne()
        , question.getOptTwo(), question.getOptThree(), question.getOptFour(), question.getCatagory(), question.getDifficultyLevel());
        listQuestionWrapper.add(questionWrapper);
        
      } ;
    return listQuestionWrapper;  */

   }

public List<QuestionWrapper> getQuestions(List<Integer> ids) {
    List<QuestionWrapper> listQuestionWrapper = new ArrayList<>();

    for (Question question : this.questionDao.findAllById(ids)) {

      QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), question.getQuestion(), question.getOptOne()
      , question.getOptTwo(), question.getOptThree(), question.getOptFour(), question.getCatagory(), question.getDifficultyLevel());
      listQuestionWrapper.add(questionWrapper);
    }

    return listQuestionWrapper  ;

}
public  Integer getscore(@RequestBody List<Response> responses ) {
    int score =0;
        for (Response resposne : responses) {
            if(resposne.getResponse().equals( this.questionDao.findById(resposne.getId()).get().getRightAnswer())){
                score++;
            }
              ;
        }

    return score ;
    
}
   
}
