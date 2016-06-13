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
						<form id="changepwd" method="post">
							<label for="user">旧密码</label>
							<input type="text" name="oldpwd" value="" /><br />
							<label for="email">新密码</label>
							<input type="text" id="new-password" name="newpwd" value="" /><br />
							<label for="comment">再次确认密码</label>
							<input type="text" name="repwd" value="" />
    						<br />
							<input type="submit" id="affirm" value="确认修改" /><br />
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
<script type="text/javascript">
$(function(){
	$("#changepwd").validate({
		rules: {
			oldpwd: {
				required: true,
				isPwd: true
			},
			newpwd: {
				required: true,
				isPwd: true
			},
			repwd: {
				required: true,
				equalTo: '#new-password'
			}
		},
		messages: {
			oldpwd: {
				required: '请输入旧密码'
			},
			newpwd: {
				required: '请输入新密码'
			},
			repwd: {
				required: '请输入确认密码',
				equalTo: '两次输入不一致，请重新输入'
			}
		},
		submitHandler:function(form){
			wanpin.fly.ajaxSubmit({
				form: form,
				url: ctx+"/"+webAdminPath+"/user/changepwd.php",
				success: function(res){
					if (res.status === 0) {//登录成功
						layer.alert('修改密码成功', {icon: 1},function(index){
							location.href = res.action ? res.action : ctx + '/'+ webAdminPath +'/login/logout.php';
							layer.close(index);
						});
					} else {
						layer.alert(res.msg || '修改密码失败', {icon: 2});
					}
				}
			});
		}
	});
});
</script>
	</body>

</html>