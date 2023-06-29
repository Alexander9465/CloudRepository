package com.clouduser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clouduser.entity.Category;
import com.clouduser.entity.Product;
import com.clouduser.repository.CategoryRepository;

@Service
public class ProductoServiceImp implements ProductService{

	@Autowired
	CategoryRepository repo;
	
	@Override
	public List<Product> listAllProduct() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product getProduct(int id) {
		
		return repo.findById(id).orElseThrow(null);
	}

	@Override
	public Product createProduct(Product product) {
		
		return repo.save(product);
	}

	@Override
	public List<Product> findByProduct(Category category) {
		// TODO Auto-generated method stub
		return repo.findByCategory(category);
	}

	@Override
	public Product updateProduct(Product product) {
		Product p = getProduct(product.getProduct_id());
		if(p==null) {
			return null;
		}
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setCategory(product.getCategory());
		p.setPrice(product.getPrice());
		return repo.save(p);
	}

	@Override
	public void deleteProduct(int id) {
		Product p = repo.findById(id).orElse(null);
		repo.delete(p);
	}

	

	@Override
	public Product updateStock(int id, int quantity) {
		Product p = getProduct(id);
		if(quantity<0) {
			Integer stk= p.getStock()-quantity;
			p.setStock(stk);
			
		}{
			Integer stk = p.getStock()+quantity;
			p.setStock(stk);
		}
	
		return repo.save(p);
	}

	
	
}
