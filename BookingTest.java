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
import com.roombooker.model.Customer;

@SpringBootTest(classes = RoomBookBoot.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookingTest {

	private static String RESTENDPOINT="http://localhost:8080/booking/";
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAllSuccess() throws JSONException {
		Booking[] bookings = this.restTemplate.getForObject(RESTENDPOINT+"all", Booking[].class);
		assertTrue(bookings.length>4?true:false);
	}
	
	
	@Test
	public void getByIdTrue() throws JSONException {
		Booking booking = this.restTemplate.getForObject(RESTENDPOINT+"18", Booking.class);
		assertTrue(booking.getCustomers().getFirstname().length()>3);
	}
	
	@Test
	public void getByIdFalse() throws JSONException {
		Booking booking = this.restTemplate.getForObject(RESTENDPOINT+"18", Booking.class);
		assertTrue(booking.getCustomers().getFirstname().length()<3);
	}
	
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
	
	@Test
	public void updateTrue() throws JSONException {
		String url = "update";
		RestTemplate restTemplate = new RestTemplate();
		Booking booking = new Booking();
		booking.setId(1);
		booking.getCustomers().setId(1);
		booking.getRooms().setId(1);
		booking.setStartdate(Date.valueOf("2020-06-20"));
		booking.setEnddate(Date.valueOf("2020-06-21"));
		ResponseEntity<Booking> response=restTemplate.exchange(RESTENDPOINT+url,HttpMethod.PUT,new HttpEntity<>(booking),
				Booking.class,booking.getId());
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void updateFalseStartDate() throws JSONException {
		String url = "update";
		RestTemplate restTemplate = new RestTemplate();
		Booking booking = new Booking();
		booking.setId(1);
		booking.getCustomers().setId(1);
		booking.getRooms().setId(1);
		booking.setStartdate(Date.valueOf("2020-13-20"));
		booking.setEnddate(Date.valueOf("2020-06-21"));
		ResponseEntity<Booking> response=restTemplate.exchange(RESTENDPOINT+url
				,HttpMethod.PUT,new HttpEntity<>(booking),
				Booking.class,Long.toString(booking.getId()));
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void updateFalseEndDate() throws JSONException {
		String url = "update";
		RestTemplate restTemplate = new RestTemplate();
		Booking booking = new Booking();
		booking.setId(1);
		booking.getCustomers().setId(1);
		booking.getRooms().setId(1);
		booking.setStartdate(Date.valueOf("2020-06-20"));
		booking.setEnddate(Date.valueOf("2020-13-21"));
		ResponseEntity<Booking> response=restTemplate.exchange(RESTENDPOINT+url,HttpMethod.PUT,new HttpEntity<>(booking),
				Booking.class,Long.toString(booking.getId()));
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void delete() throws JSONException {
		String url = "delete";
		Booking booking = new Booking();
		booking.setId(3);
		ResponseEntity<Booking> response=restTemplate.exchange(RESTENDPOINT+url+"/3",HttpMethod.DELETE,new HttpEntity<>(booking),
				Booking.class,Long.toString(booking.getId()));
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}

}
