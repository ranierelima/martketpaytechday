package com.conductor.marketpay.base.service.impl;

import org.springframework.stereotype.Service;

import com.conductor.marketpay.base.model.HistoryFileValidationSFTP;
import com.conductor.marketpay.base.repository.HistoryFileValidationSFTPRepository;
import com.conductor.marketpay.base.service.HistoryFileValidationSFTPService;

@Service
public class HistoryFileValidationSFTPServiceImpl extends BasicServiceImpl<HistoryFileValidationSFTP> implements HistoryFileValidationSFTPService{

	public HistoryFileValidationSFTPServiceImpl(HistoryFileValidationSFTPRepository repository) {
		super(repository);
	}

}
