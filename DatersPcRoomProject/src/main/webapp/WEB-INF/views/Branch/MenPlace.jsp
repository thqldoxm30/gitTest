<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<meta charset="UTF-8">
<title>메뉴주문</title>
</head>
<body>



		<select>
			<option>메뉴를 골라주세요!</option>
			<c:forEach items="${menuList}" var="menu">
				<option value="${menu.mNo}" > 👉  [  ${menu.mName} ]${menu.mPrice}원 남은수량 : ${menu.mQuantity}개</option>
			</c:forEach>
		</select>
		<input type="button" value="입력" id="select"/>
		<button id="AllChk">전체선택</button>
		<form action="MenuChoice.do" method="post">
			<div id="insertMenu">
			</div>
			<input type="submit" value="주문하기"/>
		</form>
		<input type="button" id="remove" value="메뉴삭제" onclick="">
</body>
	<script type="text/javascript">
		$(document).ready(function(){
		    var $button = $('#select');
		    $button.on('click', function(){
		    	var $text = $('select option:checked').text();
		    	var $value = $('select option:checked').val();
		    	var $quantity = $('#quantity').val();

				if($value != '메뉴를 골라주세요!'){
					$('#insertMenu').append('<table><tr><th>[주문 할 음식]</th></tr><tr><td>'+$text+
		    			'<input type="hidden" name="mNo" value="'+$value+'"/></td>'+
						'<td><input type="checkbox" name="removeChk"></td>'+'</tr></table>');
				};
		    });
		    
		    $('#remove').on('click', function() {
				if($('input[name="removeChk"]').checked = true ){
					$('input[name="removeChk"]:checked').parents("table").remove();
				};
			});

			$('#AllChk').on('click', function () {
				if($('input[name="removeChk"]').is(":checked") == true){
					$('input[name="removeChk"]').prop("checked", false);
				}else{
					$('input[name="removeChk"]').prop("checked", true);
				};
			});
		});
	</script>
</html>