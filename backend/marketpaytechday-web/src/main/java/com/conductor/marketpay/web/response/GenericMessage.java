package com.conductor.marketpay.web.response;

public abstract class GenericMessage {
	
	private String message;
	
	public GenericMessage(String message){
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
