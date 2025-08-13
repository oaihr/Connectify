<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
}

a {
	text-decoration: none;
	color: inherit;
}

.mainscreen-container {
	width: 100%;
	height: 100vh;
	background-color: #fffff;
	display: flex;
	flex-direction: column;
}

/* header 스타일 */
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
	margin-top: 20px;
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

/*=================== logo ===================*/
.logo {
	cursor: pointer;
}
</style>
</head>
<body>
	${destination.title}
	<div class="mainscreen-container">
		<!-- ==================header 구간========================== -->
		<div class="header">
			<div class="main-menu-container">

				<img src="/image/connectify_logo1.png" class="logo" width="200" style="margin: 20px 0;" onClick="location.href='/'" />

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
							<li><a href="/lodgings?category=AC010100">호텔</a></li>
							<li><a href="/lodgings?category=AC020100">콘도</a></li>
							<li><a href="/lodgings?category=AC020200">레지던스</a></li>
							<li><a href="/lodgings?category=AC030100">팬션</a></li>
							<li><a href="/lodgings?category=AC030200">한옥스테이</a></li>
							<li><a href="/lodgings?category=AC030300">농어촌민박</a></li>
							<li><a href="/lodgings?category=AC030400">홈스테이</a></li>
							<li><a href="/lodgings?category=AC040100">모텔</a></li>
							<li><a href="/lodgings?category=AC050100">일반야영장</a></li>
							<li><a href="/lodgings?category=AC050200">오토캠핑장</a></li>
						</ul>
					</li>

					<li class="menu-title menu-span span"><a href="/qna">고객센터</a></li>
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
		<footer class="footer">
			<div class="footer-container">
				<div class="footer-info">
					<div class="info-group">
						<span>(주)커넥티파이</span> 
						<span>대표이사 우정영</span> 
						<span>사업자등록번호	202-81-45295</span> 
						<span>통신판매업신고번호 중구 제03500호</span> 
						<span>호스팅 업체 (주)카오스네트워크</span>
					</div>
					<div class="info-group">
						<span>관광사업자 등록번호 2025-08</span> <span>영업보증보험 15억1천만원</span> 
						<span>기획여행영업보증 7억원</span>
					</div>
					<div class="info-group">
						<span>상담문의 1566-9564</span> 
						<span>팩스 041-561-1122</span> 
						<span>충남천안시 동남구 대흥로 215 7층</span>
					</div>
				</div>
				<div class="footer-notes">
					<ul>
						<li>※ 부득이한 사정에 의해 확정된 여행일정이 변경되는 경우 여행자의 사전 동의를 받습니다.</li>
						<li>※ (주)커넥티파이는 항공사가 제공하는 항공권 및 여행사가 제공하는 일부 여행상품에 대하여 통신판매중개자의 지위를 가지며, 해당 상품, 상거래 정보에 대한 의무와 거래에 관한 책임은 판매자에게 있습니다.</li>
						<li><b>※ 커넥티파이의 법인계좌가 아닌 다른 계좌로 입금하여 발생한 피해에 관하여, 당사는 책임지지 않습니다. 타 계좌의 입금을 유도하는 행위가 발생하는 경우 반드시 커넥티파이 고객센터로 문의하거나 신고하여 주시기 바랍니다.</b></li>
					</ul>
				</div>
				<div class="footer-copyright">COPYRIGHT CONNECTIFY, ALL RIGHTS RESERVED.</div>
			</div>
			<div class="social-icons">
				<a href="#" class="icon"><img src="/image/SNS_kakaotalk.svg"	alt="카카오톡"></a> 
				<a href="#" class="icon"><img src="/image/SNS_insta.svg" alt="인스타그램"></a> 
				<a href="#"	class="icon"><img src="/image/SNS_naverblog.svg" alt="네이버블로그"></a>
				<a href="#" class="icon"><img src="/image/SNS_youtube.svg" alt="유튜브"></a>
			</div>
		</footer>
	</div>	
</body>
</html>