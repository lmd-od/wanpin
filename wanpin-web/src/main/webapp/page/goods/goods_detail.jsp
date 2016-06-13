<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
		<title>${goods.goodsName} | 万品国际</title>
		<link href="${ctx}/res/css/goods_detail.css" rel="stylesheet" type="text/css" >
	</head>
	<body>
		<jsp:include page="/page/common/header.jsp"></jsp:include>
		<div class="article">
			<div class="active-content">
				<div class="active-content-column">
					<h1>首页>>方案商城>>方案详情</h1>
				</div>
				<div class="picture-warp">
					<div class="picture">
						<div class="picture-logo">
							<div id=preview>
								<div class=jqzoom id=spec-n1><img src="${imgPrefix}${goodsImages[0]}" jqimg="${imgPrefix}${goodsImages[0]}" style="height: 312px;width: 655px;">
								</div>
								<div id=spec-n5>
									<div class=control id=spec-left>
										<img src="${ctx}/res/images/left.gif" style="width: 20px;height: 70px;margin: 0;" />
									</div>
									<div id=spec-list>
										<ul class=list-h>
										<c:forEach items="${goodsImages}" var="gis">
											<li><img src="${imgPrefix}${gis}"> </li>
										</c:forEach>
										</ul>
									</div>
									<div class=control id=spec-right>
										<img src="${ctx}/res/images/right.gif" style="width: 20px;height: 70px;margin: 0;" />
									</div>
								</div>
							</div>

						</div>
						<div class="introduce">
							<h1>${goods.goodsName}</h1>
							<br />
							<div class="introduce-01">
								<em>国 别:</em><span>${goods.countryName}</span>
							</div>
							<div class="introduce-02">
								<em>风 格:</em><span>${goods.goodsStyleName}</span>
							</div>
							<div class="introduce-03">
								<em>功 能:</em><span>${goods.goodsFunctionName}</span>
							</div>
							<div class="introduce-04">
								<em>层 数:</em><span>${goods.goodsHierarchyName}</span>
							</div>
							<div class="goumai-warp">
								<P>￥${goods.goodsMoney}</P>
								<a href="javascript:;" class="goumai">立即购买</a>
								<ul class="zhifu">
									<li><b>支付</b></li>
									<li><a href="javascript:;">微信支付</a></li>
									<li><a href="javascript:;">支付宝支付</a></li>
									<li><a href="javascript:;">余额支付</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="share">
						<ul class="share-list">
							<li style="margin-top:5px;"><a onclick="collect();" id="collect_btn" data-id="${goods.goodsId}" collect="0" href="javascript:;">收藏</a></li>
						<div class="bdsharebuttonbox"><a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>
						<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"24"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
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
			
			
			function collect(){
				var $a = $('#collect_btn');
				wanpin.fly.json(ctx + '/' + webAdminPath + '/user/collect.php',{'id':$a.attr('data-id')},function(res){
					if(res.status == 0) {
						if($a.attr('collect') == 0) {
							$a.attr('collect','1').text('已收藏');
						} else {
							$a.attr('collect','0').text('收藏');
						}
					}
				});
			}
		</script>
		
		<SCRIPT src="${ctx}/res/js/lib.js" type=text/javascript></SCRIPT>
		<SCRIPT src="${ctx}/res/js/163css.js" type=text/javascript></SCRIPT>
		<script src="${ctx}/res/js/wanpin/detail.js" type="text/javascript"></script>
	</body>

</html>