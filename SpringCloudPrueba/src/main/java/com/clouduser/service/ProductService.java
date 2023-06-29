package com.clouduser.service;

import java.util.List;

import com.clouduser.entity.Category;
import com.clouduser.entity.Product;

public interface ProductService {

	public List<Product> listAllProduct();
	public Product getProduct(int id);
	
	public Product createProduct(Product product);
	
	public List<Product> findByProduct(Category category);
	

	public Product updateProduct(Product product);

	public void deleteProduct(int id);

	

	public Product updateStock(int id, int quantity);
	

}
