package com.conductor.marketpay.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conductor.marketpay.base.model.SFTPFileValidation;
import com.conductor.marketpay.base.repository.SFTPFileValidationRepository;
import com.conductor.marketpay.base.service.SFTPFileValidationService;

@Service
public class SFTPFileValidationServiceImpl extends BasicServiceImpl<SFTPFileValidation> implements SFTPFileValidationService{

	@Autowired
	public SFTPFileValidationServiceImpl(SFTPFileValidationRepository repository) {
		super(repository);
	}

}
