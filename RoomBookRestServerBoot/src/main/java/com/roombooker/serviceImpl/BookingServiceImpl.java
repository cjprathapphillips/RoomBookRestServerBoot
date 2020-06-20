package com.roombooker.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roombooker.Dao.BookingDao;
import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Booking;
import com.roombooker.service.BookingService;

/**
 * @author Prathap Phillips
 *
 */
/** Service Implementation for Booking */
@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDao bookingDao;
	
	/** Get all Booking */
	@Override
	public List<Booking> getAll() {
		return bookingDao.getAll();
	}

	/** Get an existing Book with ID */
	@Override
	public Booking getById(long id) {
		return bookingDao.getById(id);
	}

	/** Save a new Booking */
	@Override
	public Booking save(Booking booking) throws BadRequestException {
		return bookingDao.save(booking);
	}

	/** Update an Existing Book with an ID */
	@Override
	public Booking update(Booking booking) {
		return bookingDao.update(booking);
	}

	/** Delete an existing Booking with id */
	@Override
	public Booking delete(long id) {
		return bookingDao.delete(id);
	}
	
	
	
	

}
