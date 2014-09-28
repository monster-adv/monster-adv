<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="/css/newADV.css" />
		<script type="text/javascript">
		window.onload = function(){
	
			var usercheck = document.getElementById("requestID").value;
			var advcheck = document.getElementById("advID").value;
		if(usercheck == "")
		{
			alert("로그인해주세요!");
			window.location.assign("login");
		}
		else if(advcheck =="")
		{
			alert("디지털 사이니지를 선택해주세요");
			window.location.assign("regist");
		}
		};
		</script>
		
		
		<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />


		<div id="frame">
		<div class ="newADVTable">
		<form name="newADVReuslt" action="newADVResult" method="post">
		<input type="hidden" name="signageID" id="signageID" value="${signageID}" />
		<table width="100%" border="1"  cellpadding="0" id="joinData" summary="총 10개의 입력항목">
		<tbody>
			<tr>
				<td class="inputKind"><label>신청자</label></td>
				<td class="inputData"><input type="text" name="requestID" id = "requestID" readonly="readonly" value="${sessionScope.logininfo.userId }" /></td>	
			</tr>	
			<tr>
				<td class="inputKind"><label>위치</label></td>
				<td class="inputData"><input type="text" name="signageLocate" id="signageLocate" readonly="readonly" value="${signageName}" /></td>
			</tr>
			<tr>
				<td class="inputKind"><label>광고명</label></td>
				<td class="inputData"><input type="text" name="advName" id = "advName"  /></td>	
				
			</tr>

			<tr>
				<td class="inputKind"><label>광고종류</label></td>
				<td class="inputData"><input type="radio" name="advKind" value="V" checked="checked"/><label>영상</label>
									  <input type="radio" name="advKind" value="P"/><label>사진</label>
				
			</tr>
			<tr>
				<td class="inputKind"><label>원하는 고객종류</label></td>
				<td class="inputData"><input type="radio" name="peopleKind" value="M"/><label>남성</label>
									  <input type="radio" name="peopleKind" value="W"/><label>여성</label>
									  <input type="radio" name="peopleKind" value="N" checked="checked"/><label>무관</label></td>
			</tr>
			<tr>
				<td class="inputKind">
				<label>원하는 사람 수</label></td>
				<td class="inputData"><input type="text" name="peopleNum"/></td>
			</tr>
			<tr>
				<td class="inputKind">
				<label>파일</label></td>
				<td class="inputData"><input type="file" name="filelocate"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input class="sButton" type="submit" value="등록" /></td>
			</tr>		
		</tbody>
		</table>
		</form>
		</div>
		</div>
</body>
</html>