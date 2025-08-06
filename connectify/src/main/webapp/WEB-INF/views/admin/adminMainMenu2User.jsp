<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<style>
.body {
	/* 	margin-top: 100px; */
	font-family: 'Trebuchet MS', serif;
	line-height: 1.6;
	margin: 0;
	padding: 0;
	height: 100vh;
	overflow: hidden;
	margin: 0;
}

.header {
	display: flex;
	justify-content: space-between;

	/* margin: 25px; */
}

.header-right {
	display: flex;
	margin: 20px;
}

.h1 {
	color: #D96846;
	margin-left: 50px;
	cursor: pointer;
}

.btn-logout {
	width: 150px;
	padding: 20px;
	font-size: 20px;
	border-radius: 20px;
}

/* =============tab=================== */
.tab-container {
	height: 100vh;
	display: flex;
}

.tab-link {
	width: 100%;
	height: 100%;
	font-size: 25px;
}

ul.tabs {
	margin: 0px;
	padding: 0px;
	width: 20%;
	height: 150px;
}

ul.tabs li {
	color: #222;
	border-top: 2px solid #e0e0e0;
	cursor: pointer;
}

ul.tabs li.current {
	background: #f1f5f9;
	color: #3f4129;
}

.tab-content {
	display: none;
	background: #f1f5f9;
	width: 100%;
	overflow: auto;
	border: 3px solid #f1f5f9;
	border-left: 0;
}

.tab-content.current {
	display: inherit;
}

.menu-header {
	display: flex;
	justify-content: space-between;
	font-size: 30px;
	margin: 50px;
}

.btn {
	color: white;
	background-color: #1F2937;
	cursor: pointer;
}

.list {
	display: flex;
	justify-content: space-between;
	align-items: center;
	font-size: 17px;
	padding: 30px;
	border-bottom:;
}

.list:hover {
	background-color: #d9e2ec;
	border-radius: 15px;
}

/* travel */
.travel {
	width: 100%;
	heigth: 100%;
}

.btn-travel {
	border-radius: 20px;
}

.btn-add-travel {
	width: 200px;
	height: 50px;
	font-size: 20px;
	margin-top: 20px;
}

.btn-md-travel {
	/* margin-top: 15px; */
	font-size: 15px;
	width: 70px;
	padding: 5px;
}

/* font */
.jua-regular {
	font-family: "Jua", sans-serif;
	font-weight: 400;
	font-style: normal;
	text-align: center;
}

.name-text {
	color:;
}

/* a */
a {
	text-decoration: none;
	color: #001f3f;
}

/* form 전환*/
.travel-form-content {
	display: none;
}

.travel-form-content.active {
	display: block;
}

.user-form-content {
	display: none;
}
.user-form-content.active {
	display: block;
}




/* input */
.input {
	padding: 10px 15px;
	border: 1px solid #ccc;
	border-radius: 10px;
	font-size: 16px;
	width: 300px;
	margin: 10px 0;
	outline: none;
	transition: all 0.2s ease-in-out;
}

