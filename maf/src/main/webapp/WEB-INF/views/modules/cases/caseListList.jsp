<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用例集管理</title>
	<meta name="decorator" content="default"/>
	<%@include file="/WEB-INF/views/include/treetable.jsp" %>
	<script type="text/javascript">
	$(document).ready(function() {
		var tpl = $("#treeTableTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
		var data = ${fns:toJson(list)}, ids = [], rootIds = [];
		for (var i=0; i<data.length; i++){
			ids.push(data[i].id);
		}
		ids = ',' + ids.join(',') + ',';
		for (var i=0; i<data.length; i++){
			if (ids.indexOf(','+data[i].parentId+',') == -1){
				if ((','+rootIds.join(',')+',').indexOf(','+data[i].parentId+',') == -1){
					rootIds.push(data[i].parentId);
				}
			}
		}
		for (var i=0; i<rootIds.length; i++){
			addRow("#treeTableList", tpl, data, rootIds[i], true);
		}
		$("#treeTable").treeTable({expandLevel : 5});
	});
	function addRow(list, tpl, data, pid, root){
		for (var i=0; i<data.length; i++){
			var row = data[i];
			if ((${fns:jsGetVal('row.parentId')}) == pid){
				$(list).append(Mustache.render(tpl, {
					dict: {
					blank123:0}, pid: (root?0:pid), row: row
				}));
				addRow(list, tpl, data, row.id);
			}
		}
	}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/cases/caseList/">用例集管理列表</a></li>
		<shiro:hasPermission name="cases:caseList:edit"><li><a href="${ctx}/cases/caseList/form">用例集添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="caseList" action="${ctx}/cases/caseList/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label><input type="text" name="name" value="${caseList.name}" class="input-medium"/></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="treeTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>项目名称</th>
				<th>排序</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="cases:caseList:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody id="treeTableList"></tbody>
	</table>
	<script type="text/template" id="treeTableTpl">
		<tr id="{{row.id}}" pId="{{pid}}">
			<td><a href="${ctx}/cases/caseList/form?id={{row.id}}">{{row.name}}</a></td>
			<td>{{row.itemName}}</td>
			<td>{{row.sort}}</td>
			<td>{{row.updateDate}}</td>
			<td>{{row.remarks}}</td>
			<shiro:hasPermission name="cases:caseList:edit"><td>
				<a href="${ctx}/cases/caseList/form?id={{row.id}}">修改</a>
				<a href="${ctx}/cases/caseList/delete?id={{row.id}}" onclick="return confirmx('要删除该用例集及所有子用例集项吗？', this.href)">删除</a>
				<a href="${ctx}/cases/caseList/form?parent.id={{row.id}}">添加下级用例集</a> 
			</td></shiro:hasPermission>
		</tr>
	</script>
	<div class="pagination">${page}</div>
</body>
</html>