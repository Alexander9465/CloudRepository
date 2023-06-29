package com.cloudshopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_voice_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="voice_item_id")
    private int id;
    
    @Column(name="quantity")
    private Double quantity;
    @Column(name="price")
    private Double  price;

//    @Column(name = "product_id")
//    private Long productId;


    
    private Double subtotal;


    public Double getSubTotal(){
        if (this.price >0  && this.quantity >0 ){
            return this.quantity * this.price;
        }else {
            return (double) 0;
        }
    }
//    public InvoiceItem(){
//        this.quantity=(double) 0;
//        this.price=(double) 0;
//
//    }
}
