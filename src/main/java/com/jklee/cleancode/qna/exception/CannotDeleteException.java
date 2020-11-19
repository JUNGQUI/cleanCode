package com.jklee.cleancode.qna.exception;

public class CannotDeleteException extends Exception {
	private static final long serialVersionUID = 1L;

	public CannotDeleteException(String message) {
		super(message);
	}
}