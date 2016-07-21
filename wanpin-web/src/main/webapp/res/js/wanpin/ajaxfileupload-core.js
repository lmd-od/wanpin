/**
 * <p>Title:万品数字科技</p>
 * <p>Description:图片上传组件</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * var fileLoad=new ImgFileUpload({
  	id:"fileId",
  	imgId:"显示img图片的容器Id",
  	fileTypes:上传的文件类型，默认：jpg,jpeg,png,bmp,gif，多个以‘,’分隔。例如：jpg,jpeg,png,bmp,gif。
  	size:上传的文件大小，默认：3M。
  	download:图片前缀域名
  	});
			  fileLoad.init();
 * @author李泰然
 * @version 1.0 2016-07-14
 * 
 */
var ImgFileUpload = function(settings) {
	this.options = $.extend({},{'size': 3,'download':'http://res.wanpin.sh'},settings);
}

ImgFileUpload.prototype = {
	init: function(){
		var self = this;
		self._renderContainer();
	},
	_renderContainer: function(){
		var self = this;
		var fileValue = $("#" + self.options.id).val().toLowerCase();
		if (fileValue == "") {
			layer.msg("请选择图片！");
			return false;
		}
		if (!/\.(jpg|jpeg|png|bmp|gif)$/.test(fileValue)) {
			layer.msg("图片类型必须是jpg,jpeg,png,bmp,gif中的一种！");
			return false;
		}
		self._upload();
	},
	_upload: function(){
		var self = this;
		var url = this.options.server;
		if(!url) {
			url = ctx + "/" + webAdminPath + "";
		}
		
		$.ajaxFileUpload({
			url: url,
			type: 'post',
			secureuri: false, //一般设置为false
			fileElementId: self.options.id, //文件上传空间的id属性  <input type="file" id="file" name="file" />
			dataType: 'json', //返回值类型，一般设置为json、application/json
			data: $.extend({},{'ajax':'true'},self.options.data || {}),
			success: function(data, status) {
				var obj = data;
				if(data.statusCode == '0') {
					$("#"+self.options.imgId).attr('src',self.options.download+data.data.headPhoto);
				} else if(data.statusCode == '32001') {
					layer.msg(data.errorMsg || '上传文件为空');
				} else if(data.statusCode == '32002') {
					layer.msg(data.errorMsg || '上传文件不能大于' + self.options.size + 'M');
				} else if(data.statusCode == '32003') {
					layer.msg(data.errorMsg || '上传文件扩展名不支持');
				} else if(data.statusCode == '32010') {
					layer.msg(data.errorMsg || '上传文件失败');
				} else if(data.status === -2) {
					wanpin.fly.login();
				} else {
					layer.msg('系统繁忙，请稍后重试！');
				}
			}
		});
	}
}