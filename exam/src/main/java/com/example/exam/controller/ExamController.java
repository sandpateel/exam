package com.example.exam.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {

	@RequestMapping({ "/hello" })

	public String firstPage() {

	return "Hello World";

	}
}
