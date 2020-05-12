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
<title>notice.jsp</title>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#editBtn").click(function() {
		$("#noticeinfo").attr("action", "${root}/MvNoticeEdit").submit();
	});
	
	$("#deleteBtn").click(function() {
		$("#noticeinfo").attr("action", "${root}/deleteNotice").submit();
	});
});

</script>

</head>

<body>

<div id="head" class="jumbotron text-center">
	<ul class="nav justify-content-end">
	<c:if test="${userinfo eq null}">
	    <li class="nav-item">
	      <a class="nav-link" href="${root}/MvJoin">Sign Up</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="${root}/MvLogin">Login</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="${root}/MvNotice">공지사항</a>
	    </li>
	 </c:if>
	 <c:if test="${userinfo ne null}">
	    <li class="nav-item">
	      <a class="nav-link" href="${root}/MvMypage">MyPage</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="${root}/logout">Logout</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link" href="${root}/MvNotice">공지사항</a>
	    </li>
	 </c:if>
	  </ul>

<div id="home">
  <h1><a href = "${root}/main.do">HAPPY HOUSE</a></h1>
  <p><a href = "${root}/main.do">행복한 우리 집</a></p> 
</div>
</div>

<div class="container">
	<br><h2>공지 사항</h2><br>
	<form id="noticeinfo" method="post" action="">
	<input type="hidden" name="no" id="no" value="${notice.no}">
			<div class="form-group" align="left">
				<label for="">작성자</label>
				<input type="text" class="form-control" readonly id="author" name="author" value="${notice.author}">
			</div>
			<div class="form-group" align="left">
				<label for="">제목</label>
				<input type="text" class="form-control" readonly id="title" name="title" value="${notice.title}">
			</div>
			<div class="form-group" align="left">
				<label for="">작성 날짜</label>
				<input type="text" class="form-control" readonly id="writedate" name="writedate" value="${notice.writedate}">
			</div>
			<div class="form-group" align="left">
				<label for="content">내용</label>
				<textarea class="form-control" readonly rows="10" id="content" name="content">${notice.content}</textarea>
			</div>
			<c:if test="${userinfo.userid eq notice.author}">
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="editBtn">수정</button>
				<button type="button" class="btn btn-primary" id="deleteBtn">삭제</button>
			</div>
			</c:if>
	</form>
</div>

</body>
</html>