package com.conductor.marketpay.base.model.dto;

public class ValidationFileLayoutDataDTO {

	private long fileSize;
	private StatusValidationEnum status;
	private String message;
	private Long idValidationLayout;
	private Long timeValidation;

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

	public Long getIdValidationLayout() {
		return idValidationLayout;
	}

	public void setIdValidationLayout(Long idValidationLayout) {
		this.idValidationLayout = idValidationLayout;
	}

	public Long getTimeValidation() {
		return timeValidation;
	}

	public void setTimeValidation(Long timeValidation) {
		this.timeValidation = timeValidation;
	}

}
