<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
		<link rel="stylesheet" type="text/css" href="/css/newAccount.css" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원가입</title>



</head>
<body>
	<jsp:include page="header.jsp" />
		<div id="frame">
		
		<img src="/images/newaccount/newAccount.png" >	
		<form name="newRegister" action="infoSubmit" method="post">
		<table width="100%" border="1" cellspaceing="0" cellpadding="0" id="joinData" summary="총 10개의 입력항목">
		<tbody>
			<tr>
				<th class="inputKind"><label>아이디</label></th>
				<th class="inputData"><input type="text" name="userId" id="userId" /></th>
			</tr>
			<tr>
				<th class="inputKind"><label>비밀번호</label></th>
				<th class="inputData"><input type="password" name="uPassword" id="uPassword"/><label id="checkUPass"></label></th>
			</tr>
			<tr>
				<th class="inputKind"><label>비밀번호 확인</label></th>
				<th class="inputData"><input type="password" name="rPassword" id="rPassword"/> <label id="checkRPass"></label></th>
			</tr>
			<tr>
				<th class="inputKind">
				<label>이름</label></th>
				<th class="inputData"><input type="text" name="uName" id="uName"/></th>
			</tr>
			<tr>
				<th class="inputKind"><label>이메일</label></th>
				<th class="inputData"><input type="text" name="email" id="email"/><label id="emailRequire">주소를 입력하세요.</label></th>
			</tr>
			<tr>
				<th class="inputKind"><label>전화번호</label></th>
				<th class="inputData"><input type="text"  name="tel" maxlength="3" size="3" />
					-<input type="text" name="tel" maxlength="4" size="4" />
					-<input type="text" name="tel" maxlength="4" size="4" />
				</th>
			</tr>		
			<tr>
				<th class="inputKind"><label>휴대폰</label></th>
				<th class="inputData"><input type="text"  name="phone" maxlength="3" size="3"/>
					-<input type="text" name="phone" maxlength="4" size="4"/>
					-<input type="text" name="phone" maxlength="4" size="4"/></th>
			</tr>
			<tr>
				<th class="inputKind"><label>이메일 수신</label></th>
				<th class="inputData"><input type="checkbox" name="route" value="notice"/><label>공지사항</label>
					<input type="checkbox" name="route" value="news"/><label>소식</label>
					<input type="checkbox" name="route" value="event"/>이벤트</th>
			</tr>		
			<tr>
				<th class="inputKind"><label>자기소개</label></th>
				<th class="inputData"><input type="text" name="introduce"class="info"/></th>
			</tr>
			<tr>
				<th><input class="sButton" type="submit" value="회원가입" /></th>
				<th><input class="sButton" type="reset" value='취소하기'/></th>
			</tr>		
		</tbody>
		</table>
						
		</form>
		</div>

</body>
</html>