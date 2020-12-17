<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>드림 코스메틱 회원 가입</title>
<style>
	#joinWrap{
		width: 800px; margin: 0 auto; 
	}
	h1{
		text-align: center;
	}
	.joinItem{
		width: 100%; line-height: 30px; 
	}
	label{
		width: 110px; display: inline-block;
	}
	input{
		width: 250px;
	}
	li{
		list-style: none;
	}
</style>
</head>
<body>
<div id="joinWrap">
	<h1>드림 코스메틱 회원 가입</h1>
	<hr />
	<form name="frm" onsubmit="return validate();" action="joinDrco.do" method="post" >
		<ul class="joinItem">
			<li>
				<label for="dc_id">아이디</label>
				<input type="text" id="dc_id" name="dc_id" maxlength="20" placeholder="아이디를 입력해주세요" required="required"/>
				<input type="button" value="중복확인" onclick="dc_idChk()" style="width: 70px"/>
			</li>
			<li>
				<label for="dc_password">비밀번호</label>
				<input type="password" id="dc_password" name="dc_password" maxlength="16" placeholder="비밀번호를 입력해주세요" required="required"/>
			</li>
			<li>
				<label for="dc_passwordChk">비밀번호 확인</label>
				<input type="password" name="dc_passwordChk" placeholder="비밀번호를 다시 한번 입력해주세요" required="required"/>
			</li>
			<li>
				<label for="dc_name">이름</label>
				<input type="text" id="dc_name" name="dc_name" placeholder="이름을 입력해주세요" required="required"/>
			</li>
			<li>
				<label for="dc_birth">생년월일</label>
				<input type="text" id="dc_birth" name="dc_birth" placeholder="생년월일을 입력해주세요(ex.19950614)" required="required"/>
			</li>
			<li>
				<label>성별</label>
				<input type="radio" name="dc_gender" value="lady" checked="checked" style="width: 20px" />여
				<input type="radio" name="dc_gender" value="man" style="width: 20px" />남
			</li>
			<li>
				<label for="dc_address">주소</label>
				<input type="text" id="dc_address" name="dc_address" placeholder="주소를 입력해주세요" />
			</li>
			<li>
				<label for="dc_email">이메일</label>
				<input type="text" id="dc_email" name="dc_email" placeholder="이메일을 입력해주세요" />
			</li>
			<li>
				<input type="reset" value="내용 삭제" id="btnClear" style="width: 80px;">
				<input type="submit" id="btnSend" value="회원 가입" style="width: 80px;"/>
			</li>
			
		</ul>
	</form>	
	<hr />
	
	<a href="index.jsp" style="float: right; text-decoration: none">메인 페이지로 이동</a>
</div>
<script type="text/javascript">
	
	/* window.onload = function() {
		document.getElementById("btnSend").onclick = chkData;
		document.getElementById("btnClear").onclick = clsData;
	} */
	function validate() {
		//---------------- 정규식
		var userIdCheck = /^[A-Za-z0-9_\-]{5,20}$/;
		var passwdCheck = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;
		var nameCheck = /^[가-힣]{2,10}$/;
		var emailCheck = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		var birthdayCheck = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
		
	
		//---------------- 항목
		var dc_id = document.getElementById("dc_id");
		var dc_password = document.getElementById("dc_password");
		var dc_name = document.getElementById("dc_name");
		var dc_birth = document.getElementById("dc_birth");
		var dc_email = document.getElementById("dc_email");
		var dc_passwordChk = document.getElementById("dc_passwordChk");
		

		if (!check(nameCheck, dc_name, "이름을 한글 2~10자리로 입력해주세요.")) {
			return false;
		}
		
		if (!check(userIdCheck, dc_id, "아이디를 5~20자 영어 대소문자, 숫자, -, _ 만으로 입력해주세요!")) {
			return false;
		}
		
		if (!check(passwdCheck, dc_password, "비밀번호를 숫자, 특문 각 1회 이상, 영문은 2개 이상 사용하여 8자리 이상 입력해주세요!")) {
			return false;
		}
		
		if (!check(birthdayCheck, dc_birth, "생년월일을 8자리로 입력해주세요!(ex. 19950614)")) {
			return false;
		}
		
		if (!check(emailCheck, dc_email, "이메일을 정확하게 입력해주세요!")) {
			if(dc_email.value == ""){
				return true;
			}
			return false;
		}
		
		
		
		function check(re, what, message) {
			if (re.test(what.value)) {
				return true;
			}
			alert(message);
			what.value = "";
			what.focus();
			//return false;
		}
		
		
		//정규 표현식으로 입력자료 검사
		/* var aa = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/; // 표준식
		// a부터 z까지 문자 1개 이상일 경우 and 숫자 0,1,2일 경우에만
		if (!frm.dc_email.value.match(aa)) {
			alert("이메일을 정확히 입력하세요!");
			frm.dc_email.focus();
			return;
		} */

		/* frm.action = "joinDrco.do";
		frm.method = "post";
		frm.submit(); */

	}
	/* function clsData() {
		frm.dc_name.value = "";
		frm.dc_id.value = "";
		frm.dc_email.value = "";
		frm.dc_birth.value = "";
		return;
	} */
</script>
</body>
</html>