package com.conductor.marketpay.base.service;

import com.conductor.marketpay.base.model.User;

public interface UserService extends BasicService<User>{

	boolean emailAlreadyRegistered(String email);

}
