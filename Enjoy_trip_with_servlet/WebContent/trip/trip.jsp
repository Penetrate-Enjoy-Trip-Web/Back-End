<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/header.css">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/main.css">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/footer.css">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/trip.css">
</head>
<body>

	<%@ include file="../include/header.jsp" %>
    
    <main>
        <!-- 중앙 left content end -->
        <!-- 중앙 center content end -->
        <div class="col-md-9">
            <div class="alert alert-primary mt-3 text-center fw-bold" role="alert">
            전국 관광지 정보
            </div>
            <!-- 관광지 검색 start -->
            <form class="d-flex my-3" onsubmit="return false;" role="search">
            <input type="hidden" name="action" value="search">
            <select id="search-area" name="sido_code" class="form-select me-2">
                <option value="0" selected>검색 할 지역 선택</option>
                <c:forEach var="sido" items="${sidoList}">
                <option value="${sido.sidoCode}">${sido.sidoName}</option>
                </c:forEach>
                
            </select>
            <select id="search-content-id" name="content_type_id" class="form-select me-2">
                <option value="0" selected>관광지 유형</option>
                <option value="12">관광지</option>
                <option value="14">문화시설</option>
                <option value="15">축제공연행사</option>
                <option value="25">여행코스</option>
                <option value="28">레포츠</option>
                <option value="32">숙박</option>
                <option value="38">쇼핑</option>
                <option value="39">음식점</option>
            </select>
            <input
                id="search-keyword"
                class="form-control me-2"
                type="search"
                placeholder="검색어"
                aria-label="검색어"
            />
            <button id="btn-search" class="btn btn-outline-success" type="button"  onclick="searchAttraction()">검색</button>
            </form>

            <!-- kakao map start -->
            <!-- <div id="map" class="mt-3" style="width: 100%; height: 400px"></div> -->
            
            <!-- 지도를 표시할 div 입니다 -->
            <div id="trip-main-container">
                <div id="trip-main-rvWrapper">
                    <div id="trip-main-roadview"></div> <!-- 로드뷰를 표시할 div 입니다 -->
                    <div id="trip-main-close" title="로드뷰닫기" onclick="closeRoadview()"><span class="img"></span></div>
                </div>
                <div id="trip-main-mapWrapper">
                    <div id="trip-main-map"></div> <!-- 지도를 표시할 div 입니다 -->
                    <div id="trip-main-roadviewControl" onclick="setRoadviewRoad()"></div>
                </div>
            </div>
            <!-- kakao map end -->

            <div class="row">
            <table class="table table-striped" style="display: none">
                <thead>
                <tr>
                    <th>대표이미지</th>
                    <th>관광지명</th>
                    <th>주소</th>
                    <th>위도</th>
                    <th>경도</th>
                </tr>
                </thead>
                <tbody id="trip-list"></tbody>
            </table>
            </div>
            <!-- 관광지 검색 end -->
        </div>
        <!-- 중앙 content end -->
    </main>
    
    <%@ include file="../include/footer.jsp" %>
        
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8c9a98c64f1f3ac2b761ffbe0e2e30e3"></script>
    <script src="/Enjoy_trip_with_servlet/js/trip.js"></script>
</body>
</html>
    