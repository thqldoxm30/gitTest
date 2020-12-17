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
<form action="updateComplet.do" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="b_title" value="${thisBoard.b_title}" />
				<input type="text" name="b_seq" value="${thisBoard.b_seq}" hidden="hidden" />
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${thisBoard.dc_id}
				<input type="text" name="b_writer" value="${thisBoard.dc_id}" hidden="hidden" />
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="b_content" cols="50" rows="10">${thisBoard.b_content}</textarea>
			</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><fmt:formatDate value="${selectBoardOne.b_writeDate}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${thisBoard.b_cnt}</td>
		</tr>
		<tr>
			<td bgcolor="orange">업로드 파일</td>
			<td>${thisBoard.b_fileLoad}<input type="file" name="b_uploadfile" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="글수정" /></td>
		</tr>
	</table>
</form>
<a href="insertBoard.jsp">게시글 쓰기</a>
<br />
<a href="deleteBoardOne.do?b_seq=${thisBoard.b_seq}">글 삭제</a>
<br />
<a href="viewBoardList.do">글 목록</a>
<br />
</body>
</html>