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

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class XstreamXMLUtil {

	// private static XStream xstream=new XStream();
	// private static XStream xstream=new XStream(new DomDriver());//直接用jaxp
	// 在xml文件头部添加 <?xml version="1.0" ?>
	// private static XStream xstream = new XStream(new StaxDriver());
	private static String encoding = "UTF-8";
	private static XStream xstream = new XStream(new DomDriver(encoding));// 指定编码解析器,直接用jaxp

	/**
	 * 对象转XML
	 * 
	 * @param obj
	 * @return
	 */
	public static String objToXml(Object obj) {
		//// 如果没有这句，xml中的根元素会是<包.类名>；或者说：注解根本就没生效，所以的元素名就是类的属性
		xstream.processAnnotations(obj.getClass()); // 通过注解方式的，一定要有这句话
		return xstream.toXML(obj);
	}

	/**
	 * 将传入xml文本转换成Java对象
	 * 
	 * @Title: toBean
	 * @param xmlStr
	 * @param cls
	 *            xml对应的class类
	 * @return T xml对应的class类的实例对象
	 * 
	 */
	public static <T> T xmlToBean(String xmlStr, Class<T> cls) {
		// 注意：不是new Xstream();
		// 否则报错：java.lang.NoClassDefFoundError:
		// org/xmlpull/v1/XmlPullParserFactory
		xstream.processAnnotations(cls);
		@SuppressWarnings("unchecked")
		T obj = (T) xstream.fromXML(xmlStr);
		return obj;
	}

	/**
	 * 写到xml文件中去
	 * 
	 * @Title: writeXMLFile
	 * @param obj
	 *            对象
	 * @param absPath
	 *            绝对路径
	 * @param fileName
	 *            文件名
	 * @return boolean
	 */

	public static Map<String, Object> objToXMLFile(Object obj, String absPath, String fileName) {
		Map<String, Object> resultMap = new HashMap<>();
		String strXml = objToXml(obj);
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
			ous.write(strXml.getBytes());
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
	 * 从xml文件读取报文
	 * 
	 * @Title: toBeanFromFile
	 * @param absPath
	 *            绝对路径
	 * @param fileName
	 *            文件名
	 * @param cls
	 * @return T
	 */
	public static <T> T xmlToBeanFromFile(String absPath, String fileName, Class<T> cls) {
		String filePath = absPath + fileName;
		InputStream ins = null;
		try {
			ins = new BufferedInputStream(new FileInputStream(new File(filePath)));
			String xml = IOUtils.toString(ins, encoding);
			return (T) xmlToBean(xml, cls);
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
