<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자주 묻는 질문</title>
<style>
body {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f0e9fa; /* 연한 하늘색 배경 */
	color: #333;
}

.container {
	display: flex;
	min-height: 100vh;
}

.sidebar {
	width: 200px;
	background-color: #d3d3ff; /* 연한 블루 */
	padding: 30px 20px;
	box-shadow: 2px 0 8px rgba(0, 0, 0, 0.05);
}

.h1 {
	text-align: center;
	margin-bottom: 30px;
	color: #4b365f;
	letter-spacing: 2px;
	font-weight: 700;
}

.sidebar-menu {
	list-style: none;
	padding: 0;
	text-align: center;
}

.sidebar-menu li {
	margin-bottom: 25px;
}

.sidebar-menu li a {

	text-decoration: none;
	color: #7d6eaa;
	font-weight: 600;
	font-size: 20px;
	transition: color 1s ease;
}

.sidebar-menu li a:hover {
	color: #ffffff;
	font-weight: bold;
}

.mainboard {
	flex: 1;
	padding: 40px 50px;
	background-color: #ffffff;
	border-radius: 10px;
	margin: 30px;
	box-shadow: 0 4px 12px rgba(0, 102, 204, 0.15);
}

h2 {
	color: #024a86;
	margin-bottom: 25px;
}

.faq_item {
	background-color: #f9fbff;
	border-radius: 12px;
	padding: 20px 25px;
	margin-bottom: 15px;
	box-shadow: 8px 2px 8px rgba(3, 102, 214, 0.1);
	transition: box-shadow 0.3s ease;
}

.faq_item:hover {
	box-shadow: 0 6px 16px rgba(3, 102, 214, 0.2);
}

.faq_item h4 {
	margin: 0;
	color: #014a9c;
}

.faq_answer {
	margin-top: 12px;
	margin-left: 15px;
	color: #333;
	font-size: 15px;
}

hr {
	border: none;
	border-top: 0.5px solid #c6d9f1;
	margin: 15px 0 0 0;
}
</style>

</head>

<body>

	<div class="container">

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
					<h4>Q. ${faq.question}</h4>
					<div class="faq_answer">
						<strong>A.</strong> ${faq.answer}
					</div>
<!-- 					<hr> -->
				</div>
			</c:forEach>
		</div>
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
            document.addEventListener("DOMContentLoaded", function() {
                const faqItems = document.querySelectorAll(".faq_item");

                faqItems.forEach(item => {
                    item.addEventListener("click", function() {
                        // 클릭된 faq_item 안에서 faq_answer를 찾습니다.
                        const answer = this.querySelector(".faq_answer");

                        // 답변의 display 속성을 토글하여 보이거나 숨깁니다.
                        if (answer.style.display === "block") {
                            answer.style.display = "none";
                        } else {
                            answer.style.display = "block";
                        }
                    });
                });

                // 기존 메뉴 버튼 및 탭 관련 스크립트가 있다면 여기에 그대로 두세요.
                // 현재 제공된 HTML에는 faqSection만 있어서 다른 코드는 필요 없을 수도 있습니다.
            });
        });
    });
});

</script>

</body>
</html>