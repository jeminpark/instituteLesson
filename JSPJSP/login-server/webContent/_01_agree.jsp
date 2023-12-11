<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <style>
        form{
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
           
        }
        h1{
            
           display: flex;
           justify-content: center; 
        }
        p{
            font-size:0.8em;
        }
        .box1{
            
            width:50px;
            height: 20px;
        }
        ul{
        	display: flex;
            flex-direction: column;
            justify-content: space-between;
            gap: 40px;
        }
        p#error{
        
        	color: red;
        	font-size: 1.3em;
        }

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
    <script type = "text/javascript" src = "_02_validation.js"></script>
    <title>Account</title>
</head>
<body>
    <h1>회원가입 예제</h1>
    <form id = 'form1' method= "GET" action = "_03_join.jsp">
        
        <ul>
            <li><input type = "checkbox" class = "box1" name = "choiceAll" onclick = "checkAllBox(this)"><span>필수정보 선택정보 모두동의
                <h3 class = "article1"> 여러분 환영합니다.</h3><p>본 예제의 이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택), 프로모션 정보 수신(선택)에 모두 동의합니다.</p></span></li>
            <li><input type = "checkbox" class = "box1" name = "necessary" onclick = "checkSelectAll()"><span>이용약관동의(필수)
                <h3 class = "article2"> 회원으로 가입하시면 예제 서비스를 보다 편리하게 이용할 수 있습니다.</h3><p>본 예제 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다.
                    본 약관은 다양한 예제 서비스의 이용과 관련하여 예제 서비스를 제공하는 예제 주식회사(이하 ‘예제’)와
                    이를 이용하는 예제 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며,
                    아울러 여러분의 예제 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.</p>
            </span></li>
           
            <li><input type = "checkbox" class = "box1" name = "necessary" onclick = "checkSelectAll()"><span>개인정보 수집및 이용동의(필수)
                <h3 class = "article3">수집하는 개인정보</h3> <p>개인정보보호법에 따라 예제에 회원가입 신청하시는 분께 
                    수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 
                    관한 사항을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.
                    
                </p>
            </span></li>
            <li><input type = "checkbox" class = "box1" name = "choice" onclick = "checkSelectAll()"><span>위치정보 이용약관 동의(선택)
                <h3 class = "article4">위치정보 이용약관에 동의하시면, 위치를 활용한 광고 정보 수신 등을 포함하는 예제 위치기반 서비스를 이용할 수 있습니다.</h3> 
                <p>이 약관은 예제 주식회사 (이하 “회사”)가 제공하는 위치정보사업 또는 위치기반서비스사업과 관련하여 회사와 개인위치정보주체와의
                     권리, 의무 및 책임사항, 기타 필요한 사항을 규정함을 목적으로 합니다.
                    
                </p>
            </span></li>
            <li><input type = "checkbox" class = "box1" name = "choice" onclick = "checkSelectAll()"><span>프로모션 정보수신동의(선택)
                
                <p>예제에서 제공하는 이벤트/혜택 등 다양한 정보를 휴대전화(예제앱 알림 또는 문자), 이메일로 받아보실 수 있습니다. 
                    일부 서비스(별도 회원 체계로 운영하거나 예제 가입 이후 추가 가입하여 이용하는 서비스 등)의 경우, 개별 서비스에 대해 별도 수신 동의를 받을 수 있으며, 
                    이때에도 수신 동의에 대해 별도로 안내하고 동의를 받습니다.
                </p>
            </span></li>
        </ul>
        <p id = "error"></p>
        <input type = "button" value = "확인" onclick = "checkVal(form)">
    </form>
</body>
</html>