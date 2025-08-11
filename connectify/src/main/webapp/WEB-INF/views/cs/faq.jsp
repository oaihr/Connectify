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
* {
    box-sizing: border-box;
}
body {
	margin: 0;
	padding: 0;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f0e9fa; /* 연한 하늘색 배경 */
	color: #333;
}

/*=================== font ===================*/
a {
	text-decoration: none;
	color: inherit;
}

/*  */
/*=================== header ===================*/
.mainscreen-container {
	width: 100%;
	height: 100vh;
	background-color: #fffff;
	display: flex;
	flex-direction: column;
}

.menu-title {
	
}

.span {
	font-family: 'Jua', sans-serif;
	font-size: 25px;
}

.menu-span {
	margin-left: 50px;
	margin-right: 50px;
}

.btn {
	border-radius: 20px;
	cursor: pointer;
	border: 2.5px groove #ccc;
	transition: all 0.2s ease-in-out;
}

.btn:hover {
	transform: translateY(-2px);
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.hr {
	margin: 15px;
}

.header {
	width: 100%;
	padding: 0px 50px;
	background-color: #ffffff;
	border-bottom: 1px solid #eee;
}

.main-menu-container {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.menu {
	display: flex;
	gap: 40px;
	list-style: none;
	padding: 0;
	margin: 0;
}

.menu>li {
	display: flex;
	flex-direction: column;
	align-items: center;
	font-size: 25px;
	font-weight: 700;
	text-align: center;
	cursor: pointer;
	color: #4b365f;
	position: relative;
}

.menu>li:hover {
	color: #7d6eaa;
}

.submenu {
	list-style: none;
	background-color: #ffffff;
	width: 180px;
	color: #7d6eaa;
	display: flex;
	flex-direction: column;
	position: absolute;
	top: 100%;
	left: 50%;
	transform: translate(-50%, 10px);
	opacity: 0;
	visibility: hidden;
	transition: all 0.3s ease-in-out;
	padding: 10px 0;
	border-radius: 5px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	z-index: 10;
}

.menu>li:hover .submenu {
	opacity: 1;
	visibility: visible;
	transform: translate(-50%, 0);
}

.submenu li {
	padding: 10px 15px;
	font-size: 16px;
	font-weight: 400;
}

.submenu li:hover {
	background-color: #f0f0f0;
}

.btn-sign {
	width: 120px;
	height: 40px;
	font-size: 16px;
	background-color: #7d6eaa;
	color: #fff;
	border: none;
}

/*  */
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

button:hover {
	background-color: #d0c1ff;
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

.faq_top {
	display: flex;
	justify-content: space-between;
	align-items: center;
}
/* 기존 .faq_top 안에 있는 검색창 스타일링 추가 */
.faq_top form {
	margin: 0; /* form 자체에 불필요한 여백 제거 */
}

.faq_top input[type="search"] {
	padding: 8px 14px;
	font-size: 15px;
	border: 1.5px solid #b3a5d9; /* 연한 보라 */
	border-radius: 8px;
	outline: none;
	transition: border-color 0.3s ease, box-shadow 0.3s ease;
	background-color: #f9f7fd; /* 아주 연한 보라빛 배경 */
	color: #4b365f; /* 어두운 보라색 글자 */
	width: 220px;
	box-sizing: border-box;
}

.faq_top input[type="search"]::placeholder {
	color: #a09bbc; /* 연한 보라 회색 느낌의 placeholder */
}

.faq_top input[type="search"]:focus {
	border-color: #7d6eaa; /* 좀 더 진한 보라 */
	box-shadow: 0 0 6px 2px rgba(125, 110, 170, 0.3);
	background-color: #fff;
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

.pagination {
	text-align: center;
	/* margin-top: 30px; */
}

.pagination a, .pagination span.current {
	display: inline-block;
	margin: 0 6px;
	padding: 8px 14px;
	border-radius: 8px;
	text-decoration: none;
	font-weight: 600;
	color: #7d6eaa;
	border: 1px solid #7d6eaa;
	transition: background-color 0.3s ease;
}

.pagination a:hover {
	background-color: #7d6eaa;
	color: #fff;
}

.pagination span.current {
	background-color: #4b365f;
	color: #fff;
	border-color: #4b365f;
}
/*footer 스타일*/
.footer {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
	padding: 20px 40px;
	background-color: #f8f8f8;
	border-top: 1px solid #e5e5e5;
	font-size: 12px;
	color: #666;
	margin-top: 30px;
}

.footer-container {
	display: flex;
	flex-direction: column;
}

.info-group {
	margin-bottom: 5px;
}

.info-group span, .info-group a {
	margin-right: 15px;
}

.footer-notes ul {
	list-style: none;
	padding: 0;
	margin: 15px 0;
}

.footer-notes li {
	margin-bottom: 5px;
}

.footer-copyright {
	margin-top: 10px;
}

.social-icons {
	display: flex;
	gap: 10px;
}

.social-icons .icon {
	width: 32px;
	height: 32px;
	background-color: #ccc;
	border-radius: 50%;
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>

</head>

<body>

	<div class="mainscreen-container">
		<div class="header">
			<div class="main-menu-container">

				<img src="image/connectify_logo1.png" class="logo" width="200"
					style="margin: 20px 0;" onClick="location.href='/'" />

				<ul class="menu">
					<li class="menu-title menu-span span">여행정보
						<ul class="submenu">
							<li><a href="/travels?category=12">관광지</a></li>
							<li><a href="/travels?category=14">문화시설</a></li>
							<li><a href="/travels?category=15">행사/축제</a></li>
							<li><a href="/travels?category=28">레포츠</a></li>
							<li><a href="/travels?category=38">쇼핑</a></li>
							<li><a href="/travels?category=39">음식점</a></li>
						</ul>
					</li>

					<li class="menu-title menu-span span">숙소
						<ul class="submenu">
							<li><a href="/lodging?category=AC010100">호텔</a></li>
							<li><a href="/lodging?category=AC020100">콘도</a></li>
							<li><a href="/lodging?category=AC020200">레지던스</a></li>
							<li><a href="/lodging?category=AC030100">팬션</a></li>
							<li><a href="/lodging?category=AC030200">한옥스테이</a></li>
							<li><a href="/lodging?category=AC030300">농어촌민박</a></li>
							<li><a href="/lodging?category=AC030400">홈스테이</a></li>
							<li><a href="/lodging?category=AC040100">모텔</a></li>
							<li><a href="/lodging?category=AC050100">일반야영장</a></li>
							<li><a href="/lodging?category=AC050200">오토캠핑장</a></li>
						</ul>
					</li>

					<li class="menu-title menu-span span"><a href="/qna">고객센터</a>
						
					</li>
				</ul>

				<!-- ==================signBox 구간========================== -->
				<form action="" method="post" class="signBox">
					<div class="sign-container">
						<button type="button" class="btn-sign btn">로그인</button>
					</div>
				</form>
			</div>
		</div>

		<div class="container">

			<div class="sidebar">
				<ul class="sidebar-menu">
					<!-- <li><img src="/image/connectify_logo.png"
					style="width: 100px; height: auto;"></li> -->
					<li>
						<h1 class="h1">고객센터</h1>
					</li>
					<li><a href="qna">문의하기</a></li>
					<li><a href="faq" class="menu-btn" data-target="faqSection">자주
							묻는 질문</a></li>
				</ul>
			</div>

			<div class="mainboard" id="faqSection">
				<div class="faq_top">
					<h2>자주 묻는 질문</h2>
					<form action="/search" method="GET">
						<input type="search" name="searchValue" placeholder="질문 검색">
					</form>
				</div>
				<c:forEach var="faq" items="${faqList}">
					<div class="faq_item">
						<h4>Q. ${faq.question}</h4>
						<div class="faq_answer">
							<strong>A.</strong> ${faq.answer}
						</div>
					</div>
				</c:forEach>

				<div class="pagination">
					<c:if test="${currentPage > 1}">
						<a href="?page=${currentPage - 1}">이전</a>
					</c:if>

					<c:forEach begin="1" end="${totalPages}" var="i">
						<c:choose>
							<c:when test="${i == currentPage}">
								<span class="current">${i}</span>
							</c:when>
							<c:otherwise>
								<a href="?page=${i}">${i}</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${currentPage < totalPages}">
						<a href="?page=${currentPage + 1}">다음</a>
					</c:if>
				</div>

			</div>

		</div>
						<footer class="footer">
					<div class="footer-container">
						<div class="footer-info">
							<div class="info-group">
								<span>(주)커넥티파이</span> <span>대표이사 우정영</span> <span>사업자등록번호
									202-81-45295</span> <span>통신판매업신고번호 중구 제03500호</span> <span>호스팅
									업체 (주)카오스네트워크</span>
							</div>
							<div class="info-group">
								<span>관광사업자 등록번호 2025-08</span> <span>영업보증보험 15억 1천만원</span> <span>기획여행영업보증
									7억원</span>
							</div>
							<div class="info-group">
								<span>상담문의 1566-9564</span> <span>팩스 041-561-1122</span> <span>충남
									천안시 동남구 대흥로 215 7층</span>
							</div>
						</div>
						<div class="footer-notes">
							<ul>
								<li>※ 부득이한 사정에 의해 확정된 여행일정이 변경되는 경우 여행자의 사전 동의를 받습니다.</li>
								<li>※ (주)커넥티파이는 항공사가 제공하는 항공권 및 여행사가 제공하는 일부 여행상품에 대하여
									통신판매중개자의 지위를 가지며, 해당 상품, 상거래 정보에 대한 의무와 거래에 관한 책임은 판매자에게 있습니다.</li>
								<li><b>※ 커넥티파이의 법인계좌가 아닌 다른 계좌로 입금하여 발생한 피해에 관하여, 당사는
										책임지지 않습니다. 타 계좌의 입금을 유도하는 행위가 발생하는 경우 반드시 커넥티파이 고객센터로 문의하거나
										신고하여 주시기 바랍니다.</b></li>
							</ul>
						</div>
						<div class="footer-copyright">COPYRIGHT CONNECTIFY, ALL
							RIGHTS RESERVED.</div>
					</div>
					<div class="social-icons">
						<a href="#" class="icon"><img src="image/SNS_kakaotalk.svg"
							alt="카카오톡"></a> <a href="#" class="icon"><img
							src="image/SNS_insta.svg" alt="인스타그램"></a> <a href="#"
							class="icon"><img src="image/SNS_naverblog.svg" alt="네이버블로그"></a>
						<a href="#" class="icon"><img src="image/SNS_youtube.svg"
							alt="유튜브"></a>
					</div>
				</footer>
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