package com.cloudshopping.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudshopping.entity.Invoice;
import com.cloudshopping.service.InvoiceService;


@RestController
public class InvoiceController {
	 @Autowired
	    InvoiceService invoiceService;

	    // -------------------Retrieve All Invoices--------------------------------------------
	    @GetMapping("/list")
	    public ResponseEntity<List<Invoice>> listAllInvoices() {
	        List<Invoice> invoices = invoiceService.findInvoiceAll();
	        if (invoices.isEmpty()) {
	            return  ResponseEntity.noContent().build();
	        }
	        return  ResponseEntity.ok(invoices);
	    }

	    // -------------------Retrieve Single Invoice------------------------------------------
	    @GetMapping(value = "list/{id}")
	    public ResponseEntity<Invoice> getInvoice(@PathVariable("id") long id) {
	        
	        Invoice invoice  = invoiceService.getInvoice(id);
	        
	        return  ResponseEntity.ok(invoice);
	    }

	    // -------------------Create a Invoice-------------------------------------------
	    @PostMapping("create")
	    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
	        
	        
	        Invoice invoiceDB = invoiceService.createInvoice (invoice);

	        return  ResponseEntity.ok(invoiceDB);
	    }

	    // ------------------- Update a Invoice ------------------------------------------------
	    @PutMapping("upd/{id}")
	    public ResponseEntity<?> updateInvoice(@PathVariable("id") long id, @RequestBody Invoice invoice) {
	        
	        invoice.setId(id);
	        Invoice currentInvoice=invoiceService.updateInvoice(invoice);

	        if (currentInvoice == null) {
	           
	            return  ResponseEntity.notFound().build();
	        }
	        return  ResponseEntity.ok(currentInvoice);
	    }

	    // ------------------- Delete a Invoice-----------------------------------------
	    @DeleteMapping("borrar/{id}")
	    public void deleteInvoice(@PathVariable("id") long id) {
	        

	        Invoice invoice = invoiceService.getInvoice(id);
	        
	     
	        invoiceService.deleteInvoice(invoice);
	    }

//	    private String formatMessage( BindingResult result){
//	        List<Map<String,String>> errors = result.getFieldErrors().stream()
//	                .map(err ->{
//	                    Map<String,String> error =  new HashMap<>();
//	                    error.put(err.getField(), err.getDefaultMessage());
//	                    return error;
//
//	                }).collect(Collectors.toList());
//	        ErrorMessage errorMessage = ErrorMessage.builder()
//	                .code("01")
//	                .messages(errors).build();
//	        ObjectMapper mapper = new ObjectMapper();
//	        String jsonString="";
//	        try {
//	            jsonString = mapper.writeValueAsString(errorMessage);
//	        } catch (JsonProcessingException e) {
//	            e.printStackTrace();
//	        }
//	        return jsonString;
//	    }

}
