<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
	/* 스크랩 방지 */
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none
}

/*=================== font ===================*/
a {
	text-decoration: none;
	color: inherit;
}

/*=================== common ===================*/
.mainscreen-container {
	width: 100%;
	height: 100vh;
	background-color: #fffff;
	display: flex;
	flex-direction: column;
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

/*=================== header ===================*/
.mainscreen-container {
	width: 100%;
	height: 100vh;
	background-color: #fffff;
	display: flex;
	flex-direction: column;
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

/*=================== login ===================*/
.login-container {
	max-width: 400px;
	margin: 80px auto; /* 화면 중앙 배치 */
	padding: 30px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.login-container h1 {
	color: #7d6eaa;
	margin-bottom: 30px;
	font-size: 28px;
}

/* 입력 필드 스타일 */
.login-container p {
	margin-bottom: 20px;
	text-align: left;
}

.login-container input {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 6px;
	font-size: 14px;
	outline: none;
}

.login-container input:focus {
	border-color: #7d6eaa;
	box-shadow: 0 0 5px rgba(125, 110, 170, 0.3);
}

.body-btn-sign {
	width: 170px;
	height: 50px;
	font-size: 23px;
	background-color: #7d6eaa;
	color: #fff;
	border: none;
	margin-top: 25px;
}

/*=================== logo ===================*/
.logo {
	cursor: pointer;
}
</style>


<body>

	<div class="mainscreen-container">

		<div class="header">
			<div class="main-menu-container">

				<img src="/image/connectify_logo1.png" class="logo" width="200"
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

					<li class="menu-title menu-span span"><a href="/faq">고객센터</a></li>
				</ul>

				<!-- ==================signBox 구간========================== -->

				<form action="" method="post" class="signBox">
					<div class="sign-container">
						<button type="button" class="btn-sign btn"
							onClick="location.href='/customer/login'">로그인</button>
					</div>
				</form>
			</div>
		</div>

		<hr class="hr">

		<div class="login-container">
			<h1>로그인</h1>

			<form action="" method="post">
				<p>
					아이디 <input type="text" name="id" required>
				</p>
				<p>
					비밀번호 <input type="password" name="pw" required>
				</p>
				<div>
					<a href="/customer/signup">아이디가 왜 없어요?</a>
				</div>
				<button type="submit" class="btn body-btn-sign">로그인</button>
			</form>
		</div>
	</div>



</body>
</html>
