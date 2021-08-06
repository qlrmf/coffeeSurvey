<%@page import="survey.service.CoffeeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cafe" class="survey.model.CafeVo" scope="page"/>
<jsp:setProperty name="cafe" property="*"/>

<%
	response.sendRedirect(request.getContextPath()+"/coffee/result.do");
%>