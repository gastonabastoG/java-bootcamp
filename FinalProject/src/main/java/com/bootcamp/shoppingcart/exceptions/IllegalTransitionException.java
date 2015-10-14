package com.bootcamp.shoppingcart.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IllegalTransitionException extends Exception {

	private static final long serialVersionUID = 1L;

	public IllegalTransitionException(Long id) {
		super(String.format("It is illegal create a user with an id: '%d' , this id already exist",	id));
	}

	public IllegalTransitionException(Long id1, Long id2) {
		super(String.format("It is illegal Modify a user with an id: '%d' to an id: '%d' , this id already exist",
						id1, id2));
	}
}
