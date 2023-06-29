package com.cloudcustomer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudcustomer.entity.Customer;
import com.cloudcustomer.entity.RegionTbl;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("SELECT p FROM Customer p WHERE p.numberID = :numberID")
	 public Customer findByNumberID(String numberID);
	@Query("SELECT l FROM Customer l WHERE l.lastName =:lastName")
     public List<Customer> findByLastName(String lastName);
	@Query("SELECT l FROM Customer l WHERE l.region =:region")
     public List<Customer> findByRegion(RegionTbl region);
}
