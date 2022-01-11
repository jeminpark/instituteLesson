<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제되었습니다.</title>
</head>
<body>
	<%
	
	
		int index = Integer.parseInt(request.getParameter("index"));
	
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardDTO> board = dao.getContent();
		
		int code = board.get(index).getCode();
		
		String url = "";
		if(dao.delContent(code)){
			url= "_10_boardList.jsp";
		}
		else{
			url= "_10_boardList.jsp";
		}
		response.sendRedirect(url);
		
	
	%>
	
</body>
</html>