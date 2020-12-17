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
				<h1>마이페이지</h1>
			</div>
		<div class="myPageFormDiv">
			<div class="formTitle"> <h2>마이페이지</h2> </div>
	<form action="UsersUpdate.do" method="post">
		<input type="hidden" name="uCode" value="${UserInfo.uCode}" />
		<div class="inputBox">
			<label for="uId">아이디</label>
			<input type="text" id="uId" name="uId" value="${UserInfo.uId}" readonly="readonly"/>
		</div><br />
		<div class="inputBox">
			<label for="uPwd">비밀번호</label>
			<input type="password" id="uPwd" name="uPwd" value="${UserInfo.uPwd}"/>
		</div><br />
		<div class="inputBox">
			<label for="uName">성명</label>
			<input type="text" id="uName" name="uName" value="${UserInfo.uName}"/>
		</div><br />
		<div class="inputBox">
			<label for="uBirth">생일</label>
			<input type="date" id="uBirth" value="${UserInfo.uBirth}" readonly="readonly" />
		</div>
		<div class="inputBoxRadio">
			<label for="uGender">성별</label>
			<input type="radio" name="uGender" value="남자" required="required"/>남자
			<input type="radio" name="uGender" value="여자" required="required"/>여자 
		</div><br />
		<div class="inputBox">
			<label for="uEmail">이메일</label>
			<input type="text" id="uEmail" name="uEmail" value="${UserInfo.uEmail}"/>
		</div><br />
		<div class="inputBox">
			<label for="uPhone">전화번호</label>
			<input type="text" id="uPhone" name="uPhone" value="${UserInfo.uPhone}"/>
		</div><br />
		<div class="inputBox">
			<label for="uAddress">주소</label>
			<input type="text" id="uAddress" name="uAddress" value="${UserInfo.uAddress}"/>
		</div><br />
		<div class="userOther">
		보유포인트 : ${UserInfo.uPoint} <br />
		남은시간 : ${uSaveTimeH }시간 ${uSaveTimeM}분<br />
		가입일 : ${UserInfo.uRegdate }
		</div>
			<input class="subBtn" type="submit" value="정보수정" />
	</form>
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
