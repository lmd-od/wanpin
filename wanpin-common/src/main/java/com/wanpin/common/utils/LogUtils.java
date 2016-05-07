package com.wanpin.common.utils;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 日志工具
 * @author MingDing.Li
 *
 */
public class LogUtils {
	static{
		Properties log4jConf = new Properties(); 
	    try {
			log4jConf.load(LogUtils.class.getResourceAsStream("/log4j.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
	    PropertyConfigurator.configure(log4jConf);
	}
	/**
	 * 日志对象
	 */
	protected Logger log = Logger.getLogger("wanpin");
	/**
	 * 打印信息
	 * @author MingDing.Li
	 * @param msg
	 */
	public void info(String msg){
		log.info("INFO:"+msg);
	}
	/**
	 * 错误日志
	 * @author MingDing.Li
	 * @param msg
	 */
    public void error(String msg){
    	log.error("ERROR:"+msg);
	}
    /**
     * 调试日志
     * @author MingDing.Li
     * @param msg
     */
    public void debug(String msg){
    	log.debug("DEBUG:"+msg);
	}
	
}
