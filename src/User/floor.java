package User;

public class floor {
	private int id,num;
	private String position;
	public floor(int id,int num,String position){
		super();
		this.id=id;
		this.num=num;
		this.position=position;
	}
	public floor(){
		
	}
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String toString(){
		return "±‡∫≈:" +id+"Àﬁ…·¬•:"+num+"Œª÷√:"+position;
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		floor A=new floor();
//		A.setId(1);
//		A.setNum(1);
//		A.setPosition("–°Õı");
//		System.out.println(A.toString());
//		
//	}
}
