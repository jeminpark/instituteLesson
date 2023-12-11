<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<style>
	body{
		display: flex;
		flex-direction: column;
		justify-content: space-around;
		align-item: center;
		
		gap : 20px;
		
	}
	button{
		width: 100px;
		height: 70px;
		
		border : none;
		border-radius : 10px 10px 10px 10px;
		background-color: green;
		
		color: white;
		font-size: 1.5em;
		
		cursor: pointer;
		
	}
	
</style>
</head>
<body>
	<h1>INDEX</h1>
	 <button onclick = "location.href = '_05_Login.jsp'">Login</button>
	<button onclick = "location.href = '_01_agree.jsp'">Join</button>
		
</body>
</html>