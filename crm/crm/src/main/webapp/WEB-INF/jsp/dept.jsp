<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<h1>部门信息</h1>
		<hr>
		<table>
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>所在地</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${deptList}" var="dept">
			<tr>
				<td>${dept.no}</td>
				<td>${dept.name}</td>
				<td>${dept.location}</td>
				<td>
					<a href="del?no=${dept.no}">删除</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>