package com.ssafy.service;

public class DuplicateNameException extends Exception {
	public DuplicateNameException() {
		this("Duplicate");
	}
	public DuplicateNameException(String message) {
		super(message);
	}
}
