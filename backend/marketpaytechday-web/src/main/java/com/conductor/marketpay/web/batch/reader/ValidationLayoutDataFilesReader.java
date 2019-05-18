package com.conductor.marketpay.web.batch.reader;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.conductor.marketpay.base.model.FileValidation;
import com.conductor.marketpay.base.service.FileValidationService;

public class ValidationLayoutDataFilesReader implements ItemReader<FileValidation> {

	@Autowired
	private FileValidationService service;
	
	private static final Queue<FileValidation> QUEUE = new LinkedList<>();
	private static int pageCount = 0;
	
	@BeforeStep
	public void init() {
		Page<FileValidation> list = service.list(pageCount, "id", "asc");
		
		if( list.getContent().isEmpty() ) {
			pageCount = 0;
			list = service.list(pageCount, "id", "asc");
		}

		for ( FileValidation user : list.getContent()) {
			QUEUE.add(user);
		}
		
		pageCount++;
	}
	
	@Override
	public FileValidation read() throws Exception {
		
		if(QUEUE.isEmpty()) {
			init();
		}
		
		return QUEUE.isEmpty() ? null : QUEUE.remove();
	}

}
