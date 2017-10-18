package com.sample.demo.exception;

import org.springframework.dao.DataAccessException;

public class EmptyResultException extends DataAccessException {

	public EmptyResultException(String msg) {
		super(msg);
	}
}
