<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/css/login.css" />

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="login">
		<form action="loginResult" method="post">
		<fieldset class="login_form">
			
			<input name="input_id" type="text" size="20" maxlength="12"><br/>
			<br/>
			<input name="input_pass" type="password" size="20" maxlength="12"><br/>
			
			<input class="login_button" type="image" src="/images/login/login_btn.gif">
		</fieldset>	
		</form>
	</div>
</body>
</html>