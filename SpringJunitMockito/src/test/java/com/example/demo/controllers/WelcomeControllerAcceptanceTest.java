package com.example.demo.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
//allows the injection of the service into the controller 
@AutoConfigureMockMvc
class WelcomeControllerAcceptanceTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldGetDefaultWelcomeMessage() throws Exception {

		// testing the GET /welcome
		mockMvc.perform(get("/welcome")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(equalTo("welcome Stranger!")));

	}
	
	@Test
	void shouldGetCustomWelcomeMessage() throws Exception {

		//testing the GET /welcome 
		mockMvc.perform(get("/welcome?name=Matt"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content()
		.string(equalTo("welcome Matt!")));
		

	}

}
