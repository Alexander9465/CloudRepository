package com.cloudcustomer.controller;



import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cloudcustomer.entity.Customer;
import com.cloudcustomer.entity.*;
import com.cloudcustomer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// -------------------Retrieve All
	// Customers--------------------------------------------

	@GetMapping("/list")
	public ResponseEntity<List<Customer>> listAllCustomers(
			@RequestParam(name = "regionId", required = false) Integer regionId) {
		List<Customer> customers = new ArrayList<>();
		if (null == regionId) {
			customers = customerService.findCustomerAll();
			if (customers.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		} else {
		
//			Region Region = new Region();
//			Region.setId(regionId);
			var region = RegionTbl.builder().id(regionId).build();
			customers = customerService.findCustomersByRegion(region);
			if (null == customers) {
				
				return ResponseEntity.notFound().build();
			}
		}

		return ResponseEntity.ok(customers);
	}

	// -------------------Retrieve Single
	// Customer------------------------------------------

	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
		
		Customer customer = customerService.getCustomer(id);
		if (null == customer) {
			
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer);
	}

	// -------------------Create a
	// Customer-------------------------------------------

	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer( @RequestBody Customer customer) {
		

		Customer customerDB = customerService.createCustomer(customer);

		return ResponseEntity.ok(customerDB);
	}

	// ------------------- Update a Customer
	// ------------------------------------------------

	@PutMapping("/act/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		

		Customer currentCustomer = customerService.getCustomer(id);

		if (null == currentCustomer) {
			
			return ResponseEntity.notFound().build();
		}
		customer.setId(id);
		currentCustomer = customerService.updateCustomer(customer);
		return ResponseEntity.ok(currentCustomer);
	}

	// ------------------- Delete a
	// Customer-----------------------------------------

	@DeleteMapping("/borrar/{id}")
	public void deleteCustomer(@PathVariable("id") int id) {
		

		Customer customer = customerService.getCustomer(id);
		if (null == customer) {
			
			 ResponseEntity.notFound().build();
		}
		 customerService.deleteCustomer(customer);
		ResponseEntity.ok(customer);
	}
}
