<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
	
		<div class="line-map">
			<div class="inner-line">
				<a href="/index/do">
					<span>홈</span>
				</a>
				<a> > </a>
				<span> 로그인
			    </span>
			</div>
		</div>
		<!-- line-map -->
		
	
		<div class="inner-container-login">
						
			<div class="minTitle">
				<h1>업주 로그인</h1>
			</div>
		<div class="loginFormDiv">
			<div class="formTitle"> <h2>로그인</h2> </div>
	<form action="BranchLogin.do" method="post">
		<div class="inputBox">
			<input type="text" name="boId" placeholder="업주 아이디"/>
			<input type="password" name="boPwd" placeholder="업주 비밀번호" />
		</div>
		<input type="submit" class="subBtn" value="업주로그인" />
	</form>
	<button type="button" class="canBtn" onclick="location.href='index.do' ">취소</button>	
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
