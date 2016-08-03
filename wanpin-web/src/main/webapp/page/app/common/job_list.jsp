<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>招贤纳士 | 万品建筑视界</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">

		<!--标准mui.css-->
		<link rel="stylesheet" href="${ctx}/res/lib/MUI/css/mui.min.css">
		<!--App自定义的css-->
		<link rel="stylesheet" type="text/css" href="${ctx}/res/lib/MUI/css/app.css"/>
		<link rel="stylesheet" type="text/css" href="${ctx}/res/lib/MUI/css/wanpin/common.css"/>
		<style type="text/css">
			.mui-content {
				background-color: #efeff4;
			}
			
			.mui-content>.mui-card:first-child {
			    margin-top: 0px;
			}
			
			.mui-input-row label~span {
				padding: 7px 0px;
				line-height: 1.5;
			}
		</style>
	</head>

	<body>
		<div class="mui-content">
			<div class="mui-card">
				<div class="mui-card-header">职位：模型师</div>
				<div class="mui-content-padded" style="margin: 0px;margin-right: 15px;">
				<form class="mui-input-group">
					<div class="mui-input-row">
						<label>工作经验:</label>
						<span>三至六年</span>
					</div>
					<div class="mui-input-row">
						<label>学历要求:</label>
						<span>大专及以上学历</span>
					</div>
					<div class="mui-input-row">
						<label>薪酬:</label>
						<span>15K/月</span>
					</div>
					<div class="mui-input-row">
						<label>职位描述:</label>
						<span>初级模型师〉〉中级模型师〉〉高级模型师〉〉模型主管〉〉项目代总监≥〉项目总监〉〉副总经理〉〉分公司总理〉〉副总裁〉〉总裁〉〉董事长〉〉董事会〉〉股东会〉〉副总裁〉〉总裁〉〉董事长〉〉董事会〉</span>
					</div>
				</form>
			</div>
				<div class="mui-card-footer">投递简历:2209933733@qq.com</div>
			</div>
			<div class="mui-card">
				<div class="mui-card-header">职位：模型师</div>
				<div class="mui-content-padded" style="margin: 0px;margin-right: 15px;">
				<form class="mui-input-group">
					<div class="mui-input-row">
						<label>工作经验:</label>
						<span>三至六年</span>
					</div>
					<div class="mui-input-row">
						<label>学历要求:</label>
						<span>大专及以上学历</span>
					</div>
					<div class="mui-input-row">
						<label>薪酬:</label>
						<span>15K/月</span>
					</div>
					<div class="mui-input-row">
						<label>职位描述:</label>
						<span>初级模型师〉〉中级模型师〉〉高级模型师〉〉模型主管〉〉项目代总监≥〉项目总监〉〉副总经理〉〉分公司总理〉〉副总裁〉〉总裁〉〉董事长〉〉董事会〉〉股东会〉〉副总裁〉〉总裁〉〉董事长〉〉董事会〉</span>
					</div>
				</form>
			</div>
				<div class="mui-card-footer">投递简历:2209933733@qq.com</div>
			</div>
			<div class="mui-card">
				<div class="mui-card-header">职位：模型师</div>
				<div class="mui-content-padded" style="margin: 0px;margin-right: 15px;">
				<form class="mui-input-group">
					<div class="mui-input-row">
						<label>工作经验:</label>
						<span>三至六年</span>
					</div>
					<div class="mui-input-row">
						<label>学历要求:</label>
						<span>大专及以上学历</span>
					</div>
					<div class="mui-input-row">
						<label>薪酬:</label>
						<span>15K/月</span>
					</div>
					<div class="mui-input-row">
						<label>职位描述:</label>
						<span>初级模型师〉〉中级模型师〉〉高级模型师〉〉模型主管〉〉项目代总监≥〉项目总监〉〉副总经理〉〉分公司总理〉〉副总裁〉〉总裁〉〉董事长〉〉董事会〉〉股东会〉〉副总裁〉〉总裁〉〉董事长〉〉董事会〉</span>
					</div>
				</form>
			</div>
				<div class="mui-card-footer">投递简历:2209933733@qq.com</div>
			</div>
		</div>
		<script src="../js/mui.min.js"></script>
		<script type="text/javascript">
			// 加载滚动条
			mui('body').progressbar({
				progress: 0
			}).show();
			mui('body').progressbar().setProgress(20 + Math.round(Math.random()*20));
			document.onreadystatechange = function(){
				if (document.readyState == "uninitialized") {
					mui('body').progressbar().setProgress(0);
				} else if (document.readyState == "loading") {
					mui('body').progressbar().setProgress(35);
				} else if (document.readyState == "interactive") {
					mui('body').progressbar().setProgress(60 + Math.round(Math.random()*20));
				} else if (document.readyState == "complete") {
					mui('body').progressbar().hide();
				}
			}
		</script>
	</body>

</html>