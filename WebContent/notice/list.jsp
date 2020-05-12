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
<%@ include file="/header.jsp" %>

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