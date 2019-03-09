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
			$("#userM_userMansge_search input[name='userName']").val('');
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
				columns : [ [ {
					field : 'userID',
					title : '用户ID',
					width : 200,
					hidden : true
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
						return '<span title="'+value+'">' + value + '</span>';
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
				toolbar : '#userM_userMansge_toolbar'
			});
		});
	</script>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north',border:false" style="height: 75px;">
			<div id="userM_userMansge_search" style="margin-top: 43px">
				<input class="easyui-textbox" name="userName" data-options=""/> 
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
	<div id="userM_userMansge_toolbar" style="border: 0px;" data-options="fit:true">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="float: left;">增加</a>
		<div class="datagrid-btn-separator" style="float: left;"></div>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" style="float: left;">删除</a>
		<div class="datagrid-btn-separator" style="float: left;"></div>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" >修改</a>
	</div>
</body>
