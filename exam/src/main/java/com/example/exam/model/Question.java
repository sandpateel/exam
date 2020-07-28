package com.example.exam.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Question {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "DESCRIPTION", nullable = false, length = 500) 
	private String description;
		@Column
	private String option1;
	@Column
	private String option2;
	@Column
	private String option3;
	@Column
	private String option4;
	@Column
	private String correctOption;
	
	
	@ManyToMany(mappedBy="questions", fetch = FetchType.LAZY)
	private Set<Test> tests;


	
	
	//getters and setters
	
	public Question(String description, String op1, String op2, String op3, String op4, String correctOp) {
		this.description = description;
		this.option1 = op1;
		this.option2 = op2;
		this.option3 = op3;
		this.option4 = op4;
		this.correctOption = correctOp;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getOption1() {
		return option1;
	}


	public void setOption1(String option1) {
		this.option1 = option1;
	}


	public String getOption2() {
		return option2;
	}


	public void setOption2(String option2) {
		this.option2 = option2;
	}


	public String getOption3() {
		return option3;
	}


	public void setOption3(String option3) {
		this.option3 = option3;
	}


	public String getOption4() {
		return option4;
	}


	public void setOption4(String option4) {
		this.option4 = option4;
	}


	public String getCorrectOption() {
		return correctOption;
	}


	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}


	public Set<Test> getTests() {
		return tests;
	}


	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
	
	

}
