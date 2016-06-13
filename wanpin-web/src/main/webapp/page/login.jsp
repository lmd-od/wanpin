<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="/page/common/header.jsp"></jsp:include>
		<div class="article">
			<div class="active-content">
				<h1 class="active-content-h1">首页>>登录/注册</h1>
				<div class="warp">
					<div class="form">
						<form id="login_form" action="" method="post">
							<span class="wenben-01">手机号</span>
							<input type="text" name="mobile" id="" value="" placeholder="请填写注册或登录用的手机号" class="text"/>
							<br /><br />
							<span class="wenben-02">密码</span>
							<input type="password" name="password"  class="text" placeholder="请输入密码"/>
							<br /><br /> 
							<!-- <span class="wenben-04">验证码</span>
							<input type="text" name="img_code" id="" value="" placeholder="请输入验证码" class="text"/>
							<br /><br /> -->
							<a href="${ctx}/${webAdminPath}/login/goForgetPwd.php" style="color: blue;">忘记密码？</a><a style="margin-left: 220px;color: blue;" href="${ctx}/${webAdminPath}/login/goRegister.php">注册</a>
							<br /><br />
							<input type="submit" value=" 登录 " class="register"/>
						</form>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
		<script src="${ctx}/res/lib/jquery-validation/1.14.0/jquery.validate.min.js"></script>
		<script src="${ctx}/res/lib/jquery-validation/1.14.0/messages_zh.min.js"></script>
		<script src="${ctx}/res/lib/jquery-validation/1.14.0/validate-methods.js"></script>
		<script src="${ctx}/res/js/wanpin/login.js"></script>
	</body>

</html>