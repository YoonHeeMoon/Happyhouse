<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script>
	function goPage(aaa, bbb) { // name이 paging인 태그 var f =
		var f = document.paging;

		// form 태그의 하위 태그 값 매개 변수로 대입
		f.houseList.value = aaa;
		f.cp.value = bbb;

		// input태그의 값들을 전송하는 주소
		f.action = "${root}/main.jsp"

		// 전송 방식 : post
		f.method = "post"
		f.submit();
	}
</script>
<meta charset="UTF-8">
<title>page.jsp</title>
</head>
<body>
	<c:set var="start" value="1" />
	<c:if test="${cp>2}">
		<c:set var="start" value="${cp-2}" />
	</c:if>
	<c:set var="end" value="${start+4}" />

	<c:if test="${end>mp}">
		<c:set var="dis" value="${end-mp}" />
		<c:set var="end" value="${end-dis}" />
		<c:if test="${start-dis>0}">
			<c:set var="start" value="${start-dis}" />
		</c:if>
		<c:if test="${start-dis<=0}">
			<c:set var="start" value="1" />
		</c:if>
	</c:if>
	<c:forEach var="page" begin="${start}" end="${end}" step="1">
		<a href="javascript:goPage(${houseList},${page });">${page }</a>
	</c:forEach>
</body>
</html>