<%@page import="java.util.ArrayList"%>
<%@page import="user.User_DTO"%>
<%@page import="user.User_DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	body{
		display:flex;
		align-item: center;
		flex-direction:column;
		justify-content: space-around;
		gap: 20px;
	}
	h1{
		text-align: center;
	}
	h3{
		font-size: 0.8em;
		display:flex;
		flex-direction: column;
		justify-content: space-around;
		color: gold;
	}
	form{
	
		display:flex;
		align-item:center;
		justify-content: center;
	
	}
	input[type = "submit"]{
			cursor: pointer;
            padding: 10px;
            border: none;
            color: white;
            background-color: green;
	}

</style>
<title>Success</title>
</head>
<body>
	<h1>가입성공</h1>
	<h1>회원가입을 진심으로 환영합니다.</h1>
	<%
		request.setCharacterEncoding("utf-8");
	
		
		String id = request.getParameter("id");
		String pw1 = request.getParameter("pw1");
		String pw2 = request.getParameter("pw2");
		String name = request.getParameter("names");
		String yyyy = request.getParameter("yyyy");
		String mmmm = request.getParameter("mmmm");
		String dddd = request.getParameter("dddd");
		String gender = request.getParameter("gender");
		String mobile = request.getParameter("mobile");
	
	
		User_DAO dao = User_DAO.getInstance();		
		User_DTO user = new User_DTO(id, pw1);
		
		dao.addUser(user);
		
		ArrayList<User_DTO> users = dao.getUsers();
		User_DTO last = users.get(users.size()-1);
		
	
	%>
	<h1><%=last.toString() %></h1>
	
	<form method = "post" action = "_05_Login.jsp">
	
	<input type = "submit" value = "로그인페이지로 이동">
	
	</form>
	
	<h3>가입자 정보
	<p><%="Id: "+id+" Pw1: "+pw1+" Pw2: "+pw2+" name: "+name+" birth: "+yyyy+","+mmmm+","+dddd+" gender: "+gender+" mobile: "+mobile %></p>
	
	
	</h3>
	
</body>
</html>