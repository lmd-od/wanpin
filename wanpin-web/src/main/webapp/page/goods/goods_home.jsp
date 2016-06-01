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
				<div class="active-content-header">
					<form action="" method="post" class="active-content-form">
						<div class="wei">
							<input type="text" placeholder="请输入您需要的风格关键字" class="active-content-text" />
						</div>
						<input type="image" name="" id="" value="" src="${ctx}/res/img/03.png" class="active-content-text-image" />
					</form>
					<a href="forum.html" class="active-content-text-button">充 值</a>
				</div>
				<div class="active-content-column">
					<h1>首页>>引擎>>搜索结果</h1>
					<div class="active-content-column-list">
						<ul class="list">
							<li><a href="#">风格</a></li>
							<li><a href="#">功能</a></li>
							<li><a href="#">层数</a></li>
							<li><a href="#">国别</a></li>
						</ul>
						<div class="active-content-warp">
							<ul class="list-01">
								<li><a href="#">地中海</a></li>
								<li><a href="#">意大利</a></li>
								<li><a href="#">法式</a></li>
								<li><a href="#">英试</a></li>
								<li><a href="#">德式</a></li>
								<li><a href="#">北美</a></li>
								<li><a href="#">新古典</a></li>
								<li><a href="#">新中式</a></li>
								<li><a href="#">现代主义</a></li>
								<li><a href="#">综和类</a></li>
							</ul>
							<ul class="list-02">
								<li><a href="#">居住</a></li>
								<li><a href="#">公共</a></li>
								<li><a href="#">工业</a></li>
								<li><a href="#">农业</a></li>
							</ul>
							<ul class="list-03">
								<li><a href="#">底层</a></li>
								<li><a href="#">多层</a></li>
								<li><a href="#">高层</a></li>
							</ul>
							<ul class="list-04">
								<li><a href="#">中国</a></li>
								<li><a href="#">美国</a></li>
								<li><a href="#">法国</a></li>
								<li><a href="#">印度</a></li>
								<li><a href="#">日本</a></li>
								<li><a href="#">more</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!--图片区——↓-->
				<div class="active-content-footer">
					<div class="logo-list-01">
                    	<ul>
						<li>
                            <a href="${ctx}/page/goods/goods_detail.jsp"><img src="${ctx}/res/img/Engine-li-img.png" /></a>
                            <span>￥1500</span>
                            <a href="${ctx}/page/goods/goods_detail.jsp">
                                <p>
                                    <b>Alvaro Siza.</b>
                                    <br /> 中国.水上大楼.混疑土.异形.办公
                                </p>
                            </a>
						</li>
                        </ul>
					</div>
				</div>
			</div>
			<!--翻页——↓-->
				<div id="page1" class="paging paging-two text-center">
				</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
		<script src="${ctx}/res/lib/laypage/1.3/laypage.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	//以下将以jquery.ajax为例，演示一个异步分页
	function demo(curr){
	    $.getJSON(ctx + '/' + webAdminPath + '/goods/query.php', {
	        pageNo: curr || 1 //向服务端传的参数，此处只是演示
	    }, function(res){
	        //此处仅仅是为了演示变化的内容
	        //var demoContent = (new Date().getTime()/Math.random()/1000)|0;
	        //document.getElementById('view1').innerHTML = res.content + demoContent;
	        console.log(res.result.totalPageNum);
	        //显示分页
	        laypage({
	            cont: $('#page1'), //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
	            skin: 'molv',
	            pages: 11, //通过后台拿到的总页数
	            curr: curr || 1, //当前页
	            jump: function(obj, first){ //触发分页后的回调
	                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
	                    demo(obj.curr);
	                }
	            }
	        });
	    });
	};
	//运行
	demo();
});		
</script>
	</body>

</html>