package com.clouduser.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clouduser.entity.Category;
import com.clouduser.entity.Product;
import com.clouduser.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	ProductService service;
	
	
	/**
	 * 	Con este metodo vamos a devoler una lista que puede tener o no tener ningun valor con el required = false
	 * @param categoryId
	 * @return
	 */
	@GetMapping("/list")//?categoryId=1 para buscarlo por un parametro 
	public ResponseEntity<List<Product>> lista(@RequestParam(name="categoryId",required = false)Integer categoryId){
		 List<Product> products = new ArrayList<>();
		
		if(null ==categoryId) {
			products = service.listAllProduct();
			if(products.isEmpty()) {
				return ResponseEntity.noContent().build();//indicamos que la solicitud fue exitosa per no hay nada que mostrar				
			}
		}else {
			products = 	service.findByProduct(Category.builder().category_id(categoryId).build());
			if(products.isEmpty()) {
				return ResponseEntity.noContent().build();//indicamos que la solicitud fue exitosa per no hay nada que mostrar				
			}
				
		}
		
		return ResponseEntity.ok(products);
	}
	
//	@GetMapping("/listCa/{id}")
//	public List<Product> lisatCategoria(@PathVariable("id") int id){
//		return service.findByProduct(Category.builder().category_id(id).build());
//	}
	
	@PostMapping("/crear")
	public void createProducto(@RequestBody Product product) {
		if(product==null) {
			
		}
		service.createProduct(product);
		
	}
	
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<Product> getProducto(@PathVariable("id")int id) {
		Product producto = service.getProduct(id);
		if(producto==null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(producto);
	}
	
	@PutMapping("/modif/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id")int id,@RequestBody Product product){
		product.setProduct_id(id);
		Product p = service.updateProduct(product);
		if(p==null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(p);
		
		
	}
	@GetMapping("/delete/{id}")
	public void deleteProduct(@PathVariable("id")int id) {
		service.deleteProduct(id);
	}
	
	
	@PutMapping("/stock/id/{quantity}")
	public ResponseEntity<Product> actualizar(@PathVariable("id") int id,@PathVariable Integer quantity){
		
		Product p = service.getProduct(id);
		if(p==null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(service.updateStock(id, id));
	}
}
