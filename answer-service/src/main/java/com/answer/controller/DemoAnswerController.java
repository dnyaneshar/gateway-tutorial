package com.answer.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-answer")
public class DemoAnswerController {
	
	@GetMapping("/demo")
	public ResponseEntity<String> getAnswers(){
		return new ResponseEntity<String>("It is demo answer", HttpStatusCode.valueOf(200));
	}
	

}
