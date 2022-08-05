package com.example.exception;

import javax.persistence.EntityNotFoundException;
public class MemberNotFoundException extends EntityNotFoundException {
	public MemberNotFoundException() {}
	public MemberNotFoundException(String message) {
		super(message);
	}
}
