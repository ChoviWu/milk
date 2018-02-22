package com.xw.milk.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
	private static char md5Chars[] =
	{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
		'e', 'f' };

	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };


	private static String bufferToHex(byte bytes[])
	{
		return bufferToHex(bytes, 0, bytes.length);
	}
	
	private static String bufferToHex(byte bytes[], int m, int n)
	{
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++)
		{
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}
	
	private static void appendHexPair(byte bt, StringBuffer stringbuffer)
	{
		char c0 = md5Chars[(bt & 0xf0) >> 4];
		char c1 = md5Chars[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}
	 
	public static String toMD5(String str) throws UnsupportedEncodingException {
		MessageDigest messagedigest;
		try {
			messagedigest = MessageDigest.getInstance("MD5");
			messagedigest.update(str.getBytes("UTF-8"));
			return bufferToHex(messagedigest.digest()).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



	// 返回形式为数字跟字符串
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	// 返回形式只为数字
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		System.out.println("iRet1=" + iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	public static String GetMD5Code(String strObj) {
		String resultString = null;
		try {
			resultString = new String(strObj);
			MessageDigest md = MessageDigest.getInstance("MD5");

			resultString = byteToString(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

}