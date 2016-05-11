<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!doctype html>
<html  class="no-js" lang="en">
	<head>
		<meta charset="UTF-8">
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
					<a href="${ctx}/page/engine/engine.jsp"><img src="${ctx}/res/img/000.jpg" data-src=" " alt="First slide"></a>
				</div>
				<div class="item">
					<a href="${ctx}/page/engine/engine.jsp"><img src="${ctx}/res/img/001.jpg" data-src="" alt="Second slide"></a>
				</div>
				<div class="item">
					<a href="${ctx}/page/engine/engine.jsp"><img src="${ctx}/res/img/002.jpg" data-src="" alt="Third slide"></a>
				</div>
			</div>
		</div>
		<!--QQ-->
		<div class="qq">
			<a href="#"><img src="${ctx}/res/img/12.png" /></a>
			<a href="#"><img src="${ctx}/res/img/13.png" /></a>
		</div>
		<!--登録条-->
		<div class="regsiter">
			<ul>
				<li class="active"><a href="#">登录</a></li>
				<li class="active02"><a href="#">注册</a></li>
				<li class="active03"><a href="#">中文版</a>/<a href="#">EngclsH</a></li>
			</ul>
		</div>
		<!--解决方案-->
		<div class="scheme">
			<div class="scheme-warp">
				<P class="p1">高效·创新·颠覆</P>
				<P class="p2">建筑可视化解决方案</P>
				<P class="p3">专业运营商</P>
			</div>
		</div>
		<!--WPL图片-->
		<div class="logo">
			<img src="${ctx}/res/img/01.png" /><em>上海万品数据有限公司</em>
		</div>
		</div>
		<script src="${ctx}/res/js/jquery.min.js"></script>
		<script src="${ctx}/res/js/bootstrap.min.js"></script>
	</body>

</html>