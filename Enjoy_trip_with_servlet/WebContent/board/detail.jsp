<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/Enjoy_trip_with_servlet/css/board.css" />
    <title>Document</title>
</head>
<body>

	<%@ include file="../include/header.jsp" %>
	
	
    <div id = "contenBox">
    <br>
    <br>
    	<table>
    		<tr>
    		<th colspan="5"><h1>${board.title}</h1></th>
    		</tr>
    		<tr>
    			<th>작성자 : ${board.writer}</th>
    			<th></th>
    			<th></th>
    			<th>게시일 : ${board.createDate}</th>
    			<th>조회수 : ${board.viewCount}</th>
    		</tr>
    		<tr>
    		<td><br></td>
    		</tr>
    		<tr rowspan="5">
    			<td colspan="5">${board.content}</td>
    		</tr>
    	</table>
    	<br>
    	<br>
    	<br>
    </div>
    <a href="${root}/board?action=list"><button>목록</button></a>
    <a href="${root}/board?action=modifyForm&no=${board.no}"><button>수정</button></a>
    <a href="${root}/board?action=delete&no=${board.no}"><button>삭제</button></a>

    
    <%@ include file="../include/footer.jsp" %>
        
</body>
</html>
    