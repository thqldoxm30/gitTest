<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<th>${bHisList.boCode }</th>
			<th>${bHisList.cToday }</th>
			<th>${bHisList.cTotalTime }</th>
			<th>${bHisList.cTotalOther }</th>
			<th>${bHisList.cNetProfit }</th>
			<th>${bHisList.cCost }</th>
			<th>${bHisList.cCostInfo }</th>
			<th>${bHisList.cInsen }</th>
		</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>