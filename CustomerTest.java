package com.roombooker.test;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.roombooker.controller.RoomBookBoot;
import com.roombooker.model.Customer;

@SpringBootTest(classes = RoomBookBoot.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerTest {

	private static String RESTENDPOINT="http://localhost:8080/customer/";
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAll() throws JSONException {
		Customer[] customers = this.restTemplate.getForObject(RESTENDPOINT+"all", Customer[].class);
		assertTrue(customers.length>0?true:false);
	}
	
	@Test
	public void getById() throws JSONException {
		Customer customer = this.restTemplate.getForObject(RESTENDPOINT+"1", Customer.class);
		assertTrue(customer.getFirstname().length()>0);
	}
	
	@Test
	public void save() throws JSONException {
		String url = "add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> cusotomer = new HashMap<>();
		cusotomer.put("firstname", "prathap");
		cusotomer.put("lastname", "Phillips");
		cusotomer.put("dob", "1973-10-31");
		cusotomer.put("email", "prathap1@prathap.com");
		cusotomer.put("password", "phillips");
		ResponseEntity<Customer> response = restTemplate.postForEntity(RESTENDPOINT+url, cusotomer, Customer.class);
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void update() throws JSONException {
		String url = "update";
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = new Customer();
		customer.setId(2);customer.setFirstname("prathap111");customer.setLastname("Phillips11111");
		customer.setDob(Date.valueOf("1973-10-31"));customer.setEmail("prathap2@prathap.com");customer.setPassword("phillips");
		ResponseEntity<Customer> response=restTemplate.exchange(RESTENDPOINT+url,HttpMethod.PUT,new HttpEntity<>(customer),
                Customer.class,Long.toString(customer.getId()));
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void delete() throws JSONException {
		String url = "delete";
		Customer customer = new Customer();
		customer.setId(3);
		ResponseEntity<Customer> response=restTemplate.exchange(RESTENDPOINT+url+"/3",HttpMethod.DELETE,new HttpEntity<>(customer),
                Customer.class,Long.toString(customer.getId()));
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}

}
