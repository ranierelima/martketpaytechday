package com.conductor.marketpay.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.CompleteModel;

@Entity
@Table(name = "sftp_configuration")
public class SFTPConfiguration extends CompleteModel {

	private static final long serialVersionUID = -4960029823228302660L;

	private String fileName;
	private long maxSize;
	private String path;

	@Column(name = "filename", length = 400)
	public String getFileName() {
		return fileName;
	}

	@Column(name = "maxsize")
	public long getMaxSize() {
		return maxSize;
	}

	@Column(name = "path", length = 500)
	public String getPath() {
		return path;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
