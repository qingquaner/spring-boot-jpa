package com.chenhj.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chenhj.jpa.domain.dbo.User;

public interface UserJpaRepository extends JpaRepository<User, Long>{
	
}
