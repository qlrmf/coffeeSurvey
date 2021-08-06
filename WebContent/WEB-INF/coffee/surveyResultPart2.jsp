<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashMap"%>
<%@page import="survey.model.QuestionCoffee"%>
<%@page import="java.util.Map"%>
<%@page import="survey.service.CoffeeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<article>
	<div>
		<h1>Part2.설문 결과</h1>
		<h4>"커피 섭취 빈도"에 대한 당신과 동일한 연령대의 설문결과 입니다. </h4>
	</div>
</article>
<%
	QuestionCoffee qu = new QuestionCoffee();
	
	Map<Integer, Map<Integer, Integer>> result = (Map<Integer, Map<Integer, Integer>>)session.getAttribute("part");
	session.removeAttribute("part");
	HashMap<String, String[]> qu1 = qu.getThinkRadio();
	HashMap<String, String[]> qu2 = qu.getThinkCheck();
	
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
	<%
	nbr++;
	}
	nbr = 1;
	for(Map.Entry<String, String[]> me: qu2.entrySet()){%>
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
		<%nbr++;
	} %>
	<hr color="#BD4B4B">	
