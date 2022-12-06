package com.example.demo.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.demo.services.WelcomeService;

class WelcomeControllerUnitTest {

	@Test
	void testWelcome() {
		
		WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
		when(welcomeService.getWelcomeMessage("Matt")).thenReturn("welcome Matt!");
		WelcomeController welcomeController = new WelcomeController(welcomeService);
		assertEquals("welcome Matt!", welcomeController.welcome("Matt"));
	}

}
