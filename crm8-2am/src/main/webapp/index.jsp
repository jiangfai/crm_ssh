<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<button id="getButton">查询</button>
		<button id="delButton">删除</button>
		<button id="addButton">新增</button>
		<button id="editButton">修改</button>
	
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script>
			$(function() {
				$('#addButton').on('click', function() {
					$.ajax({
						url: 'employee',
						type: 'post',
						data: { 
							'no': 9527, 
							'name': '王大锤', 
							'job': '程序员', 
							'manager.no': 2056, 
							'salary': 3000,
							'department.no': 20
						},
						success: function(data) {
							window.alert(data);
						}
					});
				});
				$('#getButton').on('click', function() {
					$.getJSON('employee/3588', function(data) {
						window.alert(data.name);
						window.alert(data.department.name);
					});
				});
				$('#delButton').on('click', function() {
					$.ajax({
						url: 'employee/3588',
						type: 'delete',
						success: function(data) {
							window.alert(data);
						}
					});
				});
			});
		</script>	
	</body>
</html>