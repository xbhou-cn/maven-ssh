<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSH TEST</title>
<script type="text/javascript"
	src="js/jquery-easyui-1.7.4/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.7.4/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.7.4/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/myjs/xbUtil.js"></script>
<link rel="stylesheet"
	href="js/jquery-easyui-1.7.4/themes/default/easyui.css" type="text/css" />
<link rel="stylesheet" href="js/jquery-easyui-1.7.4/themes/icon.css"
	type="text/css" />
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'North Title',split:true,border:false"
		style="height: 100px;"></div>
	<div data-options="region:'south',title:'South Title',split:true,border:false"
		style="height: 100px;"></div>
	<div data-options="region:'east',title:'East',split:true,border:false"
		style="width: 100px;"></div> 
	<div data-options="region:'west',border:false,title:'功能导航'" style="width: 200px;">
		<jsp:include page="layout/west.jsp"></jsp:include>
	</div>
	<div data-options="region:'center',title:'欢迎使用'"
		style="background: #eee;">
		<jsp:include page="layout/center.jsp"></jsp:include>
	</div>
	<jsp:include page="user/login.jsp"></jsp:include>
	<jsp:include page="user/register.jsp"></jsp:include>
</body>
</html>