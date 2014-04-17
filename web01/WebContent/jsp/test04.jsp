<%-- 
Declaration (선언)
- <%! 클래스 멤버(변수, 메서드) %>
		class X ... {
			복사...
			_jspInit() {...}
			_jsService() {...}
			_jsDestroy() {...}
		}
--%>
<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%!
public String test() {
	return "okok";
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test03</title>
<%! 	//Declaration element
int i = 20;
int j = 30;
%>
</head>
<body>
<h1>Declaration element</h1>
<%= test() %>
</body>
</html>
