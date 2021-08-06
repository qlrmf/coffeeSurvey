<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연령별 커피취향과 선호도에 대한 설문조사</title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<article>
	<div  id="title">
		<input type="button" onclick="location.href='${pageContext.request.contextPath}/coffee/main.do'" value="HOME">
		<input type="button" onclick="location.href='${pageContext.request.contextPath}/coffee/info.do'" value="START">
		<input type="button" onclick="location.href='${pageContext.request.contextPath}/coffee/result.do'" value="RESULT">
		<br>
	</div>
</article>
