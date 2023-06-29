package com.cloudcustomer.entity;




import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="tbl_customers")
@Validated
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcustomer")
    private int id;

    @Column(name = "number_id" , unique = true ,length = 8, nullable = false)
    private String numberID;

   
    @Column(name="first_name", nullable=false)
    private String firstName;

 
    @Column(name="last_name", nullable=false)
    private String lastName;

   
    
    @Column(unique=true, nullable=false)
    private String email;



   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tbl_fid")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private RegionTbl region;

   
}
