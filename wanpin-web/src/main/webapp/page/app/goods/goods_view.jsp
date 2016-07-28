<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>${goodsInfo.goodsName} | 万品建筑视界</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">

		<!--标准mui.css-->
		<link rel="stylesheet" href="${ctx}/res/lib/MUI/css/mui.min.css">
		<!--App自定义的css-->
		<link rel="stylesheet" type="text/css" href="${ctx}/res/lib/MUI/css/app.css"/>
		<link rel="stylesheet" type="text/css" href="${ctx}/res/lib/MUI/css/wanpin/detail.css">
	</head>

	<body>
		<div id="slider" class="mui-slider" >
			<div class="mui-slider-group mui-slider-loop">
				<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一张轮播) -->
				<div class="mui-slider-item wanpin-slider-item mui-slider-item-duplicate">
					<a href="javascript:;">
						<img src="${imgPrefix}${goodsImages[fn:length(goodsImages)-1]}">
					</a>
				</div>
				<!-- 第一张 -->
				<c:forEach items="${goodsImages}" var="gi">
				<div class="mui-slider-item wanpin-slider-item">
					<a href="javascript:;">
						<img src="${imgPrefix}${gi}" data-preview-src="" data-preview-group="1">
					</a>
				</div>
				</c:forEach>
				<!-- 额外增加的一个节点(循环轮播：最后一个节点是第一张轮播) -->
				<div class="mui-slider-item wanpin-slider-item mui-slider-item-duplicate">
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
		<div class="mui-content">
			<h4>${goodsInfo.goodsName}</h4>
		</div>
		<div class="mui-content">
			<h4 class="h-style"><span><img src="${ctx}/res/lib/MUI/images/wanpin/yellow-block.png"/>&nbsp;&nbsp;具体介绍</span></h4>
		</div>
		<!-- 具体介绍begin -->
		<div id="engine-desc" class="mui-content">${goodsInfo.detail}</div>
		<!-- 具体介绍end -->
		<div class="mui-content">
			<h4 class="h-style"><span><img src="${ctx}/res/lib/MUI/images/wanpin/yellow-block.png"/>&nbsp;&nbsp;方案参数</span></h4>
		</div>
		<!-- 方案参数begin -->
		<div class="mui-content">
			<div class="mui-content-padded" style="margin: 5px;">
				<form class="mui-input-group">
					<div class="mui-input-row">
						<label>国别:</label>
						<span>${goodsInfo.countryName}</span>
					</div>
					<div class="mui-input-row">
						<label>风格:</label>
						<span>${goodsInfo.goodsStyleName}</span>
					</div>
					<div class="mui-input-row">
						<label>功能:</label>
						<span>${goodsInfo.goodsFunctionName}</span>
					</div>
					<div class="mui-input-row">
						<label>层数:</label>
						<span>${goodsInfo.goodsHierarchyName}</span>
					</div>
				</form>
			</div>
		</div>
		<!-- 方案参数end -->
		<div class="mui-content">
			<h4 class="h-style"><span><img src="${ctx}/res/lib/MUI/images/wanpin/yellow-block.png"/>&nbsp;&nbsp;购买流程</span></h4>
		</div>
		<!-- 购买流程begin -->
		<div class="mui-content">
			<p>
				<img src="${ctx}/res/lib/MUI/images/wanpin/img_liucheng_help.png" style="width: 100%" data-preview-src="" data-preview-group="1" />
			</p>
		</div>
		<!-- 购买流程end -->
		<script src="${ctx}/res/lib/MUI/js/mui.min.js"></script>
		<script src="${ctx}/res/lib/MUI/js/mui.zoom.js"></script>
		<script src="${ctx}/res/lib/MUI/js/mui.previewimage.js"></script>
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
			
			var desc = document.getElementById("engine-desc"),text = desc.textContent,arr = text.split('\n'),len = arr.length;
			if (len >0) {
				desc.innerHTML =  '<p class="text-desc">' + arr.join('</p><p class="text-desc">') + '</p>';
			}
			
			mui.previewImage();
		</script>
	</body>

</html>