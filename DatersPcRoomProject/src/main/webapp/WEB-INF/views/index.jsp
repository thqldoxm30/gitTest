<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/login.css" />
</head>
<body>

<div class="wrap-data">
	<!-- 헤더 -->
	<header>
		<%@include file="./include/header.jsp" %>
	</header>
	<!-- 헤더 -->

	<section id="container" class="contents">
	
			<div class="line-map">
			<div class="inner-line">
				<a href="/index.do">
					<span>홈</span>
				</a>
				<a> > </a>
				<span> MAIN
			    </span>
			</div>
		</div>
		<!-- line-map -->
	
		<div class="inner-container-main">
		<div class="body-contents">
			<div class="tit">
			<img class="mainImg" src="${path}/resources/images/main1.png" />
			</div>
		<ul class="bodyUl">
			<li>
				<img class="mainImg" src="${path}/resources/images/main2.png" />
			</li>
			<li>
				<img class="mainImg" src="${path}/resources/images/main3.png" />
			</li>	
			<li>	
				<img class="mainImg" src="${path}/resources/images/main4.png" />
			</li>
		</ul>
		</div>
		</div>
	</section>



	<footer>
		<%@include file="./include/footer.jsp" %>
	</footer>
</div>

	<!-- 윙메뉴 -->
	<%@include file="./include/nav.jsp" %>
	<!-- 윙메뉴 -->
	

</body>
</html>
