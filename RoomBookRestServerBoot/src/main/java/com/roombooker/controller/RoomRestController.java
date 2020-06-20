package com.roombooker.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Room;
import com.roombooker.service.RoomBookStautusResponce;
import com.roombooker.service.RoomService;

@RestController
@RequestMapping("room")
public class RoomRestController {

	@Autowired
	private RoomService roomService;

	/* REST EndPoint to get all the Rooms */
	
	/**
	 * @return
	 */
	@GetMapping(path = "/all", produces = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Room> getAll() {
		List<Room> rooms = roomService.getAll();
		return rooms;
	}

	/* REST EndPoint to get a single Room with the Room id */
	/**
	 * @param id
	 * @param response
	 * @return
	 * @throws BadRequestException
	 */
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Room getById(@PathVariable("id") final Integer id,HttpServletResponse response) throws BadRequestException {
		Room room = roomService.getById(id);
		if(room!=null)
			return room;
		else
			throw new BadRequestException();
	}

	/* REST EndPint to add a new Room */
	/**
	 * @param room
	 * @return
	 */
	@PostMapping(path ="/add", consumes = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<HttpStatus> save(@RequestBody Room room) {
		Room newroom=null;
		try {
			newroom = roomService.save(room);
		} catch (Exception e) {
			return RoomBookStautusResponce.returnRoomBookerStatus(null);
		}
		return RoomBookStautusResponce.returnRoomBookerStatus(newroom);
	}
	
	/* REST EndPoint to Update an Existing Room with the Room Id */
	/**
	 * @param room
	 * @return
	 */
	@PutMapping(path ="/update", produces = { MediaType.APPLICATION_JSON_VALUE} , consumes = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<HttpStatus> update(@RequestBody Room room) {
		Room newroom=roomService.update(room);
		return RoomBookStautusResponce.returnRoomBookerStatus(newroom);
	}

}
