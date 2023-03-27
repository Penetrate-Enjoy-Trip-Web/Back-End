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
	  <h2>핸드폰 목록</h2>
	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>고유번호</th>
	        <th>모델명</th>
	        <th>가격</th>
	        <th>제조사</th>
	      </tr>
	    </thead>
	    <tbody>
			<%-- 핸드폰 정보 개수만큼 반복 출력 --%>
			<c:foreach value=${list} nmae=p>
			<tr>
				<td>${p.code}</td>
				<td><a href="${root}/mobile?action=detail">${p.model}</a></td>
				<td>${p.price}</td>
				<td>${p.company}</td>
			</tr>
			</c:foreach>
	    </tbody>
	  </table>
	</div>

<%@ include file="/include/footer.jsp" %>