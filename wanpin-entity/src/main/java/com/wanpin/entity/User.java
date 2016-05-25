package com.wanpin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Long userId;

    private String mobile;

    private String email;

    private String password;

    private String payPassword;

    private String type;

    private String language;

    private String nickName;

    private String realName;

    private String idcardNo;

    private Integer userGrad;

    private Date birthday;

    private String qq;

    private String weiXin;

    private String university;

    private Integer education;

    private Integer sex;

    private Integer isAuth;

    private String company;

    private String position;

    private BigDecimal remainMoney;

    private Integer status;

    private String recommendCode;

    private String recommendUser;

    private String idcardPhoto1;

    private String idcardPhoto2;

    private String resume;

    private Boolean delFlag;

    private String loginIp;

    private Date loginDate;

    private String oldLoginIp;

    private Date oldLoginDate;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo == null ? null : idcardNo.trim();
    }

    public Integer getUserGrad() {
        return userGrad;
    }

    public void setUserGrad(Integer userGrad) {
        this.userGrad = userGrad;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWeiXin() {
        return weiXin;
    }

    public void setWeiXin(String weiXin) {
        this.weiXin = weiXin == null ? null : weiXin.trim();
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Integer isAuth) {
        this.isAuth = isAuth;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public BigDecimal getRemainMoney() {
        return remainMoney;
    }

    public void setRemainMoney(BigDecimal remainMoney) {
        this.remainMoney = remainMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode == null ? null : recommendCode.trim();
    }

    public String getRecommendUser() {
        return recommendUser;
    }

    public void setRecommendUser(String recommendUser) {
        this.recommendUser = recommendUser == null ? null : recommendUser.trim();
    }

    public String getIdcardPhoto1() {
        return idcardPhoto1;
    }

    public void setIdcardPhoto1(String idcardPhoto1) {
        this.idcardPhoto1 = idcardPhoto1 == null ? null : idcardPhoto1.trim();
    }

    public String getIdcardPhoto2() {
        return idcardPhoto2;
    }

    public void setIdcardPhoto2(String idcardPhoto2) {
        this.idcardPhoto2 = idcardPhoto2 == null ? null : idcardPhoto2.trim();
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume == null ? null : resume.trim();
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getOldLoginIp() {
        return oldLoginIp;
    }

    public void setOldLoginIp(String oldLoginIp) {
        this.oldLoginIp = oldLoginIp == null ? null : oldLoginIp.trim();
    }

    public Date getOldLoginDate() {
        return oldLoginDate;
    }

    public void setOldLoginDate(Date oldLoginDate) {
        this.oldLoginDate = oldLoginDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}