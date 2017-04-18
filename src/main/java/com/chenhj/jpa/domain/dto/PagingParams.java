package com.chenhj.jpa.domain.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PagingParams {
	@NotNull(message = "pageNumber必传")
	@Min(value=1,message="pageNumber不得小于1")
	private Integer pageNumber;
	
	@NotNull(message = "pageSize必传")
	@Min(value=1,message="pageSize不得小于1")
	private Integer pageSize;
	
	@NotNull(message = "direction必传")
	private Integer direction;

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

}
