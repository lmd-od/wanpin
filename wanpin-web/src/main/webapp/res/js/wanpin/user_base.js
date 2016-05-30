$(function(){
	$("#base_form").validate({
		rules: {
			sex: {
				required: true
			}
		},
		submitHandler:function(form){
			wanpin.fly.ajaxSubmit({
				form: form,
				url: ctx+"/"+webAdminPath+"/user/save.php",
				success: function(res){
					if (res.status === 0) {//保存成功
						layer.alert('保存成功', {icon: 1});
					} else {
						layer.alert(res.msg || '保存失败', {icon: 2});
					}
				}
			});
		}
	});
});