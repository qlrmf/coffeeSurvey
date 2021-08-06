package survey.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import survey.model.CafeVo;
import survey.service.CoffeeService;

public class InsertAction implements ICommandAction {

	@Override
	public String reqProcess(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		CoffeeService ser = CoffeeService.getInstance();
		int cafe1 = Integer.parseInt(req.getParameter("cafe1"));
		int cafe2 = Integer.parseInt(req.getParameter("cafe2"));
		int cafe3 = Integer.parseInt(req.getParameter("cafe3"));
		int cafe4 = Integer.parseInt(req.getParameter("cafe4"));
		int cafe5 = Integer.parseInt(req.getParameter("cafe5"));
		int cafe6 = Integer.parseInt(req.getParameter("cafe6"));
		int cafe7 = Integer.parseInt(req.getParameter("cafe7"));
		int cafe8 = Integer.parseInt(req.getParameter("cafe8"));
		CafeVo vo = new CafeVo(cafe1, cafe2, cafe3, cafe4, cafe5, cafe6, cafe7, cafe8);

		HttpSession session = req.getSession(true);
		
		ser.addVo("info", session.getAttribute("info"));
		ser.addVo("taste", session.getAttribute("taste"));
		ser.addVo("think", session.getAttribute("think"));
		ser.addVo("cafe", vo);
		session.removeAttribute("info");
		session.removeAttribute("taste");
		session.removeAttribute("think");
		if(ser.regist()) {
			int count = ser.personalNum();
			if(count>0) {
				session.setAttribute("userNum", count);
			}
			return "function/Insert.jsp";
		} else {
			System.out.println("!!!!!");
			return "main.jsp";
		}
	}
}
