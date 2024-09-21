package com.configserver2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer2Application {

	public static void main(String[] args) {
		
		int a = 1 ; int b = 2; int c = a = b;
		SpringApplication.run(ConfigServer2Application.class, args);
		System.out.println(c);
	}

}
