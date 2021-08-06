package survey.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoAction implements ICommandAction {

	@Override
	public String reqProcess(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		return "surveyInfo.jsp";
	}

}
