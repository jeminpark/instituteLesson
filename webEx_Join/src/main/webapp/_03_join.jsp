<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        body{
            display:flex;
            flex-direction: column;
            align-items: center;
        }
        form{
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            justify-content: center;
        }
        span{
            display: flex;
            flex-direction: column;
            white-space: pre;
        }
        #birth{
            display: flex;
            flex-direction: row;
        }
    </style>
    
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script> -->
    
    <title>join</title>

</head>
<body>
    <h1>환영합니다</h1>
    <form id = "form2" method = "POST" action = "_04_joinPro.jsp">
        <span>아이디:&#9<input type='text' name = 'required'></span><br>
        <span>비밀번호:&#9<input type='password' name = 'required' id = 'pw1' onchange = "passwordTest()"></span><br>
        <span>비밀번호 재확인<input type ='password' name = 'required' id = 'pw2' onchange = "passwordTest()"></span><br>
        <span>이름<input type ="text" name = 'required'></span><br><br>
        <span>생년월일<p id = 'birth'><input type = "number" min = '1900' max = "2021" placeholder = "년(4자)" name = 'required'><select name = 'required'><option value = "1">1</option>
        																																							 <option value = "2">2</option>	
        																																							 <option value = "3">3</option>
        																																							 <option value = "4">4</option>
        																																							 <option value = "5">5</option>
        																																							 <option value = "6">6</option>
        																																							 <option value = "7">7</option>
        																																							 <option value = "8">8</option>
        																																							 <option value = "9">9</option>
        																																							 <option value = "10">10</option>
        																																							 <option value = "11">11</option>
        																																							 <option value = "12">12</option>
        																																							 					</select><input type = "number" placeholder="일" min = "1" max = "31"name = 'required'></p></span><br>

        <span>성별</span><select name = "gender" name = 'requried'><option value = "male">남자</option>
                                                <option value = "female">여자</option>
                                                <option value = "nonchoice">선택안함</option></select><br>

        <span>본인확인 이메일</span><input type = "email" name = 'required'><br>
        <span>휴대전화<input type = "tel" pattern = "[0-9]{3}-[0-9]{4}-[0-9]{4}" name = required></span><br>                        
        <p id = 'errorMsg'></p>
        <input type = "button" value = "가입하기" onclick = "dataChange(form)">
    </form>
    <script type = "text/javascript" src = "_02_validation.js"></script>
</body>
</html>