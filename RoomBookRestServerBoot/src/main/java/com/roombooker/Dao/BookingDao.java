package com.roombooker.Dao;

import java.sql.Date;
import java.util.List;

import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Booking;



/**
 * @author Prathap Phillips
 *
 */

/** Booking Dao Interface for CRUDE Operation */
public interface BookingDao {
	
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
	/**
	 * @param roomId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public boolean IsbookingNotAvailable(long roomId,Date startDate,Date endDate);

}
