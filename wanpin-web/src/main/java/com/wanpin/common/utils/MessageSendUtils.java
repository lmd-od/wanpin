package com.wanpin.common.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.taobao.api.ApiException;
import com.wanpin.common.core.sms.SimpleMessage;
import com.wanpin.common.core.sms.SmsSendMessage;
import com.wanpin.common.core.sms.SmsTemplateCode;
import com.wanpin.common.exception.SmsException;
import com.wanpin.common.persistence.SystemEnum;
import com.wanpin.entity.SmsSendRec;
import com.wanpin.service.SmsSendRecService;

/**
 * <p>信息发送工具类</p>
 * @author litr 2016年6月26日
 * @version 1.0
 */
public class MessageSendUtils {
	
	@Autowired
	private SmsSendRecService smsSendRecService;
	
	/**
	 * <p>发送短信</p>
	 * @author litr 2016年6月26日
	 * @param stc
	 * @param mobiles
	 * @param args
	 * @return
	 * @throws SmsException
	 */
	public boolean sendSms(SmsTemplateCode stc,String mobiles,String... args) throws SmsException {
		if (stc == null) {
			throw new SmsException("短信模版编码不能为空");
		}
		
		if (StringUtils.isEmpty(mobiles)) {
			throw new SmsException("发送短信失败，手机号mobiles不能为空");
		}
		boolean flag = true;
		switch (stc) {
		case REG_VCODE: // 注册
		case FIND_PWD_VCODE: // 找回密码
		case PAY_VCODE: // 支付密码
		case LOGIN_VCODE: // 登录
			if (StringUtils.isEmpty(args) || args.length >= 4) {
				throw new SmsException("传递参数变量不正确");
			}
			
			if (mobiles.length() >= 12) {
				throw new SmsException("只允许传入一个手机号");
			}
			flag = sendSmsCode(stc, mobiles, args);
			break;

		default:
			break;
		}
		
		return flag;
	}

	private boolean sendSmsCode(SmsTemplateCode stc, String mobiles, String[] args) throws SmsException {
		SimpleMessage msg = new SimpleMessage();
		// 设置短信模版编码
		msg.setSmsTemplateCode(stc);
		// 设置模版所需参数
		msg.putParamMap("number", args[0]);
		// 设置发送时间
		msg.setSendTime(new Date());
		
		//获取来源和IP地址信息
		String ip = null;
		Byte source = null;
		if(args.length == 3){
			ip = args[1];
			source = Byte.valueOf(args[2]);
		}else if(args.length == 2){
			ip = args[1];
		}
		
		// 设置接收者
		msg.addReceiver(mobiles);
		
		// 发送标记
		byte sendFlag = SystemEnum.YES;
		try {
			SmsSendMessage.alidayuSms(msg);
		} catch (ApiException e) {
			sendFlag = SystemEnum.NO;
			e.printStackTrace();
		}
		
		SmsSendRec ssr = new SmsSendRec();
		ssr.setMobile(mobiles);
		ssr.setContent(JSON.toJSONString(msg.getParamMap()));
		ssr.setSendTime(msg.getSendTime());
		ssr.setMsgId(msg.getMsgId());
		ssr.setMsgType(SystemEnum.SMS_MSG_TYPE_NOTICE);
		ssr.setSp(SystemEnum.SMS_SP_ALIDAYU);
		ssr.setSendStatus(sendFlag);
		ssr.setbTplCode(stc.toString());
		ssr.setIp(ip);
		ssr.setSource(source);
		try {
			smsSendRecService.save(ssr);
		} catch (Exception e) {
			throw new SmsException("保存发送记录信息失败"+e);
		}
		
		return sendFlag == SystemEnum.YES;
	}
	
}
