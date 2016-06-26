package com.wanpin.common.core.sms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleMessage {

	// 消息ID
	private String msgId; // "request_id":"r4kwt3pieitg"
	
	// 通过类型编码获取短信
	private SmsTemplateCode smsTemplateCode;
	
	// 消息接受者集合
	private List<String> receivers;
	
	// 消息变量值集合
	private Map<String, String> paramMap;
	
	// 发送时间
	private Date sendTime;

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public SmsTemplateCode getSmsTemplateCode() {
		return smsTemplateCode;
	}

	public void setSmsTemplateCode(SmsTemplateCode smsTemplateCode) {
		this.smsTemplateCode = smsTemplateCode;
	}

	public List<String> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<String> receivers) {
		this.receivers = receivers;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
	public void addReceiver(String receiver) {
		if (this.receivers == null) {
			this.receivers = new ArrayList<String>();
		}
		
		this.receivers.add(receiver);
	}
	
	public void putParamMap(String key,String value) {
		if (this.paramMap == null) {
			this.paramMap = new HashMap<String,String>();
		}
		this.paramMap.put(key, value);
	}
}
