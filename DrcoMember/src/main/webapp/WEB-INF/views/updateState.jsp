<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>정말 회원을 탈퇴하시겠습니까?</h1>
<h2>개인 정보 동의에 따라 가입일로부터<br /> 
	1년간 정보를 보관함에 따라 동일한 아이디로는 가입할 수 없습니다. <br />
	또한 게시판에 작성했던 모든 게시물도 삭제처리 됩니다. <br />
	그래도 탈퇴하시겠습니까?</h2>
<span>탈퇴를 동의하신다면 <b>드림코스메틱탈퇴동의</b>를 정확히 입력해주세요.</span>
<form action="updateState.do" method="post">
<input type="text" value="${dc_id}" name="dc_id" hidden="hidden" />
<input type="text" name="agree" />&nbsp;<input type="submit" value="탈퇴...ㅠㅠ" />
</form>
</body>
</html>