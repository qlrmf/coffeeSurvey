package survey.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommandAction {
	public String reqProcess(HttpServletRequest req, HttpServletResponse resp) throws Throwable;
}
