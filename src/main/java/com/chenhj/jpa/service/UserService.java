package com.chenhj.jpa.service;

import java.util.List;

import com.chenhj.jpa.domain.dbo.User;

public interface UserService {
	public List<User> findAll();

    public void saveUser(User user);
   
    public User findOne(long id);

    public void delete(long id);

}
