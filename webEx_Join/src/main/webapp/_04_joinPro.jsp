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
		font-size: 3em;
		color: lightgrey;
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
            
            border-radius : 10px 10px 10px 10px;
	}
	#last{
		font-size: 1.5em;
		
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
		
		
		User_DAO dao = User_DAO.getInstance();
		
		if(dao.checkDuplId(id)){%>
			<h1>가입성공</h1>
			<h1>회원가입을 환영합니다.</h1>
		<% 
			User_DTO user = new User_DTO(id, pw1, name, birth, gender, email, mobile);
		
			dao.addUser(user);
		
			ArrayList<User_DTO> users = dao.getUsers();
			User_DTO last = users.get(users.size()-1);
		
			%><h1 id = "last"><%=last.toString() %></h1>
		
		
			<form method = "post" action = "_05_Login.jsp">
	
				<input type = "submit" value = "로그인페이지로 이동">
	
			</form>
	
			<h3>가입자 정보
	
			<%--<%="id:"+id+"pw1:"+pw1+"pw2:"+pw2+"name:"+name+"birth:"+birth+"gender:"+gender+"email"+email+"mobile:"+mobile %>  --%>
	
				<%for(User_DTO printUser : users){ %>
					<p><%="Id: "+printUser.getId()+" pw: "+printUser.getPw()+" name: "+printUser.getName()+" birth: "+printUser.getBirth()+
							" gender: "+printUser.getGender()+" email: "+printUser.getEmail()+" mobile: "+printUser.getMobile()%>
					</p>
	
				<%} %>
	
			</h3>
				<%}
		else{%>
			<h1> 중복된 아이디가 있습니다.</h1>
			<form action = "_03_join.jsp">
			<input type = "submit" value = " 가입페이지로 돌아가기 ">
			</form>
		<%} %>	
	
</body>
</html>