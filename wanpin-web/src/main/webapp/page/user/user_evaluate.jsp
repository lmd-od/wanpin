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
				<h1>首页>>个人中心>>评价晒单</h1>
			</div>
			<div class="companyProfile">
			
				<jsp:include page="/page/user/user_left.jsp"></jsp:include>
				
				<div class="fl">
					<div class="recommend-evaluate">
						<a href="#">评价内容</a>
					</div>
					<div class="recommend-evaluate-text">
						<textarea cols="60" rows="5"></textarea>
					</div>
					<div class="recommend-evaluate tupian">
						<a href="#">上传图片</a>
					</div>
					<div class="recommend-evaluate-img">
						<div class="logo-warp">
						<a href="#"><img src="${ctx}/res/img/0012.png"/></a>
						<a href="#"><img src="${ctx}/res/img/0012.png"/></a>
						<a href="#"><img src="${ctx}/res/img/0012.png"/></a>
						<a href="#"><img src="${ctx}/res/img/0012.png"/></a>
						</div>
						<div class="img-warp">
						<a href="#"><img src="${ctx}/res/img/10.png" class="img-warp-img"/></a>
						<p class="yijian"><a href="#">发表评论</a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
	</body>

</html>