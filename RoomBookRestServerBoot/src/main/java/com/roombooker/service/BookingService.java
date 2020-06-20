package com.roombooker.service;

import java.util.List;

import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Booking;


/**
 * @author Prathap Phillips
 *
 */

/** Service Interface to Implement Booking related Business Logic */
public interface BookingService {
	/**
	 * @return
	 */
	public List<Booking> getAll();
	/**
	 * @param id
	 * @return
	 */
	public Booking getById(long id);
	/**
	 * @param booking
	 * @return
	 * @throws BadRequestException
	 */
	public Booking save(Booking booking) throws BadRequestException;
	/**
	 * @param booking
	 * @return
	 */
	public Booking update(Booking booking);
	/**
	 * @param id
	 * @return
	 */
	public Booking delete(long id);

}
