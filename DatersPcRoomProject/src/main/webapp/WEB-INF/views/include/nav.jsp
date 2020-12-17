<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>	
		
	<div id="wrap-wing">
		<c:choose>

	
			<c:when test="${UserInfo.uId != null}">
		<!-- 유저 로그인 후 -->	
		<div class="login after" style="display:none;">
			<div class="loginUserText">
					<a class="myPageLink" href="MyUserPage.do">${UserInfo.uName } (${UserInfo.uId })</a>
					님 반갑습니다. <br /><br />		 			

		 	</div>
		 	
		 	<div class="saveTime"> 남은 시간 : ${uSaveTimeH } 시간 ${uSaveTimeM}분</div>
		 	
		 	<div class="loginBtn">
		 	<button class="loginBtnIn" onclick="openChild()">음식 주문</button>
		 	<button class="loginBtnIn" onclick="">시간 사용</button>
		 	<button class="loginBtnIn" onclick="confirmLog()">로그아웃</button>
			</div>
		</div>
		<!-- 유저 로그인 후 충전 페이지 -->
		<div class="charge after" style="display:none;">
			<div class="chargeFormDivMin">
					<div class="chargeFormDivText">
					<a>${UserInfo.uName}</a>님의 남은시간은 <a>${uSaveTimeH}시간 ${uSaveTimeM}분</a> 남았습니다.<br/>
					얼마를 충전 하시겠어요?
					</div>
					<form action="InsertUserCash.do" method="post">
						
						<table class="chargeTableMin">
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
									<th> 10,000원 </th>
									<th> 110 Point </th>								
								</tr>
							</tbody>
						</table>
						
					<input class="subBtnMin" onclick="alert('충전이 완료되었습니다.');" type="submit" value="충전하기" />
						
					</form>
			</div>		

		</div>
		
		
		<div class="floatMenu">
			<div class="wingLogOn">
			<ul class="list-wing">
				<li class="login myNotice"><a href="MyUserPage.do"><img src="${path}/resources/images/login.png" /> <span>MyPage</span></a></li>
				<li class="charge"><a href="CashInsertGO.do"><img src="${path}/resources/images/paying.png" /> <span>충전</span></a></li>
				<li class="find-pc"><a href=""><img src="${path}/resources/images/findPc.png" /> <span>피시방 찾기</span></a></li>
			</ul>
			</div>
			<div class="btn-top">
				<a href="#">
					<span> TOP </span>
				</a>
			</div>
		</div>
			</c:when>

					
			<c:when test="${BranchVO.boId != null}">
		<!-- 업주 로그인 후 -->	
		<div class="login after" style="display:none;">
		<div class="loginUserText">
			<a class="myPageLink" href="BranchMyPage.do">${BranchVO.boName} (${BranchVO.boId})님</a> <br/> 점주님 반갑습니다. <br /><br />
		 	<div class="loginBtn">
		 	<button class="loginBtnIn" onclick="confirmLog()">로그아웃</button>
		 	</div>
		</div>
		</div>
		
		
		
		<div class="floatMenu">
			<div class="wingLogOn">
			<ul class="list-wing">
				<li class="login myNotice"><a href="BranchMyPage.do"><img src="${path}/resources/images/login.png" /> <span>MyPage</span></a></li>
				<li class="time-charge"><a href="BranchCalculateGo.do"><img src="${path}/resources/images/paying.png" /> <span>정산</span></a></li>
				<li class="find-pc"><a href=""><img src="${path}/resources/images/findPc.png" /> <span>피시방 찾기</span></a></li>
			</ul>
			</div>
			<div class="btn-top">
				<a href="#">
					<span> TOP </span>
				</a>
			</div>
		</div>
			</c:when>
			

			<c:otherwise>
		<!-- 로그인 전 -->
				<div class="login" style="display:none;">
					<div class="choiceBtn">
					 	<div class="choiceLeft">
						<img src="${path}/resources/images/choiceUser.png" />
						 </div>
						 <div class="choiceRight">
						 <img src="${path}/resources/images/choiceOwner.png" />
						</div>
					</div>
					 	<div class="userContent">
							<button type="button" class="logBtn" onclick="location.href='MainGo.do'">유저 로그인</button>
							<button type="button" class="regBtn" onclick="location.href='UserCreate.do'">유저 회원가입</button>
						</div>
					 	<div class="ownerContent" style="display: none;">
							<button type="button" class="logBtnOwn" onclick="location.href='LoginOwnerGo.do'">업주 로그인</button>
							<button type="button" class="regBtnOwn" onclick="location.href='OwnerJoinGo.do'">업주 회원가입</button>
						</div>
				</div>
				
				<div class="floatMenu">
					<div class="wingLogOff">
						<ul class="list-wing">
								<li class="login on"><a><img src="${path}/resources/images/login.png" /> <span>로그인</span></a></li>
								<li class="time-charge"><a onclick="alert('해당 서비스는 로그인이 필요합니다.');" href="MainGo.do"><img src="${path}/resources/images/paying.png" /> <span>충전</span></a></li>
								<li class="find-pc"><a href=""><img src="${path}/resources/images/findPc.png" /> <span>피시방 찾기</span></a></li>
						</ul>
					</div>
				<div class="btn-top">
					<a href="#">
						<span> TOP </span>
					</a>
				</div>
				</div>
			</c:otherwise>
						
		</c:choose>	
	
	
	
	
	
		<!--
		<c:if test="${UserInfo.uId == null }">
		<div class="login" style="display:none;">
			<div class="choiceBtn">
			 	<div class="choiceLeft">
				유저
				 </div>
				 <div class="choiceRight">
				 업주
				</div>
			</div>
			 	<div class="userContent">
					<button type="button" class="logBtn" onclick="location.href='MainGo.do'">유저 로그인</button>
					<button type="button" class="regBtn" onclick="location.href='UserCreate.do'">유저 회원가입</button>
				</div>
			 	<div class="ownerContent" style="display: none;">
					<button type="button" class="logBtn" onclick="location.href='LoginOwnerGo.do'">업주 로그인</button>
					<button type="button" class="regBtn" onclick="location.href='OwnerJoinGo.do'">업주 회원가입</button>
				</div>
		</div>
		
		<div class="floatMenu">
			<div class="wingLogOff">
				<ul class="list-wing">
						<li class="login on"><a><img src="${path}/resources/images/login.png" /> <span>로그인</span></a></li>
						<li class="time-charge"><a href="MainGo.do"><img src="${path}/resources/images/paying.png" /> <span>충전</span></a></li>
						<li class="find-pc"><a href=""><img src="${path}/resources/images/findPc.png" /> <span>피시방 찾기</span></a></li>
				</ul>
			</div>
		<div class="btn-top">
			<a href="#">
				<span> TOP </span>
			</a>
		</div>
		</div>
		</c:if>

		<c:if test="${UserInfo.uId != null }">
		
		<div class="login" style="display:none;">
				${UserInfo.uName } (${UserInfo.uId })님 반갑습니다 <br />
	 고객님의 남은 시간은 : ${uSaveTimeH } 시간 ${uSaveTimeM}분 남았습니다.
	 	<a href="Logout.do">로그아웃</a>
		</div>
		
		
		
		<div class="floatMenu">
			<div class="wingLogOn">
			<ul class="list-wing">
				<li class="login myNotice"><a href=""><img src="${path}/resources/images/login.png" /> <span>MyPage</span></a></li>
				<li class="time-charge"><a href=""><img src="${path}/resources/images/paying.png" /> <span>충전</span></a></li>
				<li class="find-pc"><a href=""><img src="${path}/resources/images/findPc.png" /> <span>피시방 찾기</span></a></li>
			</ul>
			</div>
			<div class="btn-top">
				<a href="#">
					<span> TOP </span>
				</a>
			</div>
		</div>
		</c:if> -->
		
	</div>


		
		<script>
		
		
		/* 메뉴 새 창 */
		var openWin;
		
		function openChild()
		{
		    openWin = window.open("MenuPlace.do",
		            "childForm", "width=550, height=550, resizable = no, scrollbars = no");    
		}
		
		/* 로그아웃 */
		
		function confirmLog() {
		var LogOut = confirm('로그아웃 하시겠어요?');
		
	    if(LogOut==true){
	        alert('로그아웃됩니다.');
	        location='Logout.do';
	    }else{
	    }
	}
		
		
	$(document).ready(function() {
		/* 스크롤 */
		// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
		var floatPosition = parseInt($("#wrap-wing").css('top'));
		// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

		$(window).scroll(function() {
			// 현재 스크롤 위치를 가져온다.
			var scrollTop = $(window).scrollTop();
			var newPosition = scrollTop + floatPosition + "px";

			/* 애니메이션 없이 바로 따라감
			 $("#wrap-wing").css('top', newPosition);
			 */

			$("#wrap-wing").stop().animate({
				"top" : newPosition
			}, 500);

		}).scroll();


		/* 유저 업주 변경 */
		$('div.choiceLeft').click(function(){
	          $('div.userContent').show();
	          $('div.ownerContent').hide();
	      });
	      $('div.choiceRight').click(function(){
	          $('div.ownerContent').show();
	          $('div.userContent').hide();
	      });
	      
	      
	    /* 사이드 마이페이지 마우스오버 */
		  $('.login').mouseover(function(){
	          $('div.login').show();
	          $('#wrap-wing').css({width: "490px"});
	      });
		  $('.login').mouseleave(function(){
	          $('div.login').hide();
	          $('#wrap-wing').css({width: "90px"});
	      });
		  
		 /* 사이드 충전페이지 마우스오버 */
		  $('.charge').mouseover(function(){
	          $('div.charge').show();
	          $('#wrap-wing').css({width: "490px"});
	      });
		  $('.charge').mouseleave(function(){
	          $('div.charge').hide();
	          $('#wrap-wing').css({width: "90px"});
	      });
		
	});
	</script>