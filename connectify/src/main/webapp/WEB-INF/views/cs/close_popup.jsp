<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		alert("문의가 등록되었습니다.");
		// 부모 창을 새로고침하고 팝업 창을 닫습니다.
		if (opener) {
			opener.location.reload();
		}
		window.close();
	</script>
</head>
<body>
</body>
</html>