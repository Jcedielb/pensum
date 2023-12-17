package com.demo.pensum.exceptions;

public final class ErrorMessage {
    public static final String SUBJECT_NOT_FOUND = "The subject with the given id was not found";

	private ErrorMessage() {
		throw new IllegalStateException("Utility class");
	}
}



