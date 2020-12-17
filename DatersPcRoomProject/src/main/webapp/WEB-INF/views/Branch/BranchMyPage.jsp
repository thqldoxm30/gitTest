<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${path}/resources/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/resources/css/login.css" />
<link rel="stylesheet" type="text/css"
	href="${path}/resources/css/ownerInfo.css?after" />
<!-- 매장 정보 수정 폼 CSS -->

</head>
<body>

	<div class="wrap-data">
		<!-- 헤더 -->
		<header>
			<%@include file="../include/header.jsp"%>
		</header>
		<!-- 헤더 -->

		<section id="container" class="contents">
		
				<div class="line-map">
			<div class="inner-line">
				<a href="/index.do">
					<span>홈</span>
				</a>
				<a> > </a>
				<span> 업주 마이페이지
			    </span>
			</div>
		</div>
		<!-- line-map -->
		
		<div class="minTitle">
		<h1>마이페이지</h1>
		</div>
				<form action="ownerUpdate.do">
					<input type="hidden" name="boCode" value="${BranInfo.boCode }" />
					<table>
						<tr>
							<td>지점장명</td>
							<td><input type="text" name="boOrderName"
								value="${BranInfo.boOrderName}"></td>
						</tr>
						<tr>
							<td>성별</td>
							<td><input type="radio" name="boOrderGender" value="남자"
								required="required" />남자 <input type="radio" name="boOrderGender"
								value="여자" required="required" />여자</td>
						</tr>
						<tr>
							<td>개업일</td>
							<td><input type="date" value="${BranInfo.boOpendate}"
								readonly="readonly"></td>
						</tr>
						<tr>
							<td>지점 총 좌석 수</td>
							<td><input type="text" name="boTotalseat"
								value="${BranInfo.boTotalseat }"></td>
						</tr>
						<tr>
							<td>지점 주소</td>
							<td><input type="text" name="boAddress"
								value="${BranInfo.boAddress }"></td>
						</tr>
						<tr>
							<td>지점 전화번호</td>
							<td><input type="text" name="boTell"
								value="${BranInfo.boTell }"></td>
						</tr>
						<tr>
							<td>지점 프린터</td>
							<td><input type="radio" name="boPrinter" value="1"required="required" />유
							 <input type="radio" name="boPrinter" value="2" required="required" />무
							 <input type="radio" name="boPrinter" value="3" required="required" />수리</td>
						</tr>
						<tr>
						<tr>
							<td>지점 소개</td>
							<td><textarea name="boIntro" cols="80" rows="20">${BranInfo.boIntro}</textarea></td>
						</tr>
					</table>
					<input type="submit" class="subBtn" value="정보수정">
				</form>
		</section>



		<footer>
			<%@include file="../include/footer.jsp"%>
		</footer>
	</div>

	<!-- 윙메뉴 -->
	<%@include file="../include/nav.jsp"%>
	<!-- 윙메뉴 -->


</body>
</html>