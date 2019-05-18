package com.conductor.marketpay.base.model;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.conductor.marketpay.base.model.generic.BasicModel;

@Entity
@Table(name = "data_validation")
public class DataValidation extends BasicModel {

	private static final long serialVersionUID = 9027009431487303275L;

	private EmitterDatabase emitterDatabase;

	@Access(AccessType.FIELD)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = ItemDataValidation.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "data_validation_id")
	private List<ItemDataValidation> validations;

	@Column(name = "id_emitter_database")
	public EmitterDatabase getEmitterDatabase() {
		return emitterDatabase;
	}

	public List<ItemDataValidation> getValidations() {
		return validations;
	}

	public void setEmitterDatabase(EmitterDatabase emitterDatabase) {
		this.emitterDatabase = emitterDatabase;
	}

	public void setValidations(List<ItemDataValidation> validations) {
		this.validations = validations;
	}

}
