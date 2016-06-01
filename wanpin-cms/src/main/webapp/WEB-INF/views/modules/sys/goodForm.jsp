<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>方案管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
	    i = 1;  
	    j = 1;
		$(document).ready(function() {
			$("#no").focus();
			
			 $("#btn_add1").click(function(){  
		            $("#newUpload1").after($('<div id="div_'+i+'" class="controls"><input  name="file" type="file"  /><input type="button" value="删除"  onclick="del_1('+i+')"/></div>'));  
		            i = i + 1;  
		        });  
		          
		});
		
		function del_1(o){  
			$("#div_"+o).remove();
		}  
		      
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/good/list">方案列表</a></li>
		<li class="active"><a href="#">方案添加</a></li>
	</ul><br/>
	
	<form:form id="inputForm" modelAttribute="good" action="${ctx}/sys/good/save" method="post" enctype="multipart/form-data" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>
		<div class="control-group">
			<label class="control-label">方案来源:</label>
			<div class="controls">
			<select name="goodsSource">
			  <option value="1" selected="selected">公司内部</option>
			  <option value="2">其他公司</option>
			</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">方案位置:</label>
			<div class="controls">
			<select name="goodsPlaces">
			  <option value="1" >搜索引擎</option>
			  <option value="2" selected="selected">方案商城</option>
			</select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">方案名称:</label>
			<div class="controls">
					<form:input path="goodsName" htmlEscape="false" maxlength="50" class="required"/>
					<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">金额:</label>
			<div class="controls">
				<form:input path="goodsMoney" htmlEscape="false" maxlength="50" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">国别:</label>
			<div class="controls">
				<select name="countryCode">
			       <option value="CHN" selected="selected">中国</option>
			       <option value="USA">美国</option>
			    </select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">方案风格:</label>
			<div class="controls">
				<select name="goodsStyle">
				   <c:forEach items="${dictStyles }" var="dictStyle">
				      <option value="${dictStyle.value }">${dictStyle.label }</option>
				   </c:forEach>
			    </select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">方案功能:</label>
			<div class="controls">
				<select name="goodsFunction">
				   <c:forEach items="${dictFunctions }" var="dictFunction">
				      <option value="${dictFunction.value }">${dictFunction.label }</option>
				   </c:forEach>
			    </select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">方案层数:</label>
			<div class="controls">
				<select name="goodsHierarchy">
				   <c:forEach items="${dictHierarchys }" var="dictHierarchy">
				      <option value="${dictHierarchy.value }">${dictHierarchy.label }</option>
				   </c:forEach>
			    </select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建筑师:</label>
			<div class="controls">
				<form:input path="architect" htmlEscape="false" maxlength="50" class="required userName"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">建筑面积:</label>
			<div class="controls">
				<form:input path="builtArea" htmlEscape="false" maxlength="50" class="required userName"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">项目年份:</label>
			<div class="controls">
				<input id=createdAt-id name="projectYear" type="text"  maxlength="20" class="input-mini Wdate"
				value="<fmt:formatDate  value="${log.beginDate}"  pattern="yyyy"/>" onclick="WdatePicker({dateFmt:'yyyy',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
		    <label class="control-label">方案图片:</label>
		    <div id="newUpload1"  class="controls">
		        <input type="file" name="file">  
                <input type="button" id="btn_add1" value="增加一行" > 
		    </div>
             
		</div>
		<div class="control-group">
			<label class="control-label">方案详情:</label>
			<div class="controls">
				<form:textarea path="detail" htmlEscape="false" rows="6" maxlength="400" class="input-xlarge"/>
			</div>
		</div>
		
		<div class="form-actions">
			<shiro:hasPermission name="sys:user:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>