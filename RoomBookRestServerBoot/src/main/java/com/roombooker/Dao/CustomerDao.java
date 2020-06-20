package com.roombooker.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Booking;
import com.roombooker.model.Customer;



/**
 * @author Prathap Phillips
 *
 */

/** Customer Dao Interface for CRUDE Operation */
public interface CustomerDao {

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
	 * @param customer
	 * @return
	 * @throws BadRequestException
	 */
	public Customer save(Customer customer)throws BadRequestException;
	/**
	 * @param customer
	 * @return
	 */
	public Customer update(Customer customer);
	/**
	 * @param id
	 * @return
	 */
	public Customer delete(long id);

}
