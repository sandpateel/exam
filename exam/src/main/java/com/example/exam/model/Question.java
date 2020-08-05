package com.example.exam.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="questions")
public class Question {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int qno;
	
	@Column
	private String qtype;
	@Column
	private String qtype_value;

	@Column(nullable = false, length = 2000) 
	private String statement;
	@Column
	private String A;
	@Column
	private String B;
	@Column
	private String C;
	@Column
	private String D;
	@Column
	private String answer;
	@Column
	private String subject;
	@Column
	private String topic;
	@Column
	private String subtopic;
	@Column
	private String explanation;
	
	
	@ManyToMany(mappedBy="questions", fetch = FetchType.LAZY)
	private Set<Test> tests;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQno() {
		return qno;
	}


	public void setQno(int qno) {
		this.qno = qno;
	}


	public String getQtype() {
		return qtype;
	}


	public void setQtype(String qtype) {
		this.qtype = qtype;
	}


	public String getQtype_value() {
		return qtype_value;
	}


	public void setQtype_value(String qtype_value) {
		this.qtype_value = qtype_value;
	}


	public String getStatement() {
		return statement;
	}


	public void setStatement(String statement) {
		this.statement = statement;
	}


	public String getA() {
		return A;
	}


	public void setA(String a) {
		A = a;
	}


	public String getB() {
		return B;
	}


	public void setB(String b) {
		B = b;
	}


	public String getC() {
		return C;
	}


	public void setC(String c) {
		C = c;
	}


	public String getD() {
		return D;
	}


	public void setD(String d) {
		D = d;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getSubtopic() {
		return subtopic;
	}


	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
	}


	public String getExplanation() {
		return explanation;
	}


	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}


	public Set<Test> getTests() {
		return tests;
	}


	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

	

}
