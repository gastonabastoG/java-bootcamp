package com.bootcamp.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductDoesNotExistException(Long id) {
		super(String.format("Product id '%d' does not exist", id));
	}
}
