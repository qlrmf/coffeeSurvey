<%@page import="java.util.*"%>
<%@page import="coffeeSurvey.model.QuestionCoffee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="coffeeHeader.jsp" flush="false"/>
		<h1>part2. 커피 섭취 빈도 테스트</h1>
		<h4>당신이 커피를 얼마나 자주, 어디에서 먹는지 생각해보세요</h4>
<article>
	<div>
		<form action="<%=request.getContextPath()%>/coffee/function/nextCheck.jsp">
			<ol>
				<% QuestionCoffee qu = new QuestionCoffee();
					HashMap<String, String[]> hs = qu.getThinkRadio();
					int nbr = 1;
					
					for(Map.Entry<String, String[]> me: hs.entrySet()){	%>
					<br><hr>
					<li><b><%=me.getKey() %></b></li>
						<%		int num = 1;
								for(int i=0; i<me.getValue().length; i++){ %>
									<input type="radio" name="think<%=nbr %>" value="<%=num %>" id="think<%=nbr%><%=num%>" required>
										<label for="think<%=nbr%><%=num++%>"><%=me.getValue()[i] %></label><br>
							<% } 
							nbr++;
					} 
					HashMap<String, String[]> hs2 = qu.getThinkCheck();
					
					for(Map.Entry<String, String[]> me: hs2.entrySet()){	%>
					<br><hr>
					<li><b><%=me.getKey() %></b></li>
						<%		int num = 1;
								for(int i=0; i<me.getValue().length; i++){ %>
									<input type="checkBox" name="think<%=nbr %>" value="<%=num %>" id="think<%=nbr%><%=num%>">
										<label for="think<%=nbr%><%=num++%>"><%=me.getValue()[i] %></label><br>
							<% } 
							nbr++;
					} %>
			</ol>
		<br>
		<input type="submit" value="Next">
		<input type="button" value="Back" onclick="history.go(-1)">
	</form>	
	</div>
	</article>	
		
<jsp:include page="coffeeFooter.jsp" flush="false"/>
		