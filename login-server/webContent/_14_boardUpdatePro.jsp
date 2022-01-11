<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		request.setCharacterEncoding("utf-8");
		int index = Integer.parseInt(request.getParameter("index"));
		String title = request.getParameter("subtitle");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		int code = Integer.parseInt(request.getParameter("code"));
		System.out.println("UpdateForm code"+code);
		System.out.println("UpdateForm title"+title);
		System.out.println("UpdateForm content"+content);
		System.out.println("UpdateForm password"+password);
		System.out.println("UpdateForm index"+index);
		
		
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardDTO> board = dao.getContent();
		
		String url = "";
		if(dao.setContent(code,title,content,password)){
			
			url = "_18_boardView.jsp?name="+board.get(index).getTitle()+"&index="+index+"";
		}
		else{
			url = "_18_boardView.jsp?name="+board.get(index).getTitle()+"&index="+index+"";
		
		};
		response.sendRedirect(url);
		
		
		
	
	%>

</body>
</html>