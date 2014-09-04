<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="/css/report.css" />

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="selectContainer">
	<form name="newADVReuslt" action="mappingreport" method="post">
	<table>
		<tr>
		<td>
		광고 이름
		</td>
		<td>
				<select class="adv" name="adv" id="adv">
					<c:forEach var="item" items="${list}">
						<option value="${item.advNum}!${item.name}">
						${item.name}
						</option>
					</c:forEach>
				</select>		
		</td>
		</tr>
		<tr>
			<td>년</td>
			<td>
				<select class="year" name="year" id="year">
				<c:set var="i" value="2000"/>				
				<c:forEach begin="0" end="20">
				<c:set var="i" value="${i + 1}"/>
				<option value="${i}">${i}</option>
				</c:forEach>
				</select>						
			</td>
			<td>검색방법</td>
		</tr>
		<tr>
			<td>월</td>
			<td>
				<select class="month" name="month" id="month">
				<c:set var="i" value="1"/>				
				<c:forEach begin="0" end="11">
				<c:set var="i" value="${i + 1}"/>
				<option value="${i}">${i}</option>
				</c:forEach>
				</select>						
			</td>
			<td>
				<input type="radio" name="selectKind" id="selectKind" value="month"/>월 단위			
			</td>			
		</tr>
		<tr>
			<td>일</td>
			<td>
				<select class="day" name="day" id="day">
				<option ></option>
				<c:set var="i" value="1"/>				
				<c:forEach begin="0" end="30">
				<c:set var="i" value="${i + 1}"/>
				<option value="${i}">${i}</option>
				</c:forEach>
				</select>						
			</td>
			<td>
				<input type="radio" name="selectKind" id="selectKind" value="day" checked="checked"/>일 단위	
			</td>		
		</tr>
		<tr>
			<td>
				<input type="submit"   value="변경"/>
			</td>
		</tr>
	</table>
	</form>	
	</div>	
</body>
</html>