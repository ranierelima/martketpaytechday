package com.conductor.marketpay.base.model;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.BasicModel;

@Entity
@Table(name = "item_layout_file")
public class ItemLayoutFile extends BasicModel {

	private static final long serialVersionUID = 2323370326957966405L;

	private List<ItemValidationLayoutFile> validations;


	@Access(AccessType.FIELD)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = ItemValidationLayoutFile.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_item_layout_file")
	public List<ItemValidationLayoutFile> getValidations() {
		return validations;
	}

	public void setValidations(List<ItemValidationLayoutFile> validations) {
		this.validations = validations;
	}

}
