<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${root}/css/header.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>editnotice.jsp</title>

<script>
$(document).ready(function(){
	$("#editBtn").click(function() {
		if($("#title").val() == "") {
			alert("제목 입력!!!");
			return;
		} else if($("#content").val() == "") {
			alert("내용 입력!!!");
			return;
		} else{
			$("#noticeinfo").attr("action", "${root}/editNotice").submit();
		}
	});
	
});
</script>
</head>

<body>
<%@ include file="/header.jsp" %>
<div class="container">
	<br><h2>공지 수정</h2><br>
	<form id="noticeinfo" method="post" action="">
	<input type="hidden" name="no" id="no" value="${notice.no}">
			<div class="form-group" align="left">
				<label for="">작성자</label>
				<input type="text" class="form-control" readonly id="author" name="author" value="${notice.author}">
			</div>
			<div class="form-group" align="left">
				<label for="">제목</label>
				<input type="text" class="form-control" id="title" name="title" placeholder="${notice.title}">
			</div>
			<div class="form-group" align="left">
				<label for="">작성 날짜</label>
				<input type="text" class="form-control" readonly id="writedate" name="writedate" value="${notice.writedate}">
			</div>
			<div class="form-group" align="left">
				<label for="content">내용</label>
				<textarea class="form-control" rows="10" id="content" name="content">${notice.content}</textarea>
			</div>
			<c:if test="${userinfo.userid eq notice.author}">
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="editBtn">수정</button>
			</div>
			</c:if>
	</form>
</div>

</body>
</html>