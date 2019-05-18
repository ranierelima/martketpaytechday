package com.conductor.marketpay.base.model.dto;

public class ValidationFileSFTPDTO {

	private long fileSize;
	private StatusValidationEnum status;
	private String message;
	private Long idValidation;

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public StatusValidationEnum getStatus() {
		return status;
	}

	public void setStatus(StatusValidationEnum status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getIdValidation() {
		return idValidation;
	}

	public void setIdValidation(Long idValidation) {
		this.idValidation = idValidation;
	}

}
