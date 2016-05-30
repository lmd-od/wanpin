$(function(){
	$("#register_form").validate({
		rules: {
			mobile: {
				required: true,
				isMobile: true
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