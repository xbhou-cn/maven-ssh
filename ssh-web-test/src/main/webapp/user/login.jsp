<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$("#user_login_logForm input[name='userName']").focus();
		$('#user_login_logForm').form({
			url : 'userAction!login.action',
			onSubmit : function() {
				return $('#user_login_logForm').form('validate');
			},
			success : function(data) {
				var obj = JSON.parse(data);
				if (obj.success) {
					$('#user_login_logDialog').dialog('close');
				}
				$.messager.show({
					title : '登陆提示',
					msg : obj.message
				});
			}
		});
		$('#user_login_logForm input').bind('keyup', function(event) {
			if (event.keyCode == 13) {
				$('#user_login_logForm').submit();
			}
		});
	});
</script>
<div class="easyui-dialog" id="user_login_logDialog"
	data-options="title:'登陆',closable:false,modal:true,buttons:[{
				text:'注册',
				iconCls:'icon-edit',
				handler:function(){
					$('#user_register_regDialog').dialog('open');
				}
			},{
				text:'登录',
				iconCls:'icon-add',
				handler:function(){
				$('#user_login_logForm').submit();
				}
			}]"
	style="width: 250px">
	<form id="user_login_logForm" method="post">
		<table>
			<tr>
				<th>用户名</th>
				<td><input type="text" name="userName"
					class="easyui-validatebox"
					data-options="required:true,missingMessage:'登录名必填！'" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" name="password"
					class="easyui-validatebox"
					data-options="required:true,missingMessage:'登录名必填！'" /></td>
			</tr>
		</table>
	</form>
</div>