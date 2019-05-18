package com.conductor.marketpay.base.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.conductor.marketpay.base.model.generic.BasicModel;

@NoRepositoryBean
public interface BasicRepository<T extends BasicModel> extends PagingAndSortingRepository<T, Long> {
	
	
}

