package com.chenhj.jpa.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenhj.jpa.domain.dto.Result;
import com.chenhj.jpa.enums.ResultEnum;
import com.chenhj.jpa.exception.PagingException;
import com.chenhj.jpa.utils.ResultUtil;

/**
 * 统一异常处理类
 * 
 * @author chenhj
 *
 */
@ControllerAdvice
// @ControllerAdvice 注解统一处理 DAO service Controller 中抛出的异常
// @ControllerAdvice默认所有控制的抛出的异常都会在这个类进行处理
// @ControllerAdvice(annotations = {PCInfoController .class}) 配置你需要拦截的控制器，
// @ControllerAdvice(basePackages = "com.demo") 配置你需要路径下的控制器
// @ExceptionHandler 自定义的错误处理器
// @ModelAttribute 全局的对所有的controller的Model添加属性
// @InitBinder 对表单数据绑定
public class ExceptionHandle {
	private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public <T> Result<T> handle(Exception e) {
		if (e instanceof PagingException) {
			PagingException pagingException = (PagingException) e;
			return ResultUtil.error(pagingException.getCode(), e.getMessage(), null);

		} else {
			logger.error("{系统异常}" + e.getMessage());
			return ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg(), null);
		}
	}

	/**
	 * 
	 * 功能描述:
	 * 应用上下文设值给Model对象 在jsp中使用:${ctx}
	 */
	@ModelAttribute(value="ctx")
	public String setContextPath(HttpServletRequest request) {

		return request.getContextPath();
	}
}