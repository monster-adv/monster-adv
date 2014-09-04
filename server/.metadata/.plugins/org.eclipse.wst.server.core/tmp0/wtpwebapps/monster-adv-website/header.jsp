<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="/css/header.css" />
<link rel="stylesheet" type="text/css" href="/css/reset.css" />
<script type="text/javascript" src="/javascript/header.js"></script>


<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">

	
		<div id="logo">
			<a href="main" class="visual"><img src="/images/logo.png"></a>
			
		</div>
		<div id= "rightMenu">
		<c:choose>
			<c:when test=""><!-- 로그인 판별 부분 추가해야 됨 -->
				<a class="loginSelect"href="logout">logout</a><br/>
				<a class="loginSelect"href="info">info</a>
			</c:when>
			<c:otherwise>
				<a class="loginSelect" href="#" onclick="return clickRegister();">register</a><br/>
				<a class="loginSelect"href="forgot">forgot</a><br/>
				<a class="loginSelect"href="login">login</a>

			</c:otherwise>
		</c:choose>
		</div>

		
		<ul id="menu">
			<li>
				<form action="" method="get">
				<a href="weare"><img src="/images/weare.png" alt="WHO" height="60" /></a>	
				</form>
			</li>
			<li>
				<form action="" method="get">
				<a href="regist"><img src="/images/registadv.png" height="60" /></a>
				</form>
			</li>
			<li>
				<form action="" method="get">
				<a href="status"><img src="/images/advstatus.png" height="60" /></a>
				</form>	
			</li>
			<li>
				<form action="" method="get">			
				<a href="report"><img src="/images/report.png" height="60" /></a>
				</form>	
			</li>
		</ul>
	</div>

</body>
</html>