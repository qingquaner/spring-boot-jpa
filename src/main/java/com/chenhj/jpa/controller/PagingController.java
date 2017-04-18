package com.chenhj.jpa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chenhj.jpa.domain.dbo.Loanlimits;
import com.chenhj.jpa.domain.dto.PagingParams;
import com.chenhj.jpa.domain.dto.Result;
import com.chenhj.jpa.enums.ResultEnum;
import com.chenhj.jpa.exception.PagingException;
import com.chenhj.jpa.service.LoanlimitPageService;
import com.chenhj.jpa.utils.ResultUtil;

@Controller
@RequestMapping("/paging")
public class PagingController {

	@Autowired
	private LoanlimitPageService loanlimitPage;

	/**
	 * 
	 * @param pageNumber 页码  默认为第一页
	 * @param pageSize   当前页显示数   默认5个
	 * @param direction  排序规则   默认升序（1:升序;其他整数位降序）
	 * @return
	 */
	@GetMapping("/listLoanlimit")
	public ModelAndView listLoanlimit(PagingParams pagingParams) {
		Integer pageNumber = pagingParams.getPageNumber();
		Integer pageSize = pagingParams.getPageSize();
		Integer direction = pagingParams.getDirection();
		
		Page<Loanlimits> loanLimitList = loanlimitPage.getLoanLimitList(pageNumber, pageSize,direction == 1? Direction.ASC:Direction.DESC);
		ModelAndView mv = new ModelAndView();
		mv.addObject("loanLimitList", loanLimitList.getContent());
		mv.addObject("totalPageNumber", loanLimitList.getTotalElements());
		mv.addObject("pageSize", pageSize);
		mv.setViewName("paging");
		System.out.println(loanLimitList.getContent());
		System.out.println(loanLimitList.getTotalElements());
		System.out.println(pageSize);
		return mv;
	}
	@GetMapping("/list")
	@ResponseBody
	public Result<List<Loanlimits>> getListLoanlimit(@Valid PagingParams pagingParams,BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
           List<ObjectError> allErrors = bindingResult.getAllErrors();
           for (ObjectError objectError : allErrors) {
        	  System.out.println( objectError.getDefaultMessage());
        	  throw new PagingException(-1, objectError.getDefaultMessage());
           }
        }
		Integer pageNumber = pagingParams.getPageNumber();
		Integer pageSize = pagingParams.getPageSize();
		Integer direction = pagingParams.getDirection();
		Page<Loanlimits> loanLimitList = loanlimitPage.getLoanLimitList(pageNumber, pageSize,direction == 1? Direction.ASC:Direction.DESC);
		List<Loanlimits> content = loanLimitList.getContent();
		
		return ResultUtil.success("接口调用成功",content);
	}
	@GetMapping("/list2")
	@ResponseBody
	public Result<List<Loanlimits>> getListLoanlimit2(@RequestParam(value="pageNumber",defaultValue="1")Integer pageNumber,@RequestParam(value="pageSize",defaultValue="5")Integer pageSize,@RequestParam(value="direction",defaultValue="1")Integer direction) {
		System.out.println("==="+pageNumber);
		if(pageNumber <=0 ){
			throw new PagingException(-1,"pageNumber不得小于1");
		}
		if(pageSize <=0){
			throw new PagingException(-1,"pageSize不得小于1");
		}
		Page<Loanlimits> loanLimitList = loanlimitPage.getLoanLimitList(pageNumber, pageSize,direction == 1? Direction.ASC:Direction.DESC);
		List<Loanlimits> content = loanLimitList.getContent();
		
		return ResultUtil.success("接口调用成功",content);
	}
	@GetMapping("/goPaging")
	public String goPaging(HttpServletRequest request){
		System.out.println("11111111111111111"+request.getContextPath());
		return "paging";
	}
}
