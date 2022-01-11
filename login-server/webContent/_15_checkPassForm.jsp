<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type = 'text/javascript' src = "_02_validation.js"></script>
<title>Insert title here</title>
</head>
<body>
<% 
	String title = request.getParameter("name");
	System.out.println("checkPassName"+title);
	String index = request.getParameter("index");
	String workType = request.getParameter("work");
	
	System.out.println("checkPassWorkType"+workType);
	//System.out.println(index);
	System.out.println("checkPassIndex"+index);
	
	session.setAttribute("workType", workType);
	session.setAttribute("fixTitle", title); //데이터가 pro로 안넘어가서 제목 세션으로저장
	session.setAttribute("fixIndex", index); // 데이터가 pro로 안넘어가서 인덱스를 세션에 저장
	
	if(session.getAttribute("Passed") != null){
		if(session.getAttribute("Passed").equals("#%#%")){
			title = session.getAttribute("fixTitle").toString();
			index = session.getAttribute("fixIndex").toString();
			workType = session.getAttribute("workType").toString();
			%><script>alert("비밀번호가 일치하지 않습니다.");</script><% 
			
			session.setAttribute("Passed", false);
			
		}
	}
	
%>

<form method = "post" action = "_16_checkPassFormPro.jsp">
	<h1>수정 하려면 비밀번호를 입력하세요.</h1>
	<br><br>
	<input type = "password" name = "password">
	<input type = "hidden" name = "index" value = "<%=index%>">
	<input type = "button" value = "입력" onclick = "updateKey(form)">
	
</form>

<h3 id = "errorMsg3"></h3>
<script>
let boardUrl = window.location.href;
//console.log(boardUrl);
const url = new URL(boardUrl);

const urlParams = url.searchParams;
let urlName = urlParams.get('name');
let urlIndex = urlParams.get('index');
console.log(urlIndex);

const indexData = document.getElementsByName("index").value;

const tempText = " 정보 확인중..."
document.title = urlName+tempText;


console.log(indexData);



</script>

</body>
</html>