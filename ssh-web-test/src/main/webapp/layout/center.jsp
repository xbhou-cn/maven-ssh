<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	function addTab(opts) {
		var tab = $('#layout_center_tabs');
		if (tab.tabs('exists', opts.text)) {
			tab.tabs('select', opts.text);
		} else {
			if (opts.attributes.url) {
				var url = opts.attributes.url;
				tab.tabs('add', {
					title : opts.text,
					closable : true,
					fit:true,
					href : url
				});
			}
		}
	}
</script>
<div id="layout_center_tabs" class="easyui-tabs"
	data-options="fit:true,border:false"
	style="width: 500px; height: 250px;">
	<div title="首页" style="padding: 20px; display: none;">tab1</div>
</div>