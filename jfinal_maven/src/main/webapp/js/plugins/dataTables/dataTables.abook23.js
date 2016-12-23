/**
 * 
 * @param {String} dataTable	"#idName" or ".className"
 * @param {String} url
 * @param {String} columns		"id:false,name,phone,...."
 * @param {Object} dataSrc		"lsit"	{name:"",list:[{},{}]}
 * @return{DataTable} dataTable
 * @param {Function} rowCallback
 */
function dataTable(dataTable, url, columns, dataSrc, rowCallback) {
	var table = $(dataTable).DataTable({
		ajax: {
			url: url,
			dataSrc: dataSrc
		},
		columns: getDataTableColumns(columns),
		"rowCallback": function(row, data, index) {
			if(rowCallback != null)
				rowCallback(row, data, index);
		}
	});
	return table;
}

/**
 * 
 * @param {String} dataTable "#idName" or ".className"
 * @param {String} url		
 * @param {String} columns 	"id:false,name,phone,...."
 * @param {Function} rowCallback
 */
function dataTableByServer(dataTable, url, columns, rowCallback) {
	var table = $(dataTable).DataTable({
		ordering: false, //排序
		serverSide: true, //开启服务器模式
		ajax: url,
		columns: getDataTableColumns(columns),
		"rowCallback": function(row, data, index) {
			if(rowCallback != null)
				rowCallback(row, data, index);
			//			var html = "";
			//			html += '<dd class="project-people">'
			//			html += '<img alt="image" class="img-circle" src="img/a5.jpg">';
			//			html += '</dd>';
			//			$('td:eq(1)', row).html(html);
			//$('td:eq(0)', row).css('display', 'none');
		}
	});
	return table;
}

function getDataTableColumns(columns) {
	var aar = columns.split(",");
	var _columns = new Array();
	$.each(aar, function(i, d) {
		var _d = d.split(":");
		if(_d[1] == "false") {
			_d[1] = false;
		} else {
			_d[1] = true;
		}
		_columns[i] = {
			data: _d[0],
			"visible": _d[1]
		};
	});
	return _columns;
}

//获取某一个点击Id
//				$('.dataTables-example').on("dblclick", 'tr', function() {
//					//					var id = $(this).find("td").eq(0).text();
//					//					if(id != '') {
//					//						info(id);
//					//					}
//					var rowData = table.row(this).data();
//					info(rowData.userId);
//				});




//
//		<script>
//			$(document).ready(function() {
//				//				$('.dataTables-example').DataTable({
//				//					ajax:{
//				//						url:'/user/list2',
//				//						dataSrc: 'list'
//				//					},
//				//					columns:[
//				//						{data:'userId'},
//				//						{data:'name'},
//				//						{data:'phone'},
//				//						{data:'email'},
//				//						{data:'qq'},
//				//						{data:'createTime'}
//				//					]
//				//				});
//
////				var table = $('.dataTables-example').DataTable({
////					ordering: false, //排序
////					//开启服务器模式
////					serverSide: true,
////					ajax: '/user/list2',
////					columns: [{
////						data: 'userId',
////						"visible": true
////					}, {
////						data: 'name'
////					}, {
////						data: 'phone'
////					}, {
////						data: 'email'
////					}, {
////						data: 'qq'
////					}, {
////						data: 'createTime'
////					}],
////					"rowCallback": function(row, data, index) {
////						var html = "";
////						html += '<dd class="project-people">'
////						html += '<img alt="image" class="img-circle" src="img/a5.jpg">';
////						html += '</dd>';
////						$('td:eq(1)', row).html(html);
////						//$('td:eq(0)', row).css('display', 'none');
////					}
////				});
//				var table = dataTableByServer(".dataTables-example", "/user/list2", "userId:false,name,phone,email,qq,createTime");
//
//				$('.dataTables-example').on("dblclick", 'tr', function() {
//					//					var id = $(this).find("td").eq(0).text();
//					//					if(id != '') {
//					//						info(id);
//					//					}
//					var rowData = table.row(this).data();
//					info(rowData.userId);
//				});
//			});
//		</script>