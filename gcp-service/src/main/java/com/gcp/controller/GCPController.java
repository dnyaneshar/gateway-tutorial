package com.gcp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gcp.service.GoogleStorageService;

public class GCPController {

	@Autowired
	private GoogleStorageService storageService;
	
	
	@PostMapping("/send-file")
	public ResponseEntity<String> sendFile(@RequestParam("file") MultipartFile file) throws IOException {
		
		storageService.create(file);
		return ResponseEntity.ok("File uploaded successfully");
	}
}
