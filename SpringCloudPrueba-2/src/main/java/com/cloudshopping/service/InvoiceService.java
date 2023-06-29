package com.cloudshopping.service;

import java.util.List;

import com.cloudshopping.entity.Invoice;

public interface InvoiceService {

	public List<Invoice> findInvoiceAll();

    public Invoice createInvoice(Invoice invoice);
    public Invoice updateInvoice(Invoice invoice);
    public void deleteInvoice(Invoice invoice);

    public Invoice getInvoice(Long id);
}
