package com.gcp.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface GoogleStorageService {

	void create(MultipartFile file) throws IOException;
	String readFile();
}
