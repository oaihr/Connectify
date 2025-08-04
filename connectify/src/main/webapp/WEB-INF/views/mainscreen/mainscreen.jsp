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
.mainscreen-container {
	width: 100%;
	height: 100vh;
	background-color: #fcf8f1;
}

.main-span {
	font-size: 25px;
}

.btn {
	border-radius: 20px;
	cursor: pointer;
	border: 2.5px groove gray;
}

.hr {
	margin: 15px;
}

/*=================== header ===================*/
.header {
	display: flex;
	width: 100%;
}

.main-menu-container {
	width: 100%;
	height: 100px;
	justify-content: center;
	margin: 20px;
	display: flex;
}

.menu {
	display: flex;
	gap: 20px;
	list-style: none;
	padding: 0;
	margin: 0;
}

.menu>li {
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 150px;
	font-size: 20px;
	text-align: center;
	cursor: pointer;
	line-height: 150%;
}

.submenu {
	list-style: none;
	top: 100%;
	left: 50%;
	display: none;
	background-color: white;
	border: 1px solid #aaa;
	width: 150px;
	padding: 10px 0;
	z-index: 10;
}

.menu>li:hover .submenu {
	display: block;
}

/* hover animation */
.btn-sign {
	width: 150px;
	height: 50px;
	margin-left: 20px;
	font-size: 18px;
}

/*=================== body ===================*/
.body {
	display: flex;
	width: 100%;
	justify-content: center;
}

.travel-container {
	width: 800px;
	height: 550px;
	margin: 20px;
	border: 2px solid lightgray;
	border-radius: 20px;
}

.search-container {
	/* 	width: 300px;
	height: 550px;
	margin-top: 20px;
	border-radius: 20px;
	background-color: #E2ECF1; */
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: start;
	width: 300px;
	height: 550px;
	margin-top: 20px;
	border-radius: 20px;
	background-color: #E2ECF1;
	padding: 20px; /* 내부 여백 추가 */
	box-sizing: border-box;
	gap: 20px; /* 요소 간 간격 */
}

.search {
	/* 	padding: 30px;
	padding-bottom: 0;
	margin-bottom: 15px;
	flex-direction: column;
	align-items: center;
	justify-content: center; */
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 100%;
	gap: 10px;
}

.search-input {
	/* 	width: 200px;
	padding: 13px;
	border-radius: 15px;
	padding: 13px; */
	width: 100%;
	padding: 13px;
	border-radius: 15px;
	box-sizing: border-box;
}

/* select box */
.select {
	-moz-appearance: none;
	-webkit-appearance: none;
	appearance: none;
	font-family: "Noto Sansf KR", sans-serif;
	font-size: 1rem;
	font-weight: 400;
	line-height: 1.5;
	color: #444;
	background-color: #fff;
	padding: .6em 1.4em .5em .8em;
	border: 1px solid #aaa;
	border-radius: .5em;
	box-shadow: 0 1px 0 1px rgba(0, 0, 0, .04);
}

.select:hover {
	border-color: #888;
	cursor: pointer;
}

.select:focus {
	border-color: #aaa;
	box-shadow: 0 0 1px 3px rgba(59, 153, 252, .7);
	box-shadow: 0 0 0 3px -moz-mac-focusring;
	color: #222;
	outline: none;
}

.select:disabled {
	opacity: 0.5;
}

.select-form {
	display: flex;
	padding: 10px;
}

/* calendar */
.date-cal {
	width: 100%;
	padding: 13px;
	border-radius: 15px;
	box-sizing: border-box;
}

.btn-search {
	width: 100%;
	font-size: 20px;
	padding: 13px;
	border-radius: 15px;
	box-sizing: border-box;
}

/*=================== footer ===================*/

/*=================== font ===================*/
.jua-regular {
	font-family: "Jua", sans-serif;
	font-weight: 400;
	font-style: normal;
}

a {
	text-decoration: none;
	color: inherit;
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

				<img src="resources/image/free-icon-travel-3205338.png" alt="임시 이미지"
					width="150" />

				<ul class="menu">
					<li class="main-span menu-span jua-regular">여행지
						<ul class="submenu">
							<li><a href="">자연</a></li>
							<li><a href="">호캉스</a></li>
							<li><a href="">도심</a></li>
							<li><a href="">액티비티</a></li>
						</ul>
					</li>

					<li class="main-span menu-span jua-regular">이동수단
						<ul class="submenu">
							<li><a href="">항공</a></li>
							<li><a href="">렌터카</a></li>
							<li><a href="">배</a></li>
						</ul>
					</li>

					<li class="main-span menu-span jua-regular">숙소
						<ul class="submenu">
							<li><a href="">호텔</a></li>
							<li><a href="">팬션</a></li>
							<li><a href="">게스트 하우스</a></li>
						</ul>
					</li>

					<li class="main-span menu-span jua-regular">기타
						<ul class="submenu">
							<li><a href="">응급상황 대처요령</a></li>
							<li><a href="">고객센터</a></li>
						</ul>
					</li>
				</ul>

				<!-- ==================signBox 구간========================== -->
				<form action="" method="post" class="signBox">
					<div class="sign-container">
						<button type="button" class="btn-sign jua-regular btn">로그인</button>
					</div>
				</form>
			</div>
		</div>

		<hr class="hr">

		<!-- ==================travelBox 구간========================== -->
		<div class="body">

			<form action="" method="post" class="travelBox">
				<div class="travel-container">
					<a href="">여행 정보 사이트 이동(임시-이미지 넣을 예정)</a>
				</div>
			</form>


			<!-- ==================search 구간========================== -->
			<form action="" method="post" class="searchBox">
				<div class="search-container">

					<div class="search">
						<span class="main-span jua-regular search-span"> 검색 <input
							type="text" name=searchKeyword placeholder="검색어를 입력해주세요."
							<%-- value="${}" --%>
							class="search-input">
						</span>

						<div>
							<!-- area -->
							<div class="select-form search">
								<select name="languages" class="lang select">
									<option value="select" class="option">Select area</option>
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
					<button type="submit" class="btn-search jua-regular btn">검색하기</button>
				</div>
			</form>

		</div>


		<hr class="hr">

		<!-- ==================footer 구간========================== -->
		<div class="footer">
			<span class="main-span">사이트 상세 내용 구간</span>
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
					console.log("시작일:", startDate);
					console.log("종료일:", endDate);
				},
			minDate: "today"
		});
		
		
		
		
/* 		console.log(selectedRange); */
	</script>

</body>
</html>