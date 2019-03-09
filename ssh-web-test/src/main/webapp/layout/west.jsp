<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#layout_west_tree').tree({
			onClick : function(node) {
				addTab(node);
			}
		});
	});
</script>
<div class="easyui-accordion" data-options="fit:true,border:false"
	style="width: 300px; height: 200px;">
	<div title="系统菜单" data-options="iconCls:'icon-man'">
		<ul id="layout_west_tree" class="easyui-tree"
			data-options="url:'menuAction!getTree.action'"></ul>
	</div>
	<div title="其他示例" data-options="iconCls:'icon-reload'"></div>
</div>