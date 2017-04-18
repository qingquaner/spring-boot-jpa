package com.chenhj.jpa.utils;

import com.chenhj.jpa.domain.dto.Result;

public class ResultUtil {

	public static <T> Result<T> success(String msg,T obj) {
		
		return error(0,msg,obj);
	}

	public static <T> Result<T> error(Integer code,String msg,T obj) {
		Result<T> result = new Result<T>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(obj);
		return result;
	}
}
