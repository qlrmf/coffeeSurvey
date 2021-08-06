package survey.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import survey.model.TasteVo;

public class Part2Action implements ICommandAction {

	@Override
	public String reqProcess(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
		int taste1 = Integer.parseInt(req.getParameter("taste1"));
		int taste2 = Integer.parseInt(req.getParameter("taste2"));
		int taste3 = Integer.parseInt(req.getParameter("taste3"));
		int taste4 = Integer.parseInt(req.getParameter("taste4"));
		int taste5 = Integer.parseInt(req.getParameter("taste5"));
		int taste6 = Integer.parseInt(req.getParameter("taste6"));
		TasteVo vo = new TasteVo(taste1, taste2, taste3, taste4, taste5, taste6);
		
		HttpSession session = req.getSession(true);
		session.setAttribute("taste", vo);

		return "surveyPart2.jsp";
	}

}
