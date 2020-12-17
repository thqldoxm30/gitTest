<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 개인정보 페이지</title>
</head>
<body>
	${UserPrivate.uId }님의 개인정보 페이지 입니다.
	<form action="UserPrivateUpdate.do" method="post">
		<input type="hidden" name="boCode" value="${UserPrivate.boCode }" />
		<input type="hidden" name="uCode" value="${UserPrivate.uCode}" />
		<input type="text" name="uId" value="${UserPrivate.uId}" /> <br />
		<input type="password" name="uPwd" value="${UserPrivate.uPwd}"/> <br />
		<input type="text" name="uName" value="${UserPrivate.uName}"/> <br />
		<input type="date" name="uBirth" /><br />
		<input type="radio" name="uGender" value="남자" required="required"/>남자
		<input type="radio" name="uGender" value="여자" required="required"/>여자 <br />
		<input type="text" name="uEmail" value="${UserPrivate.uEmail}"/> <br />
		<input type="text" name="uPhone" value="${UserPrivate.uPhone}"/> <br />
		<input type="text" name="uAddress" value="${UserPrivate.uAddress}"/> <br />
		<input type="submit" value="정보수정" />
	</form>
		보유포인트 : ${UserPrivate.uPoint} <br />
		남은시간 : ${uSaveTimeH}시간 ${uSaveTimeM}분<br />
		가입일 : ${UserPrivate.uRegdate }
</body>
</html>