package com.cloudshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudshopping.entity.Invoice;
import com.cloudshopping.repository.InvoiceRepository;

@Service
public class InvoiceServiceImp implements InvoiceService{

	@Autowired
	InvoiceRepository repo;
	
	
	@Override
	public List<Invoice> findInvoiceAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Invoice createInvoice(Invoice invoice) {
		Invoice invoiceDB = repo.findByNumberInvoice ( invoice.getNumberInvoice () );
        if (invoiceDB !=null){
            return  invoiceDB;
        }
        invoice.setState("CREATED");
        invoiceDB = repo.save(invoice);
//        invoiceDB.getItems().forEach( invoiceItem -> {
//            productClient.updateStockProduct( invoiceItem.getProductId(), invoiceItem.getQuantity() * -1);
//        });

        return invoiceDB;
	}

	@Override
	public Invoice updateInvoice(Invoice invoice) {
		 Invoice invoiceDB = getInvoice(invoice.getId());
	        if (invoiceDB == null){
	            return  null;
	        }
	       // invoiceDB.setCustomerId(invoice.getCustomerId());
	        invoiceDB.setDescription(invoice.getDescription());
	        invoiceDB.setNumberInvoice(invoice.getNumberInvoice());
	        invoiceDB.getItems().clear();
	        invoiceDB.setItems(invoice.getItems());
	        return repo.save(invoiceDB);
	}

	@Override
	public void deleteInvoice(Invoice invoice) {
		Invoice invoiceDB = getInvoice(invoice.getId());
        
        invoiceDB.setState("DELETED");
         repo.delete(invoiceDB);
	}

	@Override
	public Invoice getInvoice(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
