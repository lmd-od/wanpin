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
			<div class="companyProfile profession-two">
				
				<jsp:include page="/page/about/about_left.jsp"></jsp:include>
				
				<div class="profession-two-map">
						<img src="${ctx}/res/img/34.png"/>
						<div class="profession-two-map-text">
							<P>上海</P>
							<P>联系电话：021-1545487</P>
							<P>邮编： 2000000</P>
							<P>地址：深圳市,话教程撒;的快乐哈速度就快了撒的撒冷地家啊说了大美女</P>
						</div>
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
	</body>

</html>