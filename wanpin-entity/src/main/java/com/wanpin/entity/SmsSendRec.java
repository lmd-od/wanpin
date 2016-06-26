package com.wanpin.entity;

import java.util.Date;

public class SmsSendRec {
    private Long sendRecId; // 发送记录ID

    private String mobile; // 接收手机号

    private String content; // 短信息内容

    private Date sendTime; // 发送时间

    private String msgId; // 消息ID

    private Byte msgType; // 短消息类型 默认 1：通知类

    private Byte sp; // 服务商（1：阿里大鱼）

    private Byte sendStatus; // 发送状态1：成功 0：失败

    private String bTplCode; // 业务模板编码(目前有：REG_VCODE,FIND_PWD_VCODE,PAY_VCODE,LOGIN_VCODE)

    private String ip; // 发送ip地址

    private Byte source; // 发送短信来源，1:PC  2:android  3:ios

    public Long getSendRecId() {
        return sendRecId;
    }

    public void setSendRecId(Long sendRecId) {
        this.sendRecId = sendRecId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId == null ? null : msgId.trim();
    }

    public Byte getMsgType() {
        return msgType;
    }

    public void setMsgType(Byte msgType) {
        this.msgType = msgType;
    }

    public Byte getSp() {
        return sp;
    }

    public void setSp(Byte sp) {
        this.sp = sp;
    }

    public Byte getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Byte sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getbTplCode() {
        return bTplCode;
    }

    public void setbTplCode(String bTplCode) {
        this.bTplCode = bTplCode == null ? null : bTplCode.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }
}