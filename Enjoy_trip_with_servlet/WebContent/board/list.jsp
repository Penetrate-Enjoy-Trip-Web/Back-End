<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/header.css">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/list.css">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/footer.css">
    <title>Document</title>
</head>
<body>

	<%@ include file="../include/header.jsp" %>
    
    <main>
	    <div id="board-list">
	    <div id="list-title">글 목록</div>
	    	<table>
	    	<tr>
	    		<th class="board-no">글 번호</th>
	    		<th class="board-title">제목</th>
	    		<th class="board-writer">작성자</th>
	    		<th class="board-createDate">작성일</th>
	    		<th class="board-viewCount">조회수</th>
	    	</tr>
	    	<c:forEach var="data" items="${boards}">
		    	<tr>
		    		<td class="board-no">${data.no}</td>
		    		<td class="board-title"><a href="${root}/board?action=detail&no=${data.no}" class="board-link">${data.title}</a></td>
		    		<td class="board-writer">${data.writer}</td>
		    		<td class="board-createDate">${data.createDate}</td>
		    		<td class="board-viewCount">${data.viewCount}</td>
		    	</tr>
	    	</c:forEach>
	    	</table>
	    	<div id="btn-div">
	    	<c:if test="${not empty user}">
	    	<a href="${root}/board?action=writeForm"><button id="write-btn">글 작성</button></a>
	    	</c:if>
	    	</div>
	    </div>
    </main>
    
    <%@ include file="../include/footer.jsp" %>
        
</body>
</html>
    