<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>方案管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
		function page(n,s){
			if(n) $("#pageNo").val(n);
			if(s) $("#pageSize").val(s);
			$("#searchForm").attr("action","${ctx}/sys/good/list");
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/good/list">方案列表</a></li>
		<li><a href="${ctx}/sys/good/form">方案添加</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="good"
		action="${ctx}/sys/good/list" method="post"
		class="breadcrumb form-search ">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>方案ID</th>
				<th>方案来源</th>
				<th>方案状态</th>
				<th>方案名</th>
				<th>金额</th>
				<th>封面</th>
				<th>国别</th>
				<th>建筑师</th>
				<th>建筑面积</th>
				<th>项目年份</th>
				<th>创建用户</th>
				<th>创建时间</th>
				<th>修改时间</th>
				<shiro:hasPermission name="sys:good:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="good">
				<tr>
					<td>${good.goodsId }</td>
					<td><c:if test="${good.goodsSource == 1}">
				  公司内部
				</c:if> <c:if test="${good.goodsSource == 2}">
				  其他公司
				</c:if></td>

					<td><c:if test="${good.goodsStatus == 1}">
				   草稿
				</c:if> <c:if test="${good.goodsStatus == 2}">
				   待审核
				</c:if> <c:if test="${good.goodsStatus == 3}">
				   审核通过
				</c:if> <c:if test="${good.goodsStatus == 4}">
				   审核不通过
				</c:if> <c:if test="${good.goodsStatus == 5}">
				   已下架
				</c:if></td>
					<td>${good.goodsName }</td>
					<td>${good.goodsMoney }</td>
					<td><img src="<%=url%>${good.goodsCover }" style="max-height: 100px;"></td>
					<td>${good.countryName }</td>
					<td>${good.architect }</td>
					<td>${good.builtArea }</td>
					<td>${good.projectYear }</td>
					<td>${good.createUser.name }</td>
					<td><fmt:formatDate value="${good.createTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${good.updateTime}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<shiro:hasPermission name="sys:user:edit">
						<td><a href="${ctx}/sys/user/form?id=${user.id}">修改</a> <a
							href="${ctx}/sys/good/delete?goodsId=${good.goodsId }"
							onclick="return confirmx('确认要删除该方案吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>