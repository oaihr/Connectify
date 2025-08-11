<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">


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

/*=================== header ===================*/
.header {
	width: 100%;
	padding: 10px 50px;
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

/*=================== body ===================*/
.body {
	display: flex;
	justify-content: center;
	align-items: flex-start;
	width: 100%;
	padding: 40px 20px;
	flex-grow: 1;
}

.travel-container {
	width: 700px;
	height: 450px;
	margin-right: 30px;
	/* border: 2px solid #e0e0e0; */
	border-radius: 20px;
	/* background-color: #f8f9fa; */
/* 	display: flex;
	align-items: center;
	justify-content: center; */
}

.search-container {
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 350px;
	height: 550px;
	border-radius: 20px;
	background-color: #f0e9fa;
	padding: 30px;
	box-sizing: border-box;
	gap: 20px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.08);
}

.search {
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 100%;
	gap: 15px;
}

.search-span {
	margin: 20px;
	font-size: 22px;
	color: #4b365f;
	font-family: 'Jua', sans-serif;
	font-size: 22px;
}

.search-input {
	width: 270px;
	padding: 8px;
	margin-top: 15px;
	border-radius: 10px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 10px;
}

/* select box */
.select {
	-moz-appearance: none;
	-webkit-appearance: none;
	appearance: none;
	font-size: 1rem;
	font-weight: 400;
	/* line-height: 1.5; */
	color: #444;
	background-color: #fff;
	padding: 10px;
	border: 1px solid #aaa;
	border-radius: 10px;
	/* box-shadow: 0 1px 0 1px rgba(0, 0, 0, .04); */
}

.select:hover {
	border-color: #888;
	cursor: pointer;
}

.select-form {
	display: flex;
	width: 100%;
}

.lang {
	width: 100%;
}

/* calendar */
.date-cal {
	width: 100%;
	padding: 15px;
	margin-top: 20px;
	border-radius: 10px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 10px;
}

.btn-search {
	width: 100%;
	font-size: 20px;
	padding: 15px;
	border-radius: 15px;
	background-color: #4b365f;
	color: #fff;
	border: none;
	font-family: 'Jua', sans-serif;
}

.btn-search:hover {
	background-color: #7d6eaa;
}
/*=================== footer ===================*/
.footer {
	width: 100%;
	padding: 20px 50px;
	text-align: center;
	color: #666;
	background-color: #f0f0f0;
	border-top: 1px solid #eee;
}

.footer span {
	font-size: 14px;
}

/*=================== font ===================*/
a {
	text-decoration: none;
	color: inherit;
}

/*=================== logo ===================*/
.logo {
	width: 150px;
	cursor: pointer;
}

/*=================== slideshow ===================*/
.slide-container {
	width: 100%;
	height: 450px;
	
	position: relative;
}

.slide-container img {
	width: 100%;
	height: 450px;
	border-radius: 20px;
}

.slide{
    -webkit-animation: fade 1.2s;
    animation: fade 1.2s;
}

@-webkit-keyframes fade {
    from {
        opacity: 0.4;
    }
    to {
        opacity: 1;
    }
}

@keyframes fade {
    from {
        opacity: 0.4;
    }
    to {
        opacity: 1;
    }
}

.prev, .next{
    cursor: pointer;
    position: absolute;
    top: 50%;
    width: auto;
    margin-top: -22px;
    padding: 16px;
    color: white;
    font-size: 25px; 
    transition: 0.6s ease;
    user-select: none;
}

.next{
    right: 0;
}

.prev:hover, .next:hover{
    background-color: rgba(0, 0, 0, 0.5);
    border-radius: 5px;
}

.text{
    font-family: 'Edu VIC WA NT Beginner', cursive;
    font-size: 15px;
    position: absolute;
    bottom: 8px;
    width: 100%;
    text-align: center;
    color: #ffffff;
}

.dots {
    position: relative;
    text-align: center;
    margin-top: 10px;
}

.dot{
    cursor: pointer;
    height: 12px;
    width: 12px;
    background-color: #bdbdbd;
    border-radius: 50%;
    display: inline-block;
}

.active, .dot:hover{
    background-color: #949494;
}


</style>

<!-- flatpickr CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
<!-- flatpickr JS -->
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>


