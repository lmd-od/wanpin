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
				<h1>首页>>个人中心>>我的建议</h1>
			</div>
			<div class="companyProfile">
				
				<jsp:include page="/page/user/user_left.jsp"></jsp:include>
				
					<div class="recommend-text">
						<textarea id="suggest" cols="60" rows="5"></textarea>
					</div>
					<div class="yijian">
						<a href="javascript:;">发表意见</a>
					</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
<script type="text/javascript">
	$("a","div.yijian").on("click",function(){
		var $div = $("#suggest"),val = $div.val();
		if (wanpin.utils.isEmpty(val)) {
			layer.msg("请输入投诉建议",{shift: 6});
			$div.focus();
			return false;
		}
		
		if (val.length > 500) {
			layer.msg("输入投诉建议内容过长",{shift: 6});
			$div.focus();
			return false;
		}
		
		wanpin.fly.json(ctx + '/' + webAdminPath + '/user/complain.php',{'suggest':val},function(result){
			if (result.status == 0) {
				layer.alert('投诉成功', {icon: 1} , function(index){
					window.location.reload();
					layer.close(index);
				});
			} else {
				layer.alert(result.msg || '投诉失败', {icon: 2});
			}
		});
	});
</script>
	</body>
</html>