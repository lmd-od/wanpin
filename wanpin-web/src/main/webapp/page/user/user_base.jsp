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
						<form action="" method="post">
							<label for="user">登录账号</label>
							<input type="text"value="" /><br />
							<label for="email">级别</label>
							<input type="text"  value="" /><br />
							<label for="comment">姓名</label>
							<input type="text"  value="" />
							<select>
      							<option>公开</option>
      							<option>保密</option>
    						</select>
    						<br />
    						<label for="comment">电话</label>
    						<input type="text"  value="" />
							<select>
      							<option>公开</option>
      							<option>保密</option>
    						</select>
    						<br />
    						<label for="comment">性别</label>
							<input type="radio" class="nan"/><span class="nanre">男</span>
							<input type="radio" class="nv"/><span class="nvren">女</span>
							<select>
      							<option>公开</option>
      							<option>保密</option>
    						</select>
    						<br />
    						<label for="comment">出生年月</label>
    						<input type="text"  value="" />
							<select>
      							<option>公开</option>
      							<option>保密</option>
    						</select>
    						<br />
    						<label for="comment">微信</label>
    						<input type="text"  value="" />
							<select>
      							<option>公开</option>
      							<option>保密</option>
    						</select>
    						<br />
    						<label for="comment">QQ</label>
    						<input type="text"  value="" />
							<select>
      							<option>公开</option>
      							<option>保密</option>
    						</select>
    						<br />
    						<label for="comment">毕业学校</label>
    						<input type="text"  value="" />
							<select>
      							<option>公开</option>
      							<option>保密</option>
    						</select>
    						<br />
    						<label for="comment">学历</label>
    						<input type="text"  value="" />
							<select>
      							<option>公开</option>
      							<option>保密</option>
    						</select>
    						<br />
    						<label for="comment">公司</label>
    						<input type="text"  value="" />
							<select>
      							<option>公开</option>
      							<option>保密</option>
    						</select>
    						<br />
    						<label for="comment">职位</label>
    						<input type="text"  value="" />
							<select>
      							<option>公开</option>
      							<option>保密</option>
    						</select>
							<br />
							<input type="submit" id="sbutton" value="保 存" /><br />
						</form>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
	</body>

</html>