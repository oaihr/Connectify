<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<style>

.body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 500px;
	
	display: flex;
	justify-content: center;
	align-items: center;
	
	margin-top: 170px;
	
	background-color: #F5F7FA;
}

.admin-input {
	width: 300px;
	height: 35px;
	
	font-size: 15px;
	margin-top: 15px;
	
	border-radius: 15px;
}


/* sign-in-container */
.sign-in-container {
	width: 550px;
	
	margin-left: 50px;

	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;

}


/* btn */
.btn-sign-in {
	margin: 40px;
	
	font-size: 25px;
	
	width: 230px;
	height: 50px;
	border-radius: 20px;
	
	color: white;
	background-color: #1F2937;
	cursor: pointer;
}



/* font */
.jua-regular {
	font-family: "Jua", sans-serif;
	font-weight: 400;
	font-style: normal;
	
	text-align: center;
}

.h1 {
	font-size: 70px;
	color: #111827;
}


/* ani */
@keyframes fadeInDown {
  0% {
    opacity: 0;
    transform: translateY(-20px);
  }
  100% {
    opacity: 1;
    transform: translateY(0);
  }
}

.sign-header h1 {
  animation: fadeInDown 2.3s ease forwards;
}

</style>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<div class="body">
		<div class="sign-header">
			<h1 class="jua-regular h1">Admin <br> Sign IN</h1>
		</div>
		<form action="/admin" method="post">
			<div class="sign-body">
				<div class="sign-in-container">
					<input type="text" name="id" class="admin-input id jua-regular" placeholder="관리자 아이디 코드">
					<input type="password" name="pw" class="admin-input pw id jua-regular" placeholder="관리자 비밀번호">
					<button type=submit class="btn-sign-in jua-regular">로그인</button>
				</div>
			</div>
		</form>
		
	</div>

</body>
</html>