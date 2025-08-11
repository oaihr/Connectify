<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<style>
body {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background: #f0e9fa; /* 연한 하늘색 배경 */
	color: #333;
}

.container {
	display: flex;
	min-height: 100vh;
}

.h1 {
	text-align: center;
	margin-bottom: 30px;
	color: #4b365f;
	letter-spacing: 2px;
	font-weight: 700;
}

.sidebar {
	width: 200px;
	background-color: #d3d3ff; /* 연한 블루 */
	padding: 30px 20px;
	box-shadow: 2px 0 8px rgba(0, 0, 0, 0.05);
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

.tabs {
	display: flex;
	margin-bottom: 20px;
	border-bottom: 1px solid #7d6eaa;
}

.tab {
	padding: 12px 25px;
	cursor: pointer;
	border: none;
	background-color: transparent;
	color: #7d6eaa;
	font-weight: 600;
	transition: background-color 0.5s ease, color 0.3s ease;
	border-radius: 8px 8px 0 0;
	margin-right: 8px;
}

.tab:hover {
	background-color: #d0c1ff;
}

.tab.active {
	background-color: #7d6eaa;
	color: white;
}

.tab-content {
	background-color: #f9fbff;
	padding: 25px;
	border-radius: 0 10px 10px 10px;
	box-shadow: inset 0 0 8px rgba(3, 102, 214, 0.1);
	min-height: 250px;
}

.hidden {
	display: none;
}

button {
	background-color: #7d6eaa;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 25px;
	font-weight: 600;
	cursor: pointer;
	transition: background-color 0.3s ease;
	margin-bottom: 20px;
}

button:hover {
	background-color: #d0c1ff;
}

.qna-box {
	border: 2px solid #c6d9f1;
	padding: 15px 20px;
	margin-bottom: 15px;
	border-radius: 12px;
	background: #ffffff;
	box-shadow: 0 2px 6px rgba(3, 102, 214, 0.1);
	transition: box-shadow 0.3s ease;
}

.qna-box:hover {
	box-shadow: 0 6px 16px rgba(3, 102, 214, 0.2);
}

.qna-box p {
	margin: 6px 0;
}

.qna-box strong {
	color: #014a9c;
}
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
</style>

</head>
<body>

	<div class="container">

		<div class="sidebar">
			<ul class="sidebar-menu">
				<li>
					<img src="/image/connectify_logo.png" style="width:100px; height:auto;">
				</li>
				<li>
					<h1 class="h1">고객센터</h1>
				</li>
				<li><a href="qna">문의하기</a></li>
				<li><a href="faq" class="menu-btn" data-target="faqSection">자주
						묻는 질문</a></li>
			</ul>
		</div>

		<div class="mainboard">

			<h2>QnA - 질문 게시판</h2>
			<div class="tabs">
				<div id="tabOneToOne" class="tab active"
					onclick="showTab('oneToOneTab')">1:1 질문</div>
				<div id="tabPublicQnA" class="tab" onclick="showTab('publicQnATab')">공개
					질문</div>
			</div>

			<!--1:1 질문 목록 -->
			<div id="oneToOneTab" class="tab-content">
				<h3>1:1 문의</h3>
				<button type="button" onclick="private_qna_popup()">문의 남기기</button>
				<c:choose>
					<c:when test="${not empty privateList}">
						<c:forEach var="qna" items="${privateList}">
							<div
								style="border: 1px solid #ddd; padding: 10px; margin-bottom: 10px;">
								<p>
									<strong>제목:</strong> ${qna.title}
								</p>
								<p>
									<strong>내용:</strong> ${qna.question}
								</p>
								<p>
									<strong>답변:</strong>
									<c:choose>
										<c:when test="${not empty qna.answer}">
											${qna.answer}
										</c:when>
										<c:otherwise>
											답변 대기 중입니다.
										</c:otherwise>
									</c:choose>
								</p>
								<button type="button" onclick="deleteQna(${qna.id})">삭제</button>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p>아직 등록된 1:1 질문이 없습니다.</p>
					</c:otherwise>
				</c:choose>

			</div>

			<!-- 공개 질문/답변 -->
			<div id="publicQnATab" class="tab-content hidden">
				<h3>게시판 질문 목록</h3>
				<button type="button" onclick="public_qna_popup()">게시판 글
					남기기</button>
				<c:choose>
					<c:when test="${not empty qnaList}">
						<c:forEach var="qna" items="${qnaList}">
							<div
								style="border: 1px solid #ddd; padding: 10px; margin-bottom: 10px;">
								<p>
									<strong>제목:</strong> ${qna.title}
								</p>
								<p>
									<strong>내용:</strong> ${qna.question}
								</p>
								<p>
									<strong>답변:</strong>
									<c:choose>
										<c:when test="${not empty qna.answer}">
											${qna.answer}
										</c:when>
										<c:otherwise>
											답변 대기 중입니다.
										</c:otherwise>
									</c:choose>
								</p>
								<button type="button" onclick="deleteQna(${qna.id})">삭제</button>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<p>아직 등록된 공개 질문이 없습니다.</p>
					</c:otherwise>
				</c:choose>

			</div>
			<br>
<footer class="footer">
    <div class="footer-container">
        <div class="footer-info">
            <div class="info-group">
                <span>(주)커넥티파이</span>
                <span>대표이사 우정영</span>
                <span>사업자등록번호 202-81-45295</span>
                <span>통신판매업신고번호 중구 제03500호</span>
                <span>호스팅 업체 (주)카오스네트워크</span>
            </div>
            <div class="info-group">
                <span>관광사업자 등록번호 2025-08</span>
                <span>영업보증보험 15억 1천만원</span>
                <span>기획여행영업보증 7억원</span>
            </div>
            <div class="info-group">
                <span>상담문의 1566-9564</span>
                <span>팩스 041-561-1122</span>
                <span>충남 천안시 동남구 대흥로 215 7층</span>
            </div>
        </div>
        <div class="footer-notes">
            <ul>
                <li>※ 부득이한 사정에 의해 확정된 여행일정이 변경되는 경우 여행자의 사전 동의를 받습니다.</li>
                <li>※ (주)커넥티파이는 항공사가 제공하는 항공권 및 여행사가 제공하는 일부 여행상품에 대하여 통신판매중개자의 지위를 가지며, 해당 상품, 상거래 정보에 대한 의무와 거래에 관한 책임은 판매자에게 있습니다.</li>
                <li><b>※ 커넥티파이의 법인계좌가 아닌 다른 계좌로 입금하여 발생한 피해에 관하여, 당사는 책임지지 않습니다. 타 계좌의 입금을 유도하는 행위가 발생하는 경우 반드시 커넥티파이 고객센터로 문의하거나 신고하여 주시기 바랍니다.</b></li>
            </ul>
        </div>
        <div class="footer-copyright">
            COPYRIGHT CONNECTIFY, ALL RIGHTS RESERVED.
        </div>
    </div>
    <div class="social-icons">
        <a href="#" class="icon"><img src="image/SNS_kakaotalk.svg" alt="카카오톡"></a>
        <a href="#" class="icon"><img src="image/SNS_insta.svg" alt="인스타그램"></a>
        <a href="#" class="icon"><img src="image/SNS_naverblog.svg" alt="네이버블로그"></a>
        <a href="#" class="icon"><img src="image/SNS_youtube.svg" alt="유튜브"></a>
    </div>
</footer>
		</div>

	</div>
	<script>
	//탭을 두개로 나뉘어 보이게함
	function showTab(tabName) {
		document.getElementById("oneToOneTab").classList.add("hidden");
		document.getElementById("publicQnATab").classList.add("hidden");
		document.getElementById(tabName).classList.remove("hidden");

		document.getElementById("tabOneToOne").classList.remove("active");
		document.getElementById("tabPublicQnA").classList.remove("active");
		if (tabName === "oneToOneTab") {
			document.getElementById("tabOneToOne").classList.add("active");
		} else {
			document.getElementById("tabPublicQnA").classList.add("active");
		}
	}
	//게시판 팝업창
	function public_qna_popup() {
		window.open("/qna/public_qna_popup", "QnAPopup",
				"width=700,height=600,resizable=no");
	}
	//1:1문의 팝업창
	function private_qna_popup() {
		window.open("/qna/private_qna_popup", "QnAPopup",
				"width=700,height=600,resizable=no");
	}
	//게시글 삭제
	function deleteQna(qnaId) {
		 if (confirm("정말 이 질문을 삭제하시겠습니까?")) {
	            // '확인'을 누르면 서버에 삭제 요청을 보냅니다.
	            // URL에 삭제할 게시물의 ID를 쿼리 파라미터로 포함시킵니다.
	            window.location.href = "/qna/delete?qnaId=" + qnaId;
	        }
	}
</script>
</body>
</html>