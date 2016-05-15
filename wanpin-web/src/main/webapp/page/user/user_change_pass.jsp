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
				<h1>首页>>个人中心>>基本信息</h1>
			</div>
			<div class="companyProfile">
				
				<jsp:include page="/page/user/user_left.jsp"></jsp:include>
				
				<div class="fl">
					<div class="changepassword">
					亲!可以直接在此修改您的密码
					</div>
					<!--表单——↓-->
					<div class="changepassword-warp">
						<form action="" method="post">
							<label for="user">当前密码</label>
							<input type="text" id=user name="user" value="" /><br />
							<label for="email">新密码</label>
							<input type="text" id=email name="email" value="" /><br />
							<label for="comment">确定新密码</label>
							<input type="text" id=email name="email" value="" />
    						<br />
    						<label for="comment">验证码</label>
    						<input type="text" id=email name="email" value="" />
							<br />
							<input type="submit" id="affirm" value="确认修改" /><br />
						</form>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
	</body>

</html>