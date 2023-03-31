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
</head>
<body>

    <%@ include file="../include/header.jsp" %>
    
    <!-- main -->
    <main>
        <section>
            <!-- 메인 이미지 + 관관지역 검색 페이지 이동 -->
            <article id="main-background-first">
                <div class="background-image">
                    <div class="dark-overlay"></div>
                    <a href="${root}/attraction?action=trip" class="background-image-button">여행을 떠나볼까요?</a>
                </div>
            </article>
            <!-- 관광지 사진 -->
            <article id="main-background-second">
	            <div class="row">
		            <table>
		                <thead>
		                <tr>
		                    <th>대표이미지</th>
		                    <th>관광지명</th>
		                    <th>주소</th>
		                    <th>설명</th>
		                </tr>
		                </thead>
		                <tbody id="trip-list">
		                </tbody>
		            </table>
	            </div>
            </article>
            <!-- 공지사항 -->
            <!-- <article id="main-background-third"></article> -->
            <!-- 공유게시판 -->
            <!-- <article id="main-background-fourth"></article> -->
        </section>
    </main>
    
	<%@ include file="../include/footer.jsp" %>

    <script src="/Enjoy_trip_with_servlet/js/main.js"></script>
</body>
</html>