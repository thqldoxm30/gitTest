<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(${UserInfo.uId })님 ${uSaveTimeH}시간 ${uSaveTimeM}분 남았습니다.</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>

	var openWin;
	
	function confirmLog() {
		var LogOut = confirm('로그아웃 하시겠어요?');
		
	    if(LogOut==true){
	        alert('로그아웃됩니다.');
	        location='Logout.do';
	    }else{
	    }
	}
	
	function openChild()
	{
	    openWin = window.open("MenuPlace.do",
	            "childForm", "width=800, height=800, resizable = no, scrollbars = no");    
	}




	var time = 0;
	var starFlag = true;
	$(document).ready(function() {
		buttonEvt();
	});

	function init() {
		document.getElementById("time").innerHTML = "사용시간 : 00시간 00분";
	}

	function buttonEvt() {
		var hour = 0;
		var min = 0;
		var sec = 0;
		var timer;

		// start btn
		$("#startbtn")
				.click(
						function() {

							if (starFlag) {
								$(".fa").css("color", "#FAED7D")
								this.style.color = "#4C4C4C";
								starFlag = false;

								if (time == 0) {
									init();
								}

								timer = setInterval(
										function() {
											time++;

											min = Math.floor(time / 60);
											hour = Math.floor(min / 60);
											sec = time;
											min = min % 60;

											var th = hour;
											var tm = min;
											var ts = sec;
											if (th < 10) {
												th = "0" + hour;
											}
											if (tm < 10) {
												tm = "0" + min;
											}
											if (ts < 10) {
												ts = "0" + sec;
											}
											document.getElementById("values").value = sec;
											document.getElementById("time").innerHTML = "사용시간 : "
													+ th + "시간 " + tm + "분";
										}, 1000);
							}
						});

		// pause btn
		$("#pausebtn").click(function() {
			if (time != 0) {
				$(".fa").css("color", "#FAED7D")
				this.style.color = "#4C4C4C";
				document.getElementById("values").value = sec;
				clearInterval(timer);
				starFlag = true;
			}
		});

		// stop btn
		$("#stopbtn").click(function() {
			if (time != 0) {
				$(".fa").css("color", "#FAED7D")
				this.style.color = "#4C4C4C";
				clearInterval(timer);
				starFlag = true;
				time = 0;
				init();
			}
		});
	}
</script>
</head>
<body>
	<h1>Daters 통합 시스템</h1>
	${UserInfo.uName } (${UserInfo.uId })님 반갑습니다 <br />
	 고객님의 남은 시간은 : ${uSaveTimeH}시간 ${uSaveTimeM}분 남았습니다.
	

	<button onclick="openChild()">메뉴</button>
	<a href="MyUserPage.do">마이페이지</a>
	
 	<div id='box' class="box">
		<div id='timerBox' class="timerBox">
			<h1 id="time" class="time">사용시간 : 00시간 00분</h1>
		</div>
		<button id="startbtn">시작</button>
		<button id="pausebtn">중지</button>
	</div>
	<form action="UseCashTime.do" method="post">
		<p>
			<input type="hidden" id="values" name="uSavetime" value="0" />
		</p>
		<input type="submit" value="사용하기" />
	</form>
	
	<table>
		<tr>
			<td><input type="button" onclick="confirmLog()" value="로그아웃"/>&nbsp;&nbsp;</td>
			<td><a href="CashInsertGO.do">시간충전하기</a></td>
		</tr>
	</table>
	
</body>
</html>