package com.wanpin.common.core.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 
 * @author MingDing.Li
 */
public class SmsSendMessage {

	public static final String appkey = "23393562";
	public static final String secret = "eb3f5eb328767e25204872d62e7f89e9";
	public static final String url = "http://gw.api.taobao.com/router/rest";
	public static final String signName = "万品数字科技";

	public static void alidayuSms(SimpleMessage sm) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		// req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("森云博客");
		if (sm.getParamMap() != null && sm.getParamMap().size() > 0) {
			req.setSmsParamString(JSON.toJSONString(sm.getParamMap()));
		}
		StringBuffer ms = new StringBuffer();
		for (String rec : sm.getReceivers()) {
			if (ms.length() > 0) {
				ms.append(",");
			}
			ms.append(rec);
		}
		req.setRecNum(ms.toString());
		req.setSmsTemplateCode(sm.getSmsTemplateCode().getValue());
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);
		String body = rsp.getBody();
		System.out.println(body);
		JSONObject jsonObj = JSON.parseObject(body);
		if (body.contains("alibaba_aliqin_fc_sms_num_send_response")) {
			JSONObject sendResp =(JSONObject) jsonObj.get("alibaba_aliqin_fc_sms_num_send_response");
			sm.setMsgId(sendResp.getString("request_id"));
		} else if (body.contains("error_response")) {
			JSONObject sendResp =(JSONObject) jsonObj.get("error_response");
			sm.setMsgId(sendResp.getString("request_id"));
			throw new ApiException(sendResp.getString("sub_msg"));
		}
		
	}
	
	public static void main(String[] args) {
		try {
			// alidayuSms(null);
			SimpleMessage sm = new SimpleMessage();
			sm.putParamMap("number", "123456");
			sm.addReceiver("13681317323,15036900300");
			sm.setSmsTemplateCode(SmsTemplateCode.REG_VCODE);
			alidayuSms(sm);
			
			// JSONObject jo = JSON.parseObject("{\"alibaba_aliqin_fc_sms_num_send_response\":{\"result\":{\"model\":\"102010583529^0\",\"success\":true},\"request_id\":\"zqb29pcmcu8c\"}}");
			// System.out.println(((JSONObject) jo.get("alibaba_aliqin_fc_sms_num_send_response")).get("request_id"));
			// System.out.println(((JSONObject) ((JSONObject) jo.get("alibaba_aliqin_fc_sms_num_send_response")).get("result")).get("success"));
			// JSON.parseObject(jo.get("alibaba_aliqin_fc_sms_num_send_response"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
