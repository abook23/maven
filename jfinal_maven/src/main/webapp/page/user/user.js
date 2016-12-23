function info(id) {
	layer.closeAll();
	var html = common_ajax.ajaxFunc("/user/info?id=" + id + "&type=0");
	//捕获页
	layer.open({
		type: 1,
		shade: false,
		title: false, //不显示标题
		content: html, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
		area: ['75%', '90%'], //宽高
		cancel: function() {

		}
	});
}

function edit(id) {
	layer.closeAll();
	var html = common_ajax.ajaxFunc("/user/info?id=" + id + "&type=1");
	//捕获页
	layer.open({
		type: 1,
		shade: false,
		title: false, //不显示标题
		content: html, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
		area: ['75%', '90%'], //宽高
//		cancel: function() {
//
//		}
	});
}

function add() {
	var html = common_ajax.ajaxFunc("/user/add");
	//捕获页
	layer.open({
		type: 1,
		shade: false,
		title: false, //不显示标题
		content: html, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
		area: ['75%', '90%'], //宽高
//		cancel: function() {
//
//		}
	});
}

function add2() {
	layer.open({
		type: 2,
		shade: false,
		title: false, //不显示标题
		content: '/page/user/add.html', //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
		area: ['75%', '90%'], //宽高
	});
}

function del(id) {
	layer.confirm('你确定要删除吗？', {
		btn: ['删除'], //按钮
		title: false, //不显示标题
		time: 5000
	}, function() {
		$.ajax({
			type: "post",
			url: "/user/delete",
			async: false,
			data: {
				id: id
			},
			success: function(data) {
				layer.msg(data.msg, {
					time: 1000 //20s后自动关闭
				}, function() {
					layer.closeAll(); //关闭layer
					common_ajax.ajaxFormMainPanel('/user/list');
				});
			}
		});
	});
}