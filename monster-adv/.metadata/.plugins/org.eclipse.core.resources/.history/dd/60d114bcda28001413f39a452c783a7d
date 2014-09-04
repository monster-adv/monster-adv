<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript">
	window.onload = function(){
		var variable = "<%=request.getAttribute("message") %>"
		if(variable=="infoincorrect")
		{
			alert("아이디 혹은 비밀번호가 올바르지 않습니다.");
			window.location.assign("login");		
		}
		else if(variable=="infocorrect")
		{
			window.location.assign("main");		
		}
		else if(variable=="passwordincorrect")
		{
			alert("비밀번호가 올바르지 않습니다.");
			window.location.assign("registAccount");					
		}
		else if(variable=="idexist")
		{
			alert("아이디가 이미 존재합니다.");
			window.location.assign("registAccount");					
		}
		else if(variable=="emailexist")
		{
			alert("아이디 혹은 비밀번호가 올바르지 않습니다.");
			window.location.assign("registAccount");					
		}
		else if(variable=="regist")
		{
			alert("회원 가입에 성공하셨습니다. 로그인 화면으로 이동합니다.");
			window.location.assign("login");					
		}
		else if(variable=="advRegistSucess")
		{
			alert("광고등록에 성공하셨습니다.");
			window.location.assign("main");					
		}
		else if(variable=="advRegistFail")
		{
			alert("광고등록에 실패하셨습니다..");
			window.location.assign("regist");					
		}
		else if(variable=="needlogin")
		{
			alert("광고등록에 실패하셨습니다..");
			window.location.assign("login");					
		}		
	};
	</script>
<title>Insert title here</title>
</head>
<body>
	<input type="hidden" id = "message" name="message" value="<%=request.getAttribute("message") %>" />

</body>
</html>