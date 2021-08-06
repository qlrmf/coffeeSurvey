<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="coffeeHeader.jsp" flush="false"/>
	<h1>Info. 인적사항</h1>
	<h4>통계를 위해 아래 정보를 부탁드려요</h4>
<article>
	<div>
	<form action="${pageContext.request.contextPath}/coffee/part1.do" method='post'>
		<ul>
			<br><hr>
			<li><b>성별</b></li>
			<input type="radio" name="gender" value="1" id="gender1"><label for="gender1">남자</label>
			<input type="radio" name="gender" value="2" id="gender2" required><label for="gender2">여자</label>
			<br><hr>
			<li><b>연령대</b></li>
			<input type="radio" name="age" value="10" id="age1"><label for="age1">10대</label>
			<input type="radio" name="age" value="20" id="age2"><label for="age2">20대</label>
			<input type="radio" name="age" value="30" id="age3"><label for="age3">30대</label>
			<input type="radio" name="age" value="40" id="age4" required><label for="age4">40대</label>
			<br><hr>
			<li><b>직업군</b></li>
			<input type="radio" name="job" value="1" id="job1"><label for="job1">무직</label>
			<input type="radio" name="job" value="2" id="job2"><label for="job2">직장인</label>
			<input type="radio" name="job" value="3" id="job3" required><label for="job3">학생</label>
		</ul>
		<p><input type="submit" value="Next"></p>
		<br>
	</form>	
	</ul>
	</div>
	</article>	
		
<jsp:include page="coffeeFooter.jsp" flush="false"/>
		