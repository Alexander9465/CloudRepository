package com.clouduser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clouduser.entity.Category;
import com.clouduser.entity.Product;

public interface CategoryRepository extends JpaRepository<Product, Integer> {
	
	@Query("SELECT p FROM Product p WHERE p.category = :category")
	public List<Product> findByCategory(Category category);

}
