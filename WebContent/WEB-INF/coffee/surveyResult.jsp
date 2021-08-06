 <%@page import="java.util.*"%>
<%@page import="survey.model.QuestionCoffee"%>
<%@page import="survey.service.CoffeeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="coffeeHeader.jsp" flush="false"/>
<%	if(session.getAttribute("check")!=null){%>
			<jsp:include page="surveyResultPart1.jsp" flush="false"/>
	<% } 
	if(session.getAttribute("part")!=null){ %>
		<jsp:include page="surveyResultPart2.jsp" flush="false"/>
	<% } %>

	<article>
		<div>
			<h1>part3. 설문 결과</h1>
			<h4>"카페전문점에 대한 인식"에 대한 설문 결과입니다.<br>
				커피 섭취 빈도에 대한 결과가 궁금하면 설문에 응답해주세요 :) </h4>
			<a href="${pageContext.request.contextPath}/coffee/info.do"><p align="right">설문 진행하기</p></a>
			<hr>
		</div>
	</article>
	<%
		QuestionCoffee qu = new QuestionCoffee();
		Map<Integer, Map<Integer, Integer>> result = (Map<Integer, Map<Integer, Integer>>)session.getAttribute("result");

		HashMap<String, String[]> qu1 = qu.getCafeRadio();
		
	 	int nbr = 1;
		for(Map.Entry<String, String[]> me: qu1.entrySet()){%>
		<br>
		<li><b><%=me.getKey() %></b></li>
	    <div class="h_graph">
	        <ul>
	        	<% 	Map<Integer,Integer> hs = result.get(nbr);
	        		for(int i=0; i<me.getValue().length; i++) {
	        			if(hs.get(i+1)==null) continue;	%>
	            <li>	
	             	<span class="g_bar" style="width:<%=hs.get(i+1)%>%">
	            		<span><%=me.getValue()[i] %>(<%=hs.get(i+1)%>%)</span>
	            	</span>
              	</li>
	            <% } %>
	       </ul>
	    </div>
		<% nbr++;
		}%>

	
<jsp:include page="coffeeFooter.jsp" flush="false"/>
		
		