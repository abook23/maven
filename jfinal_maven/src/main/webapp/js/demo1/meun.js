$(document).ready(function(){
	findUserRole();
});

/**
 * 查询当前用户所对应角色菜单
 */
function findUserRole(){
	
	var listStr="";
	jQuery.ajax({
		type : "get",
		url:"/menu/list",	 
		 async : false,
		dataType : 'json',
		success : function(data) {
			if(data){
				 $.each(data, function(i, item) {
					 if(item.pId ==0){
						 listStr+='<li >';//class="active"//选中
						 listStr+='<a><i class="fa fa-th-large"></i> <span class="nav-label">'+item.name+'</span> <span class="fa arrow"></span></a>'
						 listStr+='<ul class="nav nav-second-level">';
						 $.each(data, function(j, sub) {
							 if(sub.pId==item.menuId){
								 listStr+="<li><a onclick=common_ajax.ajaxFormMainPanel('"+sub.url+"')>"+sub.name+"</a></li>"
							 }
						 });
						 listStr+="</ul></li>";
					 }
			        });
				}
		
		},
		error : function() {
			
		//	layer.msg('网络超时或系统异常!', { icon: 2	});		

		}

	});
	var html = $('#side-menu .nav-header').html();
	html='<li class="nav-header">'+html+'</li>';
	$("#side-menu").empty();
    $("#side-menu").append(html).append(listStr);
    
    
    //$(".dashboard-header").remove();
    //$(".wrapper-content").remove();
 }

