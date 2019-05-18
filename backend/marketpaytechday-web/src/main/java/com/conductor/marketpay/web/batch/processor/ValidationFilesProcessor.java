package com.conductor.marketpay.web.batch.processor;

import java.io.FileNotFoundException;

import org.springframework.batch.item.ItemProcessor;

import com.conductor.marketpay.base.model.HistoryFileValidationSFTP;
import com.conductor.marketpay.base.model.SFTPFileValidation;
import com.conductor.marketpay.base.model.dto.StatusValidationEnum;
import com.conductor.marketpay.base.utils.BiggerFileException;
import com.conductor.marketpay.base.utils.UtilsFTP;

public class ValidationFilesProcessor implements ItemProcessor<SFTPFileValidation, HistoryFileValidationSFTP> {

	@Override
	public HistoryFileValidationSFTP process(SFTPFileValidation item) throws Exception {
		HistoryFileValidationSFTP result = new HistoryFileValidationSFTP();
		result.setIdFileValidation(item.getId());
		
		try {
			UtilsFTP.isFilePresent(item.getSftpConfiguration(), item);
			result.setStatus(StatusValidationEnum.SUCCESS.toString());
			result.setMessage("Arquivo encontrado!\nTamanho: " + result.getFileSize());
		} catch (FileNotFoundException e ) {
			result.setStatus(StatusValidationEnum.ERROR.toString());
			result.setMessage("O arquivo não foi encontrado: " + e.getMessage());
		} catch (BiggerFileException e) {
			result.setStatus(StatusValidationEnum.WARNING.toString());
			result.setMessage("Arquivo encontrado porém, com tamanho de " + result.getFileSize());
		}
		
		return result;
	}

}
