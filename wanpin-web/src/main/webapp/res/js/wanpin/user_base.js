$(function(){
	$("#base_form").validate({
		rules: {
			nickName: {
				maxlength: 20
			},
			weiXin: {
				maxlength: 50
			},
			qq: {
				isQq: true
			},
			university: {
				maxlength: 50
			},
			company: {
				maxlength: 50
			},
			position: {
				maxlength: 50
			},
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
	
	var uploadHeadPhoto = new ImgFileUpload({
		id: 'file-head-upload',
		imgId: 'head-photo',
		server: ctx + '/' + webAdminPath + '/user/uploadHead.php',
		download: 'http://localhost:8080'
	});

	$(".information-logo").on('change',"#file-head-upload",function(){
		uploadHeadPhoto.init();
		$("#file-head-upload").replaceWith('<input id="file-head-upload" type="file" name="headPhoto" class="file" title="'+((new Date()).getMilliseconds())+'"></input>');
	});
});