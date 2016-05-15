<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<script src="${ctx}/res/lib/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$(".header-content-nav a").each(function(){
		var url = window.location.href;
		var cur = $(this).attr("href").substring(0,$(this).attr("href").lastIndexOf("."));
		if (url.indexOf(cur) >= 0) {
			$(this).closest("li").addClass("active");
		}
	});
	
	$(".companyProfile-left a").each(function(){
		var url = window.location.href;
		var cur = $(this).attr("href");
		if (url.indexOf(cur) >= 0) {
			$(this).closest("li").addClass("active");
		}
	});
	
	$(".sidebar a").each(function(){
		var url = window.location.href;
		var cur = $(this).attr("href");
		if (url.indexOf(cur) >= 0) {
			$(this).closest("li").addClass("active");
		}
	});
});
</script>