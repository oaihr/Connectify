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
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">

<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
	line-height: 1.6;
	margin: 0;
	padding: 0;
	height: 100vh;
	background-color: #f8f9fa;
	overflow: hidden;
}

.body-container {
	height: calc(100vh - 80px); /* Adjust based on header height */
	display: flex;
	flex-direction: column;
}


.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	padding: 15px 50px;
	background-color: #ffffff;
	border-bottom: 1px solid #e9ecef;
}

.header-right {
	display: flex;
	align-items: center;
	gap: 20px;
}
.h1 {
	color: #4b365f;
	margin: 0;
	cursor: pointer;
	font-size: 30px;
	font-family: "Jua", sans-serif;
}

.header-name {
    font-size: 16px;
    font-weight: 700;
    color: #4b365f;
    margin: 0;
}


.btn-logout {
	width: 120px;
	height: 40px;
	font-size: 16px;
	padding: 0;
	border-radius: 20px;
	background-color: #4b365f;
	color: #fff;
	border: none;
	cursor: pointer;
	transition: background-color 0.2s, transform 0.2s;
}

.btn-logout:hover {
	background-color: #7d6eaa;
	transform: translateY(-1px);
}
/* =============tab=================== */
.tab-container {
	flex-grow: 1;
	display: flex;
}

ul.tabs {
	margin: 0;
	padding: 0;
	width: 20%;
	min-width: 220px;
	background-color: #e9ecef; /* Light gray for sidebar */
	list-style: none;
	height: 100%;
}

ul.tabs li {
	padding: 25px 20px;
	color: #495057;
	border-bottom: 1px solid #dee2e6;
	cursor: pointer;
	font-size: 18px;
	font-family: "Jua", sans-serif;
	transition: all 0.2s;
}

ul.tabs li:hover {
	background-color: #dfe3e7;
}

ul.tabs li.current {
	background: #ffffff;
	color: #4b365f;
	border-right: 4px solid #4b365f;
}

.tab-content {
	display: none;
	background: #ffffff;
	width: 80%;
	flex-grow: 1;
	padding: 30px 40px;
	overflow-y: auto;
	box-shadow: inset 5px 0 8px -5px rgba(0,0,0,0.05);
}

.tab-content.current {
	display: block;
}

/* =================== Menu Header =================== */
.menu-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	font-size: 28px;
	margin-bottom: 30px;
	padding-bottom: 15px;
	border-bottom: 2px solid #f1f5f9;
}

.menu-header p {
    margin: 0;
    color: #4b365f;
    font-family: "Jua", sans-serif;
}


/* =================== Buttons & Inputs =================== */
.btn {
	padding: 10px 20px;
	color: white;
	background-color: #4b365f;
	cursor: pointer;
	border: none;
	border-radius: 8px;
	transition: background-color 0.2s, transform 0.2s;
	font-family: 'Noto Sans KR', sans-serif;
}

.btn:hover {
	background-color: #7d6eaa;
	transform: translateY(-1px);
}

.btn-add-travel {
	font-size: 18px;
	width: 150px;
	padding: 12px 20px;
}

.btn-md-list {
	font-size: 14px;
	width: 60px;
	padding: 6px;
	margin-left: 10px;
}

.input {
	padding: 12px 15px;
	border: 1px solid #ccc;
	border-radius: 8px;
	font-size: 16px;
	width: 100%;
	max-width: 300px;
	margin: 10px 0;
	outline: none;
	transition: border-color 0.2s, box-shadow 0.2s;
}

.input:focus {
	border-color: #7d6eaa;
	box-shadow: 0 0 5px rgba(125, 110, 170, 0.5);
}

.search-container {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-bottom: 20px;
}
.search-container .input {
    margin: 0;
}
.search-container .btn {
    padding: 12px 25px;
}

.select {
    padding: 12px 15px;
    border: 1px solid #ccc;
    border-radius: 8px;
    font-size: 16px;
    background-color: #fff;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
    cursor: pointer;
}

/* =================== Lists =================== */
.list {
	display: flex;
	justify-content: space-between;
	align-items: center;
	font-size: 16px;
	padding: 15px 20px;
	border-bottom: 1px solid #e9ecef;
	transition: background-color 0.2s;
}

.list:hover {
	background-color: #f1f3f5;
	border-radius: 8px;
}

.list a {
	text-decoration: none;
	color: #495057;
	flex-grow: 1;
}

.list a:hover {
    color: #4b365f;
}

.name-text {
    color: #888;
    font-size: 14px;
}

/* =================== Form Switching =================== */
.travel-form-content, .user-form-content, .issues-form-content, .reports-form-content {
    display: none;
}
.active {
    display: block;
}

