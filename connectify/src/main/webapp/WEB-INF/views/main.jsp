<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function(){
        $("#ldongCodeSyncBtn").click(function(){
            $.ajax({
                type: "POST",
                url: "/api/ldong-codes/sync",
                success: function(response){
                    alert("성공: " + response);
                },
                error: function(error){
                    alert("오류: " + error.responseText);
                }
            });
        });
        
        $("#lclsSystemCodeSyncBtn").click(function(){
        	$.ajax({
        		type: "POST",
        		url: "/api/lcls-system-codes/sync",
        		success: function(response){
        			alert("성공: "+response);
        		},
        		error: function(error){
        			alert("오류: "+error.responseText);
        		}
        	});
        });
        
        $("#tourBtn").click(function(){
        	$.ajax({
        		type: "POST",
        		url: "/api/area-list/sync",
        		success: function(response){
        			alert("성공: "+response);
        		},
        		error: function(error){
        			alert("오류: "+error.responseText);
        		}
        	});
        });
    });
</script>
</head>
<body>
	<h1>메인페이지 테스트</h1>
	<button id="ldongCodeSyncBtn">법정동 코드 데이터 가져와서 DB 저장하기</button>
	<button id="lclsSystemCodeSyncBtn">분류체계 코드 데이터 가져와서 DB 저장하기</button>
	<button id="tourBtn">여행지 정보 모두 가져오기</button>
</body>
</html>