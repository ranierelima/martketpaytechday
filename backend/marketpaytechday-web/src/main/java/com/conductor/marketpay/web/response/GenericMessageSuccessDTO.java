package com.conductor.marketpay.web.response;

public class GenericMessageSuccessDTO extends GenericMessage{
	
	private Object data;

	public GenericMessageSuccessDTO() {
		super(ResponseMessage.MSG_GENERIC_SUCCESS);
	}
	
	public GenericMessageSuccessDTO(String message) {
		super(message);
	}
	
	public GenericMessageSuccessDTO(String message, Object data) {
		super(message);
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
