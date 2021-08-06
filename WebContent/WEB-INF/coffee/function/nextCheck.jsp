<%@page import="survey.service.CoffeeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="info" class="survey.model.InfoVo" scope="page"/>
<jsp:setProperty name="info" property="*" />
<jsp:useBean id="taste" class="survey.model.TasteVo" scope="page"/>
<jsp:setProperty name="taste" property="*" />
<jsp:useBean id="think" class="survey.model.ThinkVo" scope="page"/>
<jsp:setProperty name="think" property="*" />

<%
	CoffeeService ser = CoffeeService.getInstance();
	String[] requ = request.getHeader("referer").split("/");
	String ref = requ[requ.length-1];
	System.out.println(ref);
	if(ref.equals("surveyInfo.jsp")){
		ser.addVo("info", info);	
		response.sendRedirect(request.getContextPath()+"/coffee/surveyPart1.jsp");
	} else if(ref.equals("surveyPart1.jsp")){
		ser.addVo("taste", taste);	
		response.sendRedirect(request.getContextPath()+"/coffee/surveyPart2.jsp");
	} else if(ref.equals("surveyPart2.jsp")){
		if(think.getThink3()==null){
			%>
			<script>
				alert("3번 문항이 누락되었어요");
				history.go(-1);
			</script>
			<%
		}else if(think.getThink4()==null){
			%>
			<script>
				alert("4번 문항이 누락되었어요");
				history.go(-1);
			</script>
			<%
		}else{
		ser.addVo("think", think);	
		response.sendRedirect(request.getContextPath()+"/coffee/surveyPart3.jsp");
		}
	}else {
%>
	<script>
		alert("잘못된 요청입니다");
		history.go(-1);
	</script>
<%
	}
%>		
