package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class HospitalManagementApplication {
	int count=0;
	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementApplication.class, args);
	}
	@GetMapping("/")
	private String hello(){ return "hello my name is rahul";}

	@GetMapping("/count/")
	private String count(){ return count+++"";}

}
