$(function(){
	var $a = $('#collect_btn');
	wanpin.fly.json(ctx + '/' + webAdminPath + '/goods/checkCollect.php',{'id':$a.attr('data-id')},function(res){
		if(res.status == 2) {
			$a.attr('collect','1').text('已收藏');
		}
	});
});