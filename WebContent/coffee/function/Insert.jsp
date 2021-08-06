<%@page import="coffeeSurvey.service.CoffeeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cafe" class="coffeeSurvey.model.CafeVo" scope="page"/>
<jsp:setProperty name="cafe" property="*"/>

<%
	CoffeeService ser = CoffeeService.getInstance();
	ser.addVo("cafe", cafe);
	
	if(ser.regist()){
		int count = ser.personalNum();
		if(count>0){
			Cookie cookie = new Cookie("userNum", String.valueOf(count));
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		response.sendRedirect(request.getContextPath()+"/coffee/surveyResult.jsp");
	}else{
%>
		<script>
			alert("입력실패. 기본페이지로 돌아갑니다.");
			location.href="<%=request.getContextPath()%>/coffee/main.jsp";
		</script>
<%
	}
%>		