<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<div class="sidebar">
	<ul>
		<li><a href="${ctx}/${webAdminPath}/user/gobase.php">基本信息</a></li>
		<%-- <li><a href="${ctx}/page/user/user_goods.jsp">我的方案订单</a></li> --%>
		<li><a href="${ctx}/${webAdminPath}/user/user_favorite.php">我的收藏</a></li>
		<li><a href="${ctx}/${webAdminPath}/user/user_suggest.php">我的建议</a></li>
		<%-- <li><a href="${ctx}/page/user/user_evaluate.jsp">评价晒单</a></li>
		<li><a href="${ctx}/page/user/user_integral.jsp">我的积分</a></li> --%>
		<li><a href="${ctx}/${webAdminPath}/user/user_change_pass.php">修改密码</a></li>
		<%-- <li><a href="${ctx}/page/user/user_lineup.jsp">排  队</a></li>
		<li><a href="${ctx}/page/user/user_refund.jsp">退  款</a></li> --%>
		<li><a href="javascript:;" class="user_logout">退  出</a></li>
	</ul>
</div>