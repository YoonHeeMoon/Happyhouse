<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${root}/css/header.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>main.jsp</title>

<style type="text/css">
#search-box {
	background-color: #2E2E2E;
}
</style>

<script>
function viewdetail(no){
	document.location.href = "${root}/viewdetail?no="+no;
}
</script>
</head>

<body>
	<div id="head" class="jumbotron text-center">
		<ul class="nav justify-content-end">
			<c:if test="${userinfo eq null}">
				<li class="nav-item"><a class="nav-link" href="${root}/MvJoin">Sign
						Up</a></li>
				<li class="nav-item"><a class="nav-link" href="${root}/MvLogin">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${root}/MvNotice">공지사항</a></li>
			</c:if>
			<c:if test="${userinfo ne null}">
				<li class="nav-item"><a class="nav-link"
					href="${root}/MvMypage">MyPage</a></li>
				<li class="nav-item"><a class="nav-link" href="${root}/logout">Logout</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${root}/MvNotice">공지사항</a></li>
			</c:if>
		</ul>

		<div id="home">
			<h1>
				<a href="${root}/main.do">HAPPY HOUSE</a>
			</h1>
			<p>
				<a href="${root}/main.do">행복한 우리 집</a>
			</p>
		</div>
	</div>

	<div id="search-box" class="jumbotron text-center">
		<form method="post"
			action="${pageContext.request.contextPath }/search">
			<select name="sel1" id="sel1">
				<option>동별</option>
				<option>아파트별</option>
			</select> <input type="text" name="search" id="search"> 
			<button type="submit">검색</button>
			<input type="checkbox" name="sort" value="true">
		</form>
	</div>

	<div class="container">
		<h2>검색 결과</h2>
		<p>동별, 아파트별 실거래가 검색</p>
		<br>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>동</th>
					<th>아파트이름</th>
					<th>거래금액</th>
					<th>거래종류</th>
				</tr>
			</thead>
			<c:if test="${houseList.size() != 0}">
				<c:forEach var="house" items="${houseList}">
					<tbody>
						<tr id="no" onclick="javascript:viewdetail(${house.no});"
							style="cursor: hand">
							<td>${house.no}</td>
							<td>${house.dong}</td>
							<td>${house.aptName}</td>
							<td>${house.dealAmount}</td>
							<td>${house.type}</td>
						</tr>
					</tbody>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${houseList.size() != 0}">
			<fmt:parseNumber var="mp" integerOnly="true"
				value="${houseList.size()/5}" />
			<%@ include file="/page.jsp"%>
		</c:if>
	</div>
</body>
</html>