package com.conductor.marketpay.web.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.conductor.marketpay.base.model.dto.ValidationFileSFTPDTO;

public class ValidationFilesWriter implements ItemWriter<ValidationFileSFTPDTO>{

	@Override
	public void write(List<? extends ValidationFileSFTPDTO> items) throws Exception {
		// TODO IMPLEMENTAR HISTORICO DE VALIDAÇÕES
		
	}

}
