<%@page import="java.util.*"%>
<%@page import="survey.model.QuestionCoffee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="coffeeHeader.jsp" flush="false"/>

		<h1>part3. 커피전문점에 대한 생각</h1>
		<h4>어떤 카페를 좋아하세요?</h4>

<article>
	<div>
		<form action="${pageContext.request.contextPath}/coffee/insert.do"  method='post'>
			<ol>
				<% QuestionCoffee qu = new QuestionCoffee();
					HashMap<String, String[]> hs = qu.getCafeRadio();
					int nbr = 1;
					
					for(Map.Entry<String, String[]> me: hs.entrySet()){	%>
					<br><hr>
					<li><b><%=me.getKey() %></b></li>
						<%		int num = 1;
								for(int i=0; i<me.getValue().length; i++){ %>
									<input type="radio" name="cafe<%=nbr %>" value="<%=num %>" id="cafe<%=nbr%><%=num%>" required>
										<label for="cafe<%=nbr%><%=num++%>"><%=me.getValue()[i] %></label><br>
							<% } 
							nbr++;
					} 
				%>
			</ol>
		<br>
		<input type="submit" value="Next">
		<input type="button" value="Back" onclick="history.go(-1)">
	</form>	
	</div>
</article>	
		
<jsp:include page="coffeeFooter.jsp" flush="false"/>
		