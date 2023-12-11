<%@page import="user.UserDTO_mine"%>
<%@page import="user.UserDAO_mine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
 <script type = text/javascript src = _02_validation.js></script>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO_mine dao = UserDAO_mine.getInstance();
		
		
		
		String url = "";
		if(dao.login(id, pw)){
			

			session.setAttribute("log", id);
			
			url = "_08_main.jsp";
	    }		
		else{
			
			
			session.setAttribute("loginId", "@#@#");
			
			
			url = "_05_Login.jsp";
		 

		}
		response.sendRedirect(url);
		
		%>
	
			
</body>

</html>