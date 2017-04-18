package com.chenhj.jpa.repository;

import org.springframework.data.repository.Repository;

import com.chenhj.jpa.domain.dbo.User;

//实现Repository有两种方式
//@RepositoryDefinition(domainClass=User.class,idClass=Long.class)
public interface UserJpaRepository2 extends Repository<User, Long>{
	User getByUserName(String userName);
	
	
}
