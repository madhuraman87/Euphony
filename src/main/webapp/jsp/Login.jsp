<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Euphony</title>
<link rel="stylesheet" type="text/css"
	href="/euphony/css3/transparent.css">
<!-- <script src="../css3/prefixfree.min.js"></script> -->
<script type="text/javascript" charset="utf-8"
	src="/euphony/js/jquery/jquery-2.1.1.js"></script>
</head>
<body>
<%@include file="../jsp/Script.jsp" %>
 <form id="loginForm" class="form-horizontal">
	<div class="result"><span id="result" style="color: white;font-size: 30px;"></span></div>
	<div class="body"></div>
	<div class="grad"></div>
	<div class="header">
		<div>
			Euphony
		</div>
	</div>
	<br>
	<div class="login">
		<input id="userid" type="number" placeholder="userid" name="userid" required><br>
		<input id="password" type="password" placeholder="password" name="password" required><br>
		<input id="login" type="button" value="Login">
		<input id="register" type="button" value="Register">
	</div>
	</form>
	<script type="text/javascript" charset="utf-8"
	src="/euphony/js/login.js"></script>
</body>
</html>