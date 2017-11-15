<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<html>
<head>
<title>Home</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$("#join").click(function() {
		var param = {};
		param.member_id = $("#id").val();
		param.member_pw = $("#pw").val();
		param.member_name = $("#name").val();
		
		$.ajax({
			method : "POST",
		  	contentType : "application/json; charset=UTF-8",
		  	url : "/dk/accountRegister.do",
		  	data : JSON.stringify(param),
		  	success : function(data){
		  		alert(data);
		  	}
		});
	});
});
</script>
    <h1>Hello world!</h1>
 
    <table>
        <thead>
            <tr>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>이름</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${memberList}" var="member">
                <tr>
                    <td>${member.member_id}</td>
                    <td>${member.member_pw}</td>
                    <td>${member.member_name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h1>================</h1>
    <h2>회원가입</h2>
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
		
 		<tr>
			<td>이름</td>
			<td><input type="text" id="name">
		</tr>  
 		</thead>
 		</table>
 		</div>
 		<input type="button" id="join" value="회원가입">
 <h1>=============</h1>
 <td>로그인 아이디 : ${user.member_id}</td>
 <td>${member_id}</td>
</body>
</html>
