<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업체소개페이지</title>
</head>
<body>
	<table>
		<tr>
			<th>매장명</th>
			<th>매장소개말</th>
			<th>전체좌석수</th>
			<th>매장오픈날짜</th>
			<th>매장주소</th>
			<th>매장번호</th>
			<th>프린터유무</th>
		</tr>
		<c:forEach items="${BranchInfoList}" var="List">
		<tr>
			<td>${List.boName }</td>
			<td>${List.boIntro }</td>
			<td>${List.boTotalseat }</td>
			<td>${List.boOpendate}</td>
			<td>${List.boAddress }</td>
			<td>${List.boTell }</td>
			<c:choose>
				<c:when test="${List.boPrinter==1}">
				<td>프린터있음</td>
				</c:when>
				<c:when test="${List.boPrinter==2}">
				<td>프린터없음</td>
				</c:when>
				<c:when test="${List.boPrinter==3}">
				<td>프린터수리중</td>
				</c:when>
			</c:choose>
		</tr>
		</c:forEach>
	</table>
</body>
</html>