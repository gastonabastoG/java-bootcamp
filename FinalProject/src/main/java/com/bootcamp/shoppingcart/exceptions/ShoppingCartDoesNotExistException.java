package com.bootcamp.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShoppingCartDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public ShoppingCartDoesNotExistException(Long id) {
		super(String.format("Shopping Cart with id '%d' does not exist", id));
	}
}