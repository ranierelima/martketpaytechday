package com.conductor.marketpay.base.exception;

public class BaseException extends Exception {
	
	private static final long serialVersionUID = -2107517753446755933L;

    public BaseException() {
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

}
