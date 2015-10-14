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
import com.bootcamp.shoppingcart.entity.ProductLine;
import com.bootcamp.shoppingcart.exceptions.ProductDoesNotExistException;
import com.bootcamp.shoppingcart.service.ProductLineRepository;
import com.bootcamp.shoppingcart.service.ProductRepository;
import com.bootcamp.shoppingcart.service.ShoppingCartRepository;

@RestController
@RequestMapping(value = "/api/user/{usrid}/cart/{cartid}")
public class ProductLineController {
	@Autowired
	private ProductLineRepository productLineRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<ProductLine> allProductLine() {
		return productLineRepository.findAll();
	}

	// Get ProductLine By Id
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ProductLine findById(@PathVariable long id) {
		return productLineRepository.findOne(id);
	}

	// Add a product in the cart
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ProductLine productLine,
			HttpServletRequest request, HttpServletResponse response) {
		Product product = productRepository
				.findOne(productLine.getProduct_id());
		productLine.setSubTotal(productLine.getQuantity() * product.getPrice());
		productLineRepository.save(productLine);
		Long newId = productLine.getId();
		String requestUrl = request.getRequestURL().toString();
		URI uri = new UriTemplate("{requestUrl}{id}").expand(requestUrl, newId);
		response.setHeader("Location", uri.toASCIIString());
	}

	// Modify a ProductLine
	// Modify a Shopping Cart
	@RequestMapping(value = "product/{plid}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long plid,
			@RequestBody ProductLine productLine)
			throws ProductDoesNotExistException {
		ProductLine productLine2 = productLineRepository.findOne(plid);
		if (productLine2 == null) {
			throw new ProductDoesNotExistException(plid);
		}
		Product product = productRepository
				.findOne(productLine.getProduct_id());
		productLine.setSubTotal(productLine.getQuantity() * product.getPrice());
		productLineRepository.save(productLine);
	}

	// delete a product from the cart
	@RequestMapping(value = "product/{plid}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long plId)
			throws ProductDoesNotExistException {
		ProductLine productLine = productLineRepository.findOne(plId);
		if (productLine == null) {
			throw new ProductDoesNotExistException(plId);
		}
		productLineRepository.delete(productLine);
	}
	
//	@RequestMapping(value = "product/search", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	public List <Product> findByName(@RequestParam(required = false) String name){
//		List <Product> products = null;
//		products = productRepository.findAll().; 
//		if (productLine == null) {
//			throw new ProductDoesNotExistException(plId);
//		}
//		productLineRepository.delete(productLine);
//	}
}
