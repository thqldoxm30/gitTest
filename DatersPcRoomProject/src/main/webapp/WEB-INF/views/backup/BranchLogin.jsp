<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/login.css" />
</head>
<body>

<div class="wrap-data">
	<!-- 헤더 -->
	<header>
		<%@include file="../include/header.jsp" %>
	</header>
	<!-- 헤더 -->

	<section id="container" class="contents">
	<div class="bu">
		<button type="button" onclick="location='BranchLoginGo.do'">회원정보</button>
		<button type="button" onclick="location='BranchCalculateGo.do'">정산</button>
		<button type="button" onclick="location='BranchMyPage.do'">마이페이지</button>
		<button type="button" onclick="location='Logout.do'">로그아웃</button>
	</div>
	<form id="frm" name="frm" method="post">
		<table>
			<tr>
				<th>지점코드</th>
				<th>회원코드</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>생년월일</th>
				<th>성별</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>총 충전시간</th>
				<th>남은 시간</th>
				<th>포인트</th>
				<th>상태</th>
				<th>가입일</th>
			</tr>
	
	 		<c:forEach items="${users}" var="users">
			<tr>
				<td>${users.boCode }</td>
				<td>${users.uCode }</td>
				<td><a href="#" onclick="fscreen('UsersPrivate.do','${users.uId}')">${users.uId}</a></td>
				<td>${users.uPwd}</td>
				<td>${users.uName}</td>
				<td>${users.uBirth}</td>
				<td>${users.uGender }</td>
				<td>${users.uEmail}</td>
				<td>${users.uPhone}</td>
				<td>${users.uAddress}</td>
				<td>${users.uAllTime}</td>
				<td>${users.uSavetime}</td>
				<td>${users.uPoint}</td>
				<td>${users.uState}</td>
				<td><fmt:formatDate value="${users.uRegdate}" pattern="yyyy-MM-dd" /></td>
				
			</tr>
			</c:forEach>
		</table>
		<input type="hidden" name="uId" id="uId" hidden="hidden" />
	</form>
	</section>



	<footer>
		<%@include file="../include/footer.jsp" %>
	</footer>
</div>

	<!-- 윙메뉴 -->
	<%@include file="../include/nav.jsp" %>
	<!-- 윙메뉴 -->
	

</body>
</html>