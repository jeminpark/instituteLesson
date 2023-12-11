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
<title>정보확인중....</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	String workType = session.getAttribute("workType").toString();
	System.out.println("checkProWorkType"+workType);
	String title = session.getAttribute("fixTitle").toString();
	int index = Integer.parseInt(session.getAttribute("fixIndex").toString());//세션으로 받아온 인덱스를 인티저로 파싱
	String pw = request.getParameter("password"); //입력한 비밀번호를 변수에 저장
	
	System.out.println("checkProIndex:"+index);
	System.out.println(pw);
	BoardDAO dao = BoardDAO.getInstance();
	ArrayList<BoardDTO> board = dao.getContent();
	
	
	String url = "";
	if(board.get(index).getPassword().equals(pw)){
		
		session.setAttribute("Passed", pw);
		if(workType.equals("fix")){
			url = "_13_boardUpdateForm.jsp?name="+title+"&index="+index;
			
		}
		else if(workType.equals("delete")){
			 url = "_17_boardDeleteForm.jsp?name="+title+"&index="+index;			
		}
	}
	else{
		session.setAttribute("Passed", "#%#%");
		url = "_15_checkPassForm.jsp?name="+title+"&index="+index+"&work="+workType;
		
	}
	System.out.println(session.getAttribute("Passed"));
	
	response.sendRedirect(url);
	
%>

<!--<input type = "hidden" id = hidden_params1 value = "<%=pw %> ">  -->
<!-- <input type = "hidden" id = hidden_params2 value = "<%=index %>">
 -->


<script>
	//let pw_data = document.querySelector("#hidden_params1").value;
	//let index_data = document.querySelector("#hidden_params2").value;
	//console.log(pw_data);
	//console.log(index_data);
</script>
</body>
</html>