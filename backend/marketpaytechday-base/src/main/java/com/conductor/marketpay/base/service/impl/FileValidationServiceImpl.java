package com.conductor.marketpay.base.service.impl;

import org.springframework.stereotype.Service;

import com.conductor.marketpay.base.model.FileValidation;
import com.conductor.marketpay.base.repository.FileValidationRepository;
import com.conductor.marketpay.base.service.FileValidationService;

@Service
public class FileValidationServiceImpl extends BasicServiceImpl<FileValidation> implements FileValidationService{

	public FileValidationServiceImpl(FileValidationRepository repository) {
		super(repository);
	}

}
