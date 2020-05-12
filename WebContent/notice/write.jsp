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
<title>write.jsp</title>

<script>

$(document).ready(function(){
	$("#registerBtn").click(function() {
		if($("#title").val() == "") {
			alert("제목 입력!!!");
			return;
		} else if($("#content").val() == "") {
			alert("내용 입력!!!");
			return;
		} else{
			$("#noticeinfo").attr("action", "${root}/write").submit();
		}
	});
	
});
</script>

</head>
<body>
<%@ include file="/header.jsp" %>

<div class="container">
	<br><h2>공지사항 등록</h2><br>
	<form id="noticeinfo" method="post" action="">
	<input type="hidden" name="author" id="author" value="${userinfo.userid}">
			<div class="form-group" align="left">
				<label for="">제목</label>
				<input type="text" class="form-control" id="title" name="title" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="content">내용</label>
				<textarea class="form-control" rows="15" id="content" name="content"></textarea>
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="registerBtn">등록</button>
				<button type="reset" class="btn btn-warning">초기화</button>
			</div>
	</form>
</div>
</body>
</html>