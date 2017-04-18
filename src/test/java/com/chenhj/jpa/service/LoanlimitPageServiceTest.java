package com.chenhj.jpa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;

import com.chenhj.jpa.SimpleApplication;
import com.chenhj.jpa.domain.dbo.Loanlimits;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SimpleApplication.class)// 指定spring-boot的启动类  
public class LoanlimitPageServiceTest {
	@Autowired
	private LoanlimitPageService loanlimitPage;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	public void testGetLoanLimitList(){
		Page<Loanlimits> loanLimitList = loanlimitPage.getLoanLimitList(2, 1000, Direction.ASC);
		
	/*	System.out.println("==================="+loanLimitList.getNumberOfElements());
		System.out.println("==================="+loanLimitList.getNumber());
		System.out.println("==================="+loanLimitList.getSize());
		System.out.println("==================="+loanLimitList.getTotalElements());
		System.out.println("==================="+loanLimitList.getSort());
		System.out.println("==================="+loanLimitList.getTotalElements()/loanLimitList.getSize());*/
		long totalElements = loanLimitList.getTotalElements();
		int numberOfElements = loanLimitList.getNumberOfElements();
		int pageNum = (int)totalElements%numberOfElements == 0 ? 0 :1;
		int pageNumbers = (int) (totalElements/numberOfElements)+pageNum;
		logger.info("+++++++++++++++++"+pageNumbers);
		
	}
}
