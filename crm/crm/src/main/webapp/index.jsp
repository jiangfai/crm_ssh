<%@ page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
	</head>
	<body>
		<button id="getButton">查询</button>
		<button id="delButton">删除</button>
	
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script>
			$(function() {
				$('#getButton').on('click', function() {
					$.getJSON('employee/2056', function(data) {
						window.alert(data.name);
						window.alert(data.department.name);
					});
				});
				$('#delButton').on('click', function() {
					$.ajax({
						url: 'employee/3588',
						type: 'post',
						data: { '_method': 'delete' },
						success: function(data) {
							window.alert(data);
						}
					});
				});
			});
		</script>	
	</body>
</html>