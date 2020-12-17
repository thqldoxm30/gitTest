<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/choiceSe.css" />
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
				<span> 로그인
			    </span>
			</div>
		</div>
		<!-- line-map -->
		
	
		<div class="inner-container-login">
						
			<div class="minTitle">
				<h1>좌석선택</h1>
			</div>
		<div class="choiceSeatFormDiv">
			<div class="formTitle"> <h2>좌석선택</h2> </div>
			<div class="seatForm">
			    <form action="LoginGo.do" method="get" class="here">
			    <input type="hidden" name="boCode" value="${boCode}" />
			        <table>
			            <tr id="Seat">
							<c:forEach var="i" begin="0" end="${boTotalseat}">
								<c:if test="${useSeatTest[i] eq 0}">
									<td class="on">
									<label for="${i+1}">
									<img src="/resources/images/mnt0.png">
									</label>
									<input type="radio" name ="seat" id="${i+1}" value="${i+1}" class="a">${i+1}
									</td>
								</c:if>
								<c:if test="${useSeatTest[i] eq 1}">
									<td class="off">
									<img src ="/resources/images/mnt1.png">${i+1}
									</td>
								</c:if>
							</c:forEach>
			            </tr>
			        </table>
			        <p><input class="subBtn" type="submit" value ="앉기"></input></p>
			    </form>
			    <p><button type="button" class="canBtn" onclick="location.href='index.do' ">취소</button></p>
		    </div>	
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
	    $(document).ready(function () {
	        $('td.on').click(function () {
	            if ($(this).hasClass('on')) {
	                $('td.check').addClass('on');
	                $(this).addClass('check');
	                $('td.on').find('img').attr("src", "/resources/images/mnt0.png");
	                $(this).find("img").attr("src", "/resources/images/mnt2.png");
	            }
	        });
	    });
</script>

</html>
