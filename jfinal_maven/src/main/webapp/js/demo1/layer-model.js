//layer.closeAll(); //疯狂模式，关闭所有层
//layer.closeAll('dialog'); //关闭信息框
//layer.closeAll('page'); //关闭所有页面层
//layer.closeAll('iframe'); //关闭所有的iframe层
//layer.closeAll('loading'); //关闭加载层
//layer.closeAll('tips'); //关闭所有的tips层

function msg(msg, layerType) {
	layer.msg(msg, {
		time: 1000
	}, function() {
		if(layerType == undefined) {
			layer.closeAll()
		} else {
			layer.closeAll(layerType);
		}
	})
}

function open() {
	layer.open({
		type: 2,// 1 html代码   2 打开网页
		shade: false,
		title: false, //不显示标题
		content: '/page/user/add.html', //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
		area: ['75%', '90%'], //宽高
	});
}


//function del(id) {
//	layer.confirm('你确定要删除吗？', {
//		btn: ['删除'], //按钮
//		title: false, //不显示标题
//		time: 5000
//	}, function() {
//		$.ajax({
//			type: "post",
//			url: "/user/delete",
//			async: false,
//			data: {
//				id: id
//			},
//			success: function(data) {
//				layer.msg(data.msg, {
//					time: 1000 //20s后自动关闭
//				}, function() {
//					layer.closeAll(); //关闭layer
//					common_ajax.ajaxFormMainPanel('/user/list');
//				});
//			}
//		});
//	});
//}