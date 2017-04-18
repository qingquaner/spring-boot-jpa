package com.chenhj.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.chenhj.jpa.domain.dbo.Loanlimits;
import com.chenhj.jpa.enums.ResultEnum;
import com.chenhj.jpa.exception.PagingException;
import com.chenhj.jpa.repository.LoanlimitPagingAndSortingRepository;

@Service
public class LoanlimitPageService {
	
	@Autowired
	private LoanlimitPagingAndSortingRepository loanlimitPagingAndSortingRepository;
	
	public Page<Loanlimits> getLoanLimitList(Integer pageNumber,Integer pageSize,Direction direction){
		PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize,direction, "id");
		Page<Loanlimits> loanLimitList = loanlimitPagingAndSortingRepository.findAll(pageRequest);
		/*if(loanLimitList.getTotalPages() > 1){
			throw new PagingException(ResultEnum.PAGENUMBER_ERROR);
		}*/
		return loanLimitList;
	}

}
