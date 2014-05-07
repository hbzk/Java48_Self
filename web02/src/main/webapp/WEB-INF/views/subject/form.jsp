<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 등록폼</title>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/common.css">
</head>
<body>
<div class="container">
<jsp:include page="/header.jsp"/>
<h1>과목 등록폼</h1>
<form role="form" action="insert.bit" method="post">
<div class="form-group">
	<label for="title">과목명:</label>
	<input id="title" class="form-control" type="text" name="title" placeholder="과목명을 입력하세요">
</div>
<div class="form-group">
	<label for="description">설명: </label> 
	<textarea id="description" class="form-control" name="description" rows="10" cols="80" placeholder="과목에 대한 설명을 입력하세요"></textarea>
</div>
<input type="submit" value="등록" class="btn btn-primary">
<input type="reset" value="취소" class="btn btn-danger">



</form>
<jsp:include page="/footer.jsp"/>
</div>
</body>
</html>