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
		<div class="active-content">
			<div class="active-content-header">
				<form action="" method="post" class="active-content-form">
					<div class="wei">
						<input type="text" placeholder="请输入您需要的风格关键字" class="active-content-text" />
					</div>
					<input type="image" name="" id="" value="" src="${ctx}/res/img/03.png" class="active-content-text-image" />
				</form>
				<input type="button" name="" id="" value="论 坛" class="active-content-text-button" />
			</div>
			<div class="active-content-column">
				<h1>首页>>引擎>>搜索结果>>方案概述</h1>
				<div class="introduce-warp">
					<ul>
						<li>兼职师：HOK</li>
						<li>地址：阿塞拜藏,巴库</li>
						<li>建筑面积：234500.0spm</li>
						<li>项目年份：2013</li>
					</ul>
					<div class="introduce-warp-div">
						巴库对火的崇拜有着悠久的历史,被称为"永恒的火焰",而这为巴库开发标志性设计提供了灵感.巴库对火的崇拜有着悠久的历史,被称为"永恒的火焰",而这为巴库开发标志性设计提供了灵感.巴库对火的崇拜有着悠久的历史,被称为"永恒的火焰",而这为巴库开发标志性设计提供了灵感.巴库对火的崇拜有着悠久的历史,被称为"永恒的火焰",而这为巴库开发标志性设计提供了灵感.巴库对火的崇拜有着悠久的历史,被称为"永恒的火焰",而这为巴库开发标志性设计提供了灵感.巴库对火的崇拜有着悠久的历史,被称为"永恒的火焰",而这为巴库开发标志性设计提供了灵感.巴库对火的崇拜有着悠久的历史,被称为"永恒的火焰",而这为巴库开发标志性设计提供了灵感.巴库对火的崇拜有着悠久的历史,被称为"永恒的火焰",而这为巴库开发标志性设计提供了灵感.
					</div>
				</div>	
				<div class="rollabilitydiagram">
					<div class=rollabilitydiagram-logo id=spec-n1 >
						<img src="${ctx}/res/img/05.png" >
					</div>
					<div id=spec-n5>
						<div class=control id=spec-left>
							<img src="${ctx}/res/img/08.png" />
						</div>
						<div id=spec-list>
							<ul class=list-h>
								<li><img src="${ctx}/res/img/000.jpg"> </li>
								<li><img src="${ctx}/res/img/002.jpg"> </li>
								<li><img src="${ctx}/res/img/001.jpg"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
								<li><img src="${ctx}/res/img/0012.png"> </li>
							</ul>
						</div>
						<div class=control id=spec-right>
							<img src="${ctx}/res/img/09.png" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
		<script src="${ctx}/res/js/jquery-1.2.6.pack.js" type=text/javascript></script>
		<script src="${ctx}/res/js/base.js" type=text/javascript></SCRIPT>
		<script type=text/javascript>
			$(function() {
				$("#spec-list").jdMarquee({
					deriction: "left",
					width: 935,
					height:100,
					step: 2,
					speed:3,
					delay:10,
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
			})
		</script>
		<SCRIPT src="${ctx}/res/js/lib.js" type=text/javascript></SCRIPT>
		<SCRIPT src="${ctx}/res/js/163css.js" type=text/javascript></SCRIPT>
	</body>

</html>