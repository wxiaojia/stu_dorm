package User;

public class students {
	private int id,age,sex,phone,grade;
	private String name,sub;
	public students(){
	
	}
	public students(int id,String name, int age, int sex, int phone, int grade, String sub) {
	//	super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.grade = grade;
		this.sub = sub;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	
}
