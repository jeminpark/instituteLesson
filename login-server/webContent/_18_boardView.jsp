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

<style>

	h3{
	display: flex;
	padding-bottom: 300px;
	font-size: 2em;

}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type = "text/javascript" src = "_02_validation.js"></script>
<title></title>
</head>
<body>

<% BoardDAO dao = BoardDAO.getInstance();
	ArrayList<BoardDTO> board = dao.getContent();
	
	request.setCharacterEncoding("utf-8");
	
	int index = Integer.parseInt(request.getParameter("index"));
	System.out.println("boardViewIndex"+index);
	int code = board.get(index).getCode();
	
	dao.viewContent(code);
	
	String id = "";
	if(session.getAttribute("log")!= null){
		id = session.getAttribute("log").toString();
	}
	
	
%>
  <table >
        <tr>
           
            <td width = "100">글번호</td>
            <td><%=board.get(index).getCode()%></td>
        </tr>
        <tr>
            <td>조회수</td>
            <td><%=board.get(index).getView() %></td>
          
        </tr>
        <tr>
            <td>추천수
            	</td>
            
            <td><%=board.get(index).getLike() %></td>
            <td id = "likePanel">0     
            </td>
            
        </tr>
        <tr>
            <td>제목</td>
            <td><%=board.get(index).getTitle() %></td>
        </tr>
        <tr>
            <td>게시일</td>
            <td><%=board.get(index).getDate() %></td>
        </tr>
        
        <tr>
           	<td>내용
           		
           	</td>
       
       
        
        
    </table>
        <h3><%=board.get(index).getContent() %></h3>
	<input type = "button" onclick = "location.href = '_15_checkPassForm.jsp?name=<%=board.get(index).getTitle() %>&index=<%=index %>&work=fix '" value = "수정">
    <input type = "button" onclick = "location.href = '_15_checkPassForm.jsp?name=<%=board.get(index).getTitle() %>&index=<%=index %>&work=delete '" value = "삭제">
    <input type = "button" onclick = "location.href = '_10_boardList.jsp'" value = "목록">
    <input type = "button" id = "like" value = "좋아요" onclick = "likeClick()">
    <input type = "hidden" id = "likeCnt" name = "likeCnt">
	
<script> 

let boardUrl = window.location.href;
//console.log(boardUrl);

const url = new URL(boardUrl);

//console.log(url);
const urlParams = url.searchParams;

let urlName = urlParams.get('name');
let urlIndex = urlParams.get('index');

console.log(urlIndex);

document.title = urlName;



</script>


</body>
</html>