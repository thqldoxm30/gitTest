<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업주정산페이지</title>
</head>
<body>
	<table>
		<tr>
			<th>지점코드</th>
			<th>정산날짜</th>
			<th>총사용시간매출</th>
			<th>기타매출</th>
			<th>순수익</th>
			<th>지출(본사+a)</th>
			<th>지출내용</th>
			<th>인센티브</th>
		</tr>
		<c:forEach items="${bHisList }" var="bHisList">
		<tr>
			<td>${bHisList.boCode }</td>
			<td>${bHisList.cToday }</td>
			<td>${bHisList.cTotalTime }</td>
			<td>${bHisList.cTotalOther }</td>
			<td>${bHisList.cNetProfit }</td>
			<td>${bHisList.cCost }</td>
			<td>${bHisList.cCostInfo }</td>
			<td>${bHisList.cInsen }</td>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>