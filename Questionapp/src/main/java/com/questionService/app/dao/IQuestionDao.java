package com.questionService.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.questionService.app.model.Question;



public interface IQuestionDao extends JpaRepository<Question,Integer>{

    List<Question> findByCatagory(String catagory);

    @Query(value = "SELECT q.id from question q Where q.catagory=:catagory ORDER BY RANDOM() LIMIT :num",nativeQuery=true)
    List<Integer> findByRandomCategory(int num,String catagory);
    
}
