package com.conductor.marketpay.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.BasicModel;

@Entity
@Table(name = "sftp_file_validation")
public class SFTPFileValidation extends BasicModel{
	
	private static final long serialVersionUID = 640096913974576594L;
	
	private String fileName;
	private long maxSize;
	private String path;
	private SFTPConfiguration sftpConfiguration;
	
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
	
	@Column(name = "stfp_configuration")
	public SFTPConfiguration getSftpConfiguration() {
		return sftpConfiguration;
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

	public void setSftpConfiguration(SFTPConfiguration sftpConfiguration) {
		this.sftpConfiguration = sftpConfiguration;
	}
	

}
