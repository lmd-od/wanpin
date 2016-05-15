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
						<form action="${ctx}/page/user/user_base.jsp" method="post">
							<span class="wenben-01">
								用户名
							</span><input type="text" name="" id="" value="" placeholder="请填写注册或登录用的手机号" class="text"/>
							<input type="submit" value=" 新注册获取手机验证码 "  class="Captcha"/>
							<br /><br />
							<span class="wenben-02">密码</span>
							<input type="password" name=""  class="text"/>
							<br /><br /> 
							<span class="wenben-03">确定密码</span>
							<input type="password" name="" placeholder="已注册用户不用输入" class="text"/>
							<br /><br /> 
							<span class="wenben-04">验证码</span>
							<input type="text" name="" id="" value="" placeholder="已注册用户不用输入" class="text"/>
							<br /><br />
							<input type="submit" value=" 登录 " class="register"/>
							<input type="submit" value=" 提交注册 " class="registry"/>
						</form>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
	</body>

</html>