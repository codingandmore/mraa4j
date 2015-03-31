package com.github.mraa4j;

import com.github.mraa4j.enums.ResultT;

public class MraaException extends Exception {

	private static final long serialVersionUID = 1L;
	private ResultT mraaError;

	public MraaException(ResultT error) {
		super();
		mraaError = error;
	}

	public MraaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MraaException(String message, Throwable cause) {
		super(message, cause);
	}

	public MraaException(String message) {
		super(message);
	}

	public MraaException(Throwable cause) {
		super(cause);
	}

	public String getMessage() {
		return "Error when calling Mraa Library: " + mraaError;
	}

	public static void checkResult(ResultT result) throws MraaException {
		if (result != ResultT.MRAA_SUCCESS) {
			throw new MraaException(result);
		}
	}


}
