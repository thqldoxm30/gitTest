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
			<input type="text" name="boOrderName" required="required"/>
		</div><br />
		
		<div class="inputBoxRadio">
			<label for="boOrderGender">성별</label>
			<input type="radio" name="boOrderGender" value="남자" required="required"/>남자
			<input type="radio" name="boOrderGender" value="여자" required="required" />여자
		</div> <br />
		
		<div class="inputBox">
			<label for="boTotalseat">지점 총 좌석 수</label>
			<input type="text" name="boTotalseat" required="required"/>
		</div><br />
		
		<div class="inputBoxRadio">
			<label for="">프린터 구비 유무</label>
			<input type="radio" name="boPrinter" value="1" required="required"/>유
			<input type="radio" name="boPrinter" value="2" required="required"/>무
		</div><br />
		
		<div class="inputBox">
			<label for="boAddress">지점 주소</label>
			<input type="text" name="boAddress" required="required"/>
		</div><br />
		
		<div class="inputBox">
			<label for="boTell">지점 전화번호</label>
			<input type="text" maxlength="13" name="boTell" id="telnum" required="required" onKeyup="inputPhoneNumber(this);" />
		</div><br />

		<div class="inputBoxText">
			<label for="boIntro">지점 소개</label>
			<textarea name="boIntro" cols="30" rows="10" required="required"></textarea>
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
<script>
        
	//전화번호 하이폰 자동 완성
	var autoHypenPhone = function(str) {
		str = str.replace(/[^0-9]/g, '');
		var tmp = '';
		if (str.length < 4) {
			return str;
		} else if (str.length < 7) {
			if(str.substr(0,2) == '02'){
				tmp += str.substr(0, 2);
				tmp += '-';
				tmp += str.substr(2);
			}else{
				tmp += str.substr(0, 3);
				tmp += '-';
				tmp += str.substr(3);				
			}
			return tmp;
		} else if (str.length < 11) {
			if(str.substr(0,2) == '02'){
				tmp += str.substr(0, 2);
				tmp += '-';
				tmp += str.substr(2, 4);
				tmp += '-';
				tmp += str.substr(6);
			}else{
				tmp += str.substr(0, 3);
				tmp += '-';
				tmp += str.substr(3, 3);
				tmp += '-';
				tmp += str.substr(6);
			}
			return tmp;
		} else {
			if(str.substr(0,2) == '02'){
				tmp += str.substr(0, 2);
				tmp += '-';
				tmp += str.substr(3, 4);
				tmp += '-';
				tmp += str.substr(7);
			}else{
				tmp += str.substr(0, 3);
				tmp += '-';
				tmp += str.substr(3, 4);
				tmp += '-';
				tmp += str.substr(7);
			}
			return tmp;
		}

		return str;
	}

	var phoneNum = document.getElementById('telnum');

	phoneNum.onkeyup = function() {
		this.value = autoHypenPhone(this.value);
	}
</script>
</html>
