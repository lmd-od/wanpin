;!function(win){
var wanpin = {v: '1.0'};

wanpin.fly = {
	json: function(url,data,success,options){
		var that = this;
		options = options || {};
		data = $.extend({},{'ajax':'true','targetUrl':top.window.location.href},data || {});
		return $.ajax({
            type: options.type || 'post',
            dataType: options.dataType || 'json',
            data: data,
            url: url,
            beforeSend: function(){
            	options.beforeSend && options.beforeSend();
            },
            success: function(res){
                if (res.status === -2) {//登录超时
                	window.location.href = ctx + res.loginUrl;
				} else {
					success && success(res);
				}
            }, error: function(){
                (options.error && options.error()) || layer.msg('请求异常，请重试', {shift: 6});
            }
        });
	},
	ajaxSubmit: function(options){
		$(options.form).ajaxSubmit({
			url: options.url,
			data: {'ajax':'true','targetUrl':top.window.location.href},
			type: options.type || 'POST',
			dataType: options.dataType || 'json',
			beforeSubmit: function(){
				options.beforeSubmit && options.beforeSubmit();
			},
			success: function(res){
				if (res.status == -2) {//登录超时
					window.location.href = ctx + res.loginUrl;
				} else {
					options.success && options.success(res);
				}
			}
		});
	}
};

win.wanpin = wanpin;
}(window);

$(function(){
	$(".user_logout").on('click',function(){
		layer.confirm("确认退出？", {icon: 3, title:'提示'}, function(index){
			window.location.href = ctx + '/'+ webAdminPath +'/login/logout.do';
			layer.close(index);
		});
	});
});