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
<link href="${root}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${root}/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
<link href="${root}/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="${root}/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="${root}/assets/vendor/venobox/venobox.css" rel="stylesheet">
<link href="${root}/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${root}/assets/css/style.css">
<link rel="stylesheet" type="text/css" href="${root}/css/header.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<header id="header" class="fixed-top">
	<div class="container d-flex align-items-center">
	 <h1 class="logo mr-auto"><a style="text-decoration: none;" href="${root}/main.do">HOME</a></h1>
	 <nav class="nav-menu d-none d-lg-block">
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
		</nav>
	</div>
</header>

	<section id="hero">
		<div class="hero-container">
			<h1>
				<a style="text-decoration: none;" href="${root}/main.do">HAPPY HOUSE</a>
			</h1>
			<h2>
				<a style="text-decoration: none;" href="${root}/main.do">행복한 우리 집</a>
			</h2>
		</div>
	</section>
<script src="assets/js/main.js"></script>
<script src="assets/vendor/jquery/jquery.min.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>
<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="assets/vendor/venobox/venobox.min.js"></script>
<script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
</body>
</html>