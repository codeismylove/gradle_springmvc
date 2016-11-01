$(function() {
	var name = $("#userName"), email = $("#email"), password = $("#password"), allFields = $(
			[]).add(userName).add(email).add(password), tips = $(".validateTips"),type=$("#type option:selected"),unit=$("#unit");

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
			updateTips("所有的表单字段都是必填的。");
			return true;
		}
	}

	function checkRegexp(o, regexp, n) {
		if (!(regexp.test(o.val()))) {
			o.addClass("ui-state-error");
			updateTips(n);
			return false;
		} else {
			updateTips("所有的表单字段都是必填的。");
			return true;
		}
	}

	$("#dialog-form")
			.dialog(
					{
						autoOpen : false,
						height : 300,
						width : 350,
						modal : true,
						buttons : {
							"创建一个帐户" : function() {
								var bValid = true;
								allFields.removeClass("ui-state-error");

								bValid = bValid
										&& checkLength(name, "userName", 3, 16);
								bValid = bValid
										&& checkLength(email, "email", 6, 80);
								bValid = bValid
										&& checkLength(password, "password", 5,
												16);

								bValid = bValid
										&& checkRegexp(name,
												/^[a-z]([0-9a-z_])+$/i,
												"用户名必须由 a-z、0-9、下划线组成，且必须以字母开头。");
								// From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
								bValid = bValid
										&& checkRegexp(
												email,
												/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
												"eg. ui@jquery.com");
								bValid = bValid
										&& checkRegexp(password,
												/^([0-9a-zA-Z])+$/,
												"密码字段只允许： a-z 0-9");

								
								if (bValid) {
									 var form = $("#dialogForm");  
					                    $.ajax({  
					                        url:"saveRegisterAction.action",  
					                        type:"post",  
					                        data:{'userName':name.val(),'type':type.text(),'password':password.val(),'unit':unit.val()},  
					                        dataType:"json",
					                        success:function(data){  
					                            $("#dialog").dialog("close");  
					                            alert("成功啦");  
					                        },  
					                        error:function(){  
					                            $("#dialog").dialog("close");  
					                            alert("出错了哦");  
					                        }  
					                    }) ; 
									$(this).dialog("close");
								}
							},
							Cancel : function() {
								$(this).dialog("close");
							}
						},
						close : function() {
							allFields.val("").removeClass("ui-state-error");
						}
					});

	$("#create-user").button().click(function() {
		$("#dialog-form").dialog("open");
	});

	$("#my_check").button().click(function() {
		$("#dialog-form").dialog("open");
	});

	$("#register").click(function() {
		$("#dialog-form").dialog("open");
	});
});
