$(function(){
	$("#login_form").validate({
		rules: {
			mobile: {
				required: true,
				isMobile: true
			},
			password: {
				required: true
				//isPwd: true
			}/*,
			img_code: {
				required: true,
				maxlength: 4
			}*/
		},
		messages: {
			mobile: {
				required: '请输入手机号码'
			},
			password: {
				required: '请输入密码'
			}
		},
		submitHandler:function(form){
			wanpin.fly.ajaxSubmit({
				form: form,
				url: ctx+"/"+webAdminPath+"/login/login.php",
				success: function(res){
					if (res.status === 0) {//登录成功
						var redirectURL = decodeURIComponent(wanpin.utils.getValFromURL(location.href,'redirectURL'));
						location.href = redirectURL == ''?'/':ctx + redirectURL;
					} else {
						layer.alert(res.msg || '登录失败', {icon: 2});
					}
				}
			});
		}
	});
});