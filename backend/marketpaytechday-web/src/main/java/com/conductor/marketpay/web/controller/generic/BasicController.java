package com.conductor.hackathon.web.controller.generic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.conductor.hackathon.base.exception.EntityNotFoundException;
import com.conductor.hackathon.base.model.generic.BasicModel;
import com.conductor.hackathon.base.service.BasicService;
import com.conductor.hackathon.web.response.GenericMessage;
import com.conductor.hackathon.web.response.GenericMessageErrorDTO;
import com.conductor.hackathon.web.response.GenericMessageSuccessDTO;
import com.conductor.hackathon.web.response.ResponseMessage;

public class BasicController <T extends BasicModel>{
	
	private static final String PATH_ID = "/{id:\\d+}";

	protected BasicService<T> service;
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public BasicController(BasicService<T> service) {
		this.service = service;
	}

	@DeleteMapping(value = "/{id}")
	public GenericMessage delete(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response) {
		GenericMessage result = null;
		try {
			service.delete(id);
			
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			result = new GenericMessageSuccessDTO(ResponseMessage.MSG_DELETE_SUCCESS);
			
		} catch (EntityNotFoundException e) {
			logger.error("Object not found!", e);
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			result = new GenericMessageErrorDTO(ResponseMessage.MSG_DELETE_ERROR, e);
		} catch (Exception e) {
			logger.error("Error!!!! ", e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			result = new GenericMessageErrorDTO(ResponseMessage.MSG_GENERIC_ERROR, e);
		}
		
		return result;
	}

	@GetMapping(value = PATH_ID)
	public T get(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		logger.info("Obtendo dados do id: " + id);
		Optional<T> model = service.get(id);
		if (!model.isPresent()) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		return model.get();
	}

	@GetMapping()
	public Page<T> list(
			@RequestParam(value = "p", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "o", required = false, defaultValue = "id") String orderBy,
			@RequestParam(value = "d", required = false, defaultValue = "ASC") String direction,
			HttpServletRequest request, HttpServletResponse response) {

		return service.list(page, orderBy, direction);
	}

	@PostMapping()
	public GenericMessage save(@Valid @RequestBody T model, BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		GenericMessage result = null;
		
		if (model == null || bindingResult.hasErrors()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			result = new GenericMessageErrorDTO(HttpServletResponse.SC_BAD_REQUEST, ResponseMessage.MSG_POST_ERROR);

			Map<String, List<String>> errors = new HashMap<>();
			
			Iterator<FieldError> fieldErrors = bindingResult.getFieldErrors().iterator();
			
			while(fieldErrors.hasNext()) {
				FieldError next = fieldErrors.next();
				List<String> list = errors.get(next.getField());
				if (list == null) {
					list = new ArrayList<>();
				}
				list.add(next.getDefaultMessage());
				errors.put(next.getField(), list);
			}
			
			Iterator<ObjectError> globalErrors = bindingResult.getGlobalErrors().iterator();
			
			while(globalErrors.hasNext()) {
				ObjectError next = globalErrors.next();
				List<String> list = errors.get(next.getObjectName());
				if (list == null) {
					list = new ArrayList<>();
				}
				list.add(next.getDefaultMessage());
				errors.put(next.getObjectName(), list);
			}
			
			( (GenericMessageErrorDTO) result ).setErrors(errors);
			
		} else {

			try {
				result = new GenericMessageSuccessDTO(ResponseMessage.MSG_POST_SUCCESS, service.save(model));
			
			} catch (DataIntegrityViolationException di) {
				logger.warn("Trying to save an already existing data", di);
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				result = new GenericMessageErrorDTO(HttpServletResponse.SC_CONFLICT, ResponseMessage.MSG_POST_ERROR);
			
			} catch (Exception e) {
				logger.error("Error saving the data: ", e);
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				result = new GenericMessageErrorDTO(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ResponseMessage.MSG_POST_ERROR);
			}
			
		}
		
		return result;
	}

	@PutMapping(value = PATH_ID)
	public GenericMessage update(@PathVariable("id") Long id, @Valid @RequestBody T model, BindingResult bindingResult,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		model.setId(id);
		return save(model, bindingResult, request, response);
	}
}
