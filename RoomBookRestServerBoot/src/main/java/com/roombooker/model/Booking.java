package com.roombooker.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Prathap Phillips
 *
 */

/** All Db operation for a Booking with be done with this Entity */
@Entity
@Table(name = "roombook", schema = "roombook")
@NamedQueries({ @NamedQuery(name = "@getAllBooking", query = "From Booking") })
public class Booking {
	/* Booking id */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	/* Reservation start date */
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startdate;
	/* Reservation end date */
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enddate;
	/* Customer reference for the reservation */
	@ManyToOne
    @JoinColumn(name = "custid")
    private Customer customers;
	/* Room reference */
	@ManyToOne
    @JoinColumn(name = "roomid")
    private Room rooms;
	
	public Customer getCustomers() {
		return customers;
	}
	public void setCustomers(Customer customers) {
		this.customers = customers;
	}
	public Room getRooms() {
		return rooms;
	}
	public void setRooms(Room rooms) {
		this.rooms = rooms;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	public void copyBooking(Booking booking) {
		this.customers=booking.getCustomers();
		this.rooms=booking.getRooms();
		this.startdate=booking.getStartdate();
		this.enddate=booking.getEnddate();
	}
	
}
