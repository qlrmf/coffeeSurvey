<%@page import="java.util.*"%>
<%@page import="coffeeSurvey.model.QuestionCoffee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="coffeeHeader.jsp" flush="false"/>
	<h1>part1. 커피 취향 찾기</h1>
	<h4>당신의 취향에 딱 맞는 커피를 찾아보세요. 다음 설문을 통해 나만의 커피를 찾아보세요
		(원하지 않는다면 그냥 넘어가도 좋아요 <a href="<%=request.getContextPath()%>/coffee/function/nextCheck.jsp">넘어가기</a>)</h4>
<article>
	<div>
		<form action="<%=request.getContextPath()%>/coffee/function/nextCheck.jsp">
			<ol>
				<% QuestionCoffee qu = new QuestionCoffee();
					HashMap<String, String[]> hs = qu.getTasteRadio();
					int nbr = 1;
					
					for(Map.Entry<String, String[]> me: hs.entrySet()){	%>
					<br><hr>
					<li><b><%=me.getKey() %></b></li>
						<%		int num = 1;
								for(int i=0; i<me.getValue().length; i++){ %>
									<input type="radio" name="taste<%=nbr %>" value="<%=num %>" id="taste<%=nbr%><%=num%>">
										<label for="taste<%=nbr%><%=num++%>"><%=me.getValue()[i] %></label><br>
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
		