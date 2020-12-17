<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		 width: 100%;
	}
	h1, h2{
		text-align: center;
	}
	#memberInfo{
		background-color: #efefef;
	}
	#boardInfo{
		background-color: #efefef; text-align: center;
	}
	th, td{
		width: auto; border-bottom: 1px solid gray;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
<h1>관리자 페이지</h1>
<h3>안녕하세요. ${loginMember.dc_name}님</h3>
<hr />

<div class="drcoWrap">
	<div id="memberWrap">
		<h2>회원 명단</h2>
		<form id="frm" name="frm" method="post" >
			<table id="memberInfo">
				<tr>
					<th  style="text-align: center">전체 회원 수</th>
				</tr>
				<tr>
					<td style="text-align: center">${memberAllCnt}명</td>		
				</tr>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>주소</th>
					<th>이메일</th>
					<th>가입일</th>
					<th>회원등급</th>
					<th>회원상태</th>
					<th>게시글 작성 수</th>
					<th>댓글 작성 수</th>
					<th>방문 횟수</th>
				</tr>
				<c:forEach items="${memberList}" var="member">
				<tr>
					<td><a href="#" onclick="fscreen('myPage.do','${member.dc_id}')">${member.dc_id}</a></td>
					<td>${member.dc_password}</td>
					<td>${member.dc_name}</td>
					<td>${member.dc_birth}</td>
					<td>${member.dc_gender}</td>
					<td>${member.dc_address}</td>
					<td>${member.dc_email}</td>
					<td><fmt:formatDate value="${member.dc_regDate}" pattern="yyyy-MM-dd"/></td>
					<td>${member.dc_grade}</td>
					<td>${member.dc_state}</td>
					<td>${member.dc_boardCnt}</td>
					<td>${member.dc_commCnt}</td>
					<td>${member.dc_enterCnt}</td>
				</tr>
				</c:forEach>
			</table>
			<input type="hidden" name="dc_id" id="dc_id" hidden="hidden" />
		</form>
	</div>	
	<br />
	<div id="gMember">
		<h2>성별 회원 조회</h2>
		<table>
			<tr class="byGender">
				<th>
				<form action="adminPage.do?startYear=1960&endYear=<%=Calendar.getInstance().get(Calendar.YEAR)%>" method="post">
					<select name="searchGender" style="width: 80px; display: inline-block;">
						<c:forEach items="${searchGender}" var="sGender">
							<option value="${sGender.value}">${sGender.key}</option>
						</c:forEach>
					</select>
					<input type="submit" value="조회" style="width: 50px" />
				</form>
				</th>
			</tr>
		</table>
		<form id="frm" name="frm" method="post">
			<table>
				<tr>
					<td style="text-align: center">${sex}회원 수</td>
				</tr>
				<tr>
					<td style="text-align: center">${genderCnt}명</td>
				</tr>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>주소</th>
					<th>이메일</th>
					<th>가입일</th>
					<th>회원등급</th>
					<th>회원상태</th>
					<th>게시글 작성 수</th>
					<th>댓글 작성 수</th>
					<th>방문 횟수</th>
				</tr>
				<c:forEach items="${genderList}" var="gender">
					<tr>
						<%-- <td><a href="">${gender.dc_id}</a></td> --%>
						<td><a href="#" onclick="fscreen('myPage.do','${gender.dc_id}')">${gender.dc_id}</a></td>
						<td>${gender.dc_password}</td>
						<td>${gender.dc_name}</td>
						<td>${gender.dc_birth}</td>
						<td>${gender.dc_gender}</td>
						<td>${gender.dc_address}</td>
						<td>${gender.dc_email}</td>
						<td><fmt:formatDate value="${gender.dc_regDate}" pattern="yyyy-MM-dd"/></td>
						<td>${gender.dc_grade}</td>
						<td>${gender.dc_state}</td>
						<td>${gender.dc_boardCnt}</td>
						<td>${gender.dc_commCnt}</td>
						<td>${gender.dc_enterCnt}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<br />
	<div id="yMember">
		<h2>연도별 회원 조회</h2>
		<table>
			<tr class="byYear" >
				<th>
				<p>조회하고 싶은 연도를 선택해주세요.</p>
				<form action="adminPage.do" method="post" >
					<select name="startYear" style="width: 80px; display: inline-block;">
						<c:forEach items="${searchYear}" var="sYear">
							<option value="${sYear.value}">${sYear.key}년</option>
						</c:forEach>
					</select>
					<span> ~ </span>
					<select name="endYear" style="width: 100px; display: inline-block;">
						<c:forEach items="${searchYear}" var="sYear">
							<option value="${sYear.value}">${sYear.key}년</option>
						</c:forEach>
					</select>
					<input type="submit" value="조회" style="width: 50px" />
				</form>
				</th>
			</tr>
		</table>
		<form id="frm" name="frm" method="post">
			<table>
				<tr>
					<th colspan="13" style="text-align: center;">${startYear}년도 ~ ${endYear}년도 회원 수</th>
				</tr>
				<tr>
					<td colspan="13" style="text-align: center;">${yearCnt}명</td>
				</tr>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>주소</th>
					<th>이메일</th>
					<th>가입일</th>
					<th>회원등급</th>
					<th>회원상태</th>
					<th>게시글 작성 수</th>
					<th>댓글 작성 수</th>
					<th>방문 횟수</th>
				</tr>
				<c:forEach items="${yearList}" var="year">
					<tr>
						<%-- <td><a href="">${year.dc_id}</a></td> --%>
						<td><a href="#" onclick="fscreen('myPage.do','${year.dc_id}')">${year.dc_id}</a></td>
						<td>${year.dc_password}</td>
						<td>${year.dc_name}</td>
						<td>${year.dc_birth}</td>
						<td>${year.dc_gender}</td>
						<td>${year.dc_address}</td>
						<td>${year.dc_email}</td>
						<td><fmt:formatDate value="${year.dc_regDate}" pattern="yyyy-MM-dd"/></td>
						<td>${year.dc_grade}</td>
						<td>${year.dc_state}</td>
						<td>${year.dc_boardCnt}</td>
						<td>${year.dc_commCnt}</td>
						<td>${year.dc_enterCnt}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<br />
	<div id="board">
		<h2>게시글 전체 리스트</h2>
		<table id="boardInfo">
			<tr class="orange">
				<th>일련번호</th>
				<th>아이디</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성일</th>
				<th>그룹핑</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${boardList}" var="board">
			<tr>
				<td><a href="">${board.b_seq}</a></td>
				<td>${board.dc_id}</td>
				<td>${board.b_title}</td>
				<td>${board.b_content}</td>
				<td><fmt:formatDate value="${board.b_writeDate}" pattern="yyyy-MM-dd"/></td>
				<td>${board.b_list}</td>
				<td>${board.b_cnt}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<ul>
		<li>
			<p>회원아이디 클릭 시 수정 가능</p>
		</li>
		<li>
			<p>게시물 일련번호 클릭 시 수정 가능 @@@@@@@@@@@@@@@@@@@@@@@ 구현해야함</p>
		</li>
	</ul>
</div>

<br />
<hr />
<a href="index.jsp">메인 페이지 이동</a><br />
<a href="logout.do">로그아웃</a>
</body>
<script>
	function fscreen(url, val) {
		/* 새로운 팝업 창 띄우기 */
		/* fullscreen = window.open('about:blank', "fullscreen", 'top=0,left=0,width='
				+(screen.availWidth-10)+',height='+(screen.availHeight-48)
				+',fullscreen=yes,toolbar=0,location=0,directories=0,status=0,menubar=0,resizable=0,scrolling=0'); */
		document.getElementById('dc_id').value = val
		var obj = document.getElementById('frm')
		/* obj.target='fullscreen' */
		obj.action = url
		obj.submit()
	}
</script>
</html>