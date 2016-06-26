$(function(){
	$("#sendCode").on("click",function(){
		var $mobile = $("input[name='mobile']");
		var $img_code = $("input[name='img_code']");
		var $img_code_img = $("#img_code_img");
		var that = $(this);
		if (!$mobile.valid() || !$img_code.valid()) {
			return;
		}
		
		$(that).attr("disabled",true);
		var timeIndex = 60;
		var interval = setInterval(function(){
			$(that).val("(" + --timeIndex + ")秒后重新获取");
			if (timeIndex <= 0) {
				clearInterval(interval);
				$(that).val("获取验证码").removeAttr("disabled");
				timeIndex = 60;
			}
		},1000);
		
		wanpin.fly.json(ctx+"/"+webAdminPath+"/code/mobilecode.php",
		{
			'mobile': $mobile.val(),
			'imgcode': $img_code.val(),
			'codeType': $mobile.attr('code-type')
		},
		function(res){
			if (res.status == 0) {
				
			} else if(res.status == 2) {
				layer.msg(res.msg || '图形验证码无效',function(){});
				$img_code_img.click();
				clearInterval(interval);
				$(that).val("获取验证码").removeAttr("disabled");
			} else {
				layer.msg(res.msg || '发送短信验证码失败，请稍候重试',function(){});
				clearInterval(interval);
				$(that).val("获取验证码").removeAttr("disabled");
			}
		});
	});
});