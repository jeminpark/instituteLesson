<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>

        span{
            white-space: pre;

        }
        h1{
            color : green;
        }
        input[name = "id"]{
            padding : 10px;
            border : solid 2px green;
        }
        input[name = "pw"]{
            padding : 10px;
            border : solid 2px green;
        }
        input[type = "button"]{
            cursor: pointer;
            padding: 10px;
            border: none;
            color:white;
            background-color: green;
        }

    </style>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    
    <title>Document</title>
</head>
<body>
    <h1>LOGIN</h1>
    <form method = "POST" action = "_06_LoginPro.jsp">

        <span>id:&#9</span><input type = 'text' name = "id"><br>
        <span>pw:&#9</span><input type = 'password' name = "pw"><br><br>

		

		
        <input type = "button" value = "로그인" onclick = "loginCheck(form)">
        
        
        <h1 id = "errorMsg"></h1>
    </form>
    <script type = "text/javascript" src = "_02_validation.js"></script>
</body>
</html>