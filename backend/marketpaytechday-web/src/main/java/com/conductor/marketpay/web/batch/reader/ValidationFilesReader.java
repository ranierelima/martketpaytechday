package com.conductor.marketpay.web.batch.reader;

import org.springframework.batch.item.ItemReader;

import com.conductor.marketpay.base.model.SFTPConfiguration;

public class ValidationFilesReader implements ItemReader<SFTPConfiguration>{

	@Override
	public SFTPConfiguration read() throws Exception {
		return null;
	}

}
