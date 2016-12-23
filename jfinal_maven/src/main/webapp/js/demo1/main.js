/**
 * Ajax请求方法二次封装
 */
var common_ajax = function() {

	/**
	 * ajax请求并返回结果
	 * @param url
	 * @param data
	 * @param callback
	 * @returns {String}
	 */
	var ajaxFunc = function(url, data, dataType, callback) {
		if (dataType == undefined || dataType == null) {
			dataType = "html";
		}

		var result = "";
		$.ajax({
			type: "post",
			url: encodeURI(url),
			data: data,
			dataType: dataType,
			contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			async: false,
			cache: false,
			success: function(response) {
				result = response;
				//扩展回调函数
				if (callback != null) {
					callback();
				}
			}
		});
		return result;
	}


	/**
	 * ajax提交form替换指定主面板
	 * @param formId 提交formid
	 * @param callback 回调
	 */
	var ajaxFormMainPanel = function(formId, callback) {
		var result = ajaxFunc(formId, callback);
		var toolbarDiv = $(".wrapper-content");

		$(".dashboard-header").remove();
		toolbarDiv.empty();
		toolbarDiv.append(result);
	}

	return {
		ajaxFunc: ajaxFunc,
		ajaxFormMainPanel: ajaxFormMainPanel
	};

}();