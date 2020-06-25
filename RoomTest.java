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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.roombooker.controller.RoomBookBoot;
import com.roombooker.model.Customer;
import com.roombooker.model.Room;

@SpringBootTest(classes = RoomBookBoot.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class RoomTest {

	private static String RESTENDPOINT="http://localhost:8080/room/";
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAllSuccess() throws JSONException {
		Room[] rooms = this.restTemplate.getForObject(RESTENDPOINT+"all", Room[].class);
		assertTrue(rooms.length>0?true:false);
	}
	
	
	@Test
	public void getByIdTrue() throws JSONException {
		Room room = this.restTemplate.getForObject(RESTENDPOINT+"1", Room.class);
		assertTrue(room.getRoomtype().equals("Q"));
	}
	
	@Test
	public void getByIdFalse() throws JSONException {
		Room room = this.restTemplate.getForObject(RESTENDPOINT+"1", Room.class);
		assertTrue(room.getRoomtype().equals("A"));
	}
	
	@Test
	public void saveTrue() throws JSONException {
		String url = "add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> room = new HashMap<>();
		room.put("roomtype", "Q");
		room.put("rent", "6666");
		ResponseEntity<Room> response = restTemplate.postForEntity(RESTENDPOINT+url, room, Room.class);
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	
	@Test
	public void saveFalseInvalidRoomType() throws JSONException {
		String url = "add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> room = new HashMap<>();
		room.put("roomtype", "A");
		room.put("rent", "6666");
		ResponseEntity<Room> response = restTemplate.postForEntity(RESTENDPOINT+url, room, Room.class);
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void saveFalseInvalidRate() throws JSONException {
		String url = "add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> room = new HashMap<>();
		room.put("roomtype", "A");
		room.put("rent", "66666");
		ResponseEntity<Room> response = restTemplate.postForEntity(RESTENDPOINT+url, room, Room.class);
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void updateTrue() throws JSONException {
		String url = "update";
		RestTemplate restTemplate = new RestTemplate();
		Room room = new Room();
		room.setId(1);room.setRent(7777);room.setRoomtype("Q");
		ResponseEntity<Room> response=restTemplate.exchange(RESTENDPOINT+url,HttpMethod.PUT,new HttpEntity<>(room),
                Room.class,Long.toString(room.getId()));
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void updateFalseRoomType() throws JSONException {
		String url = "update";
		RestTemplate restTemplate = new RestTemplate();
		Room room = new Room();
		room.setId(1);room.setRent(7777);room.setRoomtype("A");
		ResponseEntity<Room> response=restTemplate.exchange(RESTENDPOINT+url,HttpMethod.PUT,new HttpEntity<>(room),
                Room.class,Long.toString(room.getId()));
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void updateFalseRate() throws JSONException {
		String url = "update";
		RestTemplate restTemplate = new RestTemplate();
		Room room = new Room();
		room.setId(1);room.setRent(77777);room.setRoomtype("A");
		ResponseEntity<Room> response=restTemplate.exchange(RESTENDPOINT+url,HttpMethod.PUT,new HttpEntity<>(room),
                Room.class,Long.toString(room.getId()));
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}
	
	@Test
	public void delete() throws JSONException {
		String url = "delete";
		Room room = new Room();
		room.setId(3);
		ResponseEntity<Customer> response=restTemplate.exchange(RESTENDPOINT+url+"/3",HttpMethod.DELETE,new HttpEntity<>(room),
                Customer.class,Long.toString(room.getId()));
		HttpStatus status=response.getStatusCode();
		assertTrue(status.value()==201?true:false);
	}

}
