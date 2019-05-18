package com.conductor.marketpay.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.BasicDateModel;

@Entity
@Table(name = "history_file_validation_sftp")
public class HistoryFileValidationSFTP extends BasicDateModel {

	private static final long serialVersionUID = -2333143971142612135L;

	private Long idFileValidation;
	private String status;
	private String message;
	private int fileSize;

	@Column(name = "id_file_validation")
	public Long getIdFileValidation() {
		return idFileValidation;
	}

	@Column(name = "message", length = 500)
	public String getMessage() {
		return message;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	@Column(name = "filesize")
	public int getFileSize() {
		return fileSize;
	}

	public void setIdFileValidation(Long idFileValidation) {
		this.idFileValidation = idFileValidation;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

}
