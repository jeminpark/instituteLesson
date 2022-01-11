<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type = text/javascript src = "_02_validation.js"></script>
</head>
<body>
	<h1>MAIN</h1>
	<%
		String id = session.getAttribute("log").toString();
	%>
	<h3><%=id %>님 로그인중...</h3>
	<button onclick = "btnClick()">Logout</button>
	<button onclick = "location.href = '_10_boardList.jsp'">게시글보기</button>
</body>
</html>