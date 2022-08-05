package com.example.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book with given id does not exists")
public class BookNotFoundException extends EntityNotFoundException {
public BookNotFoundException() {
	
}
public BookNotFoundException(String message) {
super(message);
}

}