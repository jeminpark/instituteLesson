<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <style>
        @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');
        span{


        }
        input[name = "subtitle"]{
            width: 96vw;
            height: 30px;
            font-size: 1.1em;
            word-break:"break-all";
            word-wrap:"break-word";
        }
        textarea[name = "content"]{
            width: 96.2vw;
            height: 500px;
            display: flex;
            justify-content: flex-start;
            font-size: 1em;
            white-space:'pre-wrap';
            word-wrap:break-word;
            word-break: break-all;
            font-family: 'Nanum Gothic', sans-serif;
            resize:none;
            

        }
        input[name = "password"]{
            word-break:"break-all";
            word-wrap:"break-word";
        }
        #errorMsg{
        	font-size: 2em;
        	color: green;
        }
   
    </style>

<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type = text/javascript src = "_02_validation.js"></script>
</head>
<body>
 <h1>게시글 수정</h1><br>
    <form method = "post" action = "_14_boardUpdatePro.jsp">
    <table>
    
    	<%
    	
    		BoardDAO dao = BoardDAO.getInstance();
    		ArrayList<BoardDTO> board = dao.getContent();
    		
    		
    		int index = Integer.parseInt(request.getParameter("index"));
    		System.out.println(index);
    		int code = board.get(index).getCode();
    		String title = board.get(index).getTitle();
    		String content = board.get(index).getContent();
    		String password = board.get(index).getPassword();
    		
    	
    	%>
        <tr>
            <td><span>제목:</span><br><br><input type = "text" id = "subtitle" name = "subtitle" value= "<%=title%>"><br></td>
           
            
        </tr>
        <tr>
            <td><span>본문:</span><br><br><textarea id = "content" name = "content" ><%=content%></textarea><br></td>
        </tr>
        <tr>
            <td><span>비밀번호:(수정하거나 그대로 두십시오.)</span><br><br><input type = "password" id = "password" name = "password" value = "<%=password%>"><br></td>
        </tr>

    </table>
            <input type = "hidden" name = "code" value = "<%=code %>">
            <input type = "hidden" name = "index" value = "<%=index %>">
    <h3 id = "errorMsg"> </h3>
    <input type = "button" value = "수정" onclick = "checkContent(form)">
    
  </form> 
  <script>
	let boardUrl = window.location.href;
	
	const url = new URL(boardUrl);
	
	const urlParams = url.searchParams;
	
	let urlName = urlParams.get('name');
	let urlIndex = urlParams.get('index');
	
	const tempText = " 수정페이지.."
	document.title = urlName+tempText;
</script>
  
</body>
</html>