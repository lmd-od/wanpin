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
		submitHandler:function(form){
			wanpin.fly.ajaxSubmit({
				form: form,
				url: ctx+"/"+webAdminPath+"/login/login.php",
				success: function(res){
					if (res.status === 0) {//登录成功
						//location.href = res.action?res.action:ctx;
						location.href = ctx;
					} else {
						layer.alert(res.msg || '登录失败', {icon: 2});
					}
				}
			});
		}
	});
});