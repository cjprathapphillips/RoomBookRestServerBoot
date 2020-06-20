package com.roombooker.service;

import java.util.List;

import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Customer;
import com.roombooker.model.Room;

/**
 * @author Prathap Phillips
 *
 */
/** Service Interface to Implement Room related Business Logic */
public interface RoomService {
	
	/**
	 * @return
	 */
	public List<Room> getAll();
	/**
	 * @param id
	 * @return
	 */
	public Room getById(long id);
	/**
	 * @param booking
	 * @return
	 * @throws BadRequestException
	 */
	public Room save(Room booking) throws BadRequestException;
	/**
	 * @param booking
	 * @return
	 */
	public Room update(Room booking);

}
