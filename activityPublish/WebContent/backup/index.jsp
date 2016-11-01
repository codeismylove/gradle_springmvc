<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<!--html5的头文档标签-->

<html>
<head>

<title>活动发布系统</title>

<!--CSS-->
<link type="text/css" href="css/jquery-ui-1.8.5.custom.css"
	rel="stylesheet" />
<link type="text/css" media="screen" href="css/ui.jqgrid.css"
	rel="stylesheet" />

<!--JS-->
<!--1.必须先引入jquery的核心库-->
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.5.custom.min.js"></script>
<!--2.按照依赖顺序,再引入jquery的插件核心库: 掌握检测文件是否正确加载-->
<script type="text/javascript" src="js/jquery.layout.js"></script>

<!--jqGrid-->
<script type="text/javascript" src="js/i18n/grid.locale-cn.js"></script>
<!--国际化必须放到jqGrid前-->
<script type="text/javascript" src="js/jquery.jqGrid.min.js"></script>
<link type="text/css" media="screen" href="css/my/index.css"
	rel="stylesheet" />
<script type="text/javascript" src="js/my/index.js"></script>
</head>

<body>
	<div class="ui-layout-center">
		<!--模块内容-->
		<div class="tabs" id="first1-tabs">
			<ul>
				<li><a href="#first1-tabs-1">热门活动</a></li>
			</ul>
			
			<!-- <form action="findUserAction.action" method="post"> 
					<div id="custemer1-tabs-1"><s:property value="#request.activityUser.remake"/></div>
				<div><input type="text" name="activityUser.remake" value=<s:property value="#request.activityUser.remake"/>/></div>
			</form> -->
		</div>

		<div class="tabs" id="first2-tabs">

			<ul>
				<li><a href="#first1-tabs-2">最新活动</a></li>
			</ul>
			<!-- <form action="findUserAction.action" method="post"> 
					<div id="custemer1-tabs-1"><s:property value="#request.activityUser.remake"/></div>
				<div><input type="text" name="activityUser.remake" value=<s:property value="#request.activityUser.remake"/>/></div>
			</form> -->
		</div>

 <!-- 		<div class="tabs" id="custemer1-tabs">
			<ul>
				<li><a href="#custemer1-tabs-1">活动发布</a></li>
			</ul>
			<div id="#custemer1-tabs-1">
				
			</div>
		</div> -->

		<div class="tabs" id="custemer2-tabs">
			<ul>
				<li><a href="#custemer2-tabs-2">活动列表</a></li>
			</ul>
			<div class="my_input">
				<label>标题</label>
				<input id="check_title" type="text" value=""/>
				<label style="padding-left: 4px">举办方</label>
				<input id="check_holderId" type="text" value=""/>
				<label style="padding-left: 4px">类型</label>
				<input id="check_type" type="text" value=""/>
				<button id="my_check">查找</button>
			</div>
			<div class="my_button">  
            	<button id="create-user">活动发布</button>
        	</div>  
			<table id="list47"></table>
			<div id="plist47"></div>
			
			<div id="dialog-form" title="活动发布">
  				<p class="validateTips">所有的表单字段都是必填的。</p>
  				<form id="dialogForm">
  				<fieldset>
    				<label for="activityType">活动类型</label>
  					<!--<input type="text" name="activityType" id="activityType" class="text ui-widget-content ui-corner-all"> -->
   					<div>
   						<select style="padding:5px" id="activityType" name="activityType"></select>
   					</div>
    				<label for="title">标题</label>
    				<input type="text" name="title" id="title" value="" class="text ui-widget-content ui-corner-all">
    				<label for="subject">主题描述</label>
    				<!-- <input type="text" name="subject" id="subject" value="" class="text ui-widget-content ui-corner-all"> -->
    				<textarea cols="30" rows="3" name="subject" id="subject"></textarea>
    				<label for="holderId">举办方</label>
    				<input type="text" name="holderId" id="holderId" value=<s:property value="#session.user_name"/> class="text ui-widget-content ui-corner-all">
    				<label for="holderType">举办方类型</label>
    				<input type="text" name="holderType" id="holderType" value=<s:property value="#session.user_type"/> class="text ui-widget-content ui-corner-all">
    				<label for="holdAddr">举办地址</label>
    				<input type="text" name="holdAddr" id="holdAddr" value="" class="text ui-widget-content ui-corner-all">
    				<label for="beginDate">开始日期</label>
    				<input type="date" name="beginDate" id="beginDate" value="" class="text ui-widget-content ui-corner-all">
    				<label for="endDate">结束日期</label>
    				<input type="date" name="endDate" id="endDate" value="" class="text ui-widget-content ui-corner-all">
  				</fieldset>
  				</form>
			</div>
		</div>

		<div class="tabs" id="order-tabs">
			<ul>
				<li><a href="#order-tabs-1">名单列表</a></li>
			</ul>
			<table id="list49"></table>
			<div id="plist49"></div>
		</div>

	</div>


	<div class="ui-layout-north">活动发布系统</div>
	<div class="ui-layout-south">
		<h3 align="center">2016⊙BNUZ</h3>
	</div>

	<div class="ui-layout-west">
		<!--项目菜单-->
		<div id="accordion">
			<div>
				<h3>
					<a href="#">首页</a>
				</h3>
				<div>
					<ol class="selectable">
						<li class="ui-widget-content" id="first1">热门活动</li>
						<li class="ui-widget-content" id="first2">最新活动</li>
						<!--<li class="ui-widget-content" id="custemer3">潜在客户模块</li>-->
					</ol>
				</div>
			</div>
			<div>
				<h3>
					<a href="#">活动模块</a>
				</h3>
				<div>
					<ol class="selectable">
					<!-- 	<li class="ui-widget-content" id="custemer1">活动发布</li> -->
						<li class="ui-widget-content" id="custemer2">活动列表</li>
						<!--<li class="ui-widget-content" id="custemer3">潜在客户模块</li>-->
					</ol>
				</div>
			</div>

			<div>
				<h3>
					<a href="#">活动报到登记模块</a>
				</h3>
				<div>
					<ol class="selectable">
						<li class="ui-widget-content" id="order">活动名单列表</li>
						<li class="ui-widget-content">已报道名单列表</li>
						<!--<li class="ui-widget-content">订单跟踪模块</li>-->
					</ol>
				</div>
			</div>

			<div>
				<h3>
					<a href="#">活动报道模块</a>
				</h3>
				<div>Nam dui erat, auctor a, dignissim quis.</div>
			</div>

			<div>
				<h3>
					<a href="#">用户管理模块</a>
				</h3>
				<div>Nam dui erat, auctor a, dignissim quis.</div>
			</div>
			<div>
				<h3>
					<a href="#">评论模块</a>
				</h3>
				<div>
					<div>Nam dui erat, auctor a, dignissim quis.</div>
				</div>
			</div>
		</div>
	</div>
	<div class="ui-layout-east">East</div>
</body>
</html>
