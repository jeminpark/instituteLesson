<%@page import="user.User_DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
	body{
		display: flex;
		
		flex-direction : column;
		text-align: center;
		align-item: center;
		
		gap: 100px;
	}
	h1{
		display:flex;
		flex-direction : column;
		align-item: center;
		
		color: lightgrey;
		
		font-size: 3em;
	}
	form{
	
	}
	input[type = "submit"]{
		
		width:100px;
		height:70px;
		
		border: none;
		
		border-radius: 25px 25px 25px 25px;
		background-color: green;
		font-size: 0.9em;
		
		cursor: pointer;
	}
	
</style>
<title>Login Process</title>
</head>
<body>

	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		User_DAO dao = User_DAO.getInstance();
		
		String loginId = dao.login(id,pw);
		
		if(loginId.equals("")){
			%><h1>계정을 찾을수 없습니다.</h1>
			
			<form action = '_05_Login.jsp'>
				<input type = "submit" value = "돌아가기">
			</form>
	<% }		
		else{
			
			session.setAttribute("log", id);
			session.removeAttribute("log");
			
			%><h1><%=loginId+"님 환영합니다." %></h1>
		<%} %>
	
	
</body>
</html>