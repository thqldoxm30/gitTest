<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 메인 페이지</title>
<style>
	* {
		margin: 0 auto; text-align: center; width: 500px;
	}
	.orange {
		background-color: orange;
	}
	a{
		text-decoration: none;
	}
	
</style>
</head>
<body>
<h1>드림 코스메틱 게시판</h1>
<h3>
	${loginMember.dc_name}님 환영합니다
</h3>
<div class="searchWrap">
	<form action="viewBoardList.do" method="post">
		<select name="searchCondition" style="width: 100px">
			<c:forEach items="${searchMap}" var="option">
				<option value="${option.value}">${option.key }</option>
			</c:forEach>
		</select> 
		<input type="text" name="searchKeyWord" style="width: 250px" />
		<input type="submit" value="검색" style="width: 100px" />
	</form>
</div>
<div class="boardListWrap">
	<table>
		<tr class="orange">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
		<tr>
			<td>${board.b_seq}</td>
			<td><a href="viewBoard.do?b_seq=${board.b_seq}">${board.b_title}</a></td>
			<td>${board.dc_id}</td>
			<td><fmt:formatDate value="${board.b_writeDate}" pattern="yyyy-MM-dd"/></td>
			<td>${board.b_cnt}</td>
		</tr>
		</c:forEach>
	</table>
	<hr />
	<div>
		<c:if test="${prev}">
			<span><a href="viewBoardList.do?num=${pageNumStart-1}&searchKeyWord=${searchVO.searchKeyWord}&searchCondition=${searchVO.searchCondition}"> 이전 </a></span>
		</c:if>
		<c:forEach begin="${pageNumStart}" end="${pageNumEnd}" var="num">
			<span>
				<c:if test="${now != num}">
				<%-- <a href="#" onclick="fscreen('viewBoardList.do','${num}', '${sk}', '${sc}')">${num}</a> --%>
				<a href="viewBoardList.do?num=${num}&searchKeyWord=${searchVO.searchKeyWord}&searchCondition=${searchVO.searchCondition}">${num}</a>				
				</c:if>
				<c:if test="${now == num}">
					<b>${num}</b>
				</c:if>
			</span>
		</c:forEach>
		<c:if test="${next}">
			<span><a href="viewBoardList.do?num=${pageNumEnd+1}&searchKeyWord=${searchVO.searchKeyWord}&searchCondition=${searchVO.searchCondition}"> 다음 </a></span>
		</c:if>
	</div>
	<hr />
</div>
<br />
<a href="insertBoard.jsp">게시글 쓰기</a><br />
<a href="myPage.do?dc_id=${loginMember.dc_id}">내 정보 조회</a><br />
<a href="logout.do">로그아웃</a>
</body>
<!-- <script>
	function fscreen(url, val, val2, val3) {
		/* 새로운 팝업 창 띄우기 */
		/* fullscreen = window.open('about:blank', "fullscreen", 'top=0,left=0,width='
				+(screen.availWidth-10)+',height='+(screen.availHeight-48)
				+',fullscreen=yes,toolbar=0,location=0,directories=0,status=0,menubar=0,resizable=0,scrolling=0'); */
		document.getElementById('num').value = val
		document.getElementById('searchKeyWord').value = val2
		document.getElementById('searchCondition').value = val3
		var obj = document.getElementById('frm')
		/* obj.target='fullscreen' */
		obj.action = url
		obj.submit()
	}
</script> -->
</html>