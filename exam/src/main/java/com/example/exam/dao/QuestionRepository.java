package com.example.exam.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exam.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer > {

	   List<Question> findFirst10ByQtype(String qtype, Pageable pageable);
	   

}
