<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#user_register_regForm').form({
			 url:'userAction!saveUser.action',
			 onSubmit: function(){
				return $('#user_register_regForm').form('validate');
			 },
			 success:function(data){
				var obj= JSON.parse(data);
				if(obj.success){
					$('#user_register_regDialog').dialog('close');
					$("#user_login_logForm input[name='userName']").val($("#user_register_regForm input[name='userName']").val());
					$("#user_login_logForm input[name='password']").val($("#user_register_regForm input[name='password']").val());
					$('#user_register_regForm').form('reset');
				}
				$.messager.show({
					title:'注册提示',
					msg:obj.message
				});
			 }
		});
		$('#user_register_regForm input').bind('keyup',function(event) {
			if(event.keyCode=='13'){
				$('#user_register_regForm').submit();
			}
		});
	});
</script>
<div id="user_register_regDialog" class="easyui-dialog" data-options="title:'注册',closed:true,modal:true,buttons:[{
				text:'注册',
				iconCls:'icon-add',
				handler:function(){
					$('#user_register_regForm').submit();
				}
			}]" 
		style="width: 300px">
		<form id="user_register_regForm" method="post">
			<table>
				<tr>
					<th>用户名</th>
					<td><input name="userName" type="text" class="easyui-validatebox" data-options="required:true"/></td>
				</tr>
				<tr>
					<th>密码</th>
					<td><input name="password" type="password" class="easyui-validatebox"  data-options="required:true"/></td>
				</tr>
				<tr>
					<th>重复密码</th>
					<td><input type="password" class="easyui-validatebox"  data-options="required:true,validType:'equPWD[\'#user_register_regForm input[name=password]\']'"/></td>
				</tr>
			</table>
		</form>
	</div>