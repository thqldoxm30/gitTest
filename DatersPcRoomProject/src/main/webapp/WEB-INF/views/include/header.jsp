<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header-data">
	<div class="bg-header">
		<div class="inner-header">
			<p class="logo-header">
				<a href="/index.do"><img src="${path}/resources/images/titleLogo.png" width="250" height="80"/></a>
			</p>
			<nav class="gnb">
				<ul>
					<c:choose>
						<c:when test="${UserInfo.uId != null}">
							<li><a href="CashInsertGO.do">충전</a></li>
						</c:when>
						
						<c:when test="${BranchVO.boId != null}">
							<li><a href="BranchLoginGo.do">회원정보</a></li>
						</c:when>
						
						<c:otherwise>
							<li><a onclick="alert('해당 서비스는 로그인이 필요합니다.');" href="MainGo.do">충전</a></li>
						</c:otherwise>
						
					</c:choose>
					
					<!-- <c:if test="${UserInfo.uId == null }">
					<li><a href="/MainGo.do">충전</a></li>
					</c:if>
					<c:if test="${UserInfo.uId != null }">
					<li><a href="/CashInsertGO.do">충전</a></li>
					</c:if> -->
					
					<c:if test="${BranchVO.boId == null }">
					<li><a href="#">PC방 찾기</a></li>
					</c:if>
					<c:if test="${BranchVO.boId != null }">
					<li><a href="BranchCalculateGo.do">정산</a></li>
					</c:if>






					<li><a href="#">이벤트</a></li>
					<li><a href="#">고객센터</a></li>
				</ul>
			</nav>
			<!-- gnb -->
			
		</div>
	</div>

</div>