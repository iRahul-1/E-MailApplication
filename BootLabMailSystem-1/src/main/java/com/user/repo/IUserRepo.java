package com.user.repo;

import org.springframework.data.repository.CrudRepository;

import com.user.model.User;

public interface IUserRepo extends CrudRepository<User,Long>{

}
