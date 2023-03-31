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
<link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/footer.css">
<title>Document</title>
<link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/write.css" />
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<main>
	<div class="container">
		<c:if test="${user.id ne board.writer}">
		<form method="post" action="${root}/board?action=write">

			<h1>글 작성</h1>

			<c:if test="${user.id ne board.writer}">
				<label for="title">제목</label> 
				<input type="text" id="title" name="title" placeholder="제목을 입력해주세요" required />
				
				<label for="writer">작성자</label> 
				<input type="text" disabled="disabled" id="writer" name="writer" value="${user.id}" required> 
				<input type="hidden" id="writer" name="writer" value="${user.id}" required> 
				
				<label for="content">내용</label>
				<textarea id="content" name="content" rows="10"	placeholder="내용을 입력해주세요" required></textarea>
				
				<div class="buttons">
					<button type="submit">작성</button>
					<button type="reset">취소</button>
				</div>
			</c:if>
		</form>
		</c:if>
		
		<c:if test="${user.id eq board.writer}">
		<form method="post" action="${root}/board?action=modify">
				
				<h1>글 수정</h1>
				
				<label for="title">제목</label> 
				<input type="text" id="title" name="title" value="${board.title}" required>
				<input type="hidden" id="no" name="no" value="${board.no}" required> 
				<label for="writer">작성자</label> 
				<input type="text" disabled="disabled" id="writer"name="writer" value="${board.writer}" required> 
				<input type="hidden" id="writer" name="writer" value="${user.id}" required> 
				<label for="content">내용</label>
				<textarea id="content" name="content" rows="10" value="${board.content}" required></textarea>

			<div class="buttons">
				<button type="submit">작성</button>
				<button type="reset">취소</button>
			</div>
		</form>
		</c:if>
		
		<a href="${root}/board?action=list" class="bt">목록</a>
		<a href="${root}/board?action=delete" class="bt">삭제</a>
	</div>
	</main>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
