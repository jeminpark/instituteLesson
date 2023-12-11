<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout Process</title>
</head>
<body>
	<%
		session.removeAttribute("log");
		
		String url = "index.jsp";
		response.sendRedirect(url);
	%>

</body>
</html>