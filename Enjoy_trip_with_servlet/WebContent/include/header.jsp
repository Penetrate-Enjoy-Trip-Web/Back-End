<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!-- header -->
<header>
    <!-- title -->
    <div id="header-title">
        <a href="${root}/main/main.jsp"><span>Enjoy Trip</span></a>
    </div>
    <!-- header-right -->
    <div id="header-right">
        <!-- menu -->
        <div id="header-right-menu">
            <!-- 공지사항 
            <div><a href="">공지사항</a></div>
            -->
            <!-- 공유게시판 -->
            <div><a href="${root}/board?action=list">공유게시판</a></div>
            <!-- 관광지역 -->
            <div><a href="${root}/attraction?action=trip">관광지역</a></div>
        </div>
        <!-- login -->
        <div id="header-right-login">

            <c:if test="${empty user}">
            <!-- 로그인 -->
            <div><a href="${root}/user?action=loginForm" id="loginCheck">로그인</a></div>
            <!-- 회원가입 -->
            <div><a href="${root}/user?action=registerForm" id="registerCheck">회원가입</a></div>
            </c:if>

            <c:if test="${not empty user}">
            <!-- 로그아웃 -->
            <div><a href="${root}/user?action=logout" onclick="logout()" id="logoutCheck">로그아웃</a></div>
            <!-- 내 정보 조회 -->
            <div><a href="${root}/user?action=mypage&userId=${user.id}" id="mypageCheck">내 정보 조회</a></div>
            </c:if>

        </div>
    </div>
</header>