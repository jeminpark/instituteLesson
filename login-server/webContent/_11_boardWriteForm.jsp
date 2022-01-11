<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html lang="en">
<head>
<%request.setCharacterEncoding("utf-8"); %>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type = "text/javascript" src= "_02_validation.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
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
    <script type = text/javascript src = "_02_validation.js"></script>
    <title>boardPage</title>
</head>
<body>
    <h1>게시글 쓰기</h1><br>
    <form method = "post" action = "_12_boardWritePro.jsp">
    <table>
        <tr>
            <td><span>제목:</span><br><br><input type = "text" id = "subtitle" name = "subtitle"><br></td>
           
            
        </tr>
        <tr>
            <td><span>본문:</span><br><br><textarea id = "content" name = "content"></textarea><br></td>
        </tr>
        <tr>
            <td><span>비밀번호:</span><br><br><input type = "password" id = "password" name = "password"><br></td>
            
        </tr>

    </table>
    <h3 id = "errorMsg"></h3>
    <input type = "button" value = "글쓰기" onclick = "checkContent(form)">
  </form>
	
	
	
</body>
</html>