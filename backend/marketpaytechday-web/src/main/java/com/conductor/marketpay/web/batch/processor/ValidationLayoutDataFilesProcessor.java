package com.conductor.marketpay.web.batch.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.util.StringUtils;

import com.conductor.marketpay.base.model.FileValidation;
import com.conductor.marketpay.base.model.ItemLayoutFile;
import com.conductor.marketpay.base.model.ItemValidationLayoutFile;
import com.conductor.marketpay.base.model.LayoutFile;
import com.conductor.marketpay.base.model.dto.StatusValidationEnum;
import com.conductor.marketpay.base.model.dto.ValidationFileLayoutDataDTO;

public class ValidationLayoutDataFilesProcessor implements ItemProcessor<FileValidation, ValidationFileLayoutDataDTO>{

	@Override
	public ValidationFileLayoutDataDTO process(FileValidation item) throws Exception {
		ValidationFileLayoutDataDTO result = new ValidationFileLayoutDataDTO();
		result.setIdValidationLayout(item.getId());
		
		try {
			File file = new File(item.getPath());
			if(file.exists()) {
				
				List<String> lines = Files.readAllLines(Paths.get(file.getPath()));
				
				layoutValidation(item.getLayout(), lines);
				
				
			} else {
				throw new FileNotFoundException( "O arquivo no caminho ".concat(item.getPath()).concat(" não foi localizado.") );
			}
		} catch (FileNotFoundException e) {
			result.setStatus(StatusValidationEnum.ERROR);
			result.setMessage(e.getMessage());
		}
		
		return result;
	}

	private void layoutValidation(LayoutFile layout, List<String> lines) {

		
		int aux = 0;
		for(int i = 0; i < lines.size(); i ++) {
			
			aux = i + 1;
			
			if(i == 0) {
				// Se o indice for 0, significa que é o header
				headerValidation(layout.getHeader(), lines.get(i));

			} else if(aux == lines.size()) {
				// Se o auxiliar for igual a ultima linha, significa que é o trailer
//				trailerValidation(layout.getDetail(), lines.get(i));
			
			} else {
				// Se não, significa que é o detail
//				detailValidation(layout.getTrailer(), lines.get(i));
			}
			
			
		}
		
	}

	private void trailerValidation(ItemLayoutFile detail, String string) {
		// TODO Auto-generated method stub
		
	}

	private void headerValidation(ItemLayoutFile header, String line) {

		for( ItemValidationLayoutFile validation : header.getValidations() ) {
			
			String validate = line.substring( validation.getStart(), validation.getEnd() );
			
//			switch (validation.getType()) {
//			case VAZIO:
//				validate.matches("\\s");
//				break;
//
//			case NUMERICO:
//				validate.matches("\\s");
//				break;
//
//			case VAZIO:
//				validate.matches("\\s");
//				break;
//
//			default:
//				break;
//			}
			
		}
		
	}

}
