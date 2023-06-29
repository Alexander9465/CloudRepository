package com.cloudcustomer.service;

import java.util.List;



import com.cloudcustomer.entity.Customer;
import com.cloudcustomer.entity.RegionTbl;

public interface CustomerService {

		public List<Customer> findCustomerAll();
	    public List<Customer> findCustomersByRegion(RegionTbl region);

	    public Customer createCustomer(Customer customer);
	    public Customer updateCustomer(Customer customer);
	    public void deleteCustomer(Customer customer);
	    public  Customer getCustomer(int id);

}