.input:focus {
	border-color: #3b82f6; /* 파란색 포커스 */
	box-shadow: 0 0 5px rgba(59, 130, 246, 0.5);
}
</style>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<div class="body">

		<div class="header">
			<h1 class="h1 jua-regular" onClick="location.href='/admin/main'">Admin</h1>
			<div class="header-right">
				<p class="header-name">${admin.name}</p>
				<button onClick="location.href='/admin/logout'"
					class="btn-logout jua-regular">로그아웃</button>
			</div>
		</div>

		<div class="body-container">
			<div class="tab-container">

				<ul class="tabs">
					<li class="tab-link current jua-regular" data-tab="tab-0"><p>Home</p></li>
					<li class="tab-link jua-regular" data-tab="tab-1"><p>여행지</p></li>
					<li class="tab-link jua-regular" data-tab="tab-2"><p>
							사용자<br> 검색
						</p></li>
					<li class="tab-link jua-regular" data-tab="tab-3"><p>질문내역</p></li>
					<li class="tab-link jua-regular" data-tab="tab-4"><p>신고내역</p></li>
				</ul>

				<!-- menu 0 -->
				<div id="tab-0" class="tab-content current">

					<div class="menu-header">
						<p class="jua-regular">관리자Home</p>
					</div>

				</div>


				<!-- menu 1 -->
				<div id="tab-1" class="tab-content">

					<div class="travel jua-regular">
						<!-- travel-form1 -->
						<div id="travel-form1" class="travel-form-content">
							<form action="" method="">

								<div class="menu-header">
									<p class="jua-regular">여행지</p>
									<button type="button"
										class="btn btn-add-travel jua-regular btn-travel"
										onClick="showTravelForm('travel-form2')">여행지 등록</button>
								</div>

								<div class="search-container search">
									<select name="languages" class="lang select">
										<option value="select" class="option">Select area</option>
										<%-- 							
								<c:forEach var="area" items="${areaList}">
									<option value="${}">${}</option>
								</c:forEach>
								 --%>
									</select> <input type="text" class="input" placeholder="여행지 정보 검색">
									<button type="button" class="btn">검색</button>

								</div>

								<%-- <c:forEach var="${}" items="${}"></c:forEach> --%>
								<div class="travel-list list">
									<a href="">여행 패키지 이름/가격(DB 불러올 예정)</a>
									<div>
										<button type="button"
											class="btn btn-md-travel btn-travel jua-regular">수정</button>
										<button type="button"
											class="btn btn-md-travel btn-travel jua-regular">삭제</button>
									</div>
								</div>
							</form>
						</div>
						<!-- travel-form2 -->
						<div id="travel-form2" class="travel-form-content">
							<form action="" method="">

								<div class="menu-header">
									<p class="jua-regular">여행지 등록</p>
									<button type="button"
										class="btn btn-add-travel jua-regular btn-travel"
										onClick="showTravelForm('travel-form1')">돌아가기</button>
								</div>


								<div class="travel-form2-body">
									<select>
										<option>여행지</option>
										<option>호텔</option>
										<option></option>
										<option>숙소</option>
									</select> <input type="text" class="jua-regular"
										placeholder="제목을 입력해주세요."> <input type="text"
										class="jua-regular" placeholder="제목을 입력해주세요."> <input
										type="text" class="jua-regular" placeholder="제목을 입력해주세요.">
								</div>

							</form>
						</div>

					</div>

				</div>



				<!-- menu 2 -->
				<div id="tab-2" class="tab-content">

					<div class="user-search jua-regular">

						<div class="menu-header">
							<p class="jua-regular">사용자 검색</p>
						</div>
						
						<form action="/admin/searchUser" method="post">
							<div class="search-container search">
								<input type="text" 
										name="searchKeywordUser" 
										class="input"
										placeholder="사용자 이름"
										value="${adminUserSearch.searchKeywordUser}">
								<button type="submit" class="btn">검색</button>
							</div>
						</form>


						<div id="user-form1" class="user-form-content">
							<form action="" method="">
								<c:forEach var="adminUser" items="${userList}">
									<div class="user-search-list list">
										<a href="">${userList.name} || ${userList.tel}</a>
										<div>
											<button type="button" class="btn-md-user-search btn-user-search jua-regular">수정</button>
											<button type="button" class="btn-md-user-search btn-user-search jua-regular">삭제</button>
										</div>
									</div>
								</c:forEach>
							</form>
						</div>

						<div id="user-form2" class="user-form-content">
							<form action="" method="">
								<c:forEach var="userList" items="${userList}">
									<div class="user-search-list list">
										<a href="">${userList.name} || ${userList.tel}</a>
										<div>
											<button type="button" class="btn-md-user-search btn-user-search jua-regular">수정</button>
											<button type="button" class="btn-md-user-search btn-user-search jua-regular">삭제</button>
										</div>
									</div>
								</c:forEach>
							</form>
						</div>

					</div>

				</div>

				<!-- menu 3 -->
				<div id="tab-3" class="tab-content">

					<div class="issues jua-regular">

						<form class="form">

							<div class="menu-header">
								<p class="jua-regular">질문 내역</p>
							</div>

							<%-- <c:forEach var="${}" items="${}"></c:forEach> --%>
							<div class="issues-list list">
								<a href="">질문 List(DB 불러올 예정)</a>
							</div>
						</form>

					</div>


				</div>

				<!-- menu 4 -->
				<div id="tab-4" class="tab-content">

					<div class="reports jua-regular">

						<form class="form">

							<div class="menu-header">
								<p class="jua-regular">신고 내역</p>
							</div>

							<%-- <c:forEach var="${}" items="${}"></c:forEach> --%>
							<div class="reports-list list">
								<a href="">신고 List(DB 불러올 예정)</a>
							</div>
						</form>

					</div>

				</div>

			</div>


		</div>
	</div>

	<script>
		/* =============tab menu================= */
		$(document).ready(function() {

			$('ul.tabs li').click(function() {
				var tab_id = $(this).attr('data-tab');

				$('ul.tabs li').removeClass('current');
				$('.tab-content').removeClass('current');

				$(this).addClass('current');
				$("#" + tab_id).addClass('current');
			})

		});
	 		
	 		//사용자 검색
	 		function showUserForm(tabId) {
	            const tabs = document.querySelectorAll('.user-form-content');
	            tabs.forEach(tab => {
	            	tab.classList.remove('active')
	            });
	            
	            document.getElementById(tabId).classList.add('active');
	        }
	 		
	        showTravelForm('travel-form1');
	        
	        /* 키워드 form */
	    	<c:choose>
				<c:when test="${not empty adminUserSearch.searchKeywordUser}">
					showUserForm('user-form2'); // 검색 결과 보여줌
				</c:when>
				<c:otherwise>
					showUserForm('user-form1'); // 기본 리스트
				</c:otherwise>
			</c:choose>
	        
	        
	        
	        
	</script>



</body>
</html>