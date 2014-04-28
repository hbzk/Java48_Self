<%-- EL 적용 --%>
<%@page import="sems.vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 변경폼(JSP, JSP Action)</title>
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="../css/common.css">
</head>
<body>
<div class="container">
<h1>과목 변경</h1>
<form action='update.bit' method='post' role="form">
<label for="no">번호 :</label><input class="form-control" type='text' name='no' value='${subject.no}' readonly><br>
<label for="title">과목명:</label><input class="form-control" type='text' name='title' value='${subject.title}'><br>
<label for="title">설명: </label><textarea class="form-control" name='description' rows='10' cols='80'>${subject.description}</textarea><br>
<input class="btn btn-primary" type='submit' value='변경'>
<input class="btn btn-danger" type='button' value='취소'
onclick="location.href='detail.bit?no=${subject.no}'">
</form>

<c:set var="studyClass" value="Java48$$" scope="request"/>
<jsp:include page="/footer.jsp"/>						<!-- > jsp 실행 결과인 클래스 파일을  include (출력하고 돌아온다) -->
<%--@ include file="../footer.jsp" --%>	<!-- 해당 파일의 내용을 HTML에 바로 include (이후 실행) -->


</div>
</body>
</html>






<!-- ============================================== -->

<%-- jsp:useBean 사용 
<use:include>, <use:forward>
-> 서블릿 또는 jsp로 실행 호출
-> 호출하는 페이지는 반드시 서블릿(JSP) URL 이다.

<%@ include %>
-> 해당 파일의 내용을 복사해 온다.
-> 파일이 서블릿 또는 jsp가 아니어도 된다

<%@page import="vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="subject" class="vo.SubjectVo" scope="request"/>
<% SubjectVo subject = (SubjectVo) request.getAttribute("subject"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 변경폼(JSP, JSP Action)</title>
</head>
<body>
<h1>과목 변경</h1>
<form action='update.bit' method='post'>
번호 : <input type='text' name='no' value='<jsp:getProperty name="subject" property="no"/>' readonly><br>	
과목명: <input type='text' name='title' value='<jsp:getProperty name="subject" property="title"/>'><br>
설명: <textarea name='description' rows='10' cols='80'><jsp:getProperty name="subject" property="description"/></textarea><br>
<input type='submit' value='변경'>
<input type='button' value='취소'
onclick="location.href='detail.bit?no=<jsp:getProperty name="subject" property="no"/>'">
</form>

<jsp:include page="/footer.jsp"/>						<!-- > jsp 실행 결과인 클래스 파일을  include (출력하고 돌아온다) -->

@ include file="../footer.jsp"	<!-- 해당 파일의 내용을 HTML에 바로 include (이후 실행) -->


</body>
</html>
 --%>