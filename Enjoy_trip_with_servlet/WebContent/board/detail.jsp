<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/header.css">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/detail.css">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/footer.css">
    <title>Document</title>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	<main>
	<div id="contentBox">
		<h1>${board.title}</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${board.writer}</td>
				<th>게시일</th>
				<td>${board.createDate}</td>
				<th>조회수</th>
				<td>${board.viewCount}</td>
			</tr>
			<tr>
				<td colspan="6" class="content">${board.content}</td>
			</tr>
		</table>
		<a href="${root}/board?action=list"><button>목록으로</button></a>
		<c:if test="${user.id == board.writer}">
		<a href="${root}/board?action=modifyForm&no=${board.no}"><button>수정</button></a>
		<a href="${root}/board?action=delete&no=${board.no}"><button>삭제</button></a>
		</c:if>
	</div>
	</main>
	    <%@ include file="../include/footer.jsp" %>
</body>
</html>
    