</head>
<body>

	<div class="mainscreen-container">
		<!-- ==================header 구간========================== -->
		<div class="header">
			<div class="main-menu-container">

				<img src="image/connectify_logo.png" class="logo" width="150"
					onClick="location.href='/'" />

				<ul class="menu">
					<li class="menu-title menu-span span">여행정보
						<ul class="submenu">
							<li><a href="">관광지</a></li>
							<li><a href="">문화시설</a></li>
							<li><a href="">행사/축제</a></li>
							<li><a href="">레포츠</a></li>
							<li><a href="">쇼핑</a></li>
							<li><a href="">음식점</a></li>
						</ul>
					</li>

					<li class="menu-title menu-span span">숙소
						<ul class="submenu">
							<li><a href="">호텔</a></li>
							<li><a href="">팬션</a></li>
							<li><a href="">게스트 하우스</a></li>
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

		<!-- ==================travelBox 구간========================== -->
		<div class="body">

			<form action="" method="post" class="travelBox">
				<div class="travel-container">
					<div class="slide-container">
						<div class="slide"> <img src="https://tong.visitkorea.or.kr/cms/resource/04/3304404_image2_1.jpg"> </div>
						<div class="slide"> <img src="https://tong.visitkorea.or.kr/cms/resource/33/2667333_image2_1.jpg"> </div>
						<div class="slide"> <img src="https://tong.visitkorea.or.kr/cms/resource/77/2655177_image2_1.jpg"> </div> 
						<div class="slide"> <img src="https://tong.visitkorea.or.kr/cms/resource/68/2631068_image2_1.jpg"> </div>
			            <a class="prev">&#10094;</a>
			            <a class="next">&#10095;</a>
						<div class="dots">
					            <span class="dot" data-val="0"></span>
					            <span class="dot" data-val="1"></span>
					            <span class="dot" data-val="2"></span>
					            <span class="dot" data-val="3"></span>
						</div>
					</div>
				</div>
			</form>


			<!-- ==================search 구간========================== -->
			<form action="" method="post" class="searchBox">
				<div class="search-container">

					<div class="search">
						<p class="span">
							<span class="search-span">검색</span> <input type="text"
								name=searchKeyword placeholder="검색어를 입력해주세요."
								<%-- value="${}" --%>
							class="search-input">
						</p>

						<div>
							<!-- area -->
							<div class="select-form search">
								<select name="languages" class="lang select">
									<option value="select" class="option">여행 지역 선택</option>
									<%-- 							
								<c:forEach var="area" items="${areaList}">
									<option value="${}">${}</option>
								</c:forEach>
								 --%>
								</select>
							</div>


							<!-- calendar -->
							<div class="calendar-container search">
								<input id="rangePicker" class="date-cal" placeholder="기간을 선택하세요">
							</div>

						</div>

					</div>
					<button type="submit" class="btn-search btn">검색하기</button>
				</div>
			</form>

		</div>


		<hr class="hr">

		<!-- ==================footer 구간========================== -->
		<div class="footer">
			<span class="span">사이트 상세 내용 구간</span>
		</div>



	</div>

	<!-- ==================js 구간========================== -->
	<!-- flatpickr JS -->
	<script>
		//일자 가져오기 value
		const rangePicker = document.querySelector('#rangePicker');
		
		rangePicker.addEventListener('change', () => {
		  console.log(rangePicker.value);  
		  // 예: "2025-08-03 ~ 2025-08-10"
		});
		
		const selectedRange = document.querySelector('#rangePicker').value;

		const fp = flatpickr("#rangePicker", {
			mode : "range",
			dateFormat : "Y-m-d",
			locale: {
				    ...flatpickr.l10ns.ko,
				    rangeSeparator: " ~ "
				  },
			onChange: function (selectedDates) {
					const [startDate, endDate] = selectedDates;
					
					const startStr = this.formatDate(startDate, "Y-m-d");
					const endStr = this.formatDate(endDate, "Y-m-d");

				},
			minDate: "today"
		});
		
		
		//슬라이드 쇼
		const $prev = document.querySelector('.prev');
		const $next = document.querySelector('.next');
		const $slide = document.querySelectorAll('.slide');
		const $dots = document.querySelectorAll('.dot');
		const $dot = document.querySelector('.dots');
		
		let slideIndex = 0;
		
		//실행
		window.onload = function(){
		    showSlides(slideIndex);
		
		    let sec = 6000;
		    setInterval(function(){
		        slideIndex++;
		        showSlides(slideIndex);
		    }, sec);
		}
		
		//이전 버튼을 누르면 이전으로, 다음버튼을 누르면 다음으로 이동
		function moveSlides(n){
		    slideIndex = slideIndex + n
		    showSlides(slideIndex);
		}
		
		$prev.addEventListener('click', () => moveSlides(-1))
		$next.addEventListener('click', () => moveSlides(1))
		
		
		//하단 동그라미를 누르면 해당하는 이미지로 이동
		function currentSlide(e){
		    const val = e.target.dataset.val
		    if(val !== undefined) {
		        slideIndex = +val;
		        showSlides(slideIndex);
		    }
		}
		
		$dot.addEventListener('click', currentSlide)
		
		
		//슬라이드쇼 실행
		function showSlides(n){
		    let size = $slide.length;
		
		    //슬라이드쇼의 길이보다 slideIndex가 커지면 다시 처음으로 돌아가도록
		    if((n+1) > size){
		        slideIndex = 0;
		        n = 0;
		    } else if(n < 0) {  //slideIndex가 0보다 작아지면 마지막으로 가도록
		        slideIndex = (size - 1);
		        n = (size - 1);
		    }
		    
		    //슬라이드쇼를 전부 안보이게
		    for(let i=0; i<size; i++){
		        $slide[i].style.display = 'none';
		    }
		
		    //하단 동그라미 부분을 모두 진하게 표시되지 않도록 한다.
		    for(let i=0; i<$dots.length; i++){
		        $dots[i].className = $dots[i].className.replace("active", "");
		    }
		
		    //해당하는 슬라이드만 보이도록 한다.
		    $slide[n].style.display = "block";
		
		    //해당하는 동그라미만 진하게 표시되도록 한다.
		    $dots[n].classList.toggle("active");
		}

		
	</script>

</body>
</html>