<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/login.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/ownerMain.css" /> <!-- 회원정보 CSS -->
</head>
<body>

<div class="wrap-data">
	<!-- 헤더 -->
	<header>
		<%@include file="../include/header.jsp" %>
	</header>
	<!-- 헤더 -->

	<section id="container" class="contents">
	
					<div class="line-map">
			<div class="inner-line">
				<a href="/index.do">
					<span>홈</span>
				</a>
				<a> > </a>
				<span> 회원목록
			    </span>
			</div>
		</div>
		<!-- line-map -->
		

	
	<div class="ownerTable">
		<div class="minTitle">
		<h1>회원 목록</h1>
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
					<c:choose>
						<c:when test="${users.uState == 1}">
							<td>활동중</td>
						</c:when>
						<c:when test="${users.uState == 2}">
							<td>휴면상태</td>
						</c:when>
						<c:when test="${users.uState == 3}">
							<td>탈퇴처리</td>
						</c:when>
					</c:choose>
					<td><fmt:formatDate value="${users.uRegdate}" pattern="yyyy-MM-dd" /></td>
					
				</tr>
				</c:forEach>
			</table>
			<input type="hidden" name="uId" id="uId" hidden="hidden" />
		</form>
	</div>
	</section>



	<footer>
		<%@include file="../include/footer.jsp" %>
	</footer>
</div>

	<!-- 윙메뉴 -->
	<%@include file="../include/nav.jsp" %>
	<!-- 윙메뉴 -->
	
<script>
   function fscreen(url, val) {
      document.getElementById('uId').value = val
      var obj = document.getElementById('frm')
      obj.action = url
      obj.submit()
   }
</script>

</body>
</html>