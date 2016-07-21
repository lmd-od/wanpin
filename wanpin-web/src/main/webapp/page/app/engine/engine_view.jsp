<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Hello MUI</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">

		<!--标准mui.css-->
		<link rel="stylesheet" href="${ctx}/res/lib/MUI/css/mui.min.css">
		<!--App自定义的css-->
		<link rel="stylesheet" type="text/css" href="${ctx}/res/lib/MUI/css/app.css"/>
		<style type="text/css">
			.text-desc {
				text-indent: 22px;
				padding: 0px 10px;
			}
			
			.mui-slider .mui-slider-group .mui-slider-item img {
				height: 260px;
			}
		</style>
	</head>

	<body>
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">${goodsInfo.goodsName}</h1>
		</header>
		<div id="slider" class="mui-slider" >
			<div class="mui-slider-group mui-slider-loop">
				<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一张轮播) -->
				<div class="mui-slider-item mui-slider-item-duplicate">
					<a href="javascript:;">
						<img src="${imgPrefix}${goodsImages[fn:length(goodsImages)-1]}">
					</a>
				</div>
				<!-- 第一张 -->
				<c:forEach items="${goodsImages}" var="gi">
				<div class="mui-slider-item">
					<a href="javascript:;">
						<img src="${imgPrefix}${gi}">
					</a>
				</div>
				</c:forEach>
				<!-- 额外增加的一个节点(循环轮播：最后一个节点是第一张轮播) -->
				<div class="mui-slider-item mui-slider-item-duplicate">
					<a href="javascript:;">
						<img src="${imgPrefix}${goodsImages[0]}">
					</a>
				</div>
			</div>
			<div class="mui-slider-indicator">
				<c:forEach items="${goodsImages}" var="gi" varStatus="vs">
				<div class="mui-indicator <c:if test="${vs.index eq 0}">mui-active</c:if>"></div>
				</c:forEach>
			</div>
		</div>
		<div id="engine-desc" class="mui-content">${goodsInfo.detail}</div>
		<script src="${ctx}/res/lib/MUI/js/mui.min.js"></script>
		<script type="text/javascript" charset="utf-8">
			// 加载滚动条
			mui('body').progressbar({
				progress: 0
			}).show();
			mui('body').progressbar().setProgress(20 + Math.round(Math.random()*20));
			document.onreadystatechange = function(){
				if (document.readyState == "uninitialized") {
					mui('body').progressbar().setProgress(0);
				} else if (document.readyState == "loading") {
					mui('body').progressbar().setProgress(35);
				} else if (document.readyState == "interactive") {
					mui('body').progressbar().setProgress(60 + Math.round(Math.random()*20));
				} else if (document.readyState == "complete") {
					mui('body').progressbar().hide();
				}
			}
			
			mui.init({
				swipeBack:true //启用右滑关闭功能
			});
			var slider = mui("#slider");
			slider.slider({
				interval: 2000
			});
			
			/*var $desc = $("#engine-desc"),text = $desc.text(),arr = text.split('\n'),len = arr.length;
			if (len >0) {
				$desc.html('<p class="text-desc">' + arr.join('</p><p class="text-desc">') + '</p>');
			}*/
			var desc = document.getElementById("engine-desc"),text = desc.textContent,arr = text.split('\n'),len = arr.length;
			if (len >0) {
				desc.innerHTML =  '<p class="text-desc">' + arr.join('</p><p class="text-desc">') + '</p>';
			}
		</script>
	</body>

</html>