<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
<h1>${loginMember.dc_name}님의 새로운 게시글 등록</h1>
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>제목 : </td>
			<td><input type="text" name="b_title" required="required"/>
			</td>
		</tr>
		<tr>
			<td>작성자 : </td>
			<td>${loginMember.dc_id}
				<input type="text" name="dc_id" value="${loginMember.dc_id }" hidden="hidden" />
			</td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td><textarea name="b_content" cols="50" rows="15" required="required"></textarea></td>
		</tr>
		<tr>
			<td bgcolor="orange" width="70">업로드</td>
			<td><input type="file" name="b_uploadfile" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="새 글 등록하기" /></td>
		</tr>
	</table>
</form>
<hr />
<a href="viewBoardList.do">글 목록 보기</a><br />
<a href="logout.do">로그아웃</a>

</body>
</html>