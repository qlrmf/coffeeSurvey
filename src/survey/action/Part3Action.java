package survey.action;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import survey.model.ThinkVo;

public class Part3Action implements ICommandAction {

	@Override
	public String reqProcess(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		int think1 = Integer.parseInt(req.getParameter("think1"));
		int think2 = Integer.parseInt(req.getParameter("think2"));
		int[] think3 = Arrays.stream(req.getParameterValues("think3")).mapToInt(Integer::parseInt).toArray();
		int[] think4 = Arrays.stream(req.getParameterValues("think4")).mapToInt(Integer::parseInt).toArray();
		ThinkVo vo = new ThinkVo(think1, think2, think3, think4);
		
		HttpSession session = req.getSession(true);
		session.setAttribute("think", vo);

		return "surveyPart3.jsp";
	}

}
