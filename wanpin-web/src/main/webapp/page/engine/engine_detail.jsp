<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<jsp:include page="/page/common/meta.jsp"></jsp:include>
		<title>${goods.goodsName} | 万品国际</title>
	</head>
	<body>
		<jsp:include page="/page/common/header.jsp"></jsp:include>
		<div class="active-content">
			<div class="active-content-column">
				<h1>首页>>引擎>>方案概述</h1>
				<div class="introduce-warp">
					<ul>
						<li>建筑师：${goods.architect}</li>
						<li>地址：${goods.countryName}</li>
						<li>建筑面积：<c:choose><c:when test="${not empty goods.builtArea and goods.builtArea ne '0'}">${goods.builtArea}spm</c:when><c:otherwise>不详</c:otherwise></c:choose></li>
						<li>项目年份：${goods.projectYear}</li>
					</ul>
					<div class="introduce-warp-div">${goods.detail}</div>
				</div>
				<div class="rollabilitydiagram">
			<!--新改轮播图-->
			<div class="CarouselFigureContainer">
					<div class="Dot">
						<!--大图地址最好跟下面的第一张小图地址保持一致-->
						<img src="${imgPrefix}${goodsImages[0]}"/>
						<!--左右按钮-->
						<span id="STARTTQVaul"></span>
						<span id="RightButton"></span>
					</div>
					<div class="weiactive">
						<div class="warp-ul-dd">
							<ul id="PictureContainer">
							<c:forEach items="${goodsImages}" var="gis" varStatus="vs">
							<li <c:if test="${vs.index eq 0}">class="ul-li"</c:if>><img src="${imgPrefix}${gis}"/></li>
							
							</c:forEach>
						</ul>
						</div>
						<!--左右按钮-->
						<span id="left"></span>
						<span id="right"></span>
					</div>
			</div>
			<!--新改轮播图-->
				</div>
			</div>
		</div>
		<jsp:include page="/page/common/footer.jsp"></jsp:include>
		<jsp:include page="/page/common/footer_js.jsp"></jsp:include>
		<script type="text/javascript">
	(function  () {
		$('.Dot img').attr('src',$('#PictureContainer li img').eq(0).attr('src'))
		var 	shuci=0;
		var 	zhang=Math.floor($('.warp-ul-dd').width()/$('.weiactive li').width());
		var 	genshu=$('#PictureContainer li img').length;
		var 	left=0;
		var  yeshu=1;
		var	bbb=500;
		$('#RightButton,#right').click(function  () {we(200)})
		function  we(bbb) {
		if(!$('#PictureContainer').is(":animated"))	{
			$('.Dot img').stop(true,true)	
				$('#PictureContainer li').removeClass('ul-li')//删除class
				var  sud=Math.floor($('.weiactive li').width()+10);	////定义li宽度
				left-=sud;
				shuci++;
				var src=$('#PictureContainer li img').eq(shuci).attr('src');
				if(shuci==zhang*yeshu){
					$('#PictureContainer').animate({ marginLeft:left+"px"},500)
					yeshu++;
				}
				///---------------------
				if(shuci==genshu){
					$('#PictureContainer').animate({ marginLeft:"0px"},500)
					left=0;
					yeshu=1;
					var src=$('#PictureContainer li img').eq(0).attr('src');
				}
				$('.Dot img').fadeOut(bbb,function  () {$('.Dot img').attr('src',src)}).fadeIn(bbb);
				if(shuci==genshu){shuci=0;}
				$('#PictureContainer li').eq(shuci).addClass("ul-li");
				}
			}
		//----------------------------------------
		timoutide = setInterval(we, 3000);
		$('#RightButton,#STARTTQVaul,#PictureContainer,#left,#right').hover(function() { 
			clearInterval(timoutide);
		}, function() {
			clearInterval(timoutide);
			timoutide = setInterval(we,3000);
		});
		//------------------------
		$('#STARTTQVaul,#left').click(function () {
		if(!$('#PictureContainer').is(":animated"))	{
			$('.Dot img').stop(true,true,true)	
				if(shuci==0){
					var 	ulWidth=Math.floor($('.warp-ul-dd').width()*(genshu/zhang)-$('.weiactive li').width());
					$('#PictureContainer').animate({ marginLeft:"10px"},100)
					$('#PictureContainer').animate({ marginLeft:"0px"},100)
					shuci=0;
					left=0;
					var src=$('#PictureContainer li img').eq(0).attr('src');
				}else{
					if(shuci<0){
						shuci=0;
						left=0;
						var src=$('#PictureContainer li img').eq(0).attr('src');
				}
				$('#PictureContainer li').removeClass('ul-li')//删除class
				var  sud=Math.floor($('.weiactive li').width()+10);	////定义li宽度
				left+=sud;
				shuci--;
				var src=$('#PictureContainer li img').eq(shuci).attr('src');
					if(shuci==zhang-1){
						$('#PictureContainer').animate({ marginLeft:0+"px"},500)
						yeshu--;
					}else if(shuci==zhang*2-1){
						$('#PictureContainer').animate({ marginLeft:-sud*zhang+"px"},500)
						yeshu--;
					}else if(shuci==zhang*3-1){
						$('#PictureContainer').animate({ marginLeft:-sud*zhang*2+"px"},500)
						yeshu--;
					}else if(shuci==zhang*4-1){
						$('#PictureContainer').animate({ marginLeft:-sud*zhang*3+"px"},500)
						yeshu--;
					}else if(shuci==zhang*5-1){
						$('#PictureContainer').animate({ marginLeft:-sud*zhang*4+"px"},500)
						yeshu--;
					}else if(shuci==zhang*6-1){
						$('#PictureContainer').animate({ marginLeft:-sud*zhang*5+"px"},500)
						yeshu--;
					}else if(shuci==zhang*7-1){
						$('#PictureContainer').animate({ marginLeft:-sud*zhang*6+"px"},500)
						yeshu--;
					}
				if(shuci<0){
					shuci=0;
					left=0;
					yeshu=yeshu;
				}	
				if(shuci==genshu){shuci=0;}
				$('.Dot img').fadeOut(200,function  () {$('.Dot img').attr('src',src)}).fadeIn(200);
				$('#PictureContainer li').eq(shuci).addClass("ul-li");
				}
				}
			})
		//--------------------------------
			$('#PictureContainer li img').each(function  (index) {
				$(this).click(function  () {
					shuci=index;
					$('.Dot img').fadeOut(200,function  () {
						$('.Dot img').attr('src',$('#PictureContainer li img').eq(index).attr('src'))
					}).fadeIn(200);
					$('#PictureContainer li').removeClass('ul-li');     
					$('#PictureContainer li').eq(shuci).addClass("ul-li");
					var  sud=Math.floor($('.weiactive li').width());	////定义li宽度
					left=-sud*index;
				})
			})
		}());
		$(function(){
			(function(){
				var $div = $(".introduce-warp-div"),text = $div.text(),arr = text.split('\n'),len = arr.length;
				if(len > 0) {
					$div.html('<p>' + arr.join('</p><p>') + '</p>');
				}
			})();
		});
		</script>
	</body>

</html>