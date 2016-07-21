package com.wanpin.entity;

import java.util.Date;

public class Question {
    private Long questionId;

    private Long userId; // 投诉人

    private Date questionTime;  // 投诉时间

    private String question; // 投诉内容

    private Long solver; // 处理人

    private Date solveTime; // 处理时间

    private Byte questionStatus; // 投诉状态 1：待解决 2：已解决
    
    private Byte questionSource; // 问题来源

    private String solveResult;  // 处理结果

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Date questionTime) {
        this.questionTime = questionTime;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public Long getSolver() {
        return solver;
    }

    public void setSolver(Long solver) {
        this.solver = solver;
    }

    public Date getSolveTime() {
        return solveTime;
    }

    public void setSolveTime(Date solveTime) {
        this.solveTime = solveTime;
    }

    public Byte getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(Byte questionStatus) {
        this.questionStatus = questionStatus;
    }

    public Byte getQuestionSource() {
		return questionSource;
	}

	public void setQuestionSource(Byte questionSource) {
		this.questionSource = questionSource;
	}

	public String getSolveResult() {
        return solveResult;
    }

    public void setSolveResult(String solveResult) {
        this.solveResult = solveResult == null ? null : solveResult.trim();
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