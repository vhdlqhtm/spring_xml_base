<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<html>
<head>
<title>Home</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#login").click(function() {
		var param = {};
		param.member_id = $("#id").val();
		param.member_pw = $("#pw").val();
		
		$.ajax({
			method : "POST",
		  	contentType : "application/json; charset=UTF-8",
		  	url : "/dk/memberLogin.api",
		  	data : JSON.stringify(param),
		  	success : function(data){
		  		if(data == "OK"){
		  			alert("로그인정보 확인!");
		  			location.href = "/";
		  		}else{
		  			alert("로그인실패!");
		  		}
		  		
		  	}
		});
	});
});
</script>
    <h1>로그인 페이지</h1>
    	<div>
    	<table>
 		<thead>
 		<tr>
			<td>아이디</td>
			<td><input type="text" id="id">
		</tr>
		
 		<tr>
			<td>패스워드</td>
			<td><input type="password" id="pw">
		</tr>
		
 		</thead>
 		</table>
 		</div>
 		<input type="button" id="login" value="로그인">
 
</body>
</html>
