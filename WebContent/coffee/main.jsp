<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="coffeeHeader.jsp" flush="false"/>


		<h1>LIKE COFFEE?</h1>
		<h4>커피를 드시는 분만 응답해주세요</h4>

		<div>
		<ul>
			<p>본 설문은 커피에 대한 선호도와 연령별 취향을 조사하기 위한 설문이며, 상업적인 용도로 사용되지 않습니다.</p>
			<p>정확한 통계를 위해 일부 개인정보를 수집할 수 있으나, 모든 설문은 익명으로 이루어지므로 솔직한 답변 부탁드립니다.</p>
		</ul>
			<p><input type="button" onclick="location.href='<%=request.getContextPath()%>/coffee/surveyInfo.jsp'" value="설문시작"></p>
			<br>
		</div>

<jsp:include page="coffeeFooter.jsp" flush="false"/>
		