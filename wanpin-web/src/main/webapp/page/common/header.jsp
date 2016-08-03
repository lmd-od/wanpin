<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<div class="header">
	<div class="header-content">
		<div class="header-content-logo">
			<a href="/"><img src="${ctx}/res/img/01.png" /><span>万品建筑视界</span></a>
		</div>
		<div class="header-content-nav">
			<ul>
				<li><a href="/">首页</a></li>
				<li><a href="${ctx}/${webAdminPath}/engine/golist.php">引擎</a></li>
				<li><a href="${ctx}/${webAdminPath}/goods/golist.php">方案商城</a></li>
				<li><a href="${ctx}/${webAdminPath}/internet/internet.php">互联</a></li>
				<li><a href="${ctx}/${webAdminPath}/about/about.php">关于我们</a></li>
			</ul>
		</div>
		<div class="header-content-loginbar">
			<ul class="username">
				<c:choose>
					<c:when test="${empty sessionScope.userInfo}">
				<li><a href="${ctx}/${webAdminPath}/login/goLogin.php">登录</a></li>
				<li><a href="${ctx}/${webAdminPath}/login/goRegister.php">注册</a></li>
					</c:when>
					<c:otherwise>
				<li class="activ"><a href="${ctx}/${webAdminPath}/user/gobase.php" id="sdku">用户名</a>
					<div class="sidebar Droplie">
						<ul>
							<li><a href="${ctx}/${webAdminPath}/user/gobase.php">基本信息</a></li>
							<%-- <li><a href="${ctx}/page/user/user_goods.jsp">我的方案订单</a></li> --%>
							<li><a href="${ctx}/${webAdminPath}/user/user_favorite.php">我的收藏</a></li>
							<li><a href="${ctx}/${webAdminPath}/user/user_suggest.php">我的建议</a></li>
							<%-- <li><a href="${ctx}/page/user/user_evaluate.jsp">评价晒单</a></li>
							<li><a href="${ctx}/page/user/user_integral.jsp">我的积分</a></li> --%>
							<li><a href="${ctx}/${webAdminPath}/user/user_change_pass.php">修改密码</a></li>
							<%-- <li><a href="${ctx}/page/user/user_refund.jsp">排队</a></li>
							<li><a href="${ctx}/page/user/user_refund.jsp">退款</a></li> --%>
							<li><a href="javascript:;" class="user_logout">退出</a></li>
						</ul>
					</div>
				</li>
					</c:otherwise>
				</c:choose>
			</ul>
			<!-- <span>
				<a href="#">中文版</a>
				 / 
				<a href="#">EngclsH</a>
			</span> -->
		</div>
	</div>
</div>