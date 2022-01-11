<%@page import="java.util.ArrayList"%>
<%@page import="user.UserDTO_mine"%>
<%@page import="user.UserDAO_mine"%>
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
	}
	h1{
		text-align: center;
	}

</style>
<title>Success</title>
</head>
<body>
	
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
		String email = request.getParameter("emails");
		String mobile = request.getParameter("mobile");
		
		String birth = yyyy+"-"+mmmm+"-"+dddd;
		
		%>
		
	<h3><%="Id: "+id+" Pw1: "+pw1+" Pw2: "+pw2+" name: "+name+" birth: "+birth+" gender: "+gender+"email"+email+" mobile: "+mobile %></h3>
	
	
	<%
	//DB에 넣기
	UserDAO_mine dao = UserDAO_mine.getInstance();
	UserDTO_mine user = new UserDTO_mine(id, pw1, name, birth, gender, email, mobile);
	
	String url = "";
	if(dao.addUser(user)){%>
		
	<h1>가입성공</h1>
	<h1>회원가입을 환영합니다.</h1><% 
	 
	//마지막가입자 확인용
	//ArrayList<UserDTO_mine> users = dao.getUsers();
	//UserDTO_mine last = users.get(users.size()-1);	
	//last.toString() 
	
		session.setAttribute("joinId", id);
	url = "_05_Login.jsp";
	
	
	
	
	
	}else{
		
		session.setAttribute("joinId", "#%#%");
		url = "_03_join.jsp";
		
	}
	response.sendRedirect(url);
	%>
	
	
</body>
</html>