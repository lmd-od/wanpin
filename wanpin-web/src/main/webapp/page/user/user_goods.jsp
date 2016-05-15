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
				<h1>首页>>个人中心>>我的方案订单</h1>
			</div>
			<div class="companyProfile">
				
				<jsp:include page="/page/user/user_left.jsp"></jsp:include>
				
				<div class="companyProfile-indent">
					<div class="recommend-warp">
						<ul>
							<li class="active"><a href="#">全部订单</a></li>
							<li><a href="#">待支付</a></li>
							<li><a href="#">待收货</a></li>
							<li><a href="#">待评价</a></li>
							<li><a href="#">已关闭</a></li>
						</ul>
						<form action="" method="post">
							<input type="text" placeholder="输入商品名称，商品编号，订单号" class="text"/>
							<input type="image" name="" id="" value="" src="${ctx}/res/img/03.png" class="image" />
						</form>
					</div>
					<div class="recommend-title">
						<ul>
							<li class="active">方案</li>
							<li>单价(元)</li>
							<li>数量</li>
							<li>实付款(元)</li>
							<li>方案状态</li>
							<li>剩余时间</li>
							<li>方案操作</li>
						</ul>
					</div>
					<div class="all-warp">
						<div class="all">
							<input type="checkbox" /><span>全部</span>
						</div>
						<div class="nextpage">
							<a href="#">上</a>/
							<a href="#">下一页</a>
						</div>
					</div>
					<div class="all-warp-list">
						<div class="all-warp">
							<div class="all">
								<input type="checkbox" /><span>2016-04-30订单号：123456789</span>
							</div>
							<div class="nextpage">
								<a href="#">评价</a>
							</div>
						</div>
						<div class="all-warp-list-logo">
							<ul>
								<li class="active"><img src="${ctx}/res/img/0369_03.png"/><span>意意大利(底层)单层体别墅</span></li>
								<li class="active-06">￥1500</li>
								<li class="active-05">1</li>
								<li class="active-04">￥1800</li>
								<li class="active-01">模型(已确定)<br />渲染(调整中)<br />后期(未开始)<br />发出成品(未发)</li>
								<li class="active-02">0<br />1小时<br />12小时<br />13小时</li>
								<li class="active-03"><a href="#">再次购买</a><br /><a href="#">删除订单</a></li>
							</ul>
						</div>
					</div>
					<div class="all-warp-list">
						<div class="all-warp">
							<div class="all">
								<input type="checkbox" /><span>2016-04-30订单号：123456789</span>
							</div>
							<div class="nextpage">
								<a href="#">评价</a>
							</div>
						</div>
						<div class="all-warp-list-logo">
							<ul>
								<li class="active"><img src="${ctx}/res/img/0369_03.png"/><span>意意大利(底层)单层体别墅</span></li>
								<li class="active-06">￥1500</li>
								<li class="active-05">1</li>
								<li class="active-04">￥1800</li>
								<li class="active-01">模型(已确定)<br />渲染(调整中)<br />后期(未开始)<br />发出成品(未发)</li>
								<li class="active-02">0<br />1小时<br />12小时<br />13小时</li>
								<li class="active-03"><a href="#">再次购买</a><br /><a href="#">删除订单</a></li>
							</ul>
						</div>
					</div>
					<div class="all-warp-list">
						<div class="all-warp">
							<div class="all">
								<input type="checkbox" /><span>2016-04-30订单号：123456789</span>
							</div>
							<div class="nextpage">
								<a href="#">评价</a>
							</div>
						</div>
						<div class="all-warp-list-logo">
							<ul>
								<li class="active"><img src="${ctx}/res/img/0369_03.png"/><span>意意大利(底层)单层体别墅</span></li>
								<li class="active-06">￥1500</li>
								<li class="active-05">1</li>
								<li class="active-04">￥1800</li>
								<li class="active-01">模型(已确定)<br />渲染(调整中)<br />后期(未开始)<br />发出成品(未发)</li>
								<li class="active-02">0<br />1小时<br />12小时<br />13小时</li>
								<li class="active-03"><a href="#">再次购买</a><br /><a href="#">删除订单</a></li>
							</ul>
						</div>
					</div>
					<div class="all-warp-list">
						<div class="all-warp">
							<div class="all">
								<input type="checkbox" /><span>2016-04-30订单号：123456789</span>
							</div>
							<div class="nextpage">
								<a href="#">评价</a>
							</div>
						</div>
						<div class="all-warp-list-logo">
							<ul>
								<li class="active"><img src="${ctx}/res/img/0369_03.png"/><span>意意大利(底层)单层体别墅</span></li>
								<li class="active-06">￥1500</li>
								<li class="active-05">1</li>
								<li class="active-04">￥1800</li>
								<li class="active-01">模型(已确定)<br />渲染(调整中)<br />后期(未开始)<br />发出成品(未发)</li>
								<li class="active-02">0<br />1小时<br />12小时<br />13小时</li>
								<li class="active-03"><a href="#">再次购买</a><br /><a href="#">删除订单</a></li>
							</ul>
						</div>
					</div>
					<div class="all-warp-list">
						<div class="all-warp">
							<div class="all">
								<input type="checkbox" /><span>2016-04-30订单号：123456789</span>
							</div>
							<div class="nextpage">
								<a href="#">评价</a>
							</div>
						</div>
						<div class="all-warp-list-logo">
							<ul>
								<li class="active"><img src="${ctx}/res/img/0369_03.png"/><span>意意大利(底层)单层体别墅</span></li>
								<li class="active-06">￥1500</li>
								<li class="active-05">1</li>
								<li class="active-04">￥1800</li>
								<li class="active-01">模型(已确定)<br />渲染(调整中)<br />后期(未开始)<br />发出成品(未发)</li>
								<li class="active-02">0<br />1小时<br />12小时<br />13小时</li>
								<li class="active-03"><a href="#">再次购买</a><br /><a href="#">删除订单</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="paging">
					<ul>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">6</a></li>
						<li><a href="#">...</a></li>
						<li><a href="#">18</a></li>
						<li class="xiayiye"><a href="#">下一页</a></li>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
	</body>

</html>