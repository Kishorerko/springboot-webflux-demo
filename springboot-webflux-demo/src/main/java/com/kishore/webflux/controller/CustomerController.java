package com.kishore.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.webflux.dto.Customer;
import com.kishore.webflux.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@GetMapping("/home")
	public String home(){
		return "home page";
	}
	@GetMapping("/stream")
	public Flux<Customer> getAllCustomerStream(){
		return service.getAllCustomerStream();
	}

}
