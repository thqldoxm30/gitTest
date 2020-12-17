<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/login.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/ownerMain.css" /> <!-- 정산 CSS ( 테이블 회원 정보와 내용 동일)-->
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
				<span> 정산하기
			    </span>
			</div>
		</div>
		<!-- line-map -->
	
	<div class="minTitle">
		<h1>정산하기</h1>
	</div>		
	<h1 class="branchName">매장명 : ${BranchVO.boName }</h1>
	<div class="ownerTable">
		<table>
			<tr>
				<th>유저코드</th>
				<th>지점코드</th>
				<th>결제날짜</th>
				<th>총사용시간</th>
				<th>시간결제금액</th>
				<th>기타결제금액</th>
				<th>상세결제정보</th>
				<th>이용좌석</th>
			</tr>
			<c:forEach items="${UserHistory}" var="History">
				<tr>
					<th>${History.uCode}</th>
					<th>${History.boCode}</th>
					<th>${History.uToday}</th>
					<th>${History.uUseTime}</th>
					<th>${History.uUseTimePay }</th>
					<th>${History.uUseOtherPay}</th>
					<th><textarea cols="50" rows="4" readonly="readonly">${History.uUseInfo}</textarea></th>
					<th>${History.uNowseat}</th>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<button class="subBtn" onclick="location.href='NowCalcu.do'">정산하기</button>
	
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
