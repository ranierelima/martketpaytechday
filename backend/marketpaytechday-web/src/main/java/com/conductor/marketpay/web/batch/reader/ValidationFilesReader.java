package com.conductor.marketpay.web.batch.reader;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.conductor.marketpay.base.model.SFTPFileValidation;
import com.conductor.marketpay.base.service.SFTPFileValidationService;

public class ValidationFilesReader implements ItemReader<SFTPFileValidation>{

	@Autowired
	private SFTPFileValidationService service;
	
	private static final Queue<SFTPFileValidation> QUEUE = new LinkedList<>();
	private static int pageCount = 0;
	
	@BeforeStep
	public void init() {
		Page<SFTPFileValidation> list = service.list(pageCount, "id", "asc");
		
		if( list.getContent().isEmpty() ) {
			pageCount = 0;
			list = service.list(pageCount, "id", "asc");
		}

		for ( SFTPFileValidation user : list.getContent()) {
			QUEUE.add(user);
		}
		
		pageCount++;
	}
	
	@Override
	public SFTPFileValidation read() throws Exception {
		
		if(QUEUE.isEmpty()) {
			init();
		}
		
		return QUEUE.isEmpty() ? null : QUEUE.remove();
	}

}
