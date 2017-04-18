package com.chenhj.jpa.enums;

public enum ResultEnum {
	UNKNOWN_ERROR(-9,"未知异常"),
	PAGENUMBER_ERROR(-1, "pageNumber不得小于1"),
	PAGESIZE_ERROR(-2, "pageSize不得小于1");
	
	private Integer code;
	private String msg;

	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}	
