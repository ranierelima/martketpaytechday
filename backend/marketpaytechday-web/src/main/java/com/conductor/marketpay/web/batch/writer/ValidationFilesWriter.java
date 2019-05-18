package com.conductor.marketpay.web.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.conductor.marketpay.base.model.HistoryFileValidationSFTP;
import com.conductor.marketpay.base.service.HistoryFileValidationSFTPService;

public class ValidationFilesWriter implements ItemWriter<HistoryFileValidationSFTP>{

	@Autowired
	HistoryFileValidationSFTPService service;
	
	@Override
	public void write(List<? extends HistoryFileValidationSFTP> items) throws Exception {
		
		if (items != null && !items.isEmpty()) {
			
			for(HistoryFileValidationSFTP item : items) {
				service.save(item);
				
			}
			
		}
		
		
	}

}
