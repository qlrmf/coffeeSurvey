package coffeeSurvey.model;

/*
create table COFFEE_TASTE(
 NUM number primary key,
 TASTE1 number not null,
 TASTE2 number not null,
 TASTE3 number not null,
 TASTE4 number not null,
 TASTE5 number not null,
 TASTE6 number not null
);
 */
public class TasteVo {
	private int num;
	private int taste1;
	private int taste2;
	private int taste3;
	private int taste4;
	private int taste5;
	private int taste6;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getTaste1() {
		return taste1;
	}
	public void setTaste1(int taste1) {
		this.taste1 = taste1;
	}
	public int getTaste2() {
		return taste2;
	}
	public void setTaste2(int taste2) {
		this.taste2 = taste2;
	}
	public int getTaste3() {
		return taste3;
	}
	public void setTaste3(int taste3) {
		this.taste3 = taste3;
	}
	public int getTaste4() {
		return taste4;
	}
	public void setTaste4(int taste4) {
		this.taste4 = taste4;
	}
	public int getTaste5() {
		return taste5;
	}
	public void setTaste5(int taste5) {
		this.taste5 = taste5;
	}
	public int getTaste6() {
		return taste6;
	}
	public void setTaste6(int taste6) {
		this.taste6 = taste6;
	}
	@Override
	public String toString() {
		return "TasteVo [num=" + num + ", taste1=" + taste1 + ", taste2=" + taste2 + ", taste3=" + taste3 + ", taste4="
				+ taste4 + ", taste5=" + taste5 + ", taste6=" + taste6 + "]";
	}
	
	
}
