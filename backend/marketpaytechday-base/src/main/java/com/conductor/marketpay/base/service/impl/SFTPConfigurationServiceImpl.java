package com.conductor.marketpay.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conductor.marketpay.base.model.SFTPConfiguration;
import com.conductor.marketpay.base.repository.SFTPConfigurationRepository;
import com.conductor.marketpay.base.service.SFTPConfigurationService;

@Service
public class SFTPConfigurationServiceImpl extends BasicServiceImpl<SFTPConfiguration> implements SFTPConfigurationService{

	@Autowired
	public SFTPConfigurationServiceImpl(SFTPConfigurationRepository repository) {
		super(repository);
	}

}
