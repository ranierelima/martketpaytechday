package com.conductor.marketpay.base.exception;

public class EntityNotFoundException extends BaseException {
	
	private static final String MESSAGE_DEFAULT = "A entidade pesquisada não foi encontrada";
	private static final long serialVersionUID = 3390994026739406338L;

	public EntityNotFoundException() {
		super(EntityNotFoundException.MESSAGE_DEFAULT);
	}
	
	public EntityNotFoundException(String error) {
		super(
				(error == null || error.isEmpty()) ? 
				EntityNotFoundException.MESSAGE_DEFAULT
				: error
			);
	}
}
