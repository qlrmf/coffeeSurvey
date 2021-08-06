package survey.model;

/*
create table COFFEE_CAFE(
 NUM number primary key,
 CAFE1 number not null,
 CAFE2 number not null,
 CAFE3 number not null,
 CAFE4 number not null,
 CAFE5 number not null,
 CAFE6 number not null,
 CAFE7 number not null,
 CAFE8 number not null
);
 */

public class CafeVo {
	private int num;
	private int cafe1;
	private int cafe2;
	private int cafe3;
	private int cafe4;
	private int cafe5;
	private int cafe6;
	private int cafe7;
	private int cafe8;
	
	public CafeVo() {}
	
	public CafeVo(int cafe1, int cafe2, int cafe3, int cafe4, int cafe5, int cafe6, int cafe7, int cafe8) {
		super();
		this.cafe1 = cafe1;
		this.cafe2 = cafe2;
		this.cafe3 = cafe3;
		this.cafe4 = cafe4;
		this.cafe5 = cafe5;
		this.cafe6 = cafe6;
		this.cafe7 = cafe7;
		this.cafe8 = cafe8;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCafe1() {
		return cafe1;
	}
	public void setCafe1(int cafe1) {
		this.cafe1 = cafe1;
	}
	public int getCafe2() {
		return cafe2;
	}
	public void setCafe2(int cafe2) {
		this.cafe2 = cafe2;
	}
	public int getCafe3() {
		return cafe3;
	}
	public void setCafe3(int cafe3) {
		this.cafe3 = cafe3;
	}
	public int getCafe4() {
		return cafe4;
	}
	public void setCafe4(int cafe4) {
		this.cafe4 = cafe4;
	}
	public int getCafe5() {
		return cafe5;
	}
	public void setCafe5(int cafe5) {
		this.cafe5 = cafe5;
	}
	public int getCafe6() {
		return cafe6;
	}
	public void setCafe6(int cafe6) {
		this.cafe6 = cafe6;
	}
	public int getCafe7() {
		return cafe7;
	}
	public void setCafe7(int cafe7) {
		this.cafe7 = cafe7;
	}
	public int getCafe8() {
		return cafe8;
	}
	public void setCafe8(int cafe8) {
		this.cafe8 = cafe8;
	}
	@Override
	public String toString() {
		return "CafeVo [num=" + num + ", cafe1=" + cafe1 + ", cafe2=" + cafe2 + ", cafe3=" + cafe3 + ", cafe4=" + cafe4
				+ ", cafe5=" + cafe5 + ", cafe6=" + cafe6 + ", cafe7=" + cafe7 + ", cafe8=" + cafe8 + "]";
	}
	
	
}
