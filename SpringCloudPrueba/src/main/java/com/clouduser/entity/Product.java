package com.clouduser.entity;

import java.util.Date;

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
import lombok.ToString;

@Entity
@Table(name = "tbl_products")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int product_id;
	private String name;
	private String description;
	private int stock;
	private double price;
	private String status;
	@Column(name="creatAt")
	private Date createAt;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_fid")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//con la notacion de arriba lo que hacemos es ignorar el los proxys de hibernate que hace que te cree
	//unos datos no reales para interpretar la entidad category 
	private Category category;
	
	
	
	
	

}
