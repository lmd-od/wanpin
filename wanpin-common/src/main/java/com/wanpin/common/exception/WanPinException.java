package com.wanpin.common.exception;
public class WanPinException extends RuntimeException{
	WanPinException(){}
	WanPinException(String msg){
		super(msg);
	}
}