package com.conductor.hackathon.base.service;

import com.conductor.hackathon.base.model.User;

public interface UserService extends BasicService<User>{

	boolean emailAlreadyRegistered(String email);

}
