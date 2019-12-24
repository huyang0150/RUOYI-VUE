package com.ruoyi.common.utils.md5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

public class Md5Util {
	
	private static Logger logger = LoggerFactory.getLogger(Md5Util.class);
	
	/**
	 * 
	 * 获取某种规则混淆过的md5
	 * @param inStr 字符串
	 * @param chr 混淆字符
	 * @param index 混淆序号
	 * @return 返回某种规则混淆过的md5
	 */
	public static String getConfuseMd5(String inStr,char chr,int index){
		StringBuffer buff = new StringBuffer(inStr);
		for(int i = index ; i < buff.length(); i += index){
			buff.insert(i, chr);
		}
		buff = getMD5(buff.toString());
		char[] chrs = new char[buff.length()];
		buff.getChars(0, buff.length(), chrs, 0);
		for(int i = 0 ; i < buff.length(); i += 2){
			char temp = chrs[i];
			chrs[i] = chrs[i+1];
			chrs[i+1] = temp;
		}
		return new String(chrs);
	}
	
	/**
	 * 生成md5
	 * 
	 * @param message
	 * @return
	 */
	public static StringBuffer getMD5(String inStr) {
		StringBuffer md5str = null;
		try {
			// 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("MD5");

			// 2 将消息变成byte数组
			byte[] input = inStr.getBytes("utf-8");

			// 3 计算后获得字节数组,这就是那128位了
			byte[] buff = md.digest(input);

			// 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
			md5str = bytesToHex(buff);

		} catch (Exception e) {
			logger.error("生成md5失败", e);
		}
		return md5str;
	}
	
	public static StringBuffer getSHA256(String inStr) {
		StringBuffer md5str = null;
		try {
			// 1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			// 2 将消息变成byte数组
			byte[] input = inStr.getBytes();

			// 3 计算后获得字节数组,这就是那128位了
			byte[] buff = md.digest(input);

			// 4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
			md5str = bytesToHex(buff);

		} catch (Exception e) {
			logger.error("生成md5失败", e);
		}
		return md5str;
	}

	/**
	 * 二进制转十六进制
	 * 
	 * @param bytes
	 * @return
	 */
	private static StringBuffer bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();
		// 把数组每一字节换成16进制连成md5字符串
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];

			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str;
	}
}