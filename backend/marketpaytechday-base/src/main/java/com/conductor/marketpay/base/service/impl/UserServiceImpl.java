package com.conductor.marketpay.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conductor.marketpay.base.model.User;
import com.conductor.marketpay.base.repository.UserRepository;
import com.conductor.marketpay.base.service.UserService;

@Service
public class UserServiceImpl extends BasicServiceImpl<User> implements UserService{

	@Autowired
	public UserServiceImpl(UserRepository repository) {
		super(repository);
	}

	public boolean emailAlreadyRegistered(String email) {
		return ((UserRepository)repository).emailAlreadyRegistered(email);
	}

}
