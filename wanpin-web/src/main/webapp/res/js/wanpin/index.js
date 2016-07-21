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
                	//window.location.href = ctx + res.loginUrl;
                	wanpin.fly.login();
				} else {
					success && success(res);
				}
            }, error: function(){
                (options.error && options.error()) || layer.msg('请求异常，请重试', {shift: 6});
            }
        });
	},
	ajaxSubmit: function(options){
		console.log(this);
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
					//window.location.href = ctx + res.loginUrl;
					wanpin.fly.login();
				} else {
					options.success && options.success(res);
				}
			}
		});
	},
	login: function() {
		layer.open({
			title: '万品国际',
			type: 2,
			area: ['360px', '350px'],
			content: ctx+'/page/open_login.jsp'
		});
	}
};

wanpin.utils = {
	trim: function (str) {
        return str.replace(/(^[ \t\n\r]+)|([ \t\n\r]+$)/g, '');
    },
    isEmpty: function (obj) {
    	// this代表的是wanpin.utils
    	var self = this;
    	if(obj === undefined || obj === null || this.trim(obj) === '' ) {
    		return true;
    	}
    	return false;
    }
}

win.wanpin = wanpin;
}(window);

$(function(){
	$(".user_logout").on('click',function(){
		layer.confirm("确认退出？", {icon: 3, title:'提示'}, function(index){
			window.location.href = ctx + '/'+ webAdminPath +'/login/logout.php';
			layer.close(index);
		});
	});
});