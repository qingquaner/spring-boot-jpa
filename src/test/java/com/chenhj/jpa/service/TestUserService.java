package com.chenhj.jpa.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chenhj.jpa.SimpleApplication;
import com.chenhj.jpa.domain.dbo.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SimpleApplication.class)// 指定spring-boot的启动类  
public class TestUserService {
	
	@Autowired
	private UserService userService;
	
	/*@Test
	public void test1(){
		List<User> users = userService.findAll();
		System.out.println(users);
	}*/
	@Test
	public void test2(){
		User user = new User();
		/*user.setId(5L);*/
		user.setUserName("chhjk");
		user.setNickName("陈杰");
		user.setPassWord("15611");
		user.setUserSex("MN");
		userService.saveUser(user);
	}
}
