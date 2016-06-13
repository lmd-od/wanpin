$(function(){
	$("#register_form").validate({
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
			password: {
				required: true,
				isPwd: true
			},
			repassword: {
				required: true,
				equalTo: '#password'
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
			password: {
				required: '请输入密码'
			},
			repassword: {
				required: '请输入确认密码',
				equalTo: '两次输入不一致，请重新输入'
			}
		},
		submitHandler:function(form){
			wanpin.fly.ajaxSubmit({
				form: form,
				url: ctx+"/"+webAdminPath+"/login/register.php",
				success: function(res){
					if (res.status === 0) {//注册成功
						layer.alert('注册成功', {icon: 1},function(index){
							location.href = ctx + res.url;
							layer.close(index);
						});
					} else {
						layer.alert(res.msg || '注册失败', {icon: 2});
					}
				}
			});
		}
	});
});