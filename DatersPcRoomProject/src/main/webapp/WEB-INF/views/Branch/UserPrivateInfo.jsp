<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/myPage.css" />
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
				<span> 마이페이지
			    </span>
			</div>
		</div>
		<!-- line-map -->
		
	
		<div class="inner-container-login">
						
			<div class="minTitle">
				<h1>유저 페이지</h1>
			</div>
		<div class="myUserPageFormDiv">
		<div class="formTitle"> <h2>${UserPrivate.uId }님</h2> </div>
	
	<form action="UserPrivateUpdate.do" method="post">
		<input type="hidden" name="boCode" value="${UserPrivate.boCode }" />
		<input type="hidden" name="uCode" value="${UserPrivate.uCode}" />
		<div class="inputBox">
			<label for="uId">아이디</label>
			<input type="text" name="uId" value="${UserPrivate.uId}" />
		</div><br />
		<div class="inputBox">
			<label for="uPwd">비밀번호</label>
			<input type="password" name="uPwd" value="${UserPrivate.uPwd}"/>
		</div><br />
		<div class="inputBox">
			<label for="uName">성명</label>
			<input type="text" name="uName" value="${UserPrivate.uName}"/>
		</div><br />
		<div class="inputBox">
			<label for="uBirth">생일</label>
			<input type="date" name="uBirth" value="${UserPrivate.uBirth}" required="required"/>
		</div><br />
		<div class="inputBoxRadio">
		<label for="uGender">성별</label>
			<input type="radio" name="uGender" value="남자" required="required"/>남자
			<input type="radio" name="uGender" value="여자" required="required"/>여자 
		</div><br />
		<div class="inputBox">
			<label for="uEmail">이메일</label>
			<input type="text" name="uEmail" value="${UserPrivate.uEmail}"/>
		</div><br />
		<div class="inputBox">
			<label for="uPhone">전화번호</label>
			<input type="text" name="uPhone" value="${UserPrivate.uPhone}"/>
		</div><br />
		<div class="inputBox">
			<label for="uAddress">주소</label>
			<input type="text" name="uAddress" value="${UserPrivate.uAddress}"/>
		</div><br />
		<div class="inputBoxRadio">
		<label for="uState">
			<c:choose>
				<c:when test="${UserPrivate.uState == 1}">
					[ 현재 회원의 상태 : 활동중 ]<br />
				</c:when>
				<c:when test="${UserPrivate.uState == 2}">
					[ 현재 회원의 상태 : 휴면상태 ]<br />
				</c:when>
				<c:when test="${UserPrivate.uState == 3}">
					[ 현재 회원의 상태 : 탈퇴 ]<br />
				</c:when>
			</c:choose>
		</label>

		<input type="radio" name="uState" value="1" />활동
		<input type="radio" name="uState" value="2" />휴면
		<input type="radio" name="uState" value="3" />탈퇴
		</div><br />
		<div class="userOther">
		보유포인트 : ${UserPrivate.uPoint} <br />
		남은시간 : ${uSaveTimeH}시간 ${uSaveTimeM}분<br />
		가입일 : ${UserPrivate.uRegdate }
		</div>
		<input type="submit" class="subBtn" value="정보수정" />
	</form>
		<button type="button" class="canBtn" onclick="location.href='UserTable.do'">뒤로가기</button>
		</div>
		</div>
		
		<!-- inner-container -->
		
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