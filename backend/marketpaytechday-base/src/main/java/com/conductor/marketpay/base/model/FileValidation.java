package com.conductor.marketpay.base.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.CompleteModel;

@Entity
@Table(name = "file_validation")
public class FileValidation extends CompleteModel{

	private static final long serialVersionUID = 8726857335083777341L;
	
	private String description;
	private String name;
	private String rename;
	private LayoutFile layout;
	private DataValidation dataValidation;
	private SFTPConfiguration sftpConfiguration;

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "rename")
	public String getRename() {
		return rename;
	}

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="id_layout", nullable=false, insertable=true, updatable=true)
	public LayoutFile getLayout() {
		return layout;
	}

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="id_data_validation", nullable=false, insertable=true, updatable=true)
	public DataValidation getDataValidation() {
		return dataValidation;
	}

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="id_sftp_configuration", nullable=false, insertable=true, updatable=true)
	public SFTPConfiguration getSftpConfiguration() {
		return sftpConfiguration;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public void setLayout(LayoutFile layout) {
		this.layout = layout;
	}

	public void setDataValidation(DataValidation dataValidation) {
		this.dataValidation = dataValidation;
	}

	public void setSftpConfiguration(SFTPConfiguration sftpConfiguration) {
		this.sftpConfiguration = sftpConfiguration;
	}

}
