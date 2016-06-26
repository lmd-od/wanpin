package com.wanpin.common.utils;

import java.security.MessageDigest;

public final class MD5Utils {

	public static final String encode(String source){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bs=md.digest(source.getBytes());
			StringBuffer buff=new StringBuffer();
    		for(int i=0;i<bs.length;i++){
    			String hex=Integer.toHexString(bs[i] & 0xFF);
    			if(hex.length()==1){
    				hex="0"+hex;
    			}
    			buff.append(hex);
    		}
    		return buff.toString();
		}catch(Exception e){
			e.printStackTrace();
			return source;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(MD5Utils.encode("123456"));
	}
}
