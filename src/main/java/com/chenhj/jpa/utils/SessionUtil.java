package com.chenhj.jpa.utils;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
	
	/**
	 * 将map中的值以键值对形式保存到session中
	 */
	public void setMapToSessionScope(Map<String,Object> map,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			session.setAttribute(entry.getKey(), entry.getValue());
		}
	}

}
