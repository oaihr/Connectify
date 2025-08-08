<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여행 페이지</h1>
	
	<div class="travel-list">
		<c:forEach var="dest" items="${destinations}">
			<div>
				<img src="${dest.firstimage}">
				<h3>${dest.title}</h3>
				<p>${dest.addr1} ${dest.addr2} ${dest.zipcode}</p>
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
				href="/travels?page=${currentPage - 1}&category=${currentCategory}">이전</a>
		</c:if>

		<%-- 페이지 번호 링크 --%>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:choose>
				<c:when test="${i == currentPage}">
					<span><b>${i}</b></span>
				</c:when>
				<c:otherwise>
					<a href="/travels?page=${i}&category=${currentCategory}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<%-- 다음 페이지 버튼 --%>
		<c:if test="${currentPage < totalPages}">
			<a href="/travels?page=${currentPage + 1}&category=${currentCategory}">다음</a>
		</c:if>
	</div>

	<!-- 	<div class="pagination"> -->
<%-- 		<c:forEach var="i" begin="1" end="${totalPages}"> --%>
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${i == currentPage}"> --%>
<%-- 					<span><b>${i}</b></span> --%>
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
<%-- 					<a href="/travels?page=${i}&category=${currentCategory}">${i}</a> --%>
<%-- 				</c:otherwise> --%>
<%-- 			</c:choose> --%>
<%-- 		</c:forEach>		 --%>
<!-- 	</div> -->
	
<%-- 	<c:forEach var="dest" items="${destinations}"> --%>
<!-- 			<p> -->
<%-- 				<a href="/travel/${dest.contentid}"> --%>
<%-- 					<img src="${dest.firstimage}"> --%>
<!-- 				</a> -->
<%-- 				${dest.title}<br> --%>
<%-- 				주소: ${dest.addr1} ${dest.addr2}<br> --%>
<%-- 				우편번호: ${dest.zipcode} --%>
					
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${room.viewType == 'OCN' }">오션뷰</c:when> --%>
<%-- 						<c:when test="${room.viewType == 'CTY' }">시티뷰</c:when> --%>
<%-- 						<c:when test="${room.viewType == 'MOT' }">마운틴뷰</c:when> --%>
<%-- 					</c:choose> --%>
				
<%-- 			<button type="button" onClick="location.href='/admin/removeRoom?roomId=${room.roomId}' ">삭제하기</button> --%>
<%-- 				<button type="button" onClick="removeRoom(${room.roomId})">삭제하기</button> --%>
<%-- 				<button type="button" onClick="modifyRoom(${room.roomId})">수정하기</button> --%>
<!-- 			</p>		 -->
<%-- 	</c:forEach> --%>
</body>
</html>