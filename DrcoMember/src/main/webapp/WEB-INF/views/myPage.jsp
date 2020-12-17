<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>
	input{
		width: auto;
	}
	th{
		border-bottom: 1px solid black;
	}
	td{
		border-right: 1px solid black;
	}
</style>
</head>
<body>
<h1>${loginMember.dc_name}님 정보 조회</h1>
<form action="updateMyInfo.do" method="post">
	<table style="border: 1px solid black">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>성별</th>
			<th>주소</th>
			<th>이메일</th>
			<th>가입일</th>
			<th>회원등급</th>
			<th>게시글 작성 수</th>
			<th>댓글 작성 수</th>
			<th>방문 횟수</th>
		</tr>
		<tr>
			<td><input type="text" name="dc_id" value="${loginMember.dc_id}" hidden="hidden"/>${loginMember.dc_id}</td>
			<td><input type="text" name="dc_password" value="${loginMember.dc_password}"/></td>
			<td>${loginMember.dc_name}</td>
			<td><input type="number" name="dc_birth" value="${loginMember.dc_birth}"/></td>
			<td>${loginMember.dc_gender}</td>
			<td><input type="text" name="dc_address" value="${loginMember.dc_address}"/></td>
			<td><input type="text" name="dc_email" value="${loginMember.dc_email}"/></td>
			<td><fmt:formatDate value="${loginMember.dc_regDate}" pattern="yyyy-MM-dd"/></td>
			<td>${loginMember.dc_grade}</td>
			<td>${loginMember.dc_boardCnt}</td>
			<td>${loginMember.dc_commCnt}</td>
			<td>${loginMember.dc_enterCnt}</td>
		</tr>
	</table>
	<br />
	<input type="submit" value="정보수정" />
</form>
<br />
<a href="updateState.do?dc_id=${loginMember.dc_id}&agree=0">회원 탈퇴</a>
</body>
</html>