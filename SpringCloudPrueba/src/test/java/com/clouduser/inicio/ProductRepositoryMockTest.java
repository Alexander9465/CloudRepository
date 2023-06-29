package com.clouduser.inicio;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.clouduser.entity.Category;
import com.clouduser.entity.Product;
import com.clouduser.repository.CategoryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryMockTest {

	@Autowired
	private CategoryRepository repo;
	
	@Test	
	public void whenFindByCategory_thenReturnListProduct() {
		Product product01 = Product.builder()
							.name("computer")
							.category(Category.builder().category_id(1).build())
							.description("")
							.stock(10)
							.status("create")
							.createAt(new Date())
							.build();
		
		
		
		
		Assertions.assertThat(repo.save(product01)).isEqualTo(true);
		
		
							
 	}
}
