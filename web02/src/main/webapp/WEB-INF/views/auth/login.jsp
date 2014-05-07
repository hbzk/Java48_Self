<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="../css/common.css">
<title>로그인</title>
</head>
<body>
<div class="container">
<h1>로그인</h1>
<form class="form-inline" action="login.bit" method="post">
<input class="form-control" type="text" name="email" value="${cookie.loginEmail.value}" placeholder="이메일">
<%-- 이메일: <input type="text" name="email" value="${loginEmail}"><br> --%>
<input class="form-control" type="password" name="password" placeholder="암호">

<br>
<input type="checkbox" name="saveEmail"
	<c:if test="${cookie.loginEmail != null}">checked</c:if> 
>이메일 저장

<br><br>
<input class="btn btn-primary" type="submit" value="로그인">
</form>

</div>
</body>
</html>