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
import com.roombooker.model.Booking;

@SpringBootTest(classes = RoomBookBoot.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookingCreation {

	private static String RESTENDPOINT="http://localhost:8080/booking/";
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void saveTrue() throws JSONException {
		String url = "add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> booking = new HashMap<>();
		booking.put("startdate", "2020-06-19");
		booking.put("enddate", "2020-06-20");
		Map<String, String> rooms = new HashMap<>();
		rooms.put("id", "2");
		booking.put("rooms", rooms);
		Map<String, String> customer = new HashMap<>();
		customer.put("id", "2");
		booking.put("customers", customer);
		ResponseEntity<Booking> response = restTemplate.postForEntity(RESTENDPOINT+url, booking, Booking.class);
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	
	@Test
	public void saveFalseInvalidStartDate() throws JSONException {
		String url = "add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> booking = new HashMap<>();
		booking.put("startdate", "2020-13-19");
		booking.put("enddate", "2020-06-20");
		Map<String, String> rooms = new HashMap<>();
		rooms.put("id", "2");
		booking.put("rooms", rooms);
		Map<String, String> customer = new HashMap<>();
		customer.put("id", "2");
		booking.put("customers", customer);
		ResponseEntity<Booking> response = restTemplate.postForEntity(RESTENDPOINT+url, booking, Booking.class);
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void saveFalseInvalidEndDate() throws JSONException {
		String url = "add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> booking = new HashMap<>();
		booking.put("startdate", "2020-06-19");
		booking.put("enddate", "2020-13-20");
		Map<String, String> rooms = new HashMap<>();
		rooms.put("id", "2");
		booking.put("rooms", rooms);
		Map<String, String> customer = new HashMap<>();
		customer.put("id", "2");
		booking.put("customers", customer);
		ResponseEntity<Booking> response = restTemplate.postForEntity(RESTENDPOINT+url, booking, Booking.class);
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}

}
