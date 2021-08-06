package survey.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import survey.action.ICommandAction;
import survey.action.NullAction;

public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//(1) 명령어와 명령어 처리 클래스 저장 Map
	private Map<String, Object> commandMap = new HashMap<String, Object>();
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//(2) web.xml에서 propertyConfig에 해당하는 init-param-value 를 가져온다.
		String propCon = config.getInitParameter("propertyConfig");

		//(3) 명령어와 처리클래스의 매핑 정보를 저장할 Properties객체 생성
		Properties property = new Properties();
		FileInputStream fis = null;
		String path = config.getServletContext().getRealPath("/WEB-INF");
		try {
			//(4) command.properties의 파일 정보를 Properties객체에 저장
			fis = new FileInputStream(new File(path, propCon));
			property.load(fis);
			
		} catch (IOException e) {
			throw new ServletException(e);
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {}
			}
		}
		
		//(5) Iterator객체를 사용해 propertys 파일 정보를 하나씩 가져옴
		Iterator<Object> itKey = property.keySet().iterator();
		while(itKey.hasNext()) {
			String command = (String)itKey.next();
			String className = property.getProperty(command);
			
			try {
				//(6) 가져온 문자열 정보를 클래스로 만듦
				Class<?> commandClass = Class.forName(className);
				
				//(7) 만들어진 클래스의 객체를 생성해 생성된 객체를 commandMap에 저장
				Object commandInstance = commandClass.newInstance();
				commandMap.put(command, commandInstance);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//(8) get, post 방식의 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		reqProcess(req, resp);
	}
	
	//(9) 사용자 요청에 따라 분석해 해당 작업 처리
	private void reqProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = null;
		ICommandAction comAct = null;
		
		String command = req.getRequestURI();
		if(command.indexOf(req.getContextPath())==0) {
			command = command.substring(req.getContextPath().length());
		}

		try {
			comAct = (ICommandAction)commandMap.get(command);
			if(comAct==null) {
				comAct = new NullAction();
			}
			view = "/WEB-INF/coffee/"+comAct.reqProcess(req, resp);
		}catch (Throwable e) {
			throw new ServletException(e);
		}
		req.getRequestDispatcher(view).forward(req, resp);
	}
	
}
