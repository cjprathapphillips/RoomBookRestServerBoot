package com.roombooker.controller;

import java.util.List;

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
import com.roombooker.model.Customer;
import com.roombooker.service.CustomerService;
import com.roombooker.service.RoomBookStautusResponce;

@RestController
@RequestMapping("customer")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	/** REST EndPoint to get all the Customer */
	
	/**
	 * @return
	 */
	@GetMapping(path = "/all", produces = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Customer> getAll() {
		List<Customer> customers = customerService.getAll();
		return customers;
	}

	/** REST EndPoint to get a single Customer with the Customer id */
	
	/**
	 * @param id
	 * @return
	 * @throws BadRequestException
	 */
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Customer getById(@PathVariable("id") final Integer id) throws BadRequestException {
		Customer customers = customerService.getById(id);
		if(customers!=null)
			return customers;
		else
			throw new BadRequestException();
	}

	/** REST EndPint to add a new Customer */
	
	/**
	 * @param customer
	 * @return
	 */
	@PostMapping(path ="/add", produces = { MediaType.APPLICATION_JSON_VALUE} , consumes = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<HttpStatus> save(@RequestBody Customer customer){
		Customer newcustomer=null;
		try {
			newcustomer=customerService.save(customer);
		} catch (Exception e) {
			return RoomBookStautusResponce.returnRoomBookerStatus(null);
		}
		return RoomBookStautusResponce.returnRoomBookerStatus(newcustomer);
	}
	
	/** REST EndPoint to Update an Existing Customer with the customer Id */
	
	/**
	 * @param customer
	 * @return
	 */
	@PutMapping(path ="/update", consumes = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<HttpStatus> update(@RequestBody Customer customer) {
		Customer updatedcustomer=customerService.update(customer);
		return RoomBookStautusResponce.returnRoomBookerStatus(updatedcustomer);
	}
	
	
	/** REST EndPoint to delete an existing Customer with the customer Id */
	
	/**
	 * @param id
	 * @return
	 * @throws BadRequestException
	 */
	@DeleteMapping(path = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Customer delete(@PathVariable("id") final long id) throws BadRequestException {
		Customer customer = customerService.delete(id);
		if(customer!=null)
			return customer;
		else
			throw new BadRequestException();
	}

}
