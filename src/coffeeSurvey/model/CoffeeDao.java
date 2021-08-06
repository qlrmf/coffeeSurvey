package coffeeSurvey.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.jdbc.proxy.annotation.Pre;

public class CoffeeDao {
	private static CoffeeDao instance;
	private JdbcConnectionUtil util;

	private CoffeeDao() {
		util = JdbcConnectionUtil.getInstance();
	}

	public static CoffeeDao getInstance() {
		synchronized (CoffeeDao.class) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			if (instance == null) {
				instance = new CoffeeDao();
			}
		}
		return instance;
	}

	// 설문조사결과 입력 기능 ---------------------------------------------------------
	public int insertCoffee(Map<String, Object> vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			String sql = "insert into COFFEE_INFO values (COFFEE_SEQ.nextval, ?, ?, ?)";
			InfoVo info = (InfoVo) vo.get("info");
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getGender());
			pstmt.setInt(2, info.getAge());
			pstmt.setInt(3, info.getJob());
			result += pstmt.executeUpdate();

			util.close(pstmt);
			util.close(conn);
			sql = "insert into COFFEE_TASTE values (COFFEE_SEQ.currval, ?, ?, ?, ?, ?, ?)";
			TasteVo taste = (TasteVo) vo.get("taste");
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, taste.getTaste1());
			pstmt.setInt(2, taste.getTaste2());
			pstmt.setInt(3, taste.getTaste3());
			pstmt.setInt(4, taste.getTaste4());
			pstmt.setInt(5, taste.getTaste5());
			pstmt.setInt(6, taste.getTaste6());
			result += pstmt.executeUpdate();

			util.close(pstmt);
			util.close(conn);
			sql = "insert into COFFEE_THINK values (COFFEE_SEQ.currval, ?, ?, ?, ?)";
			ThinkVo think = (ThinkVo) vo.get("think");
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, think.getThink1());
			pstmt.setInt(2, think.getThink2());
			pstmt.setString(3, toStr(think.getThink3()));
			pstmt.setString(4, toStr(think.getThink4()));
			result += pstmt.executeUpdate();

			util.close(pstmt);
			util.close(conn);
			sql = "insert into COFFEE_CAFE values (COFFEE_SEQ.currval, ?, ?, ?, ?, ?, ?, ?, ?)";
			CafeVo cafe = (CafeVo) vo.get("cafe");
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cafe.getCafe1());
			pstmt.setInt(2, cafe.getCafe2());
			pstmt.setInt(3, cafe.getCafe3());
			pstmt.setInt(4, cafe.getCafe4());
			pstmt.setInt(5, cafe.getCafe5());
			pstmt.setInt(6, cafe.getCafe6());
			pstmt.setInt(7, cafe.getCafe7());
			pstmt.setInt(8, cafe.getCafe8());
			result += pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt);
			util.close(conn);
		}
		return result;
	}

	private String toStr(int[] nums) {
		String str = "";
		if (nums.length != 0) {
			for (int i : nums) {
				str += i + ",";
			}
		}
		return str;
	}

	// 개인취향 설문 입력여부 확인 -------------------------------------------------------------
	public boolean checkResult() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = -1;
		try {
			num = currNum();
			String sql = "select sum(taste1+taste2+taste3+taste4+taste5+taste6) from coffee_taste where num=?";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(rs);
			util.close(pstmt);
			util.close(conn);
		}
		if(num<6) {
			return false;
		}
		return true;
	}

	public int currNum() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = -1;
		try {
			String sql = "select Max(num) from coffee_info";
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(rs);
			util.close(pstmt);
			util.close(conn);
		}
		return num;
	}

	// 나이에따른 결과 확인 및 조회
	// -----------------------------------------------------------------
	public Map<Integer, Map<Integer, Integer>> statResult(int num) {
		Map<Integer, Map<Integer, Integer>> result = new HashMap<Integer, Map<Integer, Integer>>();

		StringBuffer sql = new StringBuffer();
		sql.append("select T.THINK1, round(ratio_to_report(count(t.think1)) over()*100,0) ");
		sql.append("from COFFEE_INFO INFO join COFFEE_THINK T on INFO.NUM = T.NUM ");
		sql.append("group by INFO.AGE, T.THINK1 having INFO.AGE = ");
		sql.append("(select AGE from COFFEE_INFO where NUM = ?)");
		result.put(1, statRadio(sql.toString(), num));

		sql = new StringBuffer();
		sql.append("select T.THINK2, round(ratio_to_report(count(t.think2)) over()*100,0) ");
		sql.append("from COFFEE_INFO INFO join COFFEE_THINK T on INFO.NUM = T.NUM ");
		sql.append("group by INFO.AGE, T.THINK2 having INFO.AGE = ");
		sql.append("(select AGE from COFFEE_INFO where NUM = ?)");
		result.put(2, statRadio(sql.toString(), num));

		sql = new StringBuffer();
		sql.append("select T.THINK3 ");
		sql.append("from COFFEE_INFO INFO join COFFEE_THINK T on INFO.NUM = T.NUM  ");
		sql.append("where INFO.AGE = (select AGE from COFFEE_INFO where NUM = ?)");
		result.put(3, statCheckBox(sql.toString(), num));

		sql = new StringBuffer();
		sql.append("select T.THINK4 ");
		sql.append("from COFFEE_INFO INFO join COFFEE_THINK T on INFO.NUM = T.NUM  ");
		sql.append("where INFO.AGE = (select AGE from COFFEE_INFO where NUM = ?)");
		result.put(4, statCheckBox(sql.toString(), num));
		return result;
	}

	private Map<Integer, Integer> statRadio(String sql, int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.put(rs.getInt(1), rs.getInt(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(rs);
			util.close(pstmt);
			util.close(conn);
		}
		return result;
	}

	private Map<Integer, Integer> statCheckBox(String sql, int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		String[] tmp = null;
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				tmp = rs.getString(1).split(",");
				for (String s : tmp) {
					int nbr = Integer.parseInt(s);
					int value = result.containsKey(nbr) ? result.get(nbr) : 0;
					result.put(nbr, value + 1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(rs);
			util.close(pstmt);
			util.close(conn);
		}
		return result;

	}

	// 나이에 상관없이 전체 결과 확인---------------------------------------
	public Map<Integer, Map<Integer, Integer>> statResult() {
		Map<Integer, Map<Integer, Integer>> result = new HashMap<Integer, Map<Integer, Integer>>();
		QuestionCoffee coffee = new QuestionCoffee();

		for (int i = 1; i <= coffee.getCafeRadio().size(); i++) {
			StringBuffer sql = new StringBuffer();
			sql.append("select C.CAFE" + i);
			sql.append(", round(ratio_to_report(C.CAFE" + i);
			sql.append(") OVER ()*100,0) from COFFEE_CAFE C group by C.CAFE" + i);
			result.put(i, statRadio(sql.toString()));
		}
		System.out.println(result);
		return result;
	}

	private Map<Integer, Integer> statRadio(String sql) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result.put(rs.getInt(1), rs.getInt(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.close(rs);
			util.close(pstmt);
			util.close(conn);
		}
		return result;
	}
}
