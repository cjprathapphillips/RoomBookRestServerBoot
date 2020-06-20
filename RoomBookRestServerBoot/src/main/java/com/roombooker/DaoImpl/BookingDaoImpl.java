package com.roombooker.DaoImpl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roombooker.Dao.BookingDao;
import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Booking;



/**
 * @author Prathap Phillips
 *
 */
/** Booking Dao Implementation */
@Transactional
@Repository
public class BookingDaoImpl implements BookingDao{

	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	/** Get all Booking */
	public List<Booking> getAll() {
		 return (List<Booking>)	 entityManager.createNamedQuery("@getAllBooking").getResultList(); 
	}

	/** Get a Booking wit id */
	public Booking getById(long id) {
		return entityManager.find(Booking.class, id);
	}
	
	/** Save a new Booking */
	public Booking save(Booking booking) throws BadRequestException{

		try {
			/* Check if the is already some booking for the date range */
			if(IsbookingNotAvailable(booking.getRooms().getId(), booking.getStartdate(), booking.getEnddate()))
				entityManager.persist(booking);
			else
				throw new BadRequestException();	
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new BadRequestException();
		}
		return booking;
	}
	
	/** Update Booking with ID */
	public Booking update(Booking booking) {
		Booking bookingdb = entityManager.find(Booking.class, booking.getId());
		if(bookingdb==null)
			return bookingdb;
		bookingdb.copyBooking(booking);
		return bookingdb;
	}
	
	/** Delete Booking with Id*/
	public Booking delete(long id) {
		Booking bookingdb = entityManager.find(Booking.class, id);
		if(bookingdb==null)
			return bookingdb;
		entityManager.remove(bookingdb);
		return bookingdb;
	}
	
	/* Check if the there is any booking within the range */
	public boolean IsbookingNotAvailable(long roomId,Date startDate,Date endDate) {
		StringBuffer query =new StringBuffer("From Booking where roomid=").append(roomId)
				.append(" and (startdate between '").append(startDate).append("' and '")
				.append(endDate).append("')")
				.append(" or (enddate between '").append(startDate).append("' and '")
				.append(endDate).append("') ");
		List<Booking> existingBookings=entityManager.createQuery(query.toString()).getResultList(); 
		if(existingBookings!=null && existingBookings.size()>0)
			return false;
		else
			return true;
	}

}
