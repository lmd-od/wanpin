/*
 * 使用于引擎搜索和方案商城搜索
 * @author litr
 */
$(function(){
	//初始化查询条件
	var $list1 = $(".active-content-warp .list-01"),$list2 = $(".active-content-warp .list-02"),$list3 = $(".active-content-warp .list-03"),$list4 = $(".active-content-warp .list-04");
	(function(){
		$.each(ALL_DICT.GOODS_STYLE,function(idx,item){
			$list1.append('<li data-val='+item['k']+'><a href="javascript:;">'+item['v']+'</a></li>');
		});
		$.each(ALL_DICT.GOODS_FUNCTION,function(idx,item){
			$list2.append('<li data-val='+item['k']+'><a href="javascript:;" >'+item['v']+'</a></li>');
		});
		$.each(ALL_DICT.GOODS_HIERARCHY,function(idx,item){
			$list3.append('<li data-val='+item['k']+'><a href="javascript:;" >'+item['v']+'</a></li>');
		});
		$.each(ALL_DICT.COUNTRY,function(idx,item){
			if (idx >= 12) {
				$list4.append('<li style="display:none;" li-none="show" data-val='+item['k']+'><a href="javascript:;" >'+item['v']+'</a></li>');
				if (idx == ALL_DICT.COUNTRY.length - 1){
					$list4.append('<li li-none="none" li-show="true"><a href="javascript:;" >[更多]</a></li>');
				}
			}  else {
				$list4.append('<li data-val='+item['k']+'><a href="javascript:;" >'+item['v']+'</a></li>');
			}
		});
	})();
	
	$(".active-content-warp").on('click', 'li:not([li-none="none"])', function(){
		$(this).toggleClass('active');
		demo();
	});
	
	$(".active-content-warp").on('click', 'li[li-none="none"]', function(){
		var val = $(this).attr('li-show');
		console.log(val);
		if(val == 'true') {
			$list4.find('li[li-none="show"]').show(1000);
			$(this).attr('li-show',false).find('a').text('[收起]');
		} else {
			$list4.find('li[li-none="show"]').hide(1000);
			$(this).attr('li-show',true).find('a').text('[更多]');
		}
	});
	
	$("#search_btn").on('click',function(){
		demo();
	});
	
	function demo(curr){
		var dataJson = {};
		dataJson.goodsName = $(".wei input").val();
		var goodsStyle = [],goodsFunction=[],goodsHierarchy=[],country=[];
		$list1.find('li.active').each(function(idx,item){
			goodsStyle.push($(this).attr('data-val'));
		});
		$list2.find('li.active').each(function(idx,item){
			goodsFunction.push($(this).attr('data-val'));
		});
		$list3.find('li.active').each(function(idx,item){
			goodsHierarchy.push($(this).attr('data-val'));
		});
		$list4.find('li.active').each(function(idx,item){
			country.push($(this).attr('data-val'));
		});
		dataJson.goodsStyle = goodsStyle.join(',');
		dataJson.goodsFunction = goodsFunction.join(',');
		dataJson.goodsHierarchy = goodsHierarchy.join(',');
		dataJson.countryCode = country.join(',');
		dataJson.pageNo = curr || 1;
		console.log(dataJson);
		wanpin.fly.json(ctx + '/' + webAdminPath + com.wanpin.util.Constants['search'],dataJson,function(res){
			$(".logo-list-01").html(res);
			var totalPageNum = $('.logo-list-01 #totalPageNum').val();
			if(totalPageNum == '' || totalPageNum <= 1) {
				$('#page1').hide();
			} else {
				$('#page1').show();
			}
	        //显示分页
	        laypage({
	            cont: $('#page1'), //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
	            skin: 'molv',
	            pages: totalPageNum, //通过后台拿到的总页数
	            curr: curr || 1, //当前页
	            jump: function(obj, first){ //触发分页后的回调
	                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
	                    demo(obj.curr);
	                }
	            }
	        });
		},{'dataType':'html'});
	};
	//运行
	demo();
});