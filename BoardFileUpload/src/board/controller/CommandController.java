package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import attach.model.AttachVo;
@MultipartConfig(maxFileSize = -1, maxRequestSize = -1, fileSizeThreshold = 1024)
public class CommandController extends HttpServlet{
	IBoardController board;
	private Map<String, Object> reqMap = new HashMap<String, Object>();
	private static String uploadPath = "";
	private File uploadDir = null;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propConfig = config.getInitParameter("propConfig");
		uploadPath = config.getInitParameter("uploadPath");
		uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		Properties prop = new Properties();
		FileInputStream fis = null;
		String path = config.getServletContext().getRealPath("/WEB-INF");

		try {
			fis = new FileInputStream(new File(path, propConfig));
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		Iterator<Object> it = prop.keySet().iterator();
		while(it.hasNext()) {
			String command = (String) it.next();
			String className = prop.getProperty(command);
			
			try {
				Class<?> commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();
				reqMap.put(command, commandInstance);		
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contentType = req.getContentType();
		if(contentType!=null && contentType.toLowerCase().startsWith("multipart/")) {
			try {
				req.setAttribute("uploadPath", uploadPath);
				fileLoad(req);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		doRequest(req,resp);
	}

	private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = null;
		String uri = req.getRequestURI();
		if(uri.indexOf(req.getContextPath())==0) {
			uri = uri.substring(req.getContextPath().length());
		}
		try {
			board = (IBoardController) reqMap.get(uri);
			System.out.println("uri: "+uri);
			System.out.println("board: "+board);
			if(board==null) {
				board = new NullControllerImpl();
			}
			page = "/WEB-INF/board/" + board.doRequest(req, resp);
		} catch (Throwable e) {
			throw new ServletException(e);
		} req.getRequestDispatcher(page).forward(req, resp);
	}
	
	private void fileLoad(HttpServletRequest req) throws IOException, ServletException {
		Collection<Part> parts = null;
		AttachVo vo = null;
		try {
			parts = req.getParts();
			for(Part part: parts) {
				String fileName = null;
				long fileSize = 0;
				String contentType = null;
				
				vo = new AttachVo();
				contentType = part.getContentType();
				if(contentType==null) {
					req.setAttribute(part.getName(), readParameterValue(part));
					part.delete();
				}else  {
					fileName = getFileName(part);
					fileSize = part.getSize();

					vo.setFileName(fileName);
					vo.setFileSize(fileSize);
					vo.setContentType(contentType);
					
					part.write(uploadPath + fileName);
					part.delete();
				}
			}
			req.setAttribute("files", vo);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}	
		
	}
	
	private String getFileName(Part part) {
		for(String cd : part.getHeader("Content-Disposition").split(";")) {
			if(cd.trim().startsWith("filename")) {
				String tmp = cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
				tmp = tmp.substring(tmp.indexOf(":")+1);
				return tmp;
			}
		}
		return null;
	}
	
	private String readParameterValue(Part part) throws IOException {
		InputStreamReader isr = new InputStreamReader(part.getInputStream(), "utf-8");
		char[] data = new char[512];
		int len = -1;
		StringBuilder builder = new StringBuilder();
		while((len=isr.read(data))!=-1) {
			builder.append(data,0,len);
		}
		return builder.toString();
	}
}
