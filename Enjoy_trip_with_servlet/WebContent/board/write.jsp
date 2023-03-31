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
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/list.css" />
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/footer.css">
    <title>Document</title>
	<link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/write.css" />
</head>
<body>
	<%@ include file="../include/header.jsp"%>
 <main>
        <div class="container">
            <form method="post" action="${root}/board?action=write">
                <h1>글쓰기</h1>
                <br>
                <label for="title">제목</label>
                <input type="text" id="title" name="title" required>

                <label for="writer">작성자</label>
                <input type="text" id="writer" name="writer" value = "${user.id}" required>

                <label for="content">내용</label>
                <textarea id="content" name="content" rows="10" required></textarea>

                <div class="buttons">
                    <button type="submit">작성</button>
                    <button type="reset">취소</button>

                </div>
            </form>
                    <a href="${root}/board?action=list" class="bt">목록</a>
                    <a href="${root}/board?action=modify" class="bt">수정</a>
                    <a href="${root}/board?action=delete" class="bt">삭제</a>
        </div>
    </main>
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
