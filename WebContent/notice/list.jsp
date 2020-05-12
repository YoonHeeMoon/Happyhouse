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
<title>list.jsp</title>

<style>
#registerBtn a{
	color : white;
	text-decoration: none;
}
</style>

<script>
function notice(no){
	document.location.href = "${root}/notice?no="+no;
}
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
	<br>
	<c:if test="${userinfo ne null}">
  	<div class="form-group" align="center">
		<button type="button" class="btn btn-primary" id="registerBtn"><a href="${root}/MvWrite">등록</a></button>
	</div>
  </c:if>
	<br><h2>공지사항 목록</h2><br>
	<table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>작성날짜</th>   
      </tr>
    </thead>
    <c:if test="${noticeList.size() != 0}">
    <c:forEach var="notice" items="${noticeList}">
    <tbody>
	      <tr id="no" onclick="javascript:notice(${notice.no});" style="cursor:hand">
	        <td>${notice.no}</td>
	        <td>${notice.author}</td>
	        <td>${notice.title}</td>
	        <td>${notice.writedate}</td>
	      </tr>
	 </tbody>
	 </c:forEach>
	</c:if>
  </table>
</div>
</body>
</html>