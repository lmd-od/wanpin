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
				<li><a href="${ctx}/page/user/login.jsp">登录</a></li>
				<li><a href="${ctx}/page/register.jsp">注册</a></li>
				<li><a href="${ctx}/php/user/gobase.php" id="sdku">用户名</a></li>
			</ul>
			<span>
				[<a href="#">中文版</a>
				 / 
				<a href="#">English</a>]
			</span>
		</div>
		<div class="sidebar Droplie">
			<ul>
				<li><a href="${ctx}/php/user/gobase.php">基本信息</a></li>
				<li><a href="${ctx}/page/user/user_goods.jsp">我的方案订单</a></li>
				<li><a href="${ctx}/page/user/user_favorite.jsp">我的收藏</a></li>
				<li><a href="${ctx}/page/user/user_suggest.jsp">我的建议</a></li>
				<li><a href="${ctx}/page/user/user_evaluate.jsp">评价晒单</a></li>
				<li><a href="${ctx}/page/user/user_integral.jsp">我的积分</a></li>
				<li><a href="${ctx}/page/user/user_change_pass.jsp">修改密码</a></li>
				<li><a href="${ctx}/page/user/user_lineup.jsp">排队</a></li>
				<li><a href="${ctx}/page/user/user_refund.jsp">退款</a></li>
			</ul>
		</div>
	</div>
</div>