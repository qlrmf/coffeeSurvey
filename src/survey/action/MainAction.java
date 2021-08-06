package survey.action;

import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainAction implements ICommandAction {

	@Override
	public String reqProcess(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		HttpSession session = req.getSession(true);
		
		Enumeration<String> it = session.getAttributeNames();
		while(it.hasMoreElements()) {
			System.out.println(it.nextElement());
		}
		
		
		return "main.jsp";
	}

}
