package com.conductor.marketpay.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.conductor.marketpay.base.model.generic.BasicDateModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="users")
public class User extends BasicDateModel{
	
	public User() {
	}
	
	public User(String name, String email) {
		this();
		this.name = name;
		this.email = email;
	}
	
	private static final long serialVersionUID = -9121771663443778756L;
	
	private String name;
	
	private String email;
	
	private String password;

	private boolean active;
	
    @Column(name="name", length=255)
	public String getName() {
		return name;
	}

	@Column(name="email", length=255)
	@Size(min = 10, max = 255)
	@NotNull
	public String getEmail() {
		return email;
	}

	@JsonIgnore
	@Column(name="password", length=255)
	public String getPassword() {
		return password;
	}

	@Column(name = "active", columnDefinition = "boolean default true")
	public boolean isActive() {
		return active;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
