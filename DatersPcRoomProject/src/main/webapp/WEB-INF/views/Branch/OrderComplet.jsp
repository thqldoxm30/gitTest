<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${path}/resources/css/menu.css?after" />
<title>주문 완료</title>
<script>
	function windowClose(){
		window.close();
	}
</script>
</head>
<body>
<div class="orderComplete">
<h2>주문이 정상적으로 완료 되었습니다.</h2>
<button class="outBtn" onclick="windowClose()">창 닫기</button>
</div>
</body>
</html>