package com.roombooker.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roombooker.Dao.CustomerDao;
import com.roombooker.exception.BadRequestException;
import com.roombooker.model.Customer;
import com.roombooker.service.CustomerService;

/**
 * @author Prathap Phillips
 *
 */
/** Service Implementation for Customer */
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	/** Get all the Cusotmer */
	@Override
	public List<Customer> getAll() {
		return customerDao.getAll();
	}
	/** Get a customer with id */
	@Override
	public Customer getById(long id) {
		return customerDao.getById(id);
	}

	/** Save a new Customer */
	@Override
	public Customer save(Customer customer) throws BadRequestException {
		return customerDao.save(customer);
	}

	/** Update an existing Customer with id */
	@Override
	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}

	/** Delete an Existing Customer with id */
	@Override
	public Customer delete(long id) {
		return customerDao.delete(id);
	}
}
