<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1 문의 남기기</title>
</head>
<body>

	<h2>문의하기</h2>
	<form action="/qna/popup" method="post">
    <label for="title">제목</label><br>
    
    <input type="hidden" name="isPublic" value="0">
    
    <input type="hidden" name="status" value="대기">
    
    <input type="text" id="title" name="title" required><br><br>
    <label for="content">내용</label><br>
    <textarea id="question" name="question" rows="7" cols="60" required></textarea><br> <br>
    <button type="submit">질문 등록</button>
</form>
</body>
</html>