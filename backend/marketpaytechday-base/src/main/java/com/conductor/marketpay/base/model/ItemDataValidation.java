package com.conductor.marketpay.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.BasicModel;

@Entity
@Table(name = "item_data_validation")
public class ItemDataValidation extends BasicModel {

	private static final long serialVersionUID = 3804816791047382970L;

	private TypeItemDataValidation type;
	private String value;
	private String table;
	private String column;
	private String condition;

	@Column( name = "type" )
	@Enumerated(EnumType.STRING)
	public TypeItemDataValidation getType() {
		return type;
	}

	@Column( name = "value" )
	public String getValue() {
		return value;
	}

	@Column( name = "table_data" )
	public String getTable() {
		return table;
	}

	@Column( name = "column_data" )
	public String getColumn() {
		return column;
	}

	@Column( name = "condition" )
	public String getCondition() {
		return condition;
	}

	public void setType(TypeItemDataValidation type) {
		this.type = type;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
