<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
<style type="text/css">
.spanstyle {
	width: 100px;
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
						<form id="forget_pwd_form" action="" method="post">
							<span class="spanstyle float-left">手机号码</span>
							<input type="text" name="mobile" code-type="FIND_PWD_VCODE" id="" value="" placeholder="请输入您的手机号码" class="text"/>
							<br /><br />
							<span class="spanstyle float-left">图形验证码</span>
							<input type="text" name="img_code" id="" value="" placeholder="请输入图形验证码" class="text float-left"/>
							<img alt="点击刷新验证码" id="img_code_img" class="float-left" src="${ctx}/${webAdminPath}/code/imgcode.php" onclick="this.src = '${ctx}/${webAdminPath}/code/imgcode.php?rnd' + Math.random();">
							<br /><br />
							<span class="spanstyle float-left">短信验证码</span>
							<input type="text" name="code" id="" value="" placeholder="请输入短信验证码" class="text float-left"/>
							<input type="button" id="sendCode" value="获取验证码 " class="Captcha float-left"/>
							<br /><br />
							<span class="spanstyle float-left">新密码</span>
							<input type="password" name="newpassword" id="newpassword" class="text" placeholder="请输入密码"/>
							<br /><br /> 
							<span class="spanstyle float-left">再次确认密码</span>
							<input type="password" name="repassword" placeholder="确认密码" class="text"/>
							<br /><br /> 
							<input type="submit" value="修改密码" class="registry"/>
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
		<script src="${ctx}/res/js/wanpin/code.js"></script>
<script type="text/javascript">
$(function(){
	$("#forget_pwd_form").validate({
		rules: {
			mobile: {
				required: true,
				isMobile: true
			},
			img_code: {
				required: true
			},
			code: {
				required: true
			},
			newpassword: {
				required: true,
				isPwd: true
			},
			repassword: {
				required: true,
				equalTo: '#newpassword'
			}
		},
		messages: {
			mobile: {
				required: '请输入手机号码'
			},
			img_code: {
				required: '请输入图形验证码'
			},
			code: {
				required: '请输入短信验证码'
			},
			newpassword: {
				required: '请输入新密码'
			},
			repassword: {
				required: '请输入确认密码',
				equalTo: '两次输入不一致，请重新输入'
			}
		},
		submitHandler:function(form){
			wanpin.fly.ajaxSubmit({
				form: form,
				url: ctx+"/"+webAdminPath+"/login/changepwd.php",
				success: function(res){
					if (res.status === 0) {// 修改密码成功
						layer.alert('修改密码成功', {icon: 1},function(index){
							location.href = res.action ? res.action : ctx + '/'+ webAdminPath +'/login/goLogin.php';
							layer.close(index);
						});
					} else {
						layer.msg(res.msg || '修改密码失败', function(){});
					}
				}
			});
		}
	});
});
</script>
	</body>

</html>