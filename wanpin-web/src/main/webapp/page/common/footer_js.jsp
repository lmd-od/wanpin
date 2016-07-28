<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<%-- <script src="${ctx}/res/lib/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="${ctx}/res/lib/form/jquery.form.js" type="text/javascript"></script>
<script src="${ctx}/res/lib/layer/2.3/layer.js" type="text/javascript"></script> --%>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/jquery.form/3.51/jquery.form.min.js"></script>
<script src="http://cdn.bootcss.com/layer/2.3/layer.js"></script>
<script src="${ctx}/res/js/wanpin/index.js?${version}" type="text/javascript"></script>
<script src="${ctx}/res/js/new_file.js" type="text/javascript" charset="utf-8"></script>
<script src="${ctx}/res/js/wanpin/config.js?${version}" type="text/javascript"></script>
<script type="text/javascript">
var ctx = '${ctx}';
var webAdminPath = '${webAdminPath}';
/* wanpin.util.Constants = {
	"STATIC_HOME": window.document.location.href.substring(0,window.document.location.href.indexOf(window.document.location.pathname)),
	"ctx": '${ctx}',
	"webAdminPath": '${webAdminPath}'
}; */
$(function(){
	$(".header-content-nav a").each(function(){
		var url = window.location.href;
		var cur = $(this).attr("href").substring(0,$(this).attr("href").lastIndexOf("."));
		if (url.indexOf(cur) > 0) {
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