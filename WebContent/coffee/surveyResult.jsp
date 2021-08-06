 <%@page import="java.util.*"%>
<%@page import="coffeeSurvey.model.QuestionCoffee"%>
<%@page import="coffeeSurvey.service.CoffeeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="coffeeHeader.jsp" flush="false"/>
<%
	CoffeeService ser = CoffeeService.getInstance();
	int num = 0;
	Cookie[] cookies = request.getCookies();
	if(cookies!=null && cookies.length>0){
		for(Cookie coo : cookies){
			if(coo.getName().equals("userNum")){
				num = Integer.parseInt(coo.getValue());
				Cookie cookie = new Cookie("userNum","");
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
				break;
			}
		}
	}
	if(num>0){
		if(ser.checkVo(num)){%>
			<jsp:include page="surveyResultPart1.jsp" flush="false">
				<jsp:param value="<%=num %>" name="num"/>
			</jsp:include>
		<% } %>
		<jsp:include page="surveyResultPart2.jsp" flush="false">
			<jsp:param value="<%=num %>" name="num"/>
		</jsp:include>
	<% } %>

	<article>
		<div>
			<h1>part3. 설문 결과</h1>
			<h4>"카페전문점에 대한 인식"에 대한 설문 결과입니다.<br>
				커피 섭취 빈도에 대한 결과가 궁금하면 설문에 응답해주세요 :) </h4>
			<a href="surveyInfo.jsp"><p align="right">설문 진행하기</p></a>
			<hr>
		</div>
	</article>
	<%
		QuestionCoffee qu = new QuestionCoffee();
		Map<Integer, Map<Integer, Integer>> result = ser.totalPage();
	
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
		<%
		nbr++;
	}%>

	
<jsp:include page="coffeeFooter.jsp" flush="false"/>
		
		