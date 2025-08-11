<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
}

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

.submenu a {
	text-decoration: none;
	color: black;
}

.btn-sign {
	width: 120px;
	height: 40px;
	font-size: 16px;
	background-color: #7d6eaa;
	color: #fff;
	border: none;
}

/* lodging-list 컨테이너 스타일 */
.lodging-list {
	display: flex;
	flex-wrap: wrap;
	justify-content: center; 
	gap: 20px; 
	padding: 20px;
	width: 90%;
	margin: 20px auto; 
}

/* 각 여행지 아이템 스타일 */
.lodging-list>div {
	flex-basis: calc(33.333% - 20px);
	max-width: calc(33.333% - 20px); 
	border: 1px solid #ddd;
	border-radius: 8px;
	overflow: hidden; /* 이미지 모서리 둥글게 처리 */
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	transition: transform 0.2s ease-in-out;
	background-color: #fff;
	cursor: pointer;
	text-align: center;
}

.lodging-list>div:hover {
	transform: translateY(-5px); /* 호버 시 약간 위로 올라가는 효과 */
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.lodging-list img {
	width: 100%; 
	height: 200px; 
	object-fit: cover; 
	border-bottom: 1px solid #ddd;
}

.lodging-list h3 {
	font-size: 1.2em;
	color: #333;
	margin: 10px 5px 0;
}

.lodging-list p {
	font-size: 0.9em;
	color: #666;
	margin: 5px;
	padding-bottom: 10px;
}

/* 페이지네이션 스타일 */
.pagination {
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 20px 0;
	gap: 10px;
}

.pagination a, .pagination span {
	display: flex; 
    align-items: center;
    justify-content: center;
    padding: 8px 12px;
    min-width: 40px; 
    border: 1px solid #ccc; 
    border-radius: 5px;
    text-decoration: none;
    color: #555;
    transition: all 0.2s; 
}

.pagination a:hover {
	background-color: #f0f0f0;
}

.pagination span {
	color: #fff;
	background-color: #7d6eaa;
	border: 1px solid #7d6eaa;
	padding: 8px 12px;
	font-weight: bold;
	cursor: default;
}
</style>
</head>
<body>
	<div class="mainscreen-container">
		<!-- ==================header 구간========================== -->
		<div class="header">
			<div class="main-menu-container">

				<img src="image/connectify_logo.png" class="logo" width="200" onClick="location.href='/'" />

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

					<li class="menu-title menu-span span">기타
						<ul class="submenu">
							<li><a href="">응급상황 대처요령</a></li>
							<li><a href="">고객센터</a></li>
						</ul>
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

		<hr class="hr">
	
	<div class="lodging-list">
		<c:forEach var="lodging" items="${lodgings}">
			<div>
				<img src="${lodging.firstimage}">
				<h3>${lodging.title}</h3>
				<p>${lodging.addr1} ${lodging.addr2} ${lodging.zipcode}</p>
			</div>
		</c:forEach>
	</div>

	<div class="pagination">
		<%-- 시작 페이지와 끝 페이지 계산 --%>
		<c:set var="startPage"
			value="${currentPage - 2 > 1 ? currentPage - 2 : 1}" />
		<c:set var="endPage"
			value="${currentPage + 2 < totalPages ? currentPage + 2 : totalPages}" />

		<%-- 이전 페이지 버튼 --%>
		<c:if test="${currentPage > 1}">
			<a
				href="/lodging?page=${currentPage - 1}&category=${currentCategory}">이전</a>
		</c:if>

		<%-- 페이지 번호 링크 --%>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:choose>
				<c:when test="${i == currentPage}">
					<span>${i}</span>
				</c:when>
				<c:otherwise>
					<a href="/lodging?page=${i}&category=${currentCategory}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<%-- 다음 페이지 버튼 --%>
		<c:if test="${currentPage < totalPages}">
			<a href="/lodging?page=${currentPage + 1}&category=${currentCategory}">다음</a>
		</c:if>
	</div>


</body>
</html>