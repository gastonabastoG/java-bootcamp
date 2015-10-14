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

import com.bootcamp.shoppingcart.entity.Category;
import com.bootcamp.shoppingcart.service.CategoryRepository;

@RestController
@RequestMapping(value = "/api/admin/category")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	
	//Get Category By Id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Category findById(@PathVariable long id) {
		return categoryRepository.findOne(id);
	}
	
	//Create a Category
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Category category, HttpServletRequest request, HttpServletResponse response){
		categoryRepository.save(category);
		Long newId = category.getId();
		String requestUrl = request.getRequestURL().toString();
		URI uri = new UriTemplate("{requestUrl}{id}").expand(requestUrl, newId);
		response.setHeader("Location",uri.toASCIIString());
	}
	
	//Modify a Category
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody Category category){
		Category rx = categoryRepository.findOne(id);
		if(rx == null){
			throw new IllegalStateException("No category with id: " + id);
		}
			category.setId(rx.getId());
			categoryRepository.save(category);
	}
	
	//Delete a Category By Id
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id){
		categoryRepository.delete(id);
	}
	
}
