package com.roombooker.test;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.roombooker.controller.RoomBookBoot;
import com.roombooker.model.Customer;
import com.roombooker.service.RoomBookerService;

@SpringBootTest(classes = RoomBookBoot.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerCreation {

	private final static String RESTENDPOINT="http://localhost:8080/customer/";
	
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private RoomBookerService roomBookerService;
	
	@Test
	public void saveForToSuccess() throws JSONException {
		String url = "add";
		String email=roomBookerService.getRandomEmail("prathap","@prathap.com",true);
		Map<String, String> cusotomer = new HashMap<>();
		cusotomer.put("firstname", "prathap");
		cusotomer.put("lastname", "Phillips");
		cusotomer.put("dob", "1973-10-31");
		cusotomer.put("email", email);
		cusotomer.put("password", "phillips");
		ResponseEntity<Customer> response = restTemplate.postForEntity(RESTENDPOINT+url, cusotomer, Customer.class);
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void saveWithFirstNameLessthan4CharacterToFail() throws JSONException {
		String url = "add";
		String email=roomBookerService.getRandomEmail("prathap","@prathap.com",true);
		Map<String, String> cusotomer = new HashMap<>();
		cusotomer.put("firstname", "pra");
		cusotomer.put("lastname", "Phillips");
		cusotomer.put("dob", "1973-10-31");
		cusotomer.put("email", email);
		cusotomer.put("password", "phillips");
		ResponseEntity<Customer> response = restTemplate.postForEntity(RESTENDPOINT+url, cusotomer, Customer.class);
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void saveWithFirstNameMoreThan50CharacterToFail() throws JSONException {
		String url = "add";
		String email=roomBookerService.getRandomEmail("prathap","@prathap.com",true);
		Map<String, String> cusotomer = new HashMap<>();
		cusotomer.put("firstname", "praaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		cusotomer.put("lastname", "Phillips");
		cusotomer.put("dob", "1973-10-31");
		cusotomer.put("email", email);
		cusotomer.put("password", "phillips");
		ResponseEntity<Customer> response = restTemplate.postForEntity(RESTENDPOINT+url, cusotomer, Customer.class);
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}

}
