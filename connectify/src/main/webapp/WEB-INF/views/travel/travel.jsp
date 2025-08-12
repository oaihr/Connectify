<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="module"
	src="https://ajax.googleapis.com/ajax/libs/@googlemaps/extended-component-library/0.6.11/index.min.js">
    </script>
<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Noto Sans KR', sans-serif;
}

.place-picker-container {
	padding: 20px;
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

/* 바디 스타일 ===========================================================================================*/
.travel {
	padding: 0 20px;
}

.travelInfo {
	display: flex;
	margin-bottom: 20px;
}

.travelInfoTxt {
	list-style-type: none;
}

.travelInfoTxt li h2 {
	margin-bottom: 40px;
}

.travelInfoTxt li {
	margin: 40px;
}

.iconInfoBox {
	display: flex;
}

.iconInfoBox img {
	margin-right: 15px;
}
/* 지도 스타일 */
.travelMap {
	width: 100%;
	height: 70vh;
	display: flex;
}

.mapDetailInfo {
	width: 30%;
	margin-left: 20px;
}

.mapDetailInfo h3{
	padding: 10px 10px;
}
.mapDetailInfo p {
	margin-top: 15px;
	padding: 10px 10px;
}

.mapDetailInfoImgs {
	display: flex;
	width: 80%;
}

.mapDetailInfoImgs img {
	max-width: 100%;
	width: 30%;
	background-color: white;
}

.middleHr{
	margin: 20px;
	color: #ccc;
}
/*=================== slide 스타일 ===================*/
.slide-container {
	width: 90%;
	height: 450px;
	position: relative;
	margin-top: 45px;
}

.slide-container img {
	width: 100%;
	height: 700px;
	border-radius: 20px;
}

.slide {
	-webkit-animation: fade 1.2s;
	animation: fade 1.2s;
}

@
-webkit-keyframes fade {from { opacity:0.4;
	
}

to {
	opacity: 1;
}

}
@
keyframes fade {from { opacity:0.4;
	
}

to {
	opacity: 1;
}

}
.prev, .next {
	cursor: pointer;
	position: absolute;
	top: 80%;
	width: auto;
	margin-top: -22px;
	padding: 16px;
	color: white;
	font-size: 25px;
	transition: 0.6s ease;
	user-select: none;
}

.next {
	right: 0;
}

.prev:hover, .next:hover {
	background-color: rgba(0, 0, 0, 0.5);
	border-radius: 5px;
}

/*footer 스타일=========================================================================================*/
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
	<div class="mainscreen-container">
		<!-- ==================header 구간========================== -->
		<div class="header">
			<div class="main-menu-container">

				<img src="/image/connectify_logo1.png" class="logo" width="200"
					style="margin: 20px 0;" onClick="location.href='/'" />

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
		<div class="travel">
			<div class="travelInfo">
				<div class="slide-container">
						<div class="slide">
							<img
								src="/image/detailImg/1.png">
						</div>
						<div class="slide">
							<img
								src="/image/detailImg/2.png">
						</div>
						<div class="slide">
							<img
								src="/image/detailImg/3.png">
						</div>
						<div class="slide">
							<img
								src="/image/detailImg/4.png">
						</div>
						<div class="slide">
							<img
								src="/image/detailImg/5.png">
						</div>
						<div class="slide">
							<img
								src="/image/detailImg/6.png">
						</div>
						<div class="slide">
							<img
								src="/image/detailImg/7.png">
						</div>
						<a class="prev">&#10094;</a> <a class="next">&#10095;</a>
						<div class="dots">
							<span class="dot" data-val="0"></span> <span class="dot"
								data-val="1"></span> <span class="dot" data-val="2"></span> <span
								class="dot" data-val="3"></span>
						</div>
				</div>
				<ul class="travelInfoTxt">
					<li>
						<h2>${destination.title}</h2>
					</li>
					<li>
						<div class="iconInfoBox">
							<div>
								<img src="/image/infoIcons/icon_address.png">
							</div>
							<div>
								<h4>주소</h4>
								${destination.addr1}
							</div>
						</div>
					</li>
					<li>
						<div class="iconInfoBox">
							<div>
								<img src="/image/infoIcons/icon_inquiries.png">
							</div>
							<div>
								<h4>문의 및 안내</h4>
								${destination.infoCenter}
							</div>
						</div>
					</li>
					<li>
						<div class="iconInfoBox">
							<div>
								<img src="/image/infoIcons/icon_operating.png">
							</div>
							<div>
								<h4>이용시간</h4>
								<p>${destination.useTime}</p>
							</div>
						</div>
					</li>
					<li>
						<div class="iconInfoBox">
							<div>
								<img src="/image/infoIcons/icon_accom.png">
							</div>
							<div>
								<h4>수용인원</h4>
								${destination.accomCount}
							</div>
						</div>
					</li>
					<li>
						<div class="iconInfoBox">
							<div>
								<img src="/image/infoIcons/icon_holiday.png">
							</div>
							<div>
								<h4>쉬는날</h4>
								<p>${destination.restDate}</p>
							</div>
						</div>
					</li>

					<li>
						<div class="iconInfoBox">
							<div>
								<img src="/image/infoIcons/icon_parking.png">
							</div>
							<div>
								<h4>주차</h4>
								${destination.parking}
							</div>
						</div>
					</li>
					<li>
						<div class="iconInfoBox">
							<div>
								<img src="/image/infoIcons/icon_exp.png">
							</div>
							<div>
								<h4>체험 안내</h4>
								${destination.expGuide}
							</div>
						</div>
					</li>

				</ul>
			</div>
			<hr class="middleHr">
			<div class="travelMap">
				<gmpx-api-loader key="AIzaSyCZMJOBHnVifgwBxPlqA8X6EKK4I5eZcBs"
					solution-channel="GMP_GE_mapsandplacesautocomplete_v2">
				</gmpx-api-loader>
				<gmp-map center="${destination.mapy}, ${destination.mapx}" zoom="13"
					map-id="connectify_MAP">
				<div slot="control-block-start-inline-start"
					class="place-picker-container">
					<gmpx-place-picker placeholder="${destination.addr1}"></gmpx-place-picker>
				</div>
				<gmp-advanced-marker
					position="${destination.mapy}, ${destination.mapx}"></gmp-advanced-marker>
				</gmp-map>
				<div class="mapDetailInfo">
					<h3>장애정보</h3>
					<div class="mapDetailInfoImgs">
						<img src="/image/wheelchair.png"> <img
							src="/image/toilet.png"> <img src="/image/braileblock.png">
					</div>
					<hr class="hr">
					<p>${destination.publicTransport}</p>
					<hr class="hr">
					<p>휠체어 ${destination.wheelchair}</p>
					<hr class="hr">
					<p>${destination.restroom}</p>
					<hr class="hr">
					<p>${destination.braileBlock}</p>
					<hr class="hr">
					<p>${destination.room}</p>
					<hr class="hr">
				</div>
			</div>
		</div>
		<footer class="footer">
			<div class="footer-container">
				<div class="footer-info">
					<div class="info-group">
						<span>(주)커넥티파이</span> <span>대표이사 우정영</span> <span>사업자등록번호
							202-81-45295</span> <span>통신판매업신고번호 중구 제03500호</span> <span>호스팅
							업체 (주)카오스네트워크</span>
					</div>
					<div class="info-group">
						<span>관광사업자 등록번호 2025-08</span> <span>영업보증보험 15억 1천만원</span> <span>기획여행영업보증
							7억원</span>
					</div>
					<div class="info-group">
						<span>상담문의 1566-9564</span> <span>팩스 041-561-1122</span> <span>충남
							천안시 동남구 대흥로 215 7층</span>
					</div>
				</div>
				<div class="footer-notes">
					<ul>
						<li>※ 부득이한 사정에 의해 확정된 여행일정이 변경되는 경우 여행자의 사전 동의를 받습니다.</li>
						<li>※ (주)커넥티파이는 항공사가 제공하는 항공권 및 여행사가 제공하는 일부 여행상품에 대하여
							통신판매중개자의 지위를 가지며, 해당 상품, 상거래 정보에 대한 의무와 거래에 관한 책임은 판매자에게 있습니다.</li>
						<li><b>※ 커넥티파이의 법인계좌가 아닌 다른 계좌로 입금하여 발생한 피해에 관하여, 당사는
								책임지지 않습니다. 타 계좌의 입금을 유도하는 행위가 발생하는 경우 반드시 커넥티파이 고객센터로 문의하거나 신고하여
								주시기 바랍니다.</b></li>
					</ul>
				</div>
				<div class="footer-copyright">COPYRIGHT CONNECTIFY, ALL RIGHTS
					RESERVED.</div>
			</div>
			<div class="social-icons">
				<a href="#" class="icon"><img src="/image/SNS_kakaotalk.svg"
					alt="카카오톡"></a> <a href="#" class="icon"><img
					src="/image/SNS_insta.svg" alt="인스타그램"></a> <a href="#"
					class="icon"><img src="/image/SNS_naverblog.svg" alt="네이버블로그"></a>
				<a href="#" class="icon"><img src="/image/SNS_youtube.svg"
					alt="유튜브"></a>
			</div>
		</footer>
	</div>

	<script>
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
	<script>
		const destination = {
		  mapy: "<c:out value='${destination.mapy}'/>",
		  mapx: "<c:out value='${destination.mapx}'/>"
		};
      	
		console.log('mapy:', destination.mapy);
		console.log('mapx:', destination.mapx);
			
      document.addEventListener('DOMContentLoaded', async function() {
    	  
    	  await customElements.whenDefined('gmp-map');

          const map = document.querySelector('gmp-map');
          const marker = document.querySelector('gmp-advanced-marker');
          const placePicker = document.querySelector('gmpx-place-picker');
          const infowindow = new google.maps.InfoWindow();
  		
          map.innerMap.setOptions({
            mapTypeControl: false
          });
  		
          map.center = `${destination.mapy}, ${destination.mapx}`;
          marker.position = `${destination.mapy}, ${destination.mapx}`;
          
          placePicker.addEventListener('gmpx-placechange', () => {
            const place = placePicker.value;

            if (!place.location) {
              window.alert(
                "No details available for input: '" + place.name + "'"
              );
              infowindow.close();
              marker.position = `${destination.mapy}, ${destination.mapx}`;
              return;
            }

            if (place.viewport) {
              map.innerMap.fitBounds(place.viewport);
            } else {
              map.center = place.location;
              map.zoom = 17;
            }

            marker.position = place.location;
            infowindow.setContent(
              `<strong>${place.displayName}</strong><br>
               <span>${place.formattedAddress}</span>
            `);
            infowindow.open(map.innerMap, marker);
          });
          
        });
    </script>
</body>
</html>