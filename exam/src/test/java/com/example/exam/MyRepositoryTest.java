package com.example.exam;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.exam.dao.QuestionRepository;

@ExtendWith(SpringExtension.class)
public class MyRepositoryTest {

    @Autowired
    private QuestionRepository questionRepo ;
    
    @Test
    public void testFetchingQuestionsFromDB() {
    	System.out.println("________________Question Count: " + questionRepo.count());
    }
    
}