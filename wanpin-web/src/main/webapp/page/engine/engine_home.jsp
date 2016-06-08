<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
<style type="text/css">
.active-content-warp li.active a {
color:red;
}
</style>
	</head>
	<body>
		<jsp:include page="/page/common/header.jsp"></jsp:include>
		<div class="article">
			<div class="active-content">
				<div class="active-content-header">
					<form action="" method="post" class="active-content-form">
						<div class="wei">
							<input type="text" placeholder="请输入您需要的风格关键字" class="active-content-text" />
						</div>
						<img alt="" id="search_btn" src="${ctx}/res/img/03.png" class="active-content-text-image">
					</form>
					<a href="forum.html" class="active-content-text-button">论 坛</a>
				</div>
				<div class="active-content-column">
					<h1>首页>>引擎>>搜索结果</h1>
					<div class="active-content-column-list">
						<ul class="list">
							<li><a href="#">风格</a></li>
							<li><a href="#">功能</a></li>
							<li><a href="#">层数</a></li>
							<li><a href="#">国别</a></li>
						</ul>
						<div class="active-content-warp">
							<ul class="list-01">
							</ul>
							<ul class="list-02">
							</ul>
							<ul class="list-03">
							</ul>
							<ul class="list-04">
							</ul>
						</div>
					</div>
				</div>
				<!--图片区——↓-->
				<div class="active-content-footer">
					<div class="logo-list-01">
					</div>
				</div>
			</div>
			<!--翻页——↓-->
			<div id="page1" class="paging paging-two text-center">
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
		<script src="${ctx}/res/lib/laypage/1.3/laypage.js" type="text/javascript"></script>
<script type="text/javascript">
var com;if (!com) com = {};else if (typeof com != "object")	throw new Error("com already exists and is not an object");	if (!com.wanpin) com.wanpin = {};else if (typeof com.wanpin != "object")	throw new Error("com.wanpin already exists and is not object");if (!com.wanpin.util) com.wanpin.util = {};else if (typeof com.wanpin.util != "object")	throw new Error("com.sinoiov.util already exists and is not object");
com.wanpin.util.Constants = {'search':'/engine/query.php'};
</script>
<script src="${ctx}/res/js/wanpin/config.js" type="text/javascript"></script>
<script src="${ctx}/res/js/wanpin/search.js" type="text/javascript"></script>
	</body>

</html>