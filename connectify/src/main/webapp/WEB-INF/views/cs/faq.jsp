<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<style>
body {
	margin: 0px;
	padding: 0px;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
	display: flex;
}

.sidebar {
	width: 200px;
	background-color: #f8f9fa;
	padding: 20px;
}

.h1 {
	text-align: center;
}

.sidebar-menu {
	list-style: none;
	padding: 0;
	text-align: center;
}

.sidebar-menu li {
	margin-bottom: 15px;
}

.sidebar-menu li a {
	text-decoration: none;
	color: #333;
	font-weight: bold;
}

.mainboard {
	flex: 1;
	padding: 30px;
}

.myTextBox {
	width: 100%; /* 너비 100% 설정 */
	height: 60px; /* 높이를 60픽셀로 설정 */
}

.h1 {
	margin: 20px;
}
</style>

</head>

<body>
	
	<div class="sidebar">
		<ul class="sidebar-menu">
			<h1 class="h1">고객센터</h1>
			<li><a href="qna">문의하기</a></li>
			<li><a href="faq" class="menu-btn" data-target="faqSection">자주
					묻는 질문</a></li>
		</ul>
	</div>
	
	<div class="mainboard" id="faqSection">
		<h2>자주 묻는 질문</h2>
		<c:forEach var="faq" items="${faqList}">
			<div class="faq_item">
				<h4>${faq.question}</h4>
				<div class="faq_answer">${faq.answer}</div>
			</div>
		</c:forEach>
	</div>


	<script>
document.addEventListener("DOMContentLoaded", function () {
    const menuButtons = document.querySelectorAll(".menu-btn");
    const sections = {
        inquirySection: document.getElementById("inquirySection"),
        faqSection: document.getElementById("faqSection")
    };

    menuButtons.forEach(btn => {
        btn.addEventListener("click", function (e) {
            e.preventDefault();
            const target = btn.dataset.target;

            // 모든 section 숨기기
            for (let key in sections) {
                sections[key].style.display = "none";
            }

            // 선택한 section만 보이기
            sections[target].style.display = "block";
        });
    });

    // 탭 기능은 기존 그대로 유지
    const tabs = document.querySelectorAll(".tab_menu .list li");
    const contents = document.querySelectorAll(".tab_menu .cont");

    tabs.forEach((tab, index) => {
        tab.addEventListener("click", function (e) {
            e.preventDefault();
            tabs.forEach(t => t.classList.remove("is_on"));
            tab.classList.add("is_on");
            contents.forEach(c => c.classList.remove("active"));
            contents[index].classList.add("active");
        });
    });
});
</script>

</body>
</html>