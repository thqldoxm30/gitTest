<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/charge.css" />
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
				<span> 시간충전
			    </span>
			</div>
		</div>
		<!-- line-map -->
		
	
		<div class="inner-container-login">
						
			<div class="minTitle">
				<h1>시간 충전</h1>
			</div>
		<div class="chargeFormDiv">
			<div class="formTitle"> <h2>충전 결제 안내</h2> </div>
				${UserInfo.uName}님의 남은시간은 ${uSaveTimeH}시간 ${uSaveTimeM}분 남았습니다.
				<form action="InsertUserCash.do" method="post">
					얼마를 충전 하시겠어요?
					
					<table class="chargeTable">
						<caption>충전 시간 선택</caption>
						<thead>
							<tr>
								<th>충전 시간</th>
								<th>금액</th>
								<th>추가 포인트</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th class="radio"> <input type="radio" name="uSavetime" value="1" checked />1시간 </th>
								<th> 1,000원 </th>
								<th> 10 Point </th>								
							</tr>
							<tr>
								<th class="radio"> <input type="radio" name="uSavetime" value="2"/>2시간 </th>
								<th> 2,000원 </th>
								<th> 20 Point </th>								
							</tr>
							<tr>
								<th class="radio"> <input type="radio" name="uSavetime" value="3"/>3시간 </th>
								<th> 3,000원 </th>
								<th> 30 Point </th>								
							</tr>
							<tr>
								<th class="radio"> <input type="radio" name="uSavetime" value="4"/>4시간 </th>
								<th> 4,000원 </th>
								<th> 40 Point </th>								
							</tr>
							<tr>
								<th class="radio"> <input type="radio" name="uSavetime" value="5"/>5시간 </th>
								<th> 5,000원 </th>
								<th> 50 Point </th>								
							</tr>
							<tr>
								<th class="radio"> <input type="radio" name="uSavetime" value="10"/>10시간 </th>
								<th> 6,000원 </th>
								<th> 60 Point </th>								
							</tr>
						</tbody>
					</table>
					
				<input class="subBtn" type="submit" value="충전하기" />
					
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
