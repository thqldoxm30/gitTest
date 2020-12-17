<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드림 코스메틱 로그인</title>
<style>
	.container{
		width: 800px; margin: 0 auto; background-color: #e3e3e3;
	}
	table{
		 width: 100%; text-align: center;
	}
	a{
		text-decoration: none; color: black; font-size: 12px; float: right;
	}
	input{
		width: 300px;
	}
	
	
</style>
</head>
<body>
<div class="container">
	<h1 style="text-align: center">드림 코스메틱 로그인</h1>
	<hr />
	<form action="login.do" method="post">
		<table>
			<tr>
				<td>
					<label for="dc_id" >아이디&nbsp;&nbsp;&nbsp;</label>
					<input type="text" value="${member.dc_id}" id="dc_id" name="dc_id" placeholder="아이디를 입력해주세요.(패턴수정)" required="required"/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="dc_password">비밀번호</label>
					<input type="password" value="${member.dc_password}" id="dc_password" name="dc_password" placeholder="비밀번호를 입력해주세요.(패턴수정)" required="required"/>
				</td>
			</tr>
			<tr>
				<td rowspan="2">
					<input type="submit" value="로그인" style="width: 100px"/>
					<a href="index.jsp">메인 페이지 이동</a>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>