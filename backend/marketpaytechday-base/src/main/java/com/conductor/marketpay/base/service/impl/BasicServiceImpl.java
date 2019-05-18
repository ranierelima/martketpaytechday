package com.conductor.marketpay.base.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.lang.Nullable;

import com.conductor.marketpay.base.exception.EntityNotFoundException;
import com.conductor.marketpay.base.model.generic.BasicDateModel;
import com.conductor.marketpay.base.model.generic.BasicModel;
import com.conductor.marketpay.base.model.generic.CompleteModel;
import com.conductor.marketpay.base.repository.BasicRepository;
import com.conductor.marketpay.base.service.BasicService;

public class BasicServiceImpl<T extends BasicModel> implements BasicService<T>{

	protected static final String DEFAULT_SORT = "id";

	protected static final int PAGE_SIZE = 15;

	protected BasicRepository<T> repository;

	public BasicServiceImpl(BasicRepository<T> repository) {
		this.repository = repository;
	}
	
	@Override
	public void delete(Long id) throws EntityNotFoundException {
		Optional<T> object = get(id);

		if (!object.isPresent()) {
			throw new EntityNotFoundException("Não foi possível localizar a entidade do id " + id);
		} // if
		
		T t = object.get();
		
		if(isToDelete(t)) {
			this.repository.deleteById(id);		
		} else {
			((CompleteModel) t).setDeleted(Boolean.TRUE);
			((CompleteModel) t).setDeletedAt(new Date());
			this.repository.save(t);
		} // if-else
		
	} // delete()

	private boolean isToDelete(T t) {
		return !(t instanceof CompleteModel);
	} // isToDelete()

	@Override
	public Optional<T> get(Long id) {
		return this.repository.findById(id);
	} // get()

	@Override
	public Page<T> list(Integer page, @Nullable String orderBy, @Nullable String direction) {
		Sort sort = (orderBy != null && !orderBy.isEmpty()) ? getSort(DEFAULT_SORT) : getSort(orderBy);

		sort = (direction != null && direction.equalsIgnoreCase("Desc")) ? sort.descending() : sort.ascending() ;
		
		PageRequest request = PageRequest.of(Optional.ofNullable(page).orElse(0), PAGE_SIZE, sort);
		return this.repository.findAll(request);
	} // list()

	protected Sort getSort(String orderBy) {
		return Sort.by( Order.by(orderBy) );
	} // getDefaultSort()

	@Override
	public T save(T entity) {
		
		if(entity != null) {
		
			if(entity instanceof BasicDateModel) {
				if(entity.getId() == null || ((BasicDateModel) entity).getCreatedAt() == null) ((BasicDateModel) entity).setCreatedAt(new Date());
				else ((BasicDateModel) entity).setUpdatedAt(new Date());
			} // if
			
			entity = this.repository.save(entity);
		} // if
		
		return entity;
	} // save()

}
