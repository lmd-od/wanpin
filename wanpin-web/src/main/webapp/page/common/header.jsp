<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<div class="header">
	<div class="header-content">
		<div class="header-content-logo">
			<a href="#"><img src="${ctx}/res/img/01.png" /><span>万品数字科技</span></a>
		</div>
		<div class="header-content-nav">
			<ul>
				<li><a href="${ctx}/page/index.jsp">首页</a></li>
				<li><a href="${ctx}/page/engine/engine.jsp">引擎</a></li>
				<li><a href="${ctx}/page/goods/goods.jsp">方案商城</a></li>
				<li><a href="${ctx}/page/internet/internet.jsp">互联</a></li>
				<li><a href="${ctx}/page/about/about.jsp">关于我们</a></li>
			</ul>
		</div>
		<div class="header-content-loginbar">
			<ul>
				<li><a href="${ctx}/page/user/user_base.jsp">登录</a></li>
				<li><a href="${ctx}/page/register.jsp">注册</a></li>
			</ul>
			<span>
				<a href="#">中文版</a>
				 / 
				<a href="#">English</a>
			</span>
		</div>
	</div>
</div>