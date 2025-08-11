<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.mypage-container {
	width: 100%;
	heigth: 100%;
	display: flex;
	font-family: sans-serif;
}

.mypage-left {
	width: 300px;
	heigth: 100%;
	border: 2px solid #ccc;
	border-radius: 10px;
	margin: 30px;
	background-color: #fafafa;
}

.profile-container {
	text-align: center;
	margin-bottom: 20px;
}

.profile-pic {
	position: relative;
	width: 100px;
	height: 100px;
	margin: 0 auto;
}

.profile-pic img {
	width: 100%;
	height: 100%;
	border-radius: 50%;
}

.grade-circle {
	position: absolute;
	bottom: 5px;
	right: 5px;
	background-color: #ffcc00;
	color: #000;
	font-weight: bold;
	font-size: 14px;
	padding: 5px;
	border-radius: 50%;
	border: 2px solid white;
}

.edit-btn {
	margin-top: 10px;
	padding: 5px 10px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.follow-info {
	font-size: 14px;
}

.mypage-right {
	flex: 1;
	border: 2px solid #ccc;
	border-radius: 10px;
	/* padding: 20px; */
	margin: 30px;
}

.tab-menu {
	display: flex;
	gap: 10px;
	margin-bottom: 15px;
}

.tab-link {
	padding: 8px 15px;
	background-color: #eee;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.tab-link.active {
	background-color: #007bff;
	color: white;
}

.tab-content {
	display: none;
}

.tab-content.active {
	display: block;
}

.res-item, .review-item {
	display: flex;
	justify-content: space-between;
	align-items: center;
	border: 1px solid #ddd;
	padding: 10px;
	margin-bottom: 8px;
	border-radius: 5px;
}

.status {
	font-weight: bold;
}

.pre-travel {
	color: red;
}

.post-travel {
	color: orange;
}

.done-review {
	color: red;
}

.action-btn {
	padding: 5px 10px;
	border: 1px solid #333;
	background-color: white;
	cursor: pointer;
}
</style>

<body>
	<div class="header">
		<img src="/image/connectify_logo.png" class="logo" width="150" onClick="location.href='/admin/main'" >
	</div>
	
	
	<div class="mypage-container">
	
<!-- 왼쪽 -->
		<div class="mypage-left">
			<div class="profile-container">
				<div class="profile-pic">
					<img src="" alt="프로필 사진"> <span class="grade-circle">A</span>
				</div>
				<button class="edit-btn">개인정보 수정</button>
			</div>
			<div class="follow-info">
				<h3>팔로우 정보</h3>
				<p>팔로우: 10</p>
				<p>팔로워: 5</p>
			</div>
		</div>

<!-- 오른쪽 -->
		<div class="mypage-right">
			<div class="tab-menu">
				<ul class="tabs">
					<li class="tab-link current jua-regular" data-tab="tab-0"><p>예약현황</p></li>
					<li class="tab-link jua-regular" data-tab="tab-1"><p>나의 리뷰</p></li>
					<li class="tab-link jua-regular" data-tab="tab-2"><p>문의 내역</p></li>
					<li class="tab-link jua-regular" data-tab="tab-3"><p>신고내역</p></li>
				</ul>
			</div>

<!-- 예약현황 -->
			<div id="tab-0" class="tab-content current">

				<div class="menu-header">
					<p class="jua-regular">예약현황</p>
				</div>

			</div>
			
			
			
<!-- 나의 리뷰 -->
			<div id="tab-1" class="tab-content current">

				<div class="menu-header">
					<p class="jua-regular">나의 리뷰</p>
				</div>

			</div>
			
			
			
<!-- 문의 내역 -->
			<div id="tab-2" class="tab-content current">

				<div class="menu-header">
					<p class="jua-regular">문의 내역</p>
				</div>

			</div>
			
			
<!-- 신고 내역 -->
			<div id="tab-3" class="tab-content current">

				<div class="menu-header">
					<p class="jua-regular">신고 내역</p>
				</div>

			</div>


			<div class="tab-content active" id="reservations">
				<div class="res-item">
					<span class="status pre-travel">여행 전</span> <span>예약 리스트</span>
					<button class="action-btn">환불하기</button>
				</div>
				<div class="res-item">
					<span class="status post-travel">여행 후</span> <span>예약 리스트</span>
					<button class="action-btn">후기 작성하기</button>
				</div>
			</div>

			<div class="tab-content" id="reviews">
				<div class="review-item">
					<span class="status done-review">작성 완료 리뷰</span> <span>리뷰
						리스트</span>
				</div>
				<div class="review-item">
					<span>리뷰 리스트</span>
				</div>
			</div>

			<div class="tab-content" id="inquiries">
				<p>문의 내역 리스트</p>
			</div>

			<div class="tab-content" id="reports">
				<p>신고 내역 리스트</p>
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
	 		
			//여행지 tab
	 		function showTravelForm(tabId) {
	            const tabs = document.querySelectorAll('.travel-form-content');
	            tabs.forEach(tab => {
	            	tab.classList.remove('active')
	            });
	            
	            document.getElementById(tabId).classList.add('active');
	        }
	 		showTravelForm('travel-form1');

</script>


</body>
</html>