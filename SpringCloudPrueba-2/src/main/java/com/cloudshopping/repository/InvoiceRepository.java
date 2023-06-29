package com.cloudshopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudshopping.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
	// public List<Invoice> findByCustomerId(int customerId );
	@Query("SELECT i FROM Invoice i WHERE i.numberInvoice =: numberInvoice")
	 public Invoice findByNumberInvoice(String numberInvoice);
}
