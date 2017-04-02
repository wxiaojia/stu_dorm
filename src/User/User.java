package User;

public class User {
	private int id,rights;
	private String name,pw;
	public User(int id,String name,String pw,int rights){
		super();
		this.id=id;
		this.name=name;
		this.pw=pw;
		this.rights=rights;
	}
	public User(){
		
	}
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getRights() {
		return rights;
	}
	public void setRights(int rights) {
		this.rights = rights;
	}
	public String toString(){
		return "编号:" +id+"姓名:"+name+"权利:"+rights;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		User A=new User();
//		A.setNum("01");
//		A.setName("小王");
//		A.setPw("123");
//		A.setRights("超级管理员");
//		System.out.println(A.toString());
//		
//	}

}
