<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<c:if test="${not empty result.queryList}">
<ul>
<c:forEach items="${result.queryList}" var="gl">
	<li><a href="${ctx}/page/goods/goods_detail.jsp" target="_blank"><img
			src="${imgPrefix}${gl.goodsCover}" /></a> <span>￥${gl.goodsMoney}</span> <a
		href="${ctx}/page/goods/goods_detail.jsp"  target="_blank">
			<p>
				<b>${gl.goodsName}</b> <br /> ${gl.countryName}.${gl.goodsFunctionName}.${gl.goodsHierarchyName}.${gl.goodsStyleName}
			</p>
	</a></li>
</c:forEach>
</ul>
<input type="hidden" id="totalPageNum" value="${result.totalPageNum}">
</c:if>