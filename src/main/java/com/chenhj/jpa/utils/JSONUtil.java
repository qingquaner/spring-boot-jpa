package com.chenhj.jpa.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;

public class JSONUtil {
	// 常用fastjson API
	// 1 public static final Object parse(String text); //
	// 把JSON文本parse为JSONObject或者JSONArray
	// 2 public static final JSONObject parseObject(String text)； //
	// 把JSON文本parse成JSONObject
	// 3 public static final T parseObject(String text, Class clazz); //
	// 把JSON文本parse为JavaBean
	// 4 public static final JSONArray parseArray(String text); //
	// 把JSON文本parse成JSONArray
	// 5 public static final List parseArray(String text, Class clazz);
	// //把JSON文本parse成JavaBean集合
	// 6 public static final String toJSONString(Object object); //
	// 将JavaBean序列化为JSON文本
	// 7 public static final String toJSONString(Object object, boolean
	// prettyFormat); // 将JavaBean序列化为带格式的JSON文本
	// 8 public static final Object toJSON(Object javaObject);
	// 将JavaBean转换为JSONObject或者JSONArray。
	private static String encoding = "UTF-8";

	/**
	 * obj 转 json
	 * 
	 * @param obj
	 * @param prettyFormat
	 * @return
	 */
	public static String objToJson(Object obj, boolean prettyFormat) {
		String objJsonStr = JSON.toJSONString(obj, prettyFormat);
		return objJsonStr;
	}

	/**
	 * json 转 obj
	 * 
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	public static <T> T jsonToObj(String jsonStr, Class<T> cls) {
		T t = JSON.parseObject(jsonStr, cls);
		return t;
	}

	/**
	 * 
	 * @param obj
	 * @param prettyFormat
	 *            是否需要格式化
	 * @param absPath
	 *            文件路径
	 * @param fileName
	 *            文件名
	 * @return
	 */

	public static Map<String, Object> objToJsonFile(Object obj, boolean prettyFormat, String absPath, String fileName) {
		Map<String, Object> resultMap = new HashMap<>();
		String strJson = objToJson(obj, prettyFormat);
		String filePath = absPath + fileName;
		File file = new File(filePath);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				resultMap.put("status", "-1");
				resultMap.put("msg", filePath + "文件创建失败");
				return resultMap;
			}
		}

		OutputStream ous = null;
		try {
			ous = new BufferedOutputStream(new FileOutputStream(file));
			ous.write(strJson.getBytes());
			ous.flush();
			resultMap.put("status", "0");
			resultMap.put("msg", "文件写入成功");
		} catch (FileNotFoundException e) {
			resultMap.put("status", "-1");
			resultMap.put("msg", filePath + "文件不存在");
		} catch (IOException e) {
			resultMap.put("status", "-1");
			resultMap.put("msg", filePath + "文件写入失败");
		} finally {
			try {
				if (ous != null) {
					ous.close();
				}
			} catch (IOException e) {
				resultMap.put("status", "-1");
				resultMap.put("msg", "输出流关闭失败");
			}
		}
		return resultMap;
	}

	/**
	 * 从json文件读取报文
	 * 
	 * @param absPath
	 * @param fileName
	 * @param cls
	 * @return
	 */
	public static <T> T jsonToBeanFromFile(String absPath, String fileName, Class<T> cls) {
		String filePath = absPath + fileName;
		InputStream ins = null;
		try {
			ins = new BufferedInputStream(new FileInputStream(new File(filePath)));
			String json = IOUtils.toString(ins, encoding);
			return (T) jsonToObj(json, cls);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
