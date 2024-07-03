package com.user.service;

import com.user.model.User;

public interface IUserService {
    public void saveUser(User user,String cEmail,String cPass) throws Exception;
	public void findUser(String username,String Password);
}
