package survey.model;

/*
create table COFFEE_INFO(
 NUM number primary key,
 GENDER number not null,
 AGE number not null,
 JOB number not null
);
 */
public class InfoVo {
	private int num;
	private int gender;
	private int age;
	private int job;
		
	public InfoVo() {}
	
	public InfoVo(int gender, int age, int job) {
		super();
		this.gender = gender;
		this.age = age;
		this.job = job;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJob() {
		return job;
	}
	public void setJob(int job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "InfoVo [num=" + num + ", gender=" + gender + ", age=" + age + ", job=" + job + "]";
	}
	
	
}
