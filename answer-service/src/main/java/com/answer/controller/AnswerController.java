package com.answer.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer-service")
public class AnswerController {
	
	@GetMapping("/answers")
	public ResponseEntity<String> getAnswers(){
		return new ResponseEntity<String>("I am very reach person", HttpStatusCode.valueOf(200));
	}
	

}
