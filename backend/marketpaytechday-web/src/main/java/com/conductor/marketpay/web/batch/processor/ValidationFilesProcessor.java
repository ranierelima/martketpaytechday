package com.conductor.marketpay.web.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.conductor.marketpay.base.model.SFTPConfiguration;
import com.conductor.marketpay.base.model.dto.ValidationFileSFTPDTO;

public class ValidationFilesProcessor implements ItemProcessor<SFTPConfiguration, ValidationFileSFTPDTO>{

	@Override
	public ValidationFileSFTPDTO process(SFTPConfiguration item) throws Exception {
		// TODO Validar se arquivo existe, se não existir tratar neste metodo. Sempre deve ser retornado a mensagem para o usuário.
		return null;
	}

}
