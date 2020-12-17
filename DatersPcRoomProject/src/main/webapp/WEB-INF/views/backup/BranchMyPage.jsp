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
		<%@include file="../include/header.jsp" %>
	</header>
	<!-- 헤더 -->

	<section id="container" class="contents">
	

	<div class="bu">
		<button type="button" onclick="location='BranchLoginGo.do'">회원정보</button>
		<button type="button" onclick="location='BranchCalculateGo.do'">정산</button>
		<button type="button" onclick="location='BranchMyPage.do'">마이페이지</button>
		<button type="button" onclick="location='Logout.do'">로그아웃</button>
	</div>
	<hr />
	<form action="ownerUpdate.do">
		<input type="hidden" name="boCode" value="${BranInfo.boCode }" />
		<table>
			<tr>
				<td>지점장명</td>
				<td><input type="text" name="boOrderName" value="${BranInfo.boOrderName}"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="boOrderGender" value="남자" required="required"/>남자</td>
				<td><input type="radio" name="boOrderGender" value="여자" required="required"/>여자</td>
			</tr>
			<tr>
				<td>개업일</td>
				<td><input type="date" value="${BranInfo.boOpendate}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>지점 총 좌석 수</td>
				<td><input type="text" name="boTotalseat" value="${BranInfo.boTotalseat }"></td>
			</tr>
			<tr>
				<td>지점 주소</td>
				<td><input type="text" name="boAddress" value="${BranInfo.boAddress }"></td>
			</tr>
			<tr>
				<td>지점 전화번호</td>
				<td><input type="text" name="boTell" value="${BranInfo.boTell }"></td>
			</tr>
			<tr>
				<td>지점 프린터</td>
				<td>
					<input type="radio" name="boPrinter" value="1" required="required"/>유 
					<input type="radio" name="boPrinter" value="2" required="required"/>무
					<input type="radio" name="boPrinter" value="3" required="required"/>수리
				</td>
			</tr>
			<tr>
			<tr>
				<td>지점 소개</td>
				<td><textarea name="boIntro" cols="30" rows="10">${BranInfo.boIntro}</textarea></td>
			</tr>
			<tr>
				<td class="submit"><input type="submit" value="정보수정"></td>
			</tr>
		</table>
	</form>
	
	</section>



	<footer>
		<%@include file="../include/footer.jsp" %>
	</footer>
</div>

	<!-- 윙메뉴 -->
	<%@include file="../include/nav.jsp" %>
	<!-- 윙메뉴 -->
	

</body>
</html>