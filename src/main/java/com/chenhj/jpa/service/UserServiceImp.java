package com.chenhj.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chenhj.jpa.domain.dbo.User;
import com.chenhj.jpa.repository.UserJpaRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Override
	public List<User> findAll() {
		return userJpaRepository.findAll();
	}

	@Override
	public void saveUser(User user) {
		userJpaRepository.save(user);

	}

	@Override
	public User findOne(long id) {
		return userJpaRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		userJpaRepository.delete(id);
	}


}
