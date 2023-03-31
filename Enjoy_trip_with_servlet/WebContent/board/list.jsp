<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/board.css" />
    <title>Document</title>
</head>
<body>

	<%@ include file="../include/header.jsp" %>
    
    <main>
    <h2>글 목록</h2>
    	<table>
    	<tr>
    		<th>글 번호</th>
    		<th>제목</th>
    		<th>작성자</th>
    		<th>작성날짜</th>
    		<th>조회수</th>
    	</tr>
    	<c:forEach var="data" items="${boards}">
    		<td>${data.no}</td>
    		<td><a href="${root}/board?action=detail&no=${data.no}">${data.title}</a></td>
    		<td>${data.writer}</td>
    		<td>${data.createDate}</td>
    		<td>${data.viewCount}</td>
    	</c:forEach>
    	</table>
    	<a href="${root}/board?action=writeForm"><button></button></a>
    </main>
    
    <%@ include file="../include/footer.jsp" %>
        
</body>
</html>
    