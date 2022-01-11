<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Process</title>
</head>
<body>
	<%
	
		
		
		String title = request.getParameter("subtitle");
		String content = request.getParameter("content");
		Object objId = session.getAttribute("log");
		String id = (String)objId;
		String password = request.getParameter("password");
	 	
		//게시판 글쓰기 작성후 자바스크립트 객체에 글쓴번호 저장
		//글쓴번호와 좋아요 클릭시 좋아요갯수, 누가 좋아요했는지 검증때쓸 모든회원정보? 
		//
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO board = new BoardDTO(title, content, id, password);
		
		String url = "";
		if(dao.addUpload(board)){
			
			url = "_10_boardList.jsp";
		}
		else{
			
			url = "_11_boardWriteForm.jsp";
		}
		response.sendRedirect(url);	
	%>
	
</body>
</html>