package com.cybage.exception;

public class BadRequestException extends RuntimeException {

	public static final int ID_NOT_FOUND = 1;
	private static final long serialVersionUID = 1L;

	final int errCode;

	public BadRequestException(int errCode, String msg) {
		super(msg);
		this.errCode = errCode;
	}
}
