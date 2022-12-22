package com.kishore.webflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.kishore.webflux.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDao {
	
	private static void sleepExecution(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Customer> getAllCustomers(){
		return IntStream.rangeClosed(1, 10)
				.peek(CustomerDao::sleepExecution)
				.peek(i-> System.out.println("processing count:"+i))
				.mapToObj(i-> new Customer(i, "customer"+i))
				.collect(Collectors.toList());		
		}
	
	public Flux<Customer> getAllCustomerStream(){		
		return Flux.range(1, 10)
		.delayElements(Duration.ofSeconds(1))
		.doOnNext(i-> System.out.println("processing count:"+i))
		.map(i-> new Customer(i, "customer+i"));			
		}

}
