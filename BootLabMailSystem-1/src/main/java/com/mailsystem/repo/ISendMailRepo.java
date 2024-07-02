package com.mailsystem.repo;

import org.springframework.data.repository.CrudRepository;

import com.mailsystem.model.User;

public interface ISendMailRepo extends CrudRepository<User, Long>{
	
}
