package com.conductor.marketpay.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.CompleteModel;

@Entity
@Table(name = "sftp_configuration")
public class SFTPConfiguration extends CompleteModel {

	private static final long serialVersionUID = -4960029823228302660L;

	private String host;
	private Integer port;
	private String username;
	private String password;

	@Column(name = "host")
	public String getHost() {
		return host;
	}

	@Column(name = "port")
	public Integer getPort() {
		return port;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
