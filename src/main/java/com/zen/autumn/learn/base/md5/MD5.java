package com.zen.autumn.learn.base.md5;

import java.security.MessageDigest;

public class MD5 { 
	
	public static final String Key ="1780737d1f4f18097eef3236fa917ff9";
	
	public static String md5Encode(String inStr) throws Exception {
    MessageDigest md5 = null;
    try {
        md5 = MessageDigest.getInstance("MD5");
    } catch (Exception e) {
        System.out.println(e.toString());
        e.printStackTrace();
        return "";
    }

    byte[] byteArray = inStr.getBytes("UTF-8");
    byte[] md5Bytes = md5.digest(byteArray);
    StringBuffer hexValue = new StringBuffer();
    for (int i = 0; i < md5Bytes.length; i++) {
        int val = ((int) md5Bytes[i]) & 0xff;
        if (val < 16) {
            hexValue.append("0");
        }
        hexValue.append(Integer.toHexString(val));
    }
    return hexValue.toString();
}

	
	
	
	public static void main(String[] args) throws Exception {
		
		   
		   
		        String str = new String("amigoxiexiexingxing"+Key);
		        System.out.println("原始：" + str);
		        System.out.println("MD5后：" + md5Encode(str));
		   
		}
	}


