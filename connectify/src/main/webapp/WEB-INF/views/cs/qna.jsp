<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 - QnA</title>
<style>
body {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}

.container {
	display: flex;
}

.sidebar {
	width: 250px;
	background-color: #f2f2f2;
	height: 100vh;
	padding: 20px;
}

.content {
	flex: 1;
	padding: 20px;
}

.tabs {
	display: flex;
	margin-bottom: 10px;
}

.tab {
	padding: 15px 30px;
	cursor: pointer;
	border: 1px solid #ccc;
	background-color: #eee;
}

.tab.active {
	background-color: white;
	border-bottom: none;
}

.tab-content {
	border: 1px solid #ccc;
	padding: 20px;
	background-color: white;
}

.hidden {
	display: none;
}
</style>
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
				"width=500,height=400,resizable=no");
	}
	//1:1문의 팝업창
	function private_qna_popup() {
		window.open("/qna/private_qna_popup", "QnAPopup",
				"width=500,height=400,resizable=no");
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
</head>
<body>

	<div class="container">

		<div class="sidebar">
			<ul class="sidebar-menu">
				<h1 class="h1">고객센터</h1>
				<li><a href="qna">문의하기</a></li>
				<li><a href="faq" class="menu-btn" data-target="faqSection">자주
						묻는 질문</a></li>
			</ul>
		</div>

		<div class="content">

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
							<div style="border: 1px solid #ddd; padding: 10px; margin-bottom: 10px;">
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
				<h3>공개 질문 목록</h3>
				<button type="button" onclick="public_qna_popup()">게시판 글 남기기</button>
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

		</div>

	</div>

</body>
</html>
