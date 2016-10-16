package com.lukas.exceptions;

public class TurnOffException extends Exception {

	public TurnOffException(String message, Throwable cause) {
		super(message, cause);
	}

	public TurnOffException(String message) {
		super(message);
	}
}
