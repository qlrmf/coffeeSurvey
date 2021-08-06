package survey.model;

import java.util.Arrays;

/*
create table COFFEE_THINK(
 NUM number primary key,
 THINK1 number not null, 
 THINK2 number not null, 
 THINK3 varchar2(20) not null, 
 THINK4 varchar2(20) not null
);
 */
public class ThinkVo {
	private int num;
	private int think1;
	private int think2;
	private int[] think3;
	private int[] think4;
	
	public ThinkVo() {}
	
	public ThinkVo(int think1, int think2, int[] think3, int[] think4) {
		super();
		this.think1 = think1;
		this.think2 = think2;
		this.think3 = think3;
		this.think4 = think4;
	}



	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getThink1() {
		return think1;
	}
	public void setThink1(int think1) {
		this.think1 = think1;
	}
	public int getThink2() {
		return think2;
	}
	public void setThink2(int think2) {
		this.think2 = think2;
	}
	public int[] getThink3() {
		return think3;
	}
	public void setThink3(int[] think3) {
		this.think3 = think3;
	}
	public int[] getThink4() {
		return think4;
	}
	public void setThink4(int[] think4) {
		this.think4 = think4;
	}
	@Override
	public String toString() {
		return "ThinkVo [num=" + num + ", think1=" + think1 + ", think2=" + think2 + ", think3="
				+ Arrays.toString(think3) + ", think4=" + Arrays.toString(think4) + "]";
	}
}
