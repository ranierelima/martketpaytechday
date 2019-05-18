package com.conductor.hackathon.base.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.lang.Nullable;

import com.conductor.hackathon.base.exception.EntityNotFoundException;
import com.conductor.hackathon.base.model.generic.BasicModel;

public interface BasicService <T extends BasicModel>{
	
	void delete(Long id) throws EntityNotFoundException;
	Optional<T> get(Long id);
	Page<T> list(Integer page, @Nullable String orderBy, @Nullable String direction);
	T save(T entity);

}