$(document).ready(function(){

    $('.contants .memberMainForm').click(function(){
        $('.contants .memberMainForm').not($(this).addClass('focus')).removeClass('focus');
        $(this).find('input').focus();
    });
    $(document).click(function(event) { 
        $target = $(event.target);
        if(!$target.closest('.memberMainForm').length && 
        $('.memberMainForm').is(":visible")) {
          $('.memberMainForm').removeClass('focus');
        }
      });

    var re = /^[a-zA-Z0-9]{5,20}$/;
    var re1 = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-z]{1,50}).{8,30}$/;
    var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    var pw = document.getElementById("pw");
    var pUn1 = document.getElementById("pwM1");
    var pUn = document.getElementById("pwM2");
    var iUn = document.getElementById("idM");
    var eUn = document.getElementById("emM");
    var nUn = document.getElementById("naM");
	var brM = document.getElementById("brM");

     $('#id').on('keyup', function () {//아이디 유효성 검사
        $('#id').val();
        if (!re.test($('#id').val())) {
            iUn.innerHTML = "아이디는 5~20자의 영문 대소문자와 숫자로만 입력!";
            $('#idM').css({
                color: 'red'
            });
        }else{
            iUn.innerHTML = "";
        }
    });

    $('#pw').on('keyup', function () {//비밀번호 유효성 검사
        $('#pw').val();
        if (!re1.test($('#pw').val())) {
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
        } else if(re1.test($('#pw').val())){
        	pUn1.innerHTML = "";
        	pUn.innerHTML = "";        	
        } else{
        	pUn.innerHTML = "";        	        	
        }
        if($('#boPwd').val() == ""){        	
        	pUn.innerHTML = "";
        }
    });

    $('#name').on('keyup', function () {//이름이 입력되었는가.
        $('#name').val();
        var names = $('#name').val();
        var nameCount = names.length;

        if ($('#name').val() == "" || nameCount < 2) {
            nUn.innerHTML = "이름을 다시 입력해주세요!";
            $('#naM').css({
                color: 'red'
            });
        } else {
            nUn.innerHTML = "";
        }
    });

    $('#birth').on('keyup', function () {
        if ($('#birth').val() == "") {
            brM.innerHTML = "생일이 입력되있지 않습니다!";
        } else {
            brM.innerHTML = "";
        }
    });

    $('#telnum').on('keyup', function () {//전화번호 유효성 검사
        var tels = $('#telnum').val();
        var telCount = tels.length;
        if (telCount < 13) {
            numM.innerHTML = "휴대폰 번호가 짧거나 이상합니다.";
        } else {
            numM.innerHTML = "";
        }
    });

    $('#email').on('keyup', function () {//이메일 유효성 검사
        $('#email').val();

        if (!re2.test($('#email').val())) {
            eUn.innerHTML = "옳바르지않은 이메일 형식입니다.";
            $('#emM').css({
                color: 'red'
            });
        } else {
            eUn.innerHTML = "";
        }
    });

	$('#submit').on('click', function () { //회원가입시 유효성 검사
        var id = $(".idArea");
        var pw = $(".pwArea");
        var pw2 = $(".pwChkArea");
        var name = $(".nameArea");
        var birth = $(".birthArea");
        var phone = $(".phoneArea");
        var email = $(".emailArea");

        if (id.val() != "" && id.parent().next().html() == "") {
            if (pw.val() != "" && pw.parent().next().html() == "") {
                if (pw2.val() != "" && pw2.parent().next().html() == "") {
                    if (name.val() != "" && name.parent().next().html() == "") {
                        if (birth.val() != "" && birth.parent().next().html() == "") {
                            if (phone.val() != "" && phone.parent().next().html() == "") {
                                if (email.val() != "" && email.parent().next().html() == "") {
                               			$('#submit').submit();
                                } else {
                                    alert("이메일이 잘못되었습니다.");
                                    return false;
                                }
                            } else {
                                alert("전화번호가 잘못되었습니다.");
                                return false;
                            }
                        } else {
                            alert("생일이 잘못되었습니다.");
                            return false;
                        }
                    } else {
                        alert("이름이 잘못되었습니다.");
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
