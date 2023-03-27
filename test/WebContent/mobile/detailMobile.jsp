<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>

	<%-- 페이지만의 내용 --%>
	<div class="container p-4">
	
	  <h2>핸드폰 상세 정보</h2>
  	  <a class="btn btn-danger" href="${root}/mobile?action=delete">삭제</a>
	  <table class="table table-striped">
	      <tr>
	        <td>${getParameter("code")}</td><td></td>
	      </tr>
	      <tr>
	        <td>${getParameter("model")}</td><td></td>
	      </tr>
	      <tr>
	        <td>${getParameter("price")}</td><td></td>
	      </tr>
	      <tr>
	        <td>${getParameter("company")}</td><td></td>
	      </tr>
	  </table>
	
	</div>
<%@ include file="/include/footer.jsp" %>