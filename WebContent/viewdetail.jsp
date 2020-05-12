<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>viewdetail.jsp</title>
</head>
<body>

<%@ include file="/header.jsp" %>
<div class="container">
<br><h2>상세 조회</h2><br>
<c:if test="${detail ne null}">
 <table class="table">
 		<tr>
 			<th>번호</th>
 			<td>${detail.no}</td>
 		</tr>
 		<tr>
 			<th>법정동</th>
 			<td>${detail.dong}</td>
 		</tr>
 		<tr>
 			<th>아파트명</th>
 			<td>${detail.aptName}</td>
 		</tr>
 		<tr>
 			<th>법정동코드</th>
 			<td>${detail.code}</td>
 		</tr>
 		 <tr>
 			<th>거래금액</th>
 			<td>${detail.dealAmount}</td>
 		</tr>
 		 <tr>
 			<th>건축 년도</th>
 			<td>${detail.buildYear}</td>
 		</tr>
 		<tr>
 			<th>거래 날짜</th>
 			<td>${detail.dealYear}년${detail.dealMonth}월${detail.dealDay}일</td>
 		</tr>
 		<tr>
 			<th>면적</th>
 			<td>${detail.area}</td>
 		</tr>
 		<tr>
 			<th>층</th>
 			<td>${detail.floor}</td>
 		</tr>
 		<tr>
 			<th>지번</th>
 			<td>${detail.jibun}</td>
 		</tr>
 		<tr>
 			<th>주택 거래 타입</th>
 			<td>${detail.type}</td>
 		</tr>
 		 <tr>
 			<th>월세</th>
 			<td>${detail.rentMoney}</td>
 		</tr>
 </table>
 </c:if>
</div>
</body>
</html>