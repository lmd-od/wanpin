/*
 * 适用于用户收藏
 * @author litr
 */
$(function(){
	$('img.image').on('click',function(){
		var that = this, dataType = $(that).attr('data-type');
		if(dataType == 1) {
			page1();
		} else if (dataType == 2) {
			page2();
		}
	});
	
	function page1(curr) {
		var dataJson = {'pageSize':9},curr = curr || 1;
		dataJson.pageNo = curr;
		var val = $("#search_1").val();
		if (wanpin.utils.isNotEmpty(val)) {
			dataJson.goodsName = val;
		}
		wanpin.fly.json(ctx + '/' + webAdminPath + '/user/collectEngines.php',dataJson,function(res){
			if(res.status == 0) {
				var len = res.data.length;
				if(len > 0) {
					var gettpl = document.getElementById('engine-demo').innerHTML;
					laytpl(gettpl).render(res.data, function(html){
					    document.getElementById('engine-list').innerHTML = html;
					});
				} else {
					document.getElementById('engine-list').innerHTML = '<p class="text-center">未查到您收藏的引擎信息</p>';
				}
				//显示分页
		        laypage({
		            cont: $('#page1'), //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
		            skin: '#008cd6',
		            pages: res.totalPageNum, //通过后台拿到的总页数
		            curr: curr, //当前页
		            jump: function(obj, first){ //触发分页后的回调
		                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                	page1(obj.curr);
		                }
		            }
		        });
			}
		});
	}
	
	function page2(curr) {
		var dataJson = {'pageSize':5},curr = curr || 1;
		dataJson.pageNo = curr;
		var val = $("#search_2").val();
		if (wanpin.utils.isNotEmpty(val)) {
			dataJson.goodsName = val;
		}
		wanpin.fly.json(ctx + '/' + webAdminPath + '/user/collectGoods.php',dataJson,function(res){
			if(res.status == 0) {
				var len = res.data.length;
				if(len > 0) {
					$('#goods-list').removeClass('goods-list');
					var gettpl = document.getElementById('goods-demo').innerHTML;
					laytpl(gettpl).render(res.data, function(html){
					    document.getElementById('goods-list').innerHTML = html;
					});
				} else {
					$('#goods-list').addClass('goods-list');
					document.getElementById('goods-list').innerHTML = '<p class="text-center">未查到您收藏的方案信息</p>';
				}
				
				//显示分页
		        laypage({
		            cont: $('#page2'), //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
		            skin: '#008cd6',
		            pages: res.totalPageNum, //通过后台拿到的总页数
		            curr: curr, //当前页
		            prev: false,
		            next: false,
		            groups: 3,
		            jump: function(obj, first){ //触发分页后的回调
		                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
		                	page2(obj.curr);
		                }
		            }
		        });
			}
		});
	}
	
	page1();
	page2();
});