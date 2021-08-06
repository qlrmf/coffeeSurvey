package survey.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import survey.model.CafeVo;
import survey.service.CoffeeService;

public class ResultAction implements ICommandAction {

	@Override
	public String reqProcess(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		CoffeeService ser = CoffeeService.getInstance();
		HttpSession session = req.getSession(true);

		String[] re = req.getHeader("referer").split("/");
		String refer = re[re.length - 1];
		System.out.println(refer);
		if (refer.equals("part3.do")) {
			int num = (int) session.getAttribute("userNum");
			session.removeAttribute("userNum");
			session.setAttribute("part", ser.totalPage(num));
			if (ser.checkVo(num)) {
				session.setAttribute("check", ser.checkVo(num));
			}
		}
		session.setAttribute("result", ser.totalPage());
		return "surveyResult.jsp";
	}

}
