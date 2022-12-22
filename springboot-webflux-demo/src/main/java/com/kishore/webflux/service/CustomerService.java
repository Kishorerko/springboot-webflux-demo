package com.kishore.webflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishore.webflux.dao.CustomerDao;
import com.kishore.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao dao;
	
	public List<Customer> getAllCustomers(){	 
		return dao.getAllCustomers();
	}
	
	public Flux<Customer> getAllCustomerStream(){		 
		return dao.getAllCustomerStream();
	}
}
