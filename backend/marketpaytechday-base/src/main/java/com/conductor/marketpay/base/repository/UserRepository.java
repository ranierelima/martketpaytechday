package com.conductor.marketpay.base.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.conductor.marketpay.base.model.User;

@Repository
public interface UserRepository extends BasicRepository<User>{
	
	@Query("SELECT COUNT(u.id) > 0 FROM User u WHERE u.email = :email")
	boolean emailAlreadyRegistered(@Param("email") String email);
	
}
