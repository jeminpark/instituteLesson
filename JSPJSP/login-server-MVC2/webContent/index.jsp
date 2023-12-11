<%@page import="user.UserDao"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INDEX</title>
</head>
<body>
	hello world
	
	
	<!-- JSP MVC1 패턴 -->
	<!-- 사용자가 인풋 데이터에 대하여 처리 Pro 페이지에서 수행함.-->
	
	
	<!-- MVC -->
	<!-- 
	M: Model
	V: View
	C: Controller
	
	
	
	
	 -->
	 <% 
	 	
	 	UserDao dao = UserDao.getInstance();
	 	dao.getUsers();
	 
	 
	 %>
	 <form method = "post" action = "join">
	 	<input type = "text" name = "id">
	 	<input type = "password" name = "pw">
	 	
	 	<input type = "submit" value = Join>
	 </form>
</body>
</html>