package com.bootcamp.shoppingcart.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.shoppingcart.entity.Category;
import com.bootcamp.shoppingcart.entity.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	public Category findByNameLike(String name);
	public List<Category> findByNameAndProducts(String name, Product product);
}
