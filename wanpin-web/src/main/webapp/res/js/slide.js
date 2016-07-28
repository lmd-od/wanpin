var timer = null;
var offset = 5000;
var index = 0;
var  shuci=$('#thumbs ul li').length-3;

//��ͼ�����ֻ�

//$('#thumbs ul li').each(function  (index) {
//	console.log(index)
//})
function slideImage(i){
    var id = 'image_'+ target[i];
    $('#'+ id)
        .animate({opacity: 1}, 800, function(){
            $(this).find('.word').animate({height: 'show'}, 'slow');
        }).show()
        .siblings(':visible')
        .find('.word').animate({height: 'hide'},'fast',function(){
            $(this).parent().animate({opacity: 0}, 800).hide();
        });
}
//bind thumb a
function hookThumb(){    
    $('#thumbs li a')
        .bind('click', function(){
            if (timer) {
                clearTimeout(timer);
            }                
            var id = this.id;            
            index = getIndex(id.substr(shuci));
            rechange(index);
            slideImage(index); 
            timer = window.setTimeout(auto, offset);  
            this.blur();            
            return false;
        });
}
//bind next/prev img
function hookBtn(){
    $('#thumbs li img').filter('#play_prev,#play_next')
        .bind('click', function(){
            if (timer){
                clearTimeout(timer);
            }
            var id = this.id;
            if (id == 'play_prev') {
                index--;
                if (index < 0) index = shuci;
            }else{
                index++;
                if (index > shuci) index = 0;
            }
            rechange(index);
            slideImage(index);
            timer = window.setTimeout(auto, offset);
        });
}

function bighookBtn(){
    $('#bigpicarea p span').filter('#big_play_prev,#big_play_next')
        .bind('click', function(){
            if (timer){
                clearTimeout(timer);
            }
            var id = this.id;
            if (id == 'big_play_prev') {
                index--;
                if (index < 0) index = shuci;
            }else{
                index++;
                if (index > shuci) index = 0;
            }
            rechange(index);
            slideImage(index);
            timer = window.setTimeout(auto, offset);
        });
}

//get index
function getIndex(v){
    for(var i=0; i < target.length; i++){
        if (target[i] == v) return i;
    }
}
function rechange(loop){
    var id = 'thumb_'+ target[loop];
    $('#thumbs li a.current').removeClass('current');
    $('#'+ id).addClass('current');
}
function auto(){
    index++;
    if (index >shuci){
        index = 0;
    }
    rechange(index);
    slideImage(index);
    timer = window.setTimeout(auto, offset);
}
$(function(){    
    //change opacity
    $('div.word').css({opacity: 0.85});
    auto();  
    hookThumb(); 
    hookBtn();
	bighookBtn()
    
});/*  |xGv00|d7b30c0224cec55b59311c4f2af116f7 */






