<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
<style type="text/css">
.laypageskin_molv a {
    background-color: #dcdddd !important;
}
.image {
	cursor: pointer;
}
.goods-list {
	border: 1px solid #bcc5d0;
    margin-top: 10px;
    border-radius: 3px;
    padding: 5px 0px 2px 0px;
}

</style>
	</head>
	<body>
		<jsp:include page="/page/common/header.jsp"></jsp:include>
		<div class="article">
			<div class="active-content">
				<h1>首页>>个人中心>>我的收藏</h1>
			</div>
			<div class="companyProfile">
				
				<jsp:include page="/page/user/user_left.jsp"></jsp:include>
				
				<div class="all-warp-list all-warp-list-two wdsc">
					<div class="recommend-warp-two recommend-warp">
						<form action="" method="post">
							<input id="search_1" type="text" placeholder="输入引擎名称" class="text"/>
							<img data-type="1" src="${ctx}/res/img/03.png" class="image">
						</form>
					</div>
					<div class="enshrine">
						<P><a href="">引擎收藏</a></P>
					</div>
					<div id="engine-list" class="recommend-img">
					</div>
					<div id="page1" class="paging text-center"></div>
				</div>
				<div class="collect">
					<div class="recommend-warp recommend-warp-two">
						<form action="" method="post">
							<input id="search_2" type="text" placeholder="输入方案名称" class="text"/>
							<img data-type="2" src="${ctx}/res/img/03.png" class="image">
						</form>
					</div>
					<div class="Mallcollection">
						<P><a href="#">商城收藏</a></P>
					</div>
					<div id="goods-list"></div>
					<div id="page2" class="fanye"></div>
				</div>
			</div>	
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
		<script src="${ctx}/res/lib/laypage/1.3/laypage.js" type="text/javascript"></script>
		<script src="${ctx}/res/lib/laytpl/1.1/laytpl.js" type="text/javascript"></script>
		<script src="${ctx}/res/js/wanpin/collect.js" type="text/javascript"></script>
<script id="engine-demo" type="text/html">
{{# for(var i = 0, len = d.length; i < len; i++){ }}
<div class="recommend-img-01">
	<a href="${ctx}/${webAdminPath}/engine/info/{{ d[i].goodsId }}.php" target="_blank"><img src="${imgPrefix}{{ d[i].goodsCover }}"/></a>
	<figcaption class="figcaption">
		<a href="${ctx}/${webAdminPath}/engine/info/{{ d[i].goodsId }}.php" target="_blank">
		<P title="{{ d[i].goodsName }}">
			<b><b>{{ d[i].goodsName }}</b></b>
		</P>
		</a>
	</figcaption>
</div>
{{# } }}
</script>
<script id="goods-demo" type="text/html">
{{# for(var i = 0, len = d.length; i < len; i++){ }}
<div class="Mallcollection-logo">
	<a href="${ctx}/${webAdminPath}/goods/info/{{ d[i].goodsId }}.php" target="_blank"><img src="${imgPrefix}{{ d[i].goodsCover }}"/></a>
	<P>{{ d[i].goodsName }}<br />￥<b>{{ d[i].goodsMoney }}</b></P>
</div>
{{# } }}
</script>
	</body>

</html>