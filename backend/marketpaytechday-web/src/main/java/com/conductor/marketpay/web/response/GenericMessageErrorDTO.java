package com.conductor.marketpay.web.response;

public class GenericMessageErrorDTO extends GenericMessage{

	private Integer number;
	private String cause;
	private Object errors;

	public GenericMessageErrorDTO() {
		super(ResponseMessage.MSG_GENERIC_ERROR);
	}
	
	public GenericMessageErrorDTO(Integer number, String message) {
		super(message);
		this.number = number;
	}
	
	public GenericMessageErrorDTO(String message, String cause) {
		super(message);
		this.cause = cause;
	}
	
	public GenericMessageErrorDTO(String message, Throwable cause) {
		super(message);
		this.cause = cause.getMessage();
	}
	
	public GenericMessageErrorDTO(Integer number, String message, String cause) {
		this(number, message);
		this.cause = cause;
	}
	
	public GenericMessageErrorDTO(Integer number, String message, Throwable cause) {
		this(number, message);
		this.cause = cause.getMessage();
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Object getErrors() {
		return errors;
	}

	public void setErrors(Object errors) {
		this.errors = errors;
	}
	
}
