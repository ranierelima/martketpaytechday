package com.conductor.marketpay.base.model.generic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BasicDateModel extends BasicModel{

	private static final long serialVersionUID = 1L;

	private Date createdAt;
	private Date updatedAt;

	@Column(name = "created_at", insertable = true, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedAt() {
		return createdAt;
	}

	@Column(name = "updated_at", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
