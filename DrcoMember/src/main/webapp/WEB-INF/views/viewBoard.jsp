<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${thisBoard.b_title}</h1>
<div class="viewBoardWrap">
	<table>
		<tr>
			<td>일련번호</td>
			<td>${thisBoard.b_seq}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${thisBoard.b_title}</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${thisBoard.dc_id}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${thisBoard.b_content}</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><fmt:formatDate value="${thisBoard.b_writeDate}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${thisBoard.b_cnt}</td>
		</tr>
		<tr>
			<td>업로드 파일 >> </td>
			<td>${thisBoard.b_fileLoad}</td>
		</tr>
	</table>
	<hr />
	<a href="updateBoard.do?b_seq=${thisBoard.b_seq}">글 수정하기</a><br />
	<a href="deleteBoardOne.do?b_seq=${thisBoard.b_seq}">글 삭제하기</a><br />
	<a href="viewBoardList.do">전체 목록 보기</a><br />
</div>
</body>
</html>