(function  () {
				//獲取div寬度
				var divWidth= Math.floor($('.CarouselFigureContainer').innerWidth());
				//獲取div高度
				var divHeight = Math.floor($('.CarouselFigureContainer').innerHeight());
				//	‘li’的高度与宽度，将与div同步
				$('#PictureContainer li').css({
					height: divHeight + 'px',
					width: divWidth+ 'px',
					float:'left',
				});
				//图片的高度与宽度，将与div同步
				$('#PictureContainer li img').css({
					width: '100%',		
					height: '100%'
				});
				//设置左右按钮距离顶部的距离，让他居中
				$('#STARTTQVault,#RightButton').css({
					top:divHeight/2-Math.floor($('#STARTTQVault').innerHeight())/2+'px'
				});
				//1，获取li的宽度
				var liWidth = $('#PictureContainer li').innerWidth();
				//2，获取li个数	
				var Li = $('#PictureContainer').find('li').length; 
				//3，ul的宽度等于所有li的宽度的和，再加一个li的宽度
				var Ul2Width = Li * liWidth+liWidth;
				$('#PictureContainer').css({width: Ul2Width + 'px'}); 
				//4，循环li，每获取一个‘li’就创建一个‘i’标签放到class为Dot的div当中，用于显示图片个数与位置
				$('#PictureContainer li').each(function(index){
						$('<i>').appendTo(".Dot");			
				})
				var DotWidth=$('.Dot i').innerWidth()*Li+10*Li ;
				$('.Dot').css({
					width:DotWidth+'px',
					marginLeft: -DotWidth/2+'px'
				});
				//5，为新创建的第一个i标签添加上class为active
				$('.Dot i:first').addClass('active');
				//6，封装函数，用于i标签的背景换色，达到显示位置的效果
				function Optionbar() {
					$('.Dot i').css('background', '#bd8886');
					$('.Dot i').eq(index).css('background', '#ffc920');
				}
				//7，声明index，用于记录图片当前位置
				var index = 0;
				//8，复制ul里的第一个li，添加为ul的最后一个li，达到首尾都相同的效果，以便于轮播。
				$("#PictureContainer li:first").clone(true).appendTo("#PictureContainer"); 
				//9，创建函数，用于轮播
				function tt() {
					//每轮播一次，index自加一
					index++;
					//当到最后一个的时候，index就等于0
					if (index > Li - 1){index = 0}
					//当ul左移动等于ul的宽度减去li的宽度的时候，ul的左距离立马回归为零
					if ($('#PictureContainer').css('left') == -(Ul2Width-liWidth)+'px') {
						$('#PictureContainer').css('left', '0px');
					}
					//每次左移动等于li的宽度
					$('#PictureContainer').animate({left: '-='+liWidth}, 1000); 
					Optionbar()
				};
				//10,开启定时器
				timoutide = setInterval(tt,4000);
				$('.CarouselFigureContainer').hover(function() { 
					//鼠标移入的时候关闭定时器	
					clearInterval(timoutide);
				}, function() { 
					//,鼠标移出的时候,关闭定时器再开启定时器，防止各种小pug的出现
					clearInterval(timoutide);
					timoutide = setInterval(tt, 4000);
				});
			//11，点击向右－⬇	
			$('#RightButton').click(function() {
					//一点击就关闭定时器，防止各种小pug的出现
					clearInterval(timoutide);
					//当ul左移动等于ul的宽度减去li的宽度的时候，ul的左距离立马回归为零
					if ($('#PictureContainer').css('left') == -(Ul2Width-liWidth)+'px') {
						$('#PictureContainer').css('left', '0px');
					}
					//判断是否处于动画，防止用户快递点击而蹦贵
					if (!$('#PictureContainer').is(":animated")) {
						//当ul左移动
						$('#PictureContainer').animate({left: '-='+liWidth}, 500);
						//每点击次，index自加一
						index++;
						//当到最后一个的时候，index就等于0
						if (index > Li - 1){index = 0;}
						Optionbar()
					}
				});
			//点击向右－⬆
			//12，点击向左－⬇
				$('#STARTTQVault').click(function() {
					//一点击就关闭定时器，防止各种小pug的出现
					clearInterval(timoutide);
					////当ul左移动等于0的时候，ul的左距离等于负(ul的宽度减去li的宽度）
					if($('#PictureContainer').css('left')=='0px')	{
						$('#PictureContainer').animate({left:-(Ul2Width-liWidth)+'px'}, 0);
					};
					//判断是否处于动画，防止用户快递点击而蹦贵
					if (!$('#PictureContainer').is(":animated")) {
						//ul的右移动等于加等li的宽度
						$('#PictureContainer').animate({left: '+='+liWidth}, 500);
						//每点击次，index自减一
						index--;
						//当处于第一个li的时候，index就等于0
						if (index < -Li + 1) {index = 0}
						Optionbar()
					}
				});
			//点击向左－⬆
			//点击小圆点-↓
			$('.Dot i').each(function  (ind) {
				$(this).click(function  () {
					//一点击就关闭定时器，防止各种小pug的出现
					clearInterval(timoutide);
					var rr=ind*liWidth;
					$('#PictureContainer').animate({left: -rr}, 500);	
					index=ind;
					Optionbar();
				})
			})
			//点击小圆点-↑
		}())














