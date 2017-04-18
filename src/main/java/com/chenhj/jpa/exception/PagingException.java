package com.chenhj.jpa.exception;

import com.chenhj.jpa.enums.ResultEnum;

public class PagingException extends RuntimeException {
	
	private static final long serialVersionUID = 8031122052167439509L;
	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public PagingException(ResultEnum resultEnum){
		super(resultEnum.getMsg());
		this.code =  resultEnum.getCode();
	}
	public PagingException(Integer code,String msg){
		super(msg);
		this.code =  code;
	}

}
