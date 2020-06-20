package com.roombooker.service;

import java.util.List;

import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Booking;
import com.roombooker.model.Customer;

/**
 * @author Prathap Phillips
 *
 */
/** Service Interface to Implement Customer related Business Logic */
public interface CustomerService {
	
	/**
	 * @return
	 */
	public List<Customer> getAll();
	/**
	 * @param id
	 * @return
	 */
	public Customer getById(long id);
	/**
	 * @param booking
	 * @return
	 * @throws BadRequestException
	 */
	public Customer save(Customer booking) throws BadRequestException;
	/**
	 * @param booking
	 * @return
	 */
	public Customer update(Customer booking);
	/**
	 * @param id
	 * @return
	 */
	public Customer delete(long id);

}
