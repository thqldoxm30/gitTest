<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/join.css" />
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
   	<script type="text/javascript" src="${path}/resources/js/OwnerJoin.js"></script>
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
				<span> 업주회원가입
			    </span>
			</div>
		</div>
		<!-- line-map -->
		
	
		<div class="inner-container-login">
						
			<div class="minTitle">
				<h1>매장 등록</h1>
			</div>
				<div class="ownerJoinFormDiv">
					<div class="formTitle">
						<h2>회원가입</h2>
					</div>
					<form action="BranchJoin.do" method="post">
						<div class="inputBox">
							<label for="boId">업주 아이디</label> 
							<input type="text" name="boId" id="boId" class="idArea"
								placeholder="사용할 아이디를 입력해주세요." />
							<p id="idM">아이디를 입력해주세요!</p>
						</div>
						<br />
						<div class="inputBox">
							<label for="boPwd">업주 비밀번호</label> 
							<input type="password" name="boPwd" id="boPwd" class="pwArea"
								placeholder="사용할 비밀번호를 입력해주세요." />
							<p id="pwM1">비밀번호를 입력해주세요!</p>
						</div>
						<br />
						<div class="inputBox">
							<label for="checkpw">[필수] 비밀번호 확인</label> 
							<input type="password"
								name="uPwd2" class="pwChkArea" id="checkpw"
									placeholder="비밀번호재입력" >
							<p id="pwM2"></p>
						</div>
						<div class="inputBox">
							<label for="boId">지점명</label> 
							<input type="text" name="boName" id="boName" class="boName"
								placeholder="지점명을 입력해주세요." />
							<p id="nameM" style="font-size: 12px; color: red;">지점명을 입력해주세요.</p>
						</div>
						<br /> <input class="subBtn" type="submit" value="업주가입" />
					</form>
					<button type="button" class="canBtn"
						onclick="location.href='index.do' ">취소</button>
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
