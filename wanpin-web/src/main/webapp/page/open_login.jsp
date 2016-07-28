<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>登录页面 | 万品国际</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="${ctx}/res/lib/bootstrap/3.3.6/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link href="http://cdn.bootcss.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- Ionicons -->
  <link href="http://cdn.bootcss.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet">
  <!-- Theme style -->
  <link rel="stylesheet" href="${ctx}/res/lib/AdminLTE/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${ctx}/res/lib/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <style type="text/css">
  .error {color:red;}
  </style>
</head>
<body class="hold-transition" style="font-family: '微软雅黑'">
<div class="login-box-body">
    <p class="login-box-msg">账户登录</p>

    <form id="login_form" method="post">
      <div class="form-group has-feedback">
        <input type="text" name="mobile" class="form-control" placeholder="手机号">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" class="form-control" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
      	<div class="col-xs-4"><a href="${ctx}/${webAdminPath}/login/goForgetPwd.php" id="forget_pwd">忘记密码?</a><br></div>
      	<div class="col-xs-4 col-xs-offset-4 text-right"><a href="javascript:;" id="register">注册</a></div>
      </div>
      <br>
      <!-- .row -->
      <div class="row">
        <!-- <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> Remember Me
            </label>
          </div>
        </div> -->
        <!-- /.col -->
        <div class="col-xs-8 col-xs-offset-2">
          <button type="submit" class="btn btn-primary btn-block btn-flat">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
  </div>
<!-- /.login-box -->

<!-- jQuery 1.11.3 -->
<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
<!-- Bootstrap 3.3.6 -->
<script src="${ctx}/res/lib/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${ctx}/res/lib/iCheck/icheck.min.js"></script>

<script src="${ctx}/res/lib/jquery-validation/1.14.0/jquery.validate.min.js"></script>
<script src="${ctx}/res/lib/jquery-validation/1.14.0/messages_zh.min.js"></script>
<script src="${ctx}/res/lib/jquery-validation/1.14.0/validate-methods.js"></script>
<script>
  $(function () {
	  $.validator.setDefaults({
			highlight : function(element) {  
		        $(element).closest('.form-group').addClass('has-error');  
		    },
		    success : function(label) {  
		        $(label).closest('.form-group').removeClass('has-error');  
		        $(label).remove();  
		    }
		});  
	
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
    
    $("#login_form").validate({
		rules: {
			mobile: {
				required: true,
				isMobile: true
			},
			password: {
				required: true
				//isPwd: true
			}
		},
		submitHandler:function(form){
			wanpin.fly.ajaxSubmit({
				form: form,
				url: ctx+"/"+webAdminPath+"/login/login.php",
				success: function(res){
					if (res.status === 0) {//登录成功
						top.window.location.href = top.window.location.href;
					} else {
						layer.alert(res.msg || '登录失败', {icon: 2});
					}
				}
			});
		}
	});
    
    $("#register").on("click",function(){
    	top.window.location.href = ctx + '/' + webAdminPath + '/login/goForgetPwd.php';
    });
    
    $("#forget_pwd").on("click",function(){
    	top.window.location.href = ctx + '/' + webAdminPath + '/login/goRegister.php';
    });
  });
</script>
</body>
</html>