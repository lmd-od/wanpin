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
				<h1>首页>>关于我们>>招贤纳士</h1>
			</div>
			<div class="companyProfile">
			
				<jsp:include page="/page/about/about_left.jsp"></jsp:include>
				
				<div class="recommend profession-right">
					<div class="headline">
						<ul>
							<li>职业名称</li>
							<li>工作经验(年)</li>
							<li>学历要求</li>
							<li>薪酬</li>
							<li class="active">生涯规划</li>
						</ul>
					</div>
					<div class="require">
						<ul>
							<li>模型师</li>
							<li>三至六年</li>
							<li>大专及以上</li>
							<li>面议</li>
							<!--文字超出一定的数量就会自动隐藏——↓-->
							<li class="active">
								初级模型师〉〉中级模型师〉〉高级模型师〉〉模型主管〉〉项目代总监≥〉项目总监〉〉副总经理〉〉分公司总理〉〉副总裁〉〉总裁〉〉董事长〉〉董事会〉〉股东会〉〉副总裁〉〉总裁〉〉董事长〉〉董事会〉</li>
						</ul>
					</div>
					<div class="require">
						<ul>
							<li>模型师</li>
							<li>三至六年</li>
							<li>大专及以上</li>
							<li>面议</li>
							<li class="active">
								初级模型师〉〉中级模型师〉〉高级模型师〉〉模型主管〉〉项目代总监≥〉项目总监〉〉副总经理〉〉分公司总理〉〉副总裁〉〉总裁〉〉董事长〉〉董事会〉〉股东会〉〉退休公司保留养老股分红</li>
						</ul>
					</div>
					<div class="require">
						<ul>
							<li>模型师</li>
							<li>三至六年</li>
							<li>大专及以上</li>
							<li>面议</li>
							<li class="active">
								初级模型师〉〉中级模型师〉〉高级模型师〉〉模型主管〉〉项目代总监≥〉项目总监〉〉副总经理〉〉分公司总理〉〉副总裁〉〉总裁〉〉董事长〉〉董事会〉〉股东会〉〉退休公司保留养老股分红</li>
						</ul>
					</div>
				</div>
				<div class="paging paging-one">
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