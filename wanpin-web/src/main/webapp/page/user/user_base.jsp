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
				<h1>首页>>个人中心>>基本信息</h1>
			</div>
			<div class="companyProfile">
				
				<jsp:include page="/page/user/user_left.jsp"></jsp:include>
				
				<div class="information">
					<!--头像——↓-->
					<div class="information-logo">
						<img src="${ctx}/res/img/0030.png" /><a href="#">上传头像</a>
					</div>
					<!--表单——↓-->
					<div class="information-warp">
						<form id="base_form" action="" method="post">
							
							<label for="user">手机号</label>
							<input type="text" value="${user.mobile}" disabled="disabled" /><br />
							<!-- <label for="email">级别</label>
							<input type="text"  value="" /><br /> -->
							<label for="comment">姓名</label>
							<input name="nickName" type="text"  value="${user.nickName}" />
    						<br />
    						<label for="comment">性别</label>
							<input type="radio" name="sex" class="nan" value="0" <c:if test="${empty user.sex or user.sex eq 0}">checked="checked"</c:if>/><span class="nanre">男</span>
							<input type="radio" name="sex" class="nan" value="1" <c:if test="${user.sex eq 1}">checked="checked"</c:if>/><span class="nanre">女</span>
							<input type="radio" name="sex" class="nan" value="2" <c:if test="${user.sex eq 2}">checked="checked"</c:if>/><span class="nanre">保密</span>
    						<br />
    						<label for="comment">出生年月</label>
    						<input name="birthday" type="text" onclick="WdatePicker();"  value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>" />
    						<br />
    						<label for="comment">微信</label>
    						<input name="weiXin" type="text"  value="${user.weiXin}" />
    						<br />
    						<label for="comment">QQ</label>
    						<input name="qq" type="text"  value="${user.qq}" />
    						<br />
    						<label for="comment">毕业学校</label>
    						<input name="university" type="text"  value="${user.university}" />
    						<br />
    						<label for="comment">学历</label>
    						<select name="education">
    						</select>
    						<br />
    						<label for="comment">公司</label>
    						<input name="company" type="text"  value="${user.company}" />
    						<br />
    						<label for="comment">职位</label>
    						<input name="position" type="text"  value="${user.position}" />
							<br />
							<input type="submit" id="sbutton" value="保 存" /><br />
						</form>
					</div>
					<!-- .information-warp -->
				</div>
				<!-- .information -->
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
		<script src="${ctx}/res/lib/jquery-validation/1.14.0/jquery.validate.min.js"></script>
		<script src="${ctx}/res/lib/jquery-validation/1.14.0/messages_zh.min.js"></script>
		<script src="${ctx}/res/lib/jquery-validation/1.14.0/validate-methods.js"></script>
		<script src="${ctx}/res/lib/My97DatePicker/WdatePicker.js"></script>
		<script src="${ctx}/res/js/wanpin/user_base.js"></script>
<script type="text/javascript">
$(function(){
	(function(){
		var $select = $("select[name='education']"),type=[];
		$.each(ALL_DICT.EDUCATION,function(idx,item){
			var selected = '';
			if ('${user.education}' == item['k']) {
				selected = 'selected';
			}
			type.push('<option ' + selected + ' value="' + item['k'] + '">' + item['v']+ '</option>');
		});
		$select.html(type.join(''));
	})();
});
</script>
	</body>

</html>