/* Fonts */
.jua-regular {
	font-family: "Jua", sans-serif;
	font-weight: 400;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<div class="body">

		<div class="header">
			
			<!-- <h1 class="h1 jua-regular" onClick="location.href='/admin/main'">Admin</h1> -->
			<img src="/image/connectify_logo.png" class="logo" width="150"
					onClick="location.href='/admin/main'" />
			<div class="header-right">
				<p class="header-name">${sessionScope.admin.name}</p>
				<button onClick="location.href='/admin/logout'"
					class="btn-logout jua-regular">로그아웃</button>
			</div>
		</div>

		<div class="body-container">
			<div class="tab-container">

				<ul class="tabs">
					<li class="tab-link current jua-regular" onClick="location.href='/admin/main'"><p>Home</p></li>
					<li class="tab-link jua-regular" onClick="location.href='/admin/travel'"><p>여행지</p></li>
					<li class="tab-link jua-regular" onClick="location.href='/admin/user'"><p>사용자<br> 검색 </p></li>
					<li class="tab-link jua-regular" onClick="location.href='/admin/issue'"><p>질문내역</p></li>
					<li class="tab-link jua-regular" onClick="location.href='/admin/report'"><p>신고내역</p></li>
				</ul>

				<!-- menu 0 -->
				<div id="tab-0" class="tab-content current">

					<div class="menu-header">
						<p class="jua-regular">관리자Home</p>
					</div>

				</div>


				<!-- menu 1 -->
				<div id="tab-1" class="tab-content">

					<div class="tab-all jua-regular">

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
									</select> <input type="text" class="input" placeholder="여행지 정보 검색">
									<button type="button" class="btn">검색</button>
								</div>

								<div class="list">
									<a href="">여행 패키지 이름/가격(DB 불러올 예정)</a>
									<div>
										<button type="button"
											class="btn btn-md-list btn-list jua-regular">수정</button>
										<button type="button"
											class="btn btn-md-list btn-list jua-regular">삭제</button>
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

					<div class="tab-all jua-regular">

						<!-- User form1 -->
						<!-- User 전체 -->
						<div id="user-form1" class="user-form-content">

							<div class="menu-header">
								<p class="jua-regular">사용자 검색</p>
							</div>

							<form action="/admin/searchUser" method="post">
								<div class="search-container search">
									<input type="text" name="searchKeywordUser" class="input"
										placeholder="사용자 이름"
										value="${adminUserSearch.searchKeywordUser}">
									<button type="submit" class="btn" >검색</button>
								</div>
							</form>

							<div>
								<c:forEach var="user" items="${userSearchList}">
									<div class="list">
											<a href="#" onClick="showUserForm('user-form4')">NAME: ${user.name} || ID: ${user.id}
												|| TEL): ${user.tel}</a>
										<div>
											<button type="button"
												class="btn btn-md-list btn-list jua-regular"
												onClick="showUserForm('user-form5')">수정1</button>
											<button type="button"
												class="btn btn-md-list btn-list jua-regular">삭제</button>
										</div>
									</div>
								</c:forEach>
							</div>
							
							
						</div>

						<!-- User form2 -->
						<!-- 검색결과 -->
						<div id="user-form2" class="user-form-content">

							<div class="menu-header">
								<p class="jua-regular">사용자 검색</p>
							</div>

							<form action="/admin/searchUser" method="post">
								<div class="search-container search">
									<input type="text" name="searchKeywordUser" class="input"
										placeholder="사용자 이름"
										value="${adminUserSearch.searchKeywordUser}">
									<button type="submit" class="btn">검색</button>
								</div>
							</form>

							<div>
								<c:forEach var="user" items="${userSearchList}">
									<div class="list">
											<a href="#" onClick="showUserForm('user-form4')">NAME: ${user.name} || ID: ${user.id}
												|| TEL): ${user.tel}</a>
										<div>
											<button type="button"
												class="btn btn-md-list btn-list jua-regular"
												onClick="showUserForm('user-form5')">수정2</button>
											<button type="button"
												class="btn btn-md-list btn-list jua-regular">삭제</button>
										</div>
									</div>
								</c:forEach>
							</div>
							
							
						</div>

						<!-- User form3 -->
						<!-- 검색 키워드가 맞지 않을 때 -->
						<div id="user-form3" class="user-form-content">
							<form action="" method=""></form>
						</div>

						<!-- User form4 -->
						<!-- 사용자 정보 -->
						<div id="user-form4" class="user-form-content"">
							<form action="" method="">
								<div class="menu-header">
									<p class="jua-regular"></p>
									<button type="button"
										class="btn btn-add-travel jua-regular btn-travel"
										onClick="showUserForm('user-form4')">수정하기</button>
									<button type="button"
										class="btn btn-add-travel jua-regular btn-travel"
										onClick="showUserForm('user-form2')">돌아가기</button>
								</div>

								<div>
									<p>User info ${user.id}</p>
								</div>
							</form>
						</div>

						<!-- User form5 -->
						<!-- 사용자 정보 수정 -->
						<div id="user-form5" class="user-form-content">
							<form action="" method="">
								<div class="menu-header">
									<p class="jua-regular"></p>
									<button type="button"
										class="btn btn-add-travel jua-regular btn-travel"
										onClick="showUserForm('user-form2')">돌아가기</button>
								</div>

								<div>
									<p>User 수정 ${user.id}</p>
								</div>
							</form>
						</div>

					</div>

				</div>

				<!-- menu 3 -->
				<div id="tab-3" class="tab-content">

					<div class="tab-all jua-regular">
						<!-- isssues form1 -->
						<!-- isssues 전체 -->
						<div id="issues-form1" class="issues-form-content">
							<form action="" method="">
								<div class="menu-header">
									<p class="jua-regular">질문 내역</p>
								</div>
							<div>
								<c:forEach var="issue" items="${issueList}">
									<div class="list">
											<a href="#" onClick="showIssuesForm('issues-form2')">
											ID: ${issue.id} : ${issue.title}</a> <span>${issue.userId}|${issue.status}</span>
									</div>
								</c:forEach>
							</div>
							</form>
						</div>

						<!-- isssues form2 -->
						<div id="issues-form2" class="issues-form-content">
							<form action="" method="">
								<div class="menu-header">
									<p class="jua-regular">질문</p>
									<button type="button"
										class="btn btn-add-travel jua-regular btn-travel"
										onClick="showIssuesForm('issues-form1')">돌아가기</button>
								</div>
								<div class="">
									<p>issues</p>
									
								</div>>

							</form>
						</div>

					</div>


				</div>

				<!-- menu 4 -->
				<div id="tab-4" class="tab-content">

					<div class="tab-all jua-regular">

						<!-- reports form1 -->
						<!-- reports 전체 -->
						<div id="reports-form1" class="reports-form-content">
							<form action="" method="">
								<div class="menu-header">
									<p class="jua-regular">신고 내역</p>
								</div>
								<div class="issues-list list">
									<a href="#" onClick="showReportsForm('reports-form2')">신고
										List(DB 불러올 예정)</a>
								</div>
							</form>
						</div>

						<!-- reports form2 -->
						<div id="reports-form2" class="reports-form-content">
							<form action="" method="">
								<div class="menu-header">
									<p class="jua-regular">신고</p>
									<button type="button"
										class="btn btn-add-travel jua-regular btn-travel"
										onClick="showReportsForm('reports-form1')">돌아가기</button>
								</div>
								<p>내용내용</p>

							</form>
						</div>
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
		
		
 		// tab menu form 이동
 		
 			//여행지 등록
	 		function showTravelForm(tabId) {
	            const tabs = document.querySelectorAll('.travel-form-content');
	            tabs.forEach(tab => {
	            	tab.classList.remove('active')
	            });
	            
	            document.getElementById(tabId).classList.add('active');
	        }
	 		showTravelForm('travel-form1');
	 		
	 		//사용자 검색
	 		function showUserForm(tabId) {
	            const tabs = document.querySelectorAll('.user-form-content');
	            tabs.forEach(tab => {
	            	tab.classList.remove('active')
	            });
	            
	            document.getElementById(tabId).classList.add('active');
	        }
	 		showUserForm('user-form1');
	 		

	 		//질문
	 			function showIssuesForm(tabId) {
	            const tabs = document.querySelectorAll('.issues-form-content');
	            tabs.forEach(tab => {
	            	tab.classList.remove('active')
	            });
	            
	            document.getElementById(tabId).classList.add('active');
	        }
	 		
	 			showIssuesForm('issues-form1');
	 			
	 			
		 		//신고
	 			function showReportsForm(tabId) {
	            const tabs = document.querySelectorAll('.reports-form-content');
	            tabs.forEach(tab => {
	            	tab.classList.remove('active')
	            });
	            
	            document.getElementById(tabId).classList.add('active');
	        }
	 		
	 			showReportsForm('reports-form1');


	</script>

	<!-- 사용자 검색 -->
	<c:if test="${not empty adminUserSearch.searchKeywordUser}">
		<script>
			$(document).ready(function () {
				showUserForm('user-form2');
			});
		</script>
	</c:if>

	<c:if
		test="${adminUserSearch.searchKeywordUser == null || adminUserSearch.searchKeywordUser == ''}">
		<script>
			$(document).ready(function () {
				showUserForm('user-form1');
			});
		</script>
	</c:if>


	<!-- 탭 유지 코드 -->
	<c:if test="${not empty activeTab}">
		<script>
			$(document).ready(function () {
				const activeTab = '${activeTab}';
	
				// 탭 UI 갱신
				$('ul.tabs li').removeClass('current');
				$('.tab-content').removeClass('current');
				$(`ul.tabs li[data-tab="${activeTab}"]`).addClass('current');
				$(`#${activeTab}`).addClass('current');
			});
		</script>
	</c:if>


</body>
</html>