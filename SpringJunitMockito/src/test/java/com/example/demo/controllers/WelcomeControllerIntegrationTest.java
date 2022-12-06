package com.example.demo.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.services.WelcomeService;

@WebMvcTest
class WelcomeControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WelcomeService welcomeService;

	@Test
	void shouldGetDefaultWelcomeMessage() throws Exception {

		//mocking the WelcomeService class when no web param are sent
		when(welcomeService.getWelcomeMessage("Stranger")).thenReturn("welcome Stranger!");

		//testing the GET /welcome 
		mockMvc.perform(get("/welcome"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content()
		.string(equalTo("welcome Stranger!")));
		
		//verify that the mock was called
		verify(welcomeService).getWelcomeMessage("Stranger");
	}
	
	@Test
	void shouldGetCustomWelcomeMessage() throws Exception {

		//mocking the WelcomeService class when no web param are sent
		when(welcomeService.getWelcomeMessage("Matt")).thenReturn("welcome Matt!");

		//testing the GET /welcome 
		mockMvc.perform(get("/welcome?name=Matt"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content()
		.string(equalTo("welcome Matt!")));
		
		//verify that the mock was called
		verify(welcomeService).getWelcomeMessage("Matt");
	}

}
