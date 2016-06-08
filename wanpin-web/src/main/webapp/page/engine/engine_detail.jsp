<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
		<title>${goods.goodsName} | 万品国际</title>
		<link href="${ctx}/res/css/engine_detail.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="/page/common/header.jsp"></jsp:include>
		<div class="active-content">
			<div class="active-content-column">
				<h1>首页>>引擎>>方案概述</h1>
				<div class="introduce-warp">
					<ul>
						<li>兼职师：${goods.architect}</li>
						<li>地址：${goods.countryName}</li>
						<li>建筑面积：${goods.builtArea}㎡</li>
						<li>项目年份：${goods.projectYear}</li>
					</ul>
					<div class="introduce-warp-div">${goods.detail}</div>
				</div>
				<div class="rollabilitydiagram">
					<div class="wrap picshow">
						<div id=picarea>
							<div style="MARGIN: 0px auto; WIDTH:995px;  OVERFLOW: hidden">
								<div style="margin:0 auto; WIDTH: 995px;  OVERFLOW: hidden" id=bigpicarea>
									<P class=bigbtnPrev>
										<span id=big_play_prev></span>
									</P>
									<c:forEach items="${goodsImages}" var="gis" varStatus="vs">
									<div id="image_xixi-${vs.index}" class="image">
										<a href="#">
											<img alt="" src="${imgPrefix}${gis}">
										</a>
										<div class=word>
											<h3>${goods.goodsName}</h3>
										</div>
									</div>
									</c:forEach>
									<P class=bigbtnNext>
										<span id=big_play_next></span>
									</P>
								</div>
							</div>
							<div id=smallpicarea>
								<div id=thumbs>
									<ul>
										<li class="first btnPrev">
											<img id=play_prev src="${ctx}/res/img/08.png" style="width: 20px;height: 80px;">
										</li>
										<c:forEach items="${goodsImages}" var="gis" varStatus="vs">
										<li class="<c:if test="${vs.count eq fn:length(goodsImages)}">last_img</c:if> slideshowItem">
											<a id="thumb_xixi-${vs.index}" href="#">
												<img src="${imgPrefix}${gis}">
											</a>
										</li>
										</c:forEach>
										<li class="last btnNext">
											<img id=play_next src="${ctx}/res/img/09.png" style="width: 20px;height: 80px;">
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
		<SCRIPT type=text/javascript src="${ctx}/res/js/slide.js"></SCRIPT>
		<script>
			var target = [];
			for (var i = 0; i < parseInt('${fn:length(goodsImages)}'); i++) {
				target.push('xixi-' + i);
			}
		</script>
	</body>

</html>