<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<body>
	<script type="text/javascript">
		function searchUser() {
			var val=$("#userM_userMansge_search input[name='userName']").val();
			$('#userM_userMansge_dataGrid').datagrid('load',{
				userName:val
			});
		} 
		function clearUser() {
			$('#userM_userMansge_searchByUserName').textbox({
				value:''
			});
			$('#userM_userMansge_dataGrid').datagrid('load',{});
		} 
		$(function() {
			$('#userM_userMansge_dataGrid').datagrid({
				url : 'userAction!getDataGrid.action',
				fit : true,
				pagination : true,
				fitColumns : true,
				striped : true,
				idField : 'userID',
				multiSort : true,
				pagePosition : 'bottom',
				checkOnSelect:false,
				columns : [ [ {
					field : 'userID',
					title : '用户ID',
					width : 200,
					checkbox : true
				}, {
					field : 'userName',
					title : '用户名',
					width : 200,
					sortable : true,
					formatter : function(value, row, index) {
						return '<span title="'+value+'">' + value + '</span>';
					}
				}, {
					field : 'password',
					title : '用户密码',
					width : 200,
					formatter : function(value, row, index) {
						return '******';
					}
				}, {
					field : 'createDateTime',
					title : '创建日期',
					width : 200,
					sortable : true,
					formatter : function(value, row, index) {
						return '<span title="'+value+'">' + value + '</span>';
					}
				}, {
					field : 'modifyDateTime',
					title : '修改日期',
					width : 200,
					sortable : true,
					formatter : function(value, row, index) {
						if(!value){
							value='';
						}
						return '<span title="'+value+'">' + value + '</span>';
					}
				} ] ],
		toolbar : [ {
					text : '增加',
					iconCls : 'icon-add',
					handler : function() {
						addUser();
					}
				}, '-', {
					text : '删除',
					iconCls : 'icon-remove',
					handler : function() {
						remove();
					}
				}, '-', {
					text : '修改',
					iconCls : 'icon-edit',
					handler : function() {
						alert('修改')
					}
				} ]

			});
		});
		$(function() {
			$('#userM_userMansge_addUserForm').form({
				url:'userAction!addUser.action',
				onSubmit:function(){
					return $('#userM_userMansge_addUserForm').form('validate');
				},
				success:function(data){
					var obj = JSON.parse(data);
					if (obj.success) {
						$('#userM_userMansge_addUserForm').form('reset');
						$('#userM_userMansge_addUserDialog').dialog('close');
						//$('#userM_userMansge_dataGrid').datagrid('load',{});
						$('#userM_userMansge_dataGrid').datagrid('insertRow',{
							index:0,
							row:obj.obj
						});
					}
					$.messager.show({
						title : '添加提示',
						msg : obj.message
					});
				}
			});
		});
		function addUser() {
			$('#userM_userMansge_addUserDialog').dialog('open');
		}
		function remove() {
			var obj = $('#userM_userMansge_dataGrid').datagrid('getChecked');
			var ids = [];
			for (var i = 0; i < obj.length; i++) {
				ids[i] = obj[i].userID;
			}
			if (ids.length != 0) {
				$.messager.confirm({
					title : '删除用户提示',
					msg : '</br><h3 align="center">确定删除该用户</h3>',
					fn : function(f) {
						if (f) {
							$.ajax({
								type : "POST",
								url : "userAction!removeUser.action",
								data : {
									ids : ids.join(',')
								},
								dataType : 'json',
								success : function(data) {
									if (data.success) {
										$('#userM_userMansge_dataGrid')
												.datagrid('load');
									}
									$.messager.show({
										title : '删除用户提示',
										msg : data.message
									});
								}
							});
						}
					}
				});
			} else {
				$.messager.alert({
					title : '删除用户提示',
					msg : '</br><h3 align="center">请选择用户！</h3>',
					icon : 'error'
				});
			}
		}
	</script>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',border:false" style="height: 75px;">
			<div id="userM_userMansge_search" style="margin-top: 43px">
				<input id="userM_userMansge_searchByUserName" class="easyui-textbox" name="userName" data-options=""/> 
				<input class="easyui-datebox" name="createDateTime" data-options=""/> 
				<input class="easyui-datebox" name="modifyDateTime" data-options=""/> 
				<a class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchUser();">查询</a> 
				<a class="easyui-linkbutton" data-options="iconCls:'icon-clear',plain:true" onclick="clearUser();">清空</a>
			</div>
		</div>
		<div data-options="region:'center',split:true,border:false">
			<table id="userM_userMansge_dataGrid"></table>
		</div>
	</div>
	<div id="userM_userMansge_addUserDialog" class="easyui-dialog" data-options="title:'增加用户',closed:true,modal:true,buttons:[{
				text:'增加',
				iconCls:'icon-add',
				handler:function(){
					$('#userM_userMansge_addUserForm').submit();
				}
			}]">
		<form id="userM_userMansge_addUserForm" method="post">
			<table>
				<tr>
					<th>用户名</th>
					<td><input type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'登录名必填！'" name="userName" /></td>
				</tr>
				<tr>
					<th>密码</th>
					<td><input type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'密码必填！'" name="password" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
