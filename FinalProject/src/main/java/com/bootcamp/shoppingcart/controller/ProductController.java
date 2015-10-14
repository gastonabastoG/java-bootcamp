package com.bootcamp.shoppingcart.controller;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

import com.bootcamp.shoppingcart.entity.Product;
import com.bootcamp.shoppingcart.service.ProductRepository;

@RestController
@RequestMapping(value = "/api/admin/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public Iterable<Product> allProduct(){
		return productRepository.findAll();
	}
	
	//Get Product By Id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable long id) {
		return productRepository.findOne(id);
	}
	
	//Create a Product
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Product product, HttpServletRequest request, HttpServletResponse response){
		productRepository.save(product);
		Long newId = product.getId();
		String requestUrl = request.getRequestURL().toString();
		URI uri = new UriTemplate("{requestUrl}{id}").expand(requestUrl, newId);
		response.setHeader("Location",uri.toASCIIString());
	}
	
	//Modify a Product
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody Product product){
		Product rx = productRepository.findOne(id);
		if(rx == null){
			throw new IllegalStateException("No product with id: " + id);
		}
			product.setId(rx.getId());
			productRepository.save(product);
	}
	
	
	//Delete a Product By Id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id){
		productRepository.delete(id);
	}
}
