<%-- c:url, c:import, c:redirect --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>c:url, c:import, c:redirect</title>
</head>
<body>
오호라.. 리다이렉트 할까?
<%-- c:redirect --%>
<c:set var="myUrl" value="http://www.daum.net"/>
<c:if test="${not empty myUrl }">
	<c:redirect url="${myUrl}"/>
</c:if>

</body>
</html>