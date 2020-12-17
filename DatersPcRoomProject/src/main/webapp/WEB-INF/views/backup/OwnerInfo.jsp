<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/ownPage.css" />
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
				<span> 개인회원가입
			    </span>
			</div>
		</div>
		<!-- line-map -->
		
	
		<div class="inner-container-login">
						
			<div class="minTitle">
				<h1>업주 페이지</h1>
			</div>
		<div class="ownPageFormDiv">
			<div class="formTitle"> <h2>매장 정보 등록</h2> </div>
	<form action="InsertBoInfo.do" method="post">
		<input type="hidden" name="boCode" value="${boCode}" />
		
		
		<div class="inputBox">
			<label for="boOrderName">지점장이름</label>
			<input type="text" name="boOrderName"/>
		</div><br />
		
		<div class="inputBoxRadio">
			<label for="boOrderGender">성별</label>
			<input type="radio" name="boOrderGender" value="남자" required="required"/>남자
			<input type="radio" name="boOrderGender" value="여자" required="required" />여자
		</div> <br />
		
		<div class="inputBox">
			<label for="boTotalseat">지점 총 좌석 수</label>
			<input type="text" name="boTotalseat"/>
		</div><br />
		
		<div class="inputBox">
			<label for="boAddress">지점 주소</label>
			<input type="text" name="boAddress"/>
		</div><br />
		
		<div class="inputBox">
			<label for="boTell">지점 전화번호</label>
			<input type="text" name="boTell"/>
		</div><br />

		<div class="inputBoxText">
			<label for="boIntro">지점 소개</label>
			<textarea name="boIntro" cols="30" rows="10"></textarea>
		</div><br />
		<input class="subBtn" type="submit" value="정보등록">
		<input class="resetBtn" type="reset" value="초기화">
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
