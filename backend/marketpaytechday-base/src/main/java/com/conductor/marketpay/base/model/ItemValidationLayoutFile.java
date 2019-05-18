package com.conductor.marketpay.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.BasicModel;

@Entity
@Table( name = "item_validation_layout_file" )
public class ItemValidationLayoutFile extends BasicModel{

	private static final long serialVersionUID = -3585307435103954377L;
	
	private TypeItemLayout type;
	private int startItem;
	private int endItem;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	public TypeItemLayout getType() {
		return type;
	}

	@Column(name = "start_item")
	public int getStart() {
		return startItem;
	}

	@Column(name = "end_item")
	public int getEnd() {
		return endItem;
	}

	public void setType(TypeItemLayout type) {
		this.type = type;
	}

	public void setStart(int startItem) {
		this.startItem = startItem;
	}

	public void setEnd(int endItem) {
		this.endItem = endItem;
	}
}
