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
<title>mypage.jsp</title>

<script type="text/javascript">

$(document).ready(function(){
	
	$("#editBtn").click(function() {
		
		if($("#username").val() == "") {
			alert("이름 입력!!!");
			return;
		} else if($("#userpwd").val() == "") {
			alert("비밀번호 입력!!!");
			return;
		} else if($("#userpwd").val() != $("#pwdcheck").val()) {
			alert("비밀번호 확인!!!");
			return;
		} else{
			$("#mypage").attr("action", "${root}/edituserinfo").submit();
		}
	});
	
	$("#deleteBtn").click(function() {
		$("#mypage").attr("action", "${root}/deleteuserinfo").submit();
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
	<br><h2>회원 정보</h2><br>
	<form id="mypage" method="post" action="">
			<div class="form-group" align="left">
				<label for="">이름</label>
				<input type="text" class="form-control" id="username" name="username" placeholder="${userinfo.username}">
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" readonly value="${userinfo.userid}">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="userpwd" name="userpwd" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호재입력</label>
				<input type="password" class="form-control" id="pwdcheck" name="pwdcheck" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">이메일</label><br>
				<input type="text" class="form-control" id="email" name="email" placeholder="${userinfo.email}">
			</div>
			<div class="form-group" align="left">
				<label for="tel">전화번호</label><br>
				<input type="text" class="form-control" id="tel" name="tel" placeholder="${userinfo.tel}">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="editBtn">수정</button>
				<button type="button" class="btn btn-primary" id="deleteBtn">삭제</button>
				<button type="reset" class="btn btn-warning">초기화</button>
			</div>
	</form>
</div>

</body>
</html>