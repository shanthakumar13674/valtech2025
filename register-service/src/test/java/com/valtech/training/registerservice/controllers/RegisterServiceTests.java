package com.valtech.training.registerservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.valtech.training.registerservice.vos.UserVO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class RegisterServiceTests {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testGetUserByValidId() throws Exception{
		
		mockMvc.perform(get("/api/v1/users/1")).andDo(print()).andExpect(content().json("{'id':1,'age':32,'email':'xyz@gmail.com','mobile':'8955778','name':'xyz','kid':false,'subscriptionId':1}"))
		.andExpectAll(status().isOk());

	}
	
	@Test
public void testGetUserByInValidId() throws Exception{
		
		mockMvc.perform(get("/api/v1/users/0")).andDo(print()).andExpect(status().isNotFound());

	}
}
