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
public class RoomCreation {

	private static String RESTENDPOINT="http://localhost:8080/room/";
	
	@Autowired
	private TestRestTemplate restTemplate;


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
}
