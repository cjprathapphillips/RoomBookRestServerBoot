package com.roombooker.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roombooker.Dao.CustomerDao;
import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Booking;
import com.roombooker.model.Customer;


/**
 * @author Prathap Phillips
 *
 */
/** Customer Dao Implementation */
@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao{

	
	@PersistenceContext	
	private EntityManager entityManager;	
	
	/** Get All Customer */
	public List<Customer> getAll() {
		 return (List<Customer>)entityManager.createNamedQuery("@getAllCustomer").getResultList(); 
	}

	/** Get a Custoemr with ID */
	public Customer getById(long id) {
		 return entityManager.find(Customer.class, id);
	}
	
	/** Save a new Customer */
	public Customer save(Customer customer) throws BadRequestException {
		try {
			entityManager.persist(customer);
		} catch (Exception exception) {
			exception.printStackTrace();
			if (exception instanceof ConstraintViolationException) {
		         throw new BadRequestException();
		      }
		}
		return customer;
	}
	
	
	/** Update an Existing Customer with ID */
	public Customer update(Customer customer) {
		Customer customerOld = entityManager.find(Customer.class, customer.getId());
		if(customerOld==null)
			return customerOld;
		customerOld.copyCustomer(customer);
		return customerOld;
	}

	/** Delete a customer with ID */
	@Override
	public Customer delete(long id) {
		Customer customerdb = entityManager.find(Customer.class, id);
		if(customerdb==null)
			return customerdb;
		entityManager.remove(customerdb);
		return customerdb;
	}

}
