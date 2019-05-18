package com.conductor.marketpay.web.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.conductor.marketpay.base.model.SFTPFileValidation;
import com.conductor.marketpay.base.model.dto.ValidationFileSFTPDTO;

public class ValidationFilesProcessor implements ItemProcessor<SFTPFileValidation, ValidationFileSFTPDTO>{

	@Override
	public ValidationFileSFTPDTO process(SFTPFileValidation item) throws Exception {
		// TODO Validar se arquivo existe, se não existir tratar neste metodo. Sempre deve ser retornado a mensagem para o usuário.
		return null;
	}

}
