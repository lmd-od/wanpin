package com.wanpin.common.utils;

import java.security.Key;  

import javax.crypto.Cipher;  
import javax.crypto.SecretKeyFactory;  
import javax.crypto.spec.DESedeKeySpec;  
import javax.crypto.spec.IvParameterSpec; 
import com.wanpin.common.utils.Base64;
/**
 * 3des加密解密工具
 * @author MingDing.Li
 */
public class Des3Utils {
	// 密钥
    private final static String secretKey = "wanpin12345@lx100$#365#$";  
    // 向量 
    private final static String iv = "wanpin12";  
    // 加解密统一使用的编码方式  
    private final static String encoding = "utf-8";  
  
    /**
     * 3DES加密  
     * @author MingDing.Li
     * @param text
     * @return
     * @throws Exception
     */
    public static String encode(String text) throws Exception {  
        Key deskey = null;  
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());  
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");  
        deskey = keyfactory.generateSecret(spec);  
  
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");  
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());  
        cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);  
        byte[] encryptData = cipher.doFinal(text.getBytes(encoding));  
        return Base64.encodeByte(encryptData);  
    }  
  
    /**
     * 3DES解密   
     * @author MingDing.Li
     * @param text
     * @return
     * @throws Exception
     */
    public static String decode(String text) throws Exception {  
        Key deskey = null;  
        DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());  
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");  
        deskey = keyfactory.generateSecret(spec);  
        Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");  
        IvParameterSpec ips = new IvParameterSpec(iv.getBytes());  
        cipher.init(Cipher.DECRYPT_MODE, deskey, ips);  
        byte[] decryptData = cipher.doFinal(Base64.decodeByte(text));  
        return new String(decryptData, encoding);  
    }  
    
    
    public static void main(String[] args) throws Exception {
		
    	
    	
    	System.out.println(Des3Utils.encode("123456"));
    	System.out.println(Des3Utils.encode("张三"));
    	System.out.println(Des3Utils.encode("US20160427094957"));
    	
    	
    	
    	
	}
}
