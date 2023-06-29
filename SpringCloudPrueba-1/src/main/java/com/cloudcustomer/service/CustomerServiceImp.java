package com.cloudcustomer.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudcustomer.entity.Customer;
import com.cloudcustomer.entity.RegionTbl;
import com.cloudcustomer.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	CustomerRepository repo;
	
	@Override
	public List<Customer> findCustomerAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Customer> findCustomersByRegion(RegionTbl region) {
		
		return repo.findByRegion(region);
	}

	@Override
	public Customer createCustomer(Customer customer) {
		
		
		return repo.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		 	Customer customerDB = getCustomer(customer.getId());
	        if (customerDB == null){
	            return  null;
	        }
	        customerDB.setFirstName(customer.getFirstName());
	        customerDB.setLastName(customer.getLastName());
	        customerDB.setEmail(customer.getEmail());
	        

	        return  repo.save(customerDB);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		Customer customerDB = getCustomer(customer.getId());
         repo.save(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		 return  repo.findById(id).orElse(null);
	}

}
