<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
<style type="text/css">
.spanstyle {
	width: 90px;
	display: block;
}
.float-left {
	float: left;
}
</style>
	</head>
	<body>
		<jsp:include page="/page/common/header.jsp"></jsp:include>
		<div class="article">
			<div class="active-content">
				<h1 class="active-content-h1">首页>>登录/注册</h1>
				<div class="warp">
					<div class="form">
						<form id="register_form" action="" method="post">
							<span class="spanstyle float-left">手机号码</span>
							<input type="text" name="mobile" id="" value="" placeholder="请输入您的手机号码" class="text"/>
							<br /><br />
							<span class="spanstyle float-left">图形验证码</span>
							<input type="text" name="img_code" id="" value="" placeholder="请输入图形验证码" class="text float-left"/>
							<img alt="点击刷新验证码" class="float-left" src="${ctx}/${webAdminPath}/code/imgcode.php" onclick="this.src = '${ctx}/${webAdminPath}/code/imgcode.php?rnd' + Math.random();">
							<br /><br />
							<span class="spanstyle float-left">短信验证码</span>
							<input type="text" name="code" id="" value="" placeholder="请输入短信验证码" class="text float-left"/>
							<input type="button" value="获取验证码 " class="Captcha float-left"/>
							<br /><br />
							<span class="spanstyle float-left">密码</span>
							<input type="password" name="password" id="password" class="text" placeholder="请输入密码"/>
							<br /><br /> 
							<span class="spanstyle float-left">确定密码</span>
							<input type="password" name="repassword" placeholder="确认密码" class="text"/>
							<br /><br /> 
							<input type="submit" value="提交注册 " class="registry"/>
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
		<script src="${ctx}/res/js/wanpin/register.js"></script>
	</body>

</html>