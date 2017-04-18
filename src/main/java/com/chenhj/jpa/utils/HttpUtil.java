package com.chenhj.jpa.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpUtil {

	/**
	 * @param url
	 *            接口地址
	 * @param params
	 *            Map类型参数
	 * @return Map 包含statusCode和response
	 */

	public static Map<String, String> post(String url, Map<String, String> params) {
		HttpClient client = new HttpClient();
		HttpMethod method = getPostMethod(url, params); // 使用 POST 方式提交数据
		Map<String, String> responseMap = new HashMap<String, String>();
		try {
			client.executeMethod(method);
			// 打印服务器返回的状态
			String statusCode = method.getStatusLine().getStatusCode()+"";

			String response = new String(method.getResponseBodyAsString().getBytes("ISO-8859-1"), "UTF-8");
			responseMap.put("statusCode", statusCode);
			responseMap.put("response", response);

		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		method.releaseConnection();
		return responseMap;
	}

	/**
	 * 使用 POST 方式提交数据
	 * 
	 * @return
	 */
	private static HttpMethod getPostMethod(String url, Map<String, String> params) {
		PostMethod post = new PostMethod(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			nvps.add(new NameValuePair(key, params.get(key)));
		}
		NameValuePair[] nvp = new NameValuePair[params.size()];
		for (int i = 0; i < nvp.length; i++) {
			nvp[i] = nvps.get(i);
		}
		post.setRequestBody(nvp);
		return post;
	}
}
