$(document).ready(function(){
 	var idChk = /^[a-zA-Z0-9]{5,20}$/;
    var pwdChk = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-z]{1,50}).{8,30}$/;
    var korean = /[가-힣]{3,16}/;
    
    var pw = document.getElementById("boPwd");
    var pUn1 = document.getElementById("pwM1");
    var pUn = document.getElementById("pwM2");
    var iUn = document.getElementById("idM");
    var nameM = document.getElementById("nameM");
    
    $('#boId').on('keyup', function () {//아이디 유효성 검사
        if (!idChk.test($('#boId').val())) {
            iUn.innerHTML = "아이디는 5~20자의 영문 대소문자와 숫자로만 입력!";
            $('#idM').css({
                color: 'red'
            });
        }else{
            iUn.innerHTML = "";
        }
    });

    $('#boPwd').on('keyup', function () {//비밀번호 유효성 검사
        if (!pwdChk.test($('#boPwd').val())) {
            pUn1.innerHTML = "비밀번호는 6자리 이상의 영소문자, 1자리 이상의 숫자와 특수문자의 조합으로 입력!";
            $('#pwM1').css({
                color: 'red'
            });
        }else{
        	pUn1.innerHTML = "";
        	pUn.innerHTML = "비밀번호를 재입력해주세요!";
        	$('#pwM2').css({
        		color: 'red'
        	});
        }
    });

    $('#checkpw').on("keyup", function () {//비밀번호재입력 유효성 검사
        if (pw.value != checkpw.value || checkpw.value == "") {
            pUn.innerHTML = "비밀번호를 다시 확인해주세요.";
            $('#pwM2').css({
                color: 'red'
            });
        } else if(pwdChk.test($('#pw').val())){
        	pUn1.innerHTML = "";
        	pUn.innerHTML = "";        	
        } else{
        	pUn.innerHTML = "";        	        	
        }
        if($('#boPwd').val() == ""){        	
        	pUn.innerHTML = "";
        }
    });
    
    $('#boName').on("keyup", function () { //지점명 유효성 검사
        if (!korean.test($('#boName').val())) {
        	nameM.innerHTML = "지점명을 다시 확인해주세요.";
            $('#nameM').css({
                color: 'red'
            });
        } else {
        	nameM.innerHTML = "";
        }
        
    });
    
    $('.subBtn').on('click', function () { //회원가입시 유효성 검사
        var id = $(".idArea");
        var pw = $(".pwArea");
        var pw2 = $(".pwChkArea");
        var boName = $(".boName");
        
        if (id.val() != "" && id.next().html() == "") {
            if (pw.val() != "" && pw.next().html() == "") {
                if (pw2.val() != "" && pw2.next().html() == "") {
                	if(boName.val() != "" && boName.next().html() == ""){
                		$('.subBtn').submit();
                	} else {
	                    alert("지점명이 잘못되었습니다.");
	                    return false;
	                }
                } else {
                    alert("비밀번호재입력이 잘못되었습니다.");
                    return false;
                }
            } else {
                alert("비밀번호가 잘못되었습니다.");
                return false;
            }
        } else {
            alert("아이디가 잘못 되었습니다.");
            return false;
        }
    });	
});
