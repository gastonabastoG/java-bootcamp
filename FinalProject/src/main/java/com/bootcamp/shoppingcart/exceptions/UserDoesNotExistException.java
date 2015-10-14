package com.bootcamp.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserDoesNotExistException extends Exception{

	private static final long serialVersionUID = 1L;

	public UserDoesNotExistException(Long id) {
        super(String.format("User '%d' does not exist", id));
    }
}
