package com.roombooker.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Booking;
import com.roombooker.service.BookingService;
import com.roombooker.service.RoomBookStautusResponce;

/**
 * @author Prathap Phillips
 *
 */
@RestController
@RequestMapping("booking")
public class BookingRestController {

	@Autowired
	private BookingService bookingService;

	/* REST EndPoint to get all the Bookings */
	/**
	 * @return
	 */
	@GetMapping(path = "/all", produces = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Booking> getAll() {
		List<Booking> bookings = bookingService.getAll();
		return bookings;
	}

	/** REST EndPoint to get a single booking with the booking id */
	/**
	 * @param id
	 * @return
	 * @throws BadRequestException
	 */
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Booking getById(@PathVariable("id") final long id) throws BadRequestException {
		Booking booking = bookingService.getById(id);
		if(booking!=null)
			return booking;
		else
			throw new BadRequestException();
	}

	/** REST EndPint to add a new Booking */
	
	/**
	 * @param booking
	 * @return
	 */
	@PostMapping(path ="/add", consumes = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<HttpStatus> save(@RequestBody Booking booking) {
		Booking newBooking;
		try {
			newBooking = bookingService.save(booking);
		} catch (Exception e) {
			return RoomBookStautusResponce.returnRoomBookerStatus(null);
		}
		return RoomBookStautusResponce.returnRoomBookerStatus(newBooking);
	}
	
	/** REST EndPoint to Update an Existing Booking with the booking Id */
	
	/**
	 * @param booking
	 * @return
	 */
	@PutMapping(path ="/update", consumes = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<HttpStatus> update(@RequestBody Booking booking) {
		Booking updatedBooking=bookingService.update(booking);
		return RoomBookStautusResponce.returnRoomBookerStatus(updatedBooking);
	}
	
	/** REST EndPoint to delete an existing Booking with the booking Id */
	
	/**
	 * @param id
	 * @return 
	 * @throws BadRequestException
	 */
	@DeleteMapping(path = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Booking delete(@PathVariable("id") final long id) throws BadRequestException {
		Booking booking = bookingService.delete(id);
		if(booking!=null)
			return booking;
		else
			throw new BadRequestException();
	}

	

}
