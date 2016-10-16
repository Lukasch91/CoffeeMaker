package com.lukas.exceptions;

public class IsNotCleanException extends Exception {

	public IsNotCleanException(String message, Throwable cause) {
		super(message, cause);
	}

	public IsNotCleanException(String message) {
		super(message);
	}
}
