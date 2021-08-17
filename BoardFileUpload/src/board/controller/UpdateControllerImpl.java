package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attach.model.AttachDao;
import attach.model.AttachVo;
import board.model.BoardVo;

public class UpdateControllerImpl implements IBoardController {
	private AttachDao attachdao = AttachDao.getInstance();

	@Override
	public String doRequest(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(true);
		
		String password = req.getParameter("password");
		BoardVo update = (BoardVo)session.getAttribute("update");

		if(!password.equals(update.getPassword())) {
			session.setAttribute("error", "update");
			return "error.jsp";
		}
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		title = new String(title.getBytes("8859_1"), "utf-8");
		content = new String(content.getBytes("8859_1"), "utf-8");
		
		BoardVo vo = new BoardVo();
		vo.setNum(update.getNum());
		vo.setTitle(title);
		vo.setContent(content);
		dao.update(vo);
		
		AttachVo file = (AttachVo)req.getAttribute("files");
		if(file!=null) {
			if(attachdao.countFile(update.getNum())==0) {
				attachdao.insert(file);
			}else {
				file.setbNum(update.getNum());
				attachdao.update(file);
			}
		}
		return "tmp.jsp";
	}

}
