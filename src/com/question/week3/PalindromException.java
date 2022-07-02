package com.question.week3;

public class PalindromException extends Exception {
	private static final long serialVersionUID = 1L;

	public PalindromException(String message) {
		super(message + " Lütfen tekrar deneyin.");
	}
}
