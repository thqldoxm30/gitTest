<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/join.css?after" />
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
   	<script type="text/javascript" src="${path}/resources/js/UserJoin.js"></script>
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
				<h1>회원가입</h1>
			</div>
			
		<div class="userJoinFormDiv">
			<div class="formTitle"> <h2>회원가입</h2> </div>
	<form action="UserJoin.do" method="post">
	
    <div class="inputBox">
        <label for="uId">[필수] 아이디</label>
        <div class="memberMainForm">
            <input type="text" name="uId" class="idArea" id="id"
                placeholder="아이디입력 5-20자" required>
        </div>
        <p id="idM">아이디를 입력해주세요!</p>
    </div>

    <div class="inputBox">
        <label for="uPwd">[필수] 비밀번호</label>
        <div class="memberMainForm">
            <input type="password" name="uPwd" class="pwArea" id="pw"
                placeholder="비밀번호입력" required>
        </div>
        <p id="pwM1">비밀번호를 입력해주세요!</p>
    </div>

    <div class="inputBox">
        <label for="uPwd">[필수] 비밀번호 확인</label>
        <div class="memberMainForm">
            <input type="password" name="uPwd2" class="pwChkArea" id="checkpw"
                placeholder="비밀번호재입력" required>
        </div>
        <p id="pwM2"></p>
    </div>

    <div class="inputBox">
        <label for="uName">[필수] 성명</label>
        <div class="memberMainForm">
            <input type="text" name="uName" class="nameArea" id="name" placeholder="ex)홍길동"
                required="required" maxlength="5">
        </div>
        <p id="naM">이름을 다시 입력해주세요!</p>
    </div>

    <div class="inputBox">
        <label for="uBirth">[필수] 생년월일</label>
        <div class="memberMainForm">
            <input type="date" name="uBirth" class="birthArea" id="birth" required>
        </div>
        <p id="brM"></p>
    </div>
	
    <div class="inputBoxRadio">
        <label for="uGender">[필수]성별</label> <br />
        <input type="radio" name="uGender" value="남자" required="required"/>남자
        <input type="radio" name="uGender" value="여자" required="required"/>여자
    </div> <br />

    <div class="inputBox">
        <label for="uPhone">[필수]전화번호</label>
        <div class="memberMainForm">
            <input type="text" name="uPhone" class="phoneArea" id="telnum"
                onKeyup="inputPhoneNumber(this);" maxlength="13"
                placeholder="000-0000-0000">
        </div>
        <p id="numM"></p>
    </div>

    <div class="inputBox">
        <label for="uEmail">[필수] 이메일</label>
        <div class="memberMainForm">
            <input type="text" name="uEmail" class="emailArea" id="email"
                placeholder="exam@exam.com">
        </div>
        <p id="emM"></p>
    </div>

    <div class="inputBox">
        <label for="uAddress">주소</label>
        <div class="memberMainForm">
        <input type="text" name="uAddress" placeholder="주소를 입력해주세요." required="required"/>
        </div>
    </div> <br />

    <div class="inputBox">
        <label for="boCode">가입지점 선택</label>
        <select name="boCode">
            <c:forEach items="${BoCodeList}" var="Bo">	
            <option value="${Bo.boCode}">${Bo.boName} 지점</option>
            </c:forEach>
        </select>  <br />
    </div>
		
		<input class="subBtn" id="submit" type="submit" value="회원가입">
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
</body>
</html>
