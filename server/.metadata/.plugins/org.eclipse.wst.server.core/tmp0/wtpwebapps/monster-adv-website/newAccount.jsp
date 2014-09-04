<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
		<link rel="stylesheet" type="text/css" href="/css/newAccount.css" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>회원가입</title>

		<script type="text/javascript">

		
		
			function idFunc()
			{	
				if(document.newRegister.userId.value.length<6)
				{	
					alert("아이디는 6자리 이상입니다.");
					document.getElementById("userId").value="";
					document.getElementById("idIcon").src="/images/newaccount/icon_red_check.jpg";
				}
				else{
					document.getElementById("idIcon").src="/images/newaccount/icon_check.jpg";
				}
				return;
			}
			function passwordFunc()
			{	
				document.getElementById("checkRPass").innerHTML="";
				document.getElementById("rPassword").value="";
				if(document.getElementById("uPassword").value.length<6){
				document.getElementById("checkUPass").innerHTML="6자리 이상";
				document.getElementById("uPassIcon").src="/images/newaccount/icon_red_check.jpg";
				document.getElementById("rPassIcon").src="/images/newaccount/icon_red_check.jpg";
				return;
				}
				document.getElementById("uPassIcon").src="/images/newaccount/icon_check.jpg";
				if(document.getElementById("rPassword").value!="")
				{
				document.getElementById("rPassIcon").src="/images/newaccount/icon_red_check.jpg";
				document.getElementById("rPassword").value="";
				}
				return;
			}
			function repeatPasswordFunc()
			{
				if(document.getElementById("rPassword").value!=document.getElementById("uPassword").value){
				document.getElementById("rPassIcon").src="/images/newaccount/icon_red_check.jpg";
				document.getElementById("checkRPass").innerHTML="다시 입력하세요."
				return;	
				}
				document.getElementById("rPassIcon").src="/images/newaccount/icon_check.jpg";
				document.getElementById("checkRPass").innerHTML=""
			}
			function checkName()
			{
				if(document.getElementById("uName").value!="")
				{
				document.getElementById("uNameIcon").src="/images/newaccount/icon_check.jpg";
				}
				else
				document.getElementById("uNameIcon").src="/images/newaccount/icon_red_check.jpg";
			}
			function register()
			{	
				
				if(document.getElementById("userId").value!="")
				{
					if(document.getElementById("rPassword").value!="")
					{
						if(document.getElementById("uName").value!="")
						{	
							var temp="";
							temp+="ID :"+document.getElementById("userId").value+"\n"
							+"PASS :"+document.getElementById("rPassword").value+"\n"
							+"NAME :"+document.getElementById("uName").value+"\n"
							+"EMAIL :"+document.getElementById("email").value+"\n";
							temp+="TEL :"
							for(var i=0;i<3;i++)
							{
								if(document.newRegister.tel[i].value!="")
								temp+=document.newRegister.tel[i].value;
							}
							temp+="\nPHONE :";
							for(var i=0;i<3;i++)
							{
								if(document.newRegister.phone[i].value!="")
								temp+=document.newRegister.phone[i].value;
							}
							temp+="\nROUTE :";
							for(var i=0;i<3;i++)
							{
								if(document.newRegister.route[i].checked)
								temp+=document.newRegister.route[i].value+",";
							}
							temp+="\nINTRODUCE :"+document.newRegister.introduce.value+"\n";
							alert(temp);
							return false;
						}
					}
				}
				alert("체크항목을 모두 완성해 주세요");
				return false;
			}
			
			function emailCheck(email)
			{	
				if(email=="")
				{	document.getElementById("emailRequire").innerHTML="주소를 입력하세요."
					document.getElementById("eMailIcon").src="/images/newaccount/icon_red_check.jpg";
					return;
				}
				var fEmail = email.value.split('@');
				if(fEmail.length!=2||fEmail[0]==""||fEmail[1].split(".").length==1){
					document.getElementById("emailRequire").innerHTML="잘못된 형식입니다."
					document.getElementById("eMailIcon").src="/images/newaccount/icon_red_check.jpg";
					return;	
				}	/*첫번째 오류검사 형식이 맞지 않는 경우*/
				fEmail = fEmail[1].split(".");
				for(var i=0;i<fEmail.length;i++)
				{
					if(fEmail[i]=="")
					{document.getElementById("emailRequire").innerHTML="잘못된 형식입니다."
					document.getElementById("eMailIcon").src="/images/newaccount/icon_red_check.jpg";
					return;
					}
				}
				document.getElementById("emailRequire").innerHTML="올바른 형식입니다."
				document.getElementById("eMailIcon").src="/images/newaccount/icon_check.jpg";
				return;	
			}

		</script>



</head>
<body>
		<div id="frame">
		<div id="header"><p><img src="/images/newaccount/icon_check.jpg" alt="필수">은 필수 입력항목입니다.</p>
		</div>
		<form name="newRegister" onsubmit="return register()">
		<table width="100%" border="1" cellspaceing="0" cellpadding="0" id="joinData" summary="총 10개의 입력항목">
		<tbody>
			<tr>
				<th class="inputKind"><img id="idIcon" src="/images/newaccount/icon_red_check.jpg" alt="필수"><label>아이디</label></th>
				<th class="inputData"><input type="text" id="userId" onchange= "return idFunc()"/></th>
			</tr>
			<tr>
				<th class="inputKind"><img id="uPassIcon" src="/images/newaccount/icon_red_check.jpg" alt="필수"><label>비밀번호</label></th>
				<th class="inputData"><input type="password" id="uPassword" onchange="return passwordFunc();"/><label id="checkUPass"></label></th>
			</tr>
			<tr>
				<th class="inputKind"><img id="rPassIcon" src="/images/newaccount/icon_red_check.jpg" alt="필수"><label>비밀번호 확인</label></th>
				<th class="inputData"><input type="password" id="rPassword"onchange="return repeatPasswordFunc();"/><label id="checkRPass"></label></th>
			</tr>
			<tr>
				<th class="inputKind"><img id="uNameIcon"src="/images/newaccount/icon_red_check.jpg" alt="필수">
				<label>이름</label></th>
				<th class="inputData"><input type="text" id="uName" onchange="return checkName();"/></th>
			</tr>
			<tr>
				<th class="inputKind"><img id="eMailIcon" src="/images/newaccount/icon_red_check.jpg" alt="필수"><label>이메일</label></th>
				<th class="inputData"><input type="text" id="email" onchange="return emailCheck(this)"/><label id="emailRequire">주소를 입력하세요.</label></th>
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