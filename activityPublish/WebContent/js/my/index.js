$(document).ready(function() {
	$('body').layout({
		applyDefaultStyles : true,
		north__closable: false,//可以被关闭  
		north__resizable: false,//可以改变大小
		north__size: 50,//pane的大小 
		spacing_open: 0//边框的间隙 
	});

	// Accordion
	$("#accordion").accordion({
		header : "h3"
	});

	$(".tabs").tabs();
	$(".tabs").hide();// 隐藏全部
	$("#first1-tabs").show();// 现实首页

	$(".selectable").selectable({
		stop : function() {
			// for each
			$(".ui-selected", this).each(function(index, domEle) {
				// alert($(domEle).attr("id"));
				$(".tabs").hide();// 显示前先隐藏全部
				$("#" + $(domEle).attr("id") + "-tabs").show();

			});
		}
	});
	// 配置对话框
	$.getJSON("publishAction.action", function(json) {
		for (i = 0; i < json.list.length; i++) {
			var tname = json.list[i];
			var tid = i;
			$("#activityType").append(
					"<option value='"+tname+"'>" + tname
							+ "</option>");
		}
	});

});

$(document).ready(function() {
	$("#list47").jqGrid({
		url : "activityListJsonAction.action",
		datatype : "json",
		mtype : "get",
		height : 300,
		width : 800,
		rowNum : 10,
		rowList : [ 10, 20, 30, 40, 50 ],

		colNames : [ '编号', '标题', '类型','举办方'],

		colModel : [ {name : 'id',index : 'id',width : 60}, 
		             {name : 'title',index : 'title',width : 90}, 
		             {name : 'activityType',index : 'activityType',width : 100,editable : true}, 
		             {name : 'holderId',index : 'holderId',width : 100,editable : true}
		            ],
		pager : "#plist47",
		prmNames : {search : "search"},
		jsonReader : {
			root : "gridModel",
			records : "record",
			repeatitems : false
		},
		viewrecords : true,
		caption : "活动列表"
	});
});


$(function() {
	$("#list49").jqGrid({
		url : "userListJsonAction.action",
		datatype : "json",
		mtype : "get",
		height : 300,
		width : 800,
		rowNum : 10,
		rowList : [ 10, 20, 30, 40, 50 ],

		colNames : [ '编号', '用户名', '类型','所属单位'],

		colModel : [ {
			name : 'id',
			index : 'id',
			width : 60
		}, {
			name : 'userName',
			index : 'userName',
			width : 90
		}, {
			name : 'type',
			index : 'type',
			width : 100,
			editable : true
		}, {
			name : 'unit',
			index : 'unit',
			width : 100,
			editable : true
		}

		],
		pager : "#plist49",
		prmNames : {
			search : "search"
		},
		jsonReader : {
			root : "gridModel",
			records : "record",
			repeatitems : false
		},
		viewrecords : true,
		caption : "活动列表"
	});
});

$(function() {
	var activityType = $("#activityType").val(), title = $("#title"), subject = $("#subject"), holderId = $("#holderId"), holderType = $("#holderType"), holdAddr = $("#holdAddr"), tips = $(".validateTips"),beginDate = $("#beginDate"), endDate = $("#endDate");

	function updateTips(t) {
		tips.text(t).addClass("ui-state-highlight");
		setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500);
		}, 500);
	}

	function checkLength(o, n, min, max) {
		if (o.val().length > max || o.val().length < min) {
			o.addClass("ui-state-error");
			updateTips("" + n + " 的长度必须在 " + min + " 和 " + max + " 之间。");
			return false;
		} else {
			return true;
		}
	}

	function checkRegexp(o, regexp, n) {
		if (!(regexp.test(o.val()))) {
			o.addClass("ui-state-error");
			updateTips(n);
			return false;
		} else {
			return true;
		}
	}

	$("#dialog-form").dialog({
		autoOpen : false,
		height : 600,
		width : 280,
		modal : true,
		buttons : {
			"提交" : function() {
				var bValid = true;

				/*
				 * bValid = bValid && checkLength(name, "username", 3, 16);
				 * bValid = bValid && checkLength(email, "email", 6, 80); bValid =
				 * bValid && checkLength(password, "password", 5, 16);
				 * 
				 * bValid = bValid && checkRegexp(name, /^[a-z]([0-9a-z_])+$/i,
				 * "用户名必须由 a-z、0-9、下划线组成，且必须以字母开头。"); // From jquery.validate.js
				 * (by joern), contributed by Scott Gonzalez:
				 * http://projects.scottsplayground.com/email_address_validation/
				 * bValid = bValid && checkRegexp( email,
				 * /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
				 * "eg. ui@jquery.com"); bValid = bValid &&
				 * checkRegexp(password, /^([0-9a-zA-Z])+$/, "密码字段只允许： a-z
				 * 0-9");
				 */

				if (bValid) {
					var form = $("#dialogForm");
					$.ajax({
						url : "activityPublicAction.action",
						type : "post",
						data : {
							'activityType' : activityType,
							'title' : title.val(),
							'subject' : subject.val(),
							'holderId' : holderId.val(),
							'holderType' : holderType.val(),
							'holdAddr' : holdAddr.val(),
							'beginDate' : beginDate.val(),
							'endDate' : endDate.val(),
						},
						dataType : "json",
						success : function(data) {
							$("#dialog").dialog("close");
							alert("成功啦");
						},
						error : function() {
							$("#dialog").dialog("close");
							alert("出错了哦");
						}
					});
					$(this).dialog("close");
				}
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		},
		close : function() {
			$(this).dialog("close");
		}
	});

	$("#create-user").button().click(function() {
		$("#dialog-form").dialog("open");
	});
	$("#register").click(function() {
		$("#dialog-form").dialog("open");
	});
	$("#my_check").button().click(function() {     //页面上的button按钮的click事件，重新获取参数后发送参数，然后重新加载数据。  
	    var keyword1 = $("#check_title").val();
	    var keyword2 = $("#check_holderId").val();
	    var keyword3 = $("#check_type").val();
	    //获取输入框内容   
	      $("#list47").jqGrid('setGridParam',{  
	          datatype:'json',
	          type : "post",
	          postData:{'checkTitle':keyword1,'checkHolderId':keyword2,'checkType':keyword3}, //发送数据  
	          page:1  
	      }).trigger("reloadGrid"); //重新载入  
	}); 
});




