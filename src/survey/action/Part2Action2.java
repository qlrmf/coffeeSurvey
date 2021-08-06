package survey.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import survey.model.TasteVo;

public class Part2Action2 implements ICommandAction {

	@Override
	public String reqProcess(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		HttpSession session = req.getSession(true);
		session.setAttribute("taste", new TasteVo(0, 0, 0, 0, 0, 0));
		return "surveyPart2.jsp";
	}

}
