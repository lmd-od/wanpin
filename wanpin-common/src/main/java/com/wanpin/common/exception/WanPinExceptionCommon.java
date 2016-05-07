package com.wanpin.common.exception;

import com.wanpin.common.persistence.SystemEnum;

public class WanPinExceptionCommon extends Exception {
	public WanPinExceptionCommon(String msg){
		super(msg);
	}
	public static void throwException(String msg) {
		throw new WanPinException(msg);
	}
	
	public static void runtimeException(String msg) {
		throw new WanPinException(msg);
	}
}
