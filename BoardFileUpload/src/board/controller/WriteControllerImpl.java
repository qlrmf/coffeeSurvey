package board.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import attach.model.AttachVo;
import attach.model.AttachDao;
import board.model.BoardVo;

public class WriteControllerImpl implements IBoardController {
	private AttachDao attachdao = AttachDao.getInstance();
	
	@Override
	public String doRequest(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(true);
		AttachVo file = null;
		
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		int depth = Integer.parseInt(req.getParameter("depth"));
		int ref =  Integer.parseInt(req.getParameter("ref"));
		String password = req.getParameter("password");
		
		writer = new String(writer.getBytes("8859_1"), "utf-8");
		title = new String(title.getBytes("8859_1"), "utf-8");
		content = new String(content.getBytes("8859_1"), "utf-8");
		password = new String(password.getBytes("8859_1"), "utf-8");

		BoardVo vo = new BoardVo();
		vo.setWriter(writer);
		if(ref!=0) {
			vo.setDepth(depth+1);
		}else {
			vo.setDepth(depth);
		}
		vo.setTitle(title);
		vo.setContent(content);
		vo.setRef(ref);
		vo.setPassword(password);
		System.out.println(vo);
		if(dao.insert(vo)!=-1) {
			file = (AttachVo)req.getAttribute("files");
			System.out.println(file);
			if(file!=null) {
				attachdao.insert(file);
			}
			return "tmp.jsp";
		}
		session.setAttribute("error", "Writing");
		return "error.jsp";
	}
	
	
}
