package com.cloudshopping.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;	
import lombok.NoArgsConstructor;


@Entity
@Table(name="tbl_invoice")
@Builder
@Data
@AllArgsConstructor

public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="invoice_id")
    private Long id;

    @Column(name = "number_Invoice")
    private String numberInvoice;

    private String description;

//    @Column(name = "customer_id")
//    private Long customerId;

    @Column(name = "creat_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;
    public Invoice(){
        items = new ArrayList<>();
    }
    	

    
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tbl_invoiceid")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private List<InvoiceItem> items;

    private String state;

 

    

   

}
