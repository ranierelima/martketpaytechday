package com.conductor.marketpay.base.model.generic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasicDTO {

	private Long id;

	private final Map<String, List<String>> errors = new HashMap<>();
	
	public BasicDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, List<String>> getErrors() {
		return errors;
	}
	
	
}
