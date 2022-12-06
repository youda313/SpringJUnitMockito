package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	
	public String getWelcomeMessage(String name) {
		return String.format("welcome %s!", name);
	}

}
//test
