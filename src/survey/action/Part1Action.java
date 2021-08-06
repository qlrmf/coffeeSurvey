package survey.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import survey.model.InfoVo;

public class Part1Action implements ICommandAction {

	@Override
	public String reqProcess(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		int gender = Integer.parseInt(req.getParameter("gender"));
		int age = Integer.parseInt(req.getParameter("age"));
		int job = Integer.parseInt(req.getParameter("job"));
		InfoVo vo = new InfoVo(gender, age, job);
		
		HttpSession session = req.getSession(true);
		session.setAttribute("info", vo);

		return "surveyPart1.jsp";
	}

}
