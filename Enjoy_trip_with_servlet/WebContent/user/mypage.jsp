<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/header.css" />
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/main.css" />
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/footer.css" />
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/modal.css" />
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
            <a href="#" class="background-image-button">여행을 떠나볼까요?</a>
          </div>
        </article>
        <!-- 관광지 사진 -->
        <article id="main-background-second"></article>
        <!-- 공지사항 -->
        <article id="main-background-third"></article>
        <!-- 공유게시판 -->
        <article id="main-background-fourth"></article>
      </section>
    </main>

    <!-- modal -->
    <div id="modal" class="modal">
      <div class="modal-content">
        <a href="${root}/attraction?action=main"><span class="close">&times;</span></a>
        <br>
        <h3>${user.id}님의 정보</h3>
        <form method="post" action="${root}/user?action=register">
          <label for="name">이름</label>
          <div>${user.name}</div><br>
          <label for="name">아이디</label>
          <div>${user.id}</div><br>
          <label for="email">이메일:</label>
          <div>${user.email}</div><br>
          <label for="password">비밀번호:</label>
          <div>${user.pw}</div><br>
        </form>
         <a href="${root}/user?action=deluser&id=${user.id}"><input type="submit" value="회원탈퇴" /></a>
         <a href="${root}/user?action=modifyForm&id=${user.id}"><input type="submit" value="정보수정" /></a>
        </div>
    </div>

    <script type="text/javascript" src="/Enjoy_trip_with_servlet/js/modal.js"></script>
    
    <%@ include file="../include/footer.jsp" %>
    
    <!-- loginCheck -->
    <script src="/Enjoy_trip_with_servlet/js/loginCheck.js"></script>
  </body>
</html>
