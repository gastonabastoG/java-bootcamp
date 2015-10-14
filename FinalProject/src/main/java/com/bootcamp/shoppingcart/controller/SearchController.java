package com.bootcamp.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.shoppingcart.entity.Category;
import com.bootcamp.shoppingcart.entity.Product;
import com.bootcamp.shoppingcart.exceptions.CategoryDoesNotExistException;
import com.bootcamp.shoppingcart.exceptions.ProductDoesNotExistException;
import com.bootcamp.shoppingcart.service.CategoryRepository;
import com.bootcamp.shoppingcart.service.ProductRepository;

@RestController
@RequestMapping(value = "/api/search")
public class SearchController {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findAllByProductNameAndCategory(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String category)
			throws CategoryDoesNotExistException, ProductDoesNotExistException {
		Category category2 = categoryRepository.findByNameLike(category);
		System.out.println(category);
		System.out.println(category2);
		if (category == null) {
			throw new CategoryDoesNotExistException((long) 1);

		} else {
			long id = category2.getId();
			List<Product> product = productRepository.findByNameAndCategoryId(
					name, id);
			if (product == null) {
				throw new ProductDoesNotExistException((long) 1);
			}
			return product;
		}
	}
}
