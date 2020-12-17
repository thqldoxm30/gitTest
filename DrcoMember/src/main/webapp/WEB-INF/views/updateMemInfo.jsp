<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 보기</title>
<style>
	
</style>
</head>
<body>
<h1>회원 수정란</h1>
<h2>${updateMemInfo.dc_id}님 정보</h2>
<form action="updateMemInfo.do" method="post">
	<table>
		<tr >
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
			<td><input type="text" name="dc_id" value="${updateMemInfo.dc_id}" />${myInfo.dc_id}</td>
			<td><input type="text" name="dc_password" value="${updateMemInfo.dc_password}"/></td>
			<td><input type="text" name="dc_name" value="${updateMemInfo.dc_name}" /></td>
			<td><input type="number" name="dc_birth" value="${updateMemInfo.dc_birth}"/></td>
			<td><input type="text" name="dc_gender" value="${updateMemInfo.dc_gender}" /></td>
			<td><input type="text" name="dc_address" value="${updateMemInfo.dc_address}"/></td>
			<td><input type="text" name="dc_email" value="${updateMemInfo.dc_email}"/></td>
			<td><fmt:formatDate value="${updateMemInfo.dc_regDate}" pattern="yyyy-MM-dd"/></td>
			<td><input type="number" name="dc_grade" value="${updateMemInfo.dc_grade}" /></td>
			<td><input type="number" name="dc_state" value="${updateMemInfo.dc_state}" /></td>
			<td><input type="number" name="dc_boardCnt" value="${updateMemInfo.dc_boardCnt}" /></td>
			<td><input type="number" name="dc_commCnt" value="${updateMemInfo.dc_commCnt}" /></td>
			<td><input type="number" name="dc_enterCnt" value="${updateMemInfo.dc_enterCnt}" /></td>
		</tr>
	</table>
	<input type="submit" value="정보수정" />
</form>

</body>
</html>