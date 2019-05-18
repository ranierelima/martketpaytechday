package com.conductor.marketpay.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.BasicModel;

@Entity
@Table(name = "emitter_database")
public class EmitterDatabase extends BasicModel {

	private static final long serialVersionUID = 8106137522804535219L;
	
	private String host;
	private int port;
	private String username;
	private String password;
	private String nameDatabase;

	@Column( name = "host" )
	public String getHost() {
		return host;
	}

	@Column( name = "port" )
	public int getPort() {
		return port;
	}

	@Column( name = "username" )
	public String getUsername() {
		return username;
	}

	@Column( name = "password" )
	public String getPassword() {
		return password;
	}

	@Column( name = "name_database" )
	public String getNameDatabase() {
		return nameDatabase;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNameDatabase(String nameDatabase) {
		this.nameDatabase = nameDatabase;
	}
	
}
