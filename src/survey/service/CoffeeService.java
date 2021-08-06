package survey.service;

import java.util.HashMap;
import java.util.Map;

import survey.model.CoffeeDao;

public class CoffeeService {
	private static CoffeeService instance;
	private CoffeeDao dao;
	private Map<String, Object> vo;
	
	private CoffeeService() {
		resetVo();
		dao = CoffeeDao.getInstance();
	}
	
	public static CoffeeService getInstance() {
		synchronized (CoffeeService.class) {
			if(instance==null) {
				instance = new CoffeeService();
			}
		}
		return instance;
	}
	
	
	public boolean regist() {
		System.out.println(vo);
		if(vo.size()==4 && dao.insertCoffee(vo)==4) {
			return true;
		}
		return false;
	}
	
	
	public Map<Integer, Map<Integer, Integer>> totalPage(int num) {
		if(num>0) {
			return dao.statResult(num);
		}else {
			return null;
		}
	}
	
	public Map<Integer, Map<Integer, Integer>> totalPage() {
		return dao.statResult();
	}
	
	public int personalNum() {
		return dao.currNum();
	}
	
	public boolean checkVo(int num) {
		return dao.checkResult();
	}
	
	public void addVo(String st, Object ob) {
		vo.put(st, ob);
	}
	
	public void resetVo() {
		vo = new HashMap<String, Object>();
	}
}
