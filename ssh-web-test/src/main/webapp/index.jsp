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
<link rel="stylesheet"
	href="js/jquery-easyui-1.7.4/themes/default/easyui.css"
	type="text/css" />
<link rel="stylesheet" href="js/jquery-easyui-1.7.4/themes/icon.css"
	type="text/css" />
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'North Title',split:true"
		style="height: 100px;"></div>
	<div data-options="region:'south',title:'South Title',split:true"
		style="height: 100px;"></div>
	<div data-options="region:'east',title:'East',split:true"
		style="width: 100px;"></div>
	<div data-options="region:'west',split:true" style="width: 150px;">
		<div class="easyui-panel" data-options="title:'菜单',fit:true">
			<a href="helloAction!say.action">点击</a>
		</div>
	</div>
	<div data-options="region:'center',title:'center title'"
		style="background: #eee;"></div>
	<div class="easyui-dialog" data-options="title:'登陆',closable:false,modal:true,buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#index_register').dialog('open');
				}
			},{
				text:'登录',
				iconCls:'icon-add',
				handler:function(){}
			}]"
			style="width: 250px">
		<table>
			<tr>
				<th>用户名</th>
				<td><input /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input /></td>
			</tr>
		</table>
	</div>
	<div id="index_register" class="easyui-dialog" data-options="title:'注册',closed:true,modal:true,buttons:[{
				text:'注册',
				iconCls:'icon-add',
				handler:function(){}
			}]" 
		style="width: 250px">
		<table>
			<tr>
				<th>用户名</th>
				<td><input /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input /></td>
			</tr>
			<tr>
				<th>重复密码</th>
				<td><input /></td>
			</tr>
		</table>
	</div>
</body>
</html>