package com.cloudshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudshopping.entity.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer>{

}
