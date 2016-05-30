<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
		<link href="${ctx}/res/css/goods_detail.css" rel="stylesheet" type="text/css" >
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
						<input type="image" name="" id="" value="" src="${ctx}/res/img/03.png" class="active-content-text-image" />
					</form>
					<input type="button" name="" id="" value="充 值" class="active-content-text-button" />
				</div>
				<div class="active-content-column">
					<h1>首页>>方案>>搜索结果</h1>
					<div class="active-content-column-list">
						<ul class="list">
							<li><a href="#">风格</a></li>
							<li><a href="#">功能</a></li>
							<li><a href="#">层数</a></li>
							<li><a href="#">国别</a></li>
						</ul>
						<div class="active-content-warp">
							<ul class="list-01">
								<li><a href="#">地中海</a></li>
								<li><a href="#">意大利</a></li>
								<li><a href="#">法式</a></li>
								<li><a href="#">英试</a></li>
								<li><a href="#">德式</a></li>
								<li><a href="#">北美</a></li>
								<li><a href="#">新古典</a></li>
								<li><a href="#">新中式</a></li>
								<li><a href="#">现代主义</a></li>
								<li><a href="#">综和类</a></li>
							</ul>
							<ul class="list-02">
								<li><a href="#">居住</a></li>
								<li><a href="#">公共</a></li>
								<li><a href="#">工业</a></li>
								<li><a href="#">农业</a></li>
							</ul>
							<ul class="list-03">
								<li><a href="#">底层</a></li>
								<li><a href="#">多层</a></li>
								<li><a href="#">高层</a></li>
							</ul>
							<ul class="list-04">
								<li><a href="#">中国</a></li>
								<li><a href="#">美国</a></li>
								<li><a href="#">法国</a></li>
								<li><a href="#">印度</a></li>
								<li><a href="#">日本</a></li>
								<li><a href="#">more</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="picture-warp">
					<div class="picture">
						<div class="picture-logo">
							<div id=preview>
								<div class=jqzoom id=spec-n1><img src="${ctx}/res/img/43.png" jqimg="${ctx}/res/img/43.png" style="height: 312px;width: 655px;">
								</div>
								<div id=spec-n5>
									<div class=control id=spec-left>
										<img src="${ctx}/res/images/left.gif" style="width: 20px;height: 70px;margin: 0;" />
									</div>
									<div id=spec-list>
										<ul class=list-h>
											<li><img src="${ctx}/res/img/43.png"> </li>
											<li><img src="${ctx}/res/images/img02.jpg"> </li>
											<li><img src="${ctx}/res/images/img03.jpg"> </li>
											<li><img src="${ctx}/res/images/img04.jpg"> </li>
											<li><img src="${ctx}/res/images/img01.jpg"> </li>
											<li><img src="${ctx}/res/images/img02.jpg"> </li>
											<li><img src="${ctx}/res/images/img03.jpg"> </li>
											<li><img src="${ctx}/res/images/img04.jpg"> </li>
											<li><img src="${ctx}/res/images/img01.jpg"> </li>
											<li><img src="${ctx}/res/images/img02.jpg"> </li>
											<li><img src="${ctx}/res/images/img03.jpg"> </li>
											<li><img src="${ctx}/res/images/img04.jpg"> </li>
										</ul>
									</div>
									<div class=control id=spec-right>
										<img src="${ctx}/res/images/right.gif" style="width: 20px;height: 70px;margin: 0;" />
									</div>
								</div>
							</div>

						</div>
						<div class="introduce">
							<h1>意大利(底层)单层单体别墅</h1>
							<br />
							<div class="introduce-01">
								<em>要 求:</em><span>简单 复杂 精细</span>
							</div>
							<div class="introduce-02">
								<em>资 料:</em><span>CDA平面图 CDA立面图 手绘平面图 手绘细节图   整体参考图 细节参考图 草图大师粗模 草图大师细模</span>
							</div>
							<div class="introduce-03">
								<em>爱 好:</em><span>灰调 阳光 黄昏 夜景</span>
							</div>
							<div class="introduce-04">
								<em>角 度:</em><span>正左视角 正右视角 背左视角 背右视角</span>
							</div>
							<div class="goumai-warp">
								<P>￥1500</P>
								<a href="javascript:;" class="goumai">立即购买</a>
								<ul class="zhifu">
									<li><b>支付</b></li>
									<li><a href="#">微信支付</a></li>
									<li><a href="#">支付宝支付</a></li>
									<li><a href="#">余额支付</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="share">
						<ul class="share-list">
							<li><a href="#">收藏</a></li>
						</ul>
					</div>
				</div>
				<div class="flow">
					<img src="${ctx}/res/img/31.png" />
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
		<script src="${ctx}/res/js/jquery.pack.js" type=text/javascript></script>
		<script src="${ctx}/res/js/base.js" type=text/javascript></script>
		<script type=text/javascript>
			$(function() {
				$(".jqzoom").jqueryzoom({
					xzoom: 350,
					yzoom: 310,
					offset: 3,
					position: "right",
					preload: 1,
					lens: 1
				});
				$("#spec-list").jdMarquee({
					deriction: "left",
					width: 650,
					height: 77,
					step: 2,
					speed: 4,
					delay: 10,
					control: true,
					_front: "#spec-right",
					_back: "#spec-left"
				});
				$("#spec-list img").bind("mouseover", function() {
					var src = $(this).attr("src");
					$("#spec-n1 img").eq(0).attr({
						src: src.replace("\/n5\/", "\/n1\/"),
						jqimg: src.replace("\/n5\/", "\/n0\/")
					});
					$(this).css({
						"border": "2px solid #ff6600",
						"padding": "1px"
					});
				}).bind("mouseout", function() {
					$(this).css({
						"border": "1px solid #ccc",
						"padding": "2px"
					});
				});
				
			});
			
		</script>
		
		<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"6","bdPos":"right","bdTop":"100"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
		<SCRIPT src="${ctx}/res/js/lib.js" type=text/javascript></SCRIPT>
		<SCRIPT src="${ctx}/res/js/163css.js" type=text/javascript></SCRIPT>
	</body>

</html>