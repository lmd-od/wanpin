<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="/page/common/header.jsp"></jsp:include>
		<div class="article">
			<div class="active-content">
				<div class="active-content-column">
					<h1>首页>>互联</h1>
				</div>
				<div class="video-warp">
					<!--视屏放置区——↓-->
						<video src="${ctx}/res/video/02.mp4" controls autobuffer ></video>
				</div>
				<div class="download-warp">
                    <a href="#"><img src="${ctx}/res/img/42.png" class="download-warp-noe" /></a>
                    <a href="#"><img src="${ctx}/res/img/36.png" /></a>
				</div>
				<div class="xiazai-warp">
					<div class="xiazai-logo">
						<img src="${ctx}/res/img/38.png" />
						<img src="${ctx}/res/img/38.png" class="xiazai-logo-gs" />
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
	</body>

</html>