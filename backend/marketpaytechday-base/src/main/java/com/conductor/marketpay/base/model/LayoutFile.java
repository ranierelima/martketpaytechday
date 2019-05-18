package com.conductor.marketpay.base.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.BasicModel;

@Entity
@Table(name = "layout_file")
public class LayoutFile extends BasicModel {

	private static final long serialVersionUID = -1029560554061183253L;

	private ItemLayoutFile header;
	private ItemLayoutFile detail;
	private ItemLayoutFile trailer;

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="id_header", nullable=false, insertable=true, updatable=true)
	public ItemLayoutFile getHeader() {
		return header;
	}

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="id_detail", nullable=false, insertable=true, updatable=true)
	public ItemLayoutFile getDetail() {
		return detail;
	}

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="id_trailer", nullable=false, insertable=true, updatable=true)
	public ItemLayoutFile getTrailer() {
		return trailer;
	}

	public void setHeader(ItemLayoutFile header) {
		this.header = header;
	}

	public void setDetail(ItemLayoutFile detail) {
		this.detail = detail;
	}

	public void setTrailer(ItemLayoutFile trailer) {
		this.trailer = trailer;
	}

}
