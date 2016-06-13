<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!doctype html>
<html  class="no-js" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1" />
		<meta name="referrer" content="always" />
		<meta name="format-detection" content="telephone=no" />
		<title>首页</title>
		<link href="${ctx}/res/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="${ctx}/res/css/Engine.css">
		<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
	</head>
	<body style="overflow: hidden;">
		<div class="background">
		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="position: inherit;">
			<!--切换按钮-->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!--背景图-->
			<div class="carousel-inner">
				<div class="item active">
					<a href="${ctx}/${webAdminPath}/engine/golist.php"><img src="${ctx}/res/img/000.jpg" data-src=" " alt="First slide"></a>
				</div>
				<div class="item">
					<a href="${ctx}/${webAdminPath}/engine/golist.php"><img src="${ctx}/res/img/001.jpg" data-src="" alt="Second slide"></a>
				</div>
				<div class="item">
					<a href="${ctx}/${webAdminPath}/engine/golist.php"><img src="${ctx}/res/img/002.jpg" data-src="" alt="Third slide"></a>
				</div>
			</div>
		</div>
		<!--QQ-->
		<div class="qq">
			<div class="eject01">
				<img src="${ctx}/res/img/12.png" />
				<div class="Connectionbox01 Connection01">
					<ul>
						<li><a href="#">人力资源部</a></li>
						<li><a href="#">人力资源部</a></li>
						<li><a href="#">人力资源部</a></li>
						<li><a href="#">人力资源部</a></li>
						<li><a href="#">人力资源部</a></li>
						<li><a href="#">人力资源部</a></li>
					</ul>
				</div>
			</div>
			<div class="eject02">
				<img src="${ctx}/res/img/13.png" />
				<div class="Connectionbox01 Connectionbox02 Connection02">
					全国联系电话：<P>400-0214-5431</P>
				</div>
			</div>
		</div>
		<!--登録条-->
				<c:if test="${empty sessionScope.userInfo}">
		<div class="regsiter-warp">
			<div class="regsiter">
			<ul>
				<li class="active"><a href="${ctx}/${webAdminPath}/login/goLogin.php">登录</a></li>
				<li class="active02"><a href="${ctx}/${webAdminPath}/login/goRegister.php">注册</a></li>
				<!-- <li class="active03"><a href="#">中文版</a> / <a href="#">EngclsH</a></li> -->
			</ul>
		</div>
				</c:if>
		</div>
		<!--解决方案-->
		<div class="scheme">
			<img src="${ctx}/res/img/index-01.png"/>
		</div>
		<!--WPL图片-->
		<div class="logo">
			<img src="${ctx}/res/img/index-02.png"/>
		</div>
		</div>
		<script src="${ctx}/res/js/jquery.min.js"></script>
		<script src="${ctx}/res/js/bootstrap.min.js"></script>
	</body>

</html>