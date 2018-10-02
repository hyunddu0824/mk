<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page trimDirectiveWhitespaces="true" %> 
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/resources/image/icon.png">

<title>Sticky Footer Navbar Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="/resources/include/dist/css/bootstrap.min.css"	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/resources/include/css/sticky-footer-navbar.css" rel="stylesheet">


<script
	src="/resources/include/dist/assets/js/ie-emulation-modes-warning.js"></script>


</head>

<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top">
		<tiles:insertAttribute name="header"/>
	</nav>	


	<div class="container">
		<div class="page-header">
			<h1>
				<tiles:insertAttribute name="title"/>
			</h1>
		</div>
		<tiles:insertAttribute name="body"/>
	</div>


	<!-- 풋터 시작 -->
 		<tiles:insertAttribute name="footer" />
    <script src="/resources/include/dist/assets/js/docs.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/resources/include/dist/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
