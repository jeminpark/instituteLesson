<%@page import="java.sql.Timestamp"%>
<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%request.setCharacterEncoding("UTF-8"); %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<title>boardList</title>
</head>
<body>
	<div>
		<table border = "1">
			<tr>
				<td>no</td>
				<td>title</td>
				<td>id</td>
				<td>view</td>
				<td>like</td>
				<td>date</td>
				
			</tr>
			<tr id = 'tr2'>
			<%
			BoardDAO dao = BoardDAO.getInstance();
			
			request.setCharacterEncoding("utf-8");
			ArrayList<BoardDTO> board = dao.getContent();
			
			int idx = 0;
			String hello = "hello";
			for(int i=0; i<board.size(); i++){	
				
				idx = i;
			%>
			<tr>
				<td><%=board.get(i).getCode()%></td>
				<td><a href = "_18_boardView.jsp?name=<%=board.get(i).getTitle()%>&index=<%=idx%>"><%=board.get(i).getTitle()%></a></td>
				<td><%=board.get(i).getId() %></td>
				<td><%=board.get(i).getView() %></td>
				<td><%=board.get(i).getLike() %></td>
				<td><%=board.get(i).getDate() %></td>				
		
			<%} %>
		
			<!-- 
            <tr>
                <td>1</td>
                <td><a href= ""></a>2</td>
                <td>3</td>
                <td>4</td>
                <td>5</td>
                <td>6</td>
                
            </tr>
            -->
			</tr>
			
		</table>
		<button onclick = "location.href = '_08_main.jsp'">뒤로가기</button>
		<button onclick = "location.href = '_11_boardWriteForm.jsp'">글쓰기</button>	
	</div>
	
</body>
</html>