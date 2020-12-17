<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/choiceBo.css" />
	<script src="${path}/resources/js/Login.js"></script>
</head>
<body>

<div class="wrap-data">

	<header>
		<%@include file="../include/header.jsp" %>
	</header>

	

	<section id="container" class="contents">
	
		<div class="line-map">
			<div class="inner-line">
				<a href="/index.do">
					<span>홈</span>
				</a>
				<a> > </a>
				<span> 로그인
			    </span>
			</div>
		</div>

		

		<div class="inner-container-login">
						
			<div class="minTitle">
				<h1>로그인</h1>
			</div>
		<div class="userLog">
			
			<div class="choiceBoFormDiv">
				<div class="formTitle"> <h2>지점선택</h2> </div>
				<div class="choiceForm">
					<h3>이용하실 지점을 선택해주세요.</h3>
					<form action="ChoiceSeat.do" method="get">
						<div class="boSelect">
						<select name="boCode">
							<c:forEach items="${BoCodeList}" var="Bo">	
							<option value="${Bo.boCode}">${Bo.boName} 지점</option>
							</c:forEach>
						</select>
						</div>
						<input type="submit" class="subBtn" value="매장 선택" />
					</form>
				<button type="button" class="canBtn" onclick="location.href='index.do' ">취소</button>	
				</div>
			</div>
		</div>
		
		<!-- inner-container -->

		</div>
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
