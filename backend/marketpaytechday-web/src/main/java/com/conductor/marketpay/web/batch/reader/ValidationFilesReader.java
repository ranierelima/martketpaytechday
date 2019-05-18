package com.conductor.marketpay.web.batch.reader;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.conductor.marketpay.base.model.SFTPConfiguration;
import com.conductor.marketpay.base.service.SFTPConfigurationService;

public class ValidationFilesReader implements ItemReader<SFTPConfiguration>{

	@Autowired
	private SFTPConfigurationService service;
	
	private static final Queue<SFTPConfiguration> QUEUE = new LinkedList<>();
	private static int pageCount = 0;
	
	@AfterJob
	public void init() {
		Page<SFTPConfiguration> list = service.list(pageCount, "id", "asc");
		
		if( list.getContent().isEmpty() ) {
			pageCount = 0;
			list = service.list(pageCount, "id", "asc");
		}

		for ( SFTPConfiguration user : list.getContent()) {
			QUEUE.add(user);
		}
		
		pageCount++;
	}
	
	@Override
	public SFTPConfiguration read() throws Exception {
		
		if(QUEUE.isEmpty()) {
			init();
		}
		
		return QUEUE.remove();
	}

}
