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