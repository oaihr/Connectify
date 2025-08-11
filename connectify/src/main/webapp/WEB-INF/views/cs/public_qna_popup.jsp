<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 문의 남기기</title>
<style>
body {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f0e9fa; /* 연한 하늘색 배경 */
	color: #333;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh; /* 팝업창 중앙 정렬 */
}

.container {
	background-color: #ffffff;
	padding: 30px 40px;
	border-radius: 12px;
	box-shadow: 0 4px 12px rgba(0, 102, 204, 0.15);
	width: 500px;
}

h2 {
	color: #024a86;
	margin-bottom: 25px;
	text-align: center;
}

label {
	display: block;
	margin-bottom: 8px;
	font-weight: 600;
	color: #4b365f;
}

input[type="text"], textarea {
	width: 100%;
	padding: 10px 12px;
	border: 1px solid #c6d9f1;
	border-radius: 8px;
	font-size: 15px;
	color: #333;
	resize: vertical;
	transition: border-color 0.3s ease;
	box-sizing: border-box;
}

input[type="text"]:focus, textarea:focus {
	border-color: #024a86;
	outline: none;
}

button[type="submit"] {
	margin-top: 20px;
	width: 100%;
	background-color: #4b365f;
	color: #f0e9fa;
	font-weight: 700;
	padding: 12px;
	border: none;
	border-radius: 8px;
	font-size: 18px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

button[type="submit"]:hover {
	background-color: #7d6eaa;
}
</style>
</head>
<body>

	<div class="container">
		<h2>문의하기</h2>
		<form action="/qna/popup" method="post">
			<label for="title">제목</label><br> <input type="hidden"
				name="isPublic" value="1"> <input type="hidden"
				name="status" value="대기"> <input type="text" id="title"
				name="title" required><br> <br> <label
				for="content">내용</label><br>
			<textarea id="question" name="question" rows="7" cols="60" required></textarea>
			<br> <br>
			<button type="submit">질문 등록</button>

		</form>
	</div>
</body>
</html>