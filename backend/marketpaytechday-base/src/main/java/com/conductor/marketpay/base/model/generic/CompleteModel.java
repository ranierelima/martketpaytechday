package com.conductor.marketpay.base.model.generic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class CompleteModel extends BasicDateModel{

	private static final long serialVersionUID = 1L;
	
	private boolean deleted;
	private Date deletedAt;
	
	@Column(name = "deleted", columnDefinition = "boolean default false")
	public boolean isDeleted() {
		return deleted;
	}
	
	@Column(name = "deleted_at", insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public Date getDeletedAt() {
		return deletedAt;
	}
	
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